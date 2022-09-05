package com.sraapp.schedule.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.sraapp.common.model.BusinessException;
import com.sraapp.schedule.IBaseJob;
import com.sraapp.schedule.entity.ScheduleJob;
import com.sraapp.schedule.param.ScheduleJobLogAddParam;
import com.sraapp.schedule.service.IScheduleJobLogService;
import com.sraapp.schedule.service.IScheduleJobRegistryService;
import com.sraapp.schedule.service.IScheduleJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

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
@Component
@EnableScheduling
public class SraScheduleConfigurerServiceImpl implements SchedulingConfigurer, IScheduleJobRegistryService {
    private static final Logger logger = LoggerFactory.getLogger(SraScheduleConfigurerServiceImpl.class);
    private static final ConcurrentHashMap<String, CronTask> JOB_REGISTRY = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Future<?>> RUNNING_JOB = new ConcurrentHashMap<>();
    @Resource
    private IScheduleJobService scheduleJobService;
    @Resource
    private IScheduleJobLogService scheduleJobLogService;
    private ThreadPoolExecutor executor;
    private volatile ScheduledTaskRegistrar registrar;

    public SraScheduleConfigurerServiceImpl() {
        logger.info("SraScheduleConfigurerServiceImpl initializing...");
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadFactory threadFactory = runnable -> {
            Thread thread = new Thread(runnable);
            thread.setName("SRA-Schedule-Thread");
            thread.setDaemon(false);
            return thread;
        };
        this.executor = new ThreadPoolExecutor(5, 5, 10,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(10), threadFactory);
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(5, threadFactory);
        taskRegistrar.setScheduler(service);
        this.registrar = taskRegistrar;

        List<ScheduleJob> allActiveScheduleJob = scheduleJobService.getAllActiveScheduleJob();
        try {
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
        List<CronTask> cronTaskList = registrar.getCronTaskList();
        cronTaskList.clear();
        JOB_REGISTRY.clear();

        Enumeration<String> runningKeys = RUNNING_JOB.keys();
        Map<String, ScheduleJob> scheduleJobMap = CollectionUtil.toMap(scheduleJobList, MapUtil.newHashMap(), ScheduleJob::getId);
        while (runningKeys.hasMoreElements()) {
            String key = runningKeys.nextElement();
            if (scheduleJobMap.containsKey(key)) {
                Future<?> future = RUNNING_JOB.get(key);
                future.cancel(false);
                RUNNING_JOB.remove(key);
            }
        }

        for (ScheduleJob scheduleJob : scheduleJobList) {
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
            logger.info("{} job add to registrar", scheduleJob);
            registrar.addCronTask(cronTask);
            JOB_REGISTRY.put(scheduleJob.getId(), cronTask);
        }
    }

    @Override
    public boolean start(ScheduleJob scheduleJob) throws Exception {
        if (!RUNNING_JOB.containsKey(scheduleJob.getId())) {
            Runnable runnable = wrapRunnableJob(scheduleJob);
            if (runnable != null) {
                Future<?> future = this.executor.submit(runnable);
                RUNNING_JOB.put(scheduleJob.getId(), future);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean flushJob(ScheduleJob scheduleJob) throws Exception {
        String key = scheduleJob.getId();
        JOB_REGISTRY.remove(key);
        if (RUNNING_JOB.containsKey(key)) {
            Future<?> future = RUNNING_JOB.get(key);
            future.cancel(false);
            RUNNING_JOB.remove(key);
        }
        String expression = scheduleJob.getCornExpression();
        //计划任务表达式为空则跳过
        if (StrUtil.isNotBlank(expression)) {
            Runnable runnableJob = wrapRunnableJob(scheduleJob);
            if (runnableJob != null) {
                CronTask cronTask = new CronTask(runnableJob, expression);
                registrar.addCronTask(cronTask);
                JOB_REGISTRY.put(scheduleJob.getId(), cronTask);
                return JOB_REGISTRY.containsKey(key);
            }
        }
        return false;
    }

    @PreDestroy
    public void destroy() {
        this.executor.shutdown();
        this.registrar.destroy();
    }

    private Runnable wrapRunnableJob(ScheduleJob scheduleJob) {
        String className = scheduleJob.getClassName();
        try {
            Class<?> jobClass = Class.forName(className);
            IBaseJob job = (IBaseJob) jobClass.getDeclaredConstructor().newInstance();
            String loginIdVar = "";
            try {
                if (StpUtil.isLogin()) {
                    loginIdVar = (String) StpUtil.getLoginId();
                }
            } catch (Exception ignore) {
            }
            final String loginId = loginIdVar;
            return () -> {
                int result = 1;
                Date triggerTime = new Date();
                String taskName = scheduleJob.getName();
                logger.info("开始执行计划任务: {}", taskName);
                StopWatch stopWatch = new StopWatch();
                stopWatch.start(taskName);
                try {
                    job.execute();
                } catch (Exception e) {
                    result = 0;
                    RUNNING_JOB.remove(scheduleJob.getId());
                    logger.error("计划任务执行出现异常! ", e);
                }
                stopWatch.stop();
                logger.info("计划任务: {} 执行耗时: {}ms", taskName, stopWatch.getLastTaskTimeMillis());
                try {
                    ScheduleJobLogAddParam param = new ScheduleJobLogAddParam()
                            .setJobId(scheduleJob.getId())
                            .setExeResult(result)
                            .setTriggerBy(loginId)
                            .setTriggerTime(triggerTime)
                            .setFinishTime(new Date())
                            .setSpendTimeMillis(stopWatch.getLastTaskTimeMillis());
                    scheduleJobLogService.add(param);
                } catch (BusinessException e) {
                    throw new RuntimeException(e);
                }
            };
        } catch (Exception e) {
            logger.error("加载任务时出现异常", e);
            e.printStackTrace();
            return null;
        }
    }
}
