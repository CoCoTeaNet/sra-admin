package net.cocotea.admin.schedule.core.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import net.cocotea.admin.schedule.core.JobExecutor;
import net.cocotea.admin.schedule.core.entity.ScheduleJob;
import net.cocotea.admin.schedule.core.param.ScheduleJobLogAddParam;
import net.cocotea.admin.schedule.core.service.ScheduleJobLogService;
import net.cocotea.admin.schedule.core.service.ScheduleJobRegistryService;
import net.cocotea.admin.schedule.core.service.ScheduleJobService;
import net.cocotea.admin.schedule.core.ScheduleContext;
import net.cocotea.admin.common.model.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.*;

/**
 * 计划任务调度器配置
 *
 * @author Guo wentao
 * @date 2022/8/9
 */
@Service
@EnableScheduling
public class SraScheduleConfigurerServiceImpl implements ApplicationContextAware, SchedulingConfigurer, ScheduleJobRegistryService {
    private static final Logger logger = LoggerFactory.getLogger(SraScheduleConfigurerServiceImpl.class);
    private static final ConcurrentHashMap<String, ScheduledTask> SCHEDULED_TASK_REGISTRY = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Future<?>> RUNNING_JOB = new ConcurrentHashMap<>();
    private ApplicationContext applicationContext;
    @Resource
    private ScheduleJobService scheduleJobService;
    @Resource
    private ScheduleJobLogService scheduleJobLogService;
    private ThreadPoolExecutor executor;
    private volatile ScheduledTaskRegistrar registrar;
    private static final ThreadFactory THREAD_FACTORY = runnable -> {
        Thread thread = new Thread(runnable);
        thread.setName("SRA-Schedule-Thread");
        thread.setDaemon(false);
        return thread;
    };

    public SraScheduleConfigurerServiceImpl() {
        logger.info("SraScheduleConfigurerServiceImpl initializing...");
    }

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(5);
        threadPoolTaskScheduler.setThreadFactory(THREAD_FACTORY);
        threadPoolTaskScheduler.setRemoveOnCancelPolicy(true);
        threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        threadPoolTaskScheduler.setThreadGroupName("SRA-Schedule-Thread");
        return threadPoolTaskScheduler;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        this.executor = new ThreadPoolExecutor(5, 5, 10,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(10), THREAD_FACTORY);

        this.registrar = taskRegistrar;

        try {
            List<ScheduleJob> allActiveScheduleJob = scheduleJobService.getAllActiveScheduleJob();
            this.refreshAll(allActiveScheduleJob);
        } catch (Exception e) {
            logger.error("计划任务初始化异常", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void refreshAll(List<ScheduleJob> scheduleJobList) throws Exception {
        if (ObjectUtil.isNull(scheduleJobList)) {
            logger.info("没有加载任何任务...");
            return;
        }

        for (ScheduleJob scheduleJob : scheduleJobList) {
            logger.info("初始化任务: {}", scheduleJob.getName());
            String expression = scheduleJob.getCornExpression();
            //计划任务表达式为空则跳过
            if (StrUtil.isBlank(expression)) {
                continue;
            }

            Runnable runnableJob = wrapRunnableJob(scheduleJob);
            if (runnableJob == null) {
                continue;
            }
            CronTask cronTask = new CronTask(runnableJob, expression);
            logger.info("注册成功");
            ScheduledTask scheduledTask = registrar.scheduleCronTask(cronTask);
            SCHEDULED_TASK_REGISTRY.put(scheduleJob.getId(), scheduledTask);
        }
    }

    @Override
    public boolean start(String key, ScheduleJob scheduleJob) throws Exception {
        JobExecutor runnable = wrapRunnableJob(scheduleJob);
        if (runnable != null && (!isRunning(key) || !runnable.isDisabledConcurrentExecute())) {
            Future<?> future = this.executor.submit(runnable);
            RUNNING_JOB.put(key, future);
            return true;
        }
        return false;
    }

    @Override
    public boolean flushJob(ScheduleJob scheduleJob) throws Exception {
        String key = scheduleJob.getId();
        removeJob(key);

        String expression = scheduleJob.getCornExpression();
        //计划任务表达式为空则跳过
        if (StrUtil.isNotBlank(expression)) {
            Runnable runnableJob = wrapRunnableJob(scheduleJob);
            if (runnableJob != null) {
                CronTask cronTask = new CronTask(runnableJob, expression);
                ScheduledTask scheduledTask = registrar.scheduleCronTask(cronTask);
                SCHEDULED_TASK_REGISTRY.put(key, scheduledTask);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeJob(String id) throws Exception {
        if (RUNNING_JOB.containsKey(id)) {
            Future<?> future = RUNNING_JOB.get(id);
            future.cancel(false);
            RUNNING_JOB.remove(id);
        }
        ScheduledTask scheduledTask = SCHEDULED_TASK_REGISTRY.get(id);
        if (scheduledTask != null) {
            scheduledTask.cancel();
        }
        return false;
    }

    @Override
    public boolean isRunning(String id) {
        return RUNNING_JOB.containsKey(id)
                && (!RUNNING_JOB.get(id).isDone() || !RUNNING_JOB.get(id).isCancelled());
    }

    @Override
    public void finish(String key, ScheduleJobLogAddParam param) {
        Future<?> future = RUNNING_JOB.get(key);
        if (future == null || future.isDone() || future.isCancelled()) {
            RUNNING_JOB.remove(key);
        }
        try {
            scheduleJobLogService.add(param);
        } catch (BusinessException e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    public void destroy() {
        this.executor.shutdown();
        this.registrar.destroy();
    }

    private JobExecutor wrapRunnableJob(ScheduleJob scheduleJob) {
        return wrapRunnableJob(scheduleJob, scheduleJob.getId());
    }

    private JobExecutor wrapRunnableJob(ScheduleJob scheduleJob, String key) {
        try {
            String loginId = "";
            try {
                if (StpUtil.isLogin()) {
                    loginId = (String) StpUtil.getLoginId();
                }
            } catch (Exception ignore) {
            }

            ScheduleContext context = new ScheduleContext(this, applicationContext, scheduleJob, loginId, key);
            return JobExecutor.create(context);
        } catch (Exception e) {
            logger.error("加载任务时出现异常", e);
            return null;
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
