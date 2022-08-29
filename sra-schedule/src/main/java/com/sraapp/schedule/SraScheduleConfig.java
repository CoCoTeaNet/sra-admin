package com.sraapp.schedule;

import com.sraapp.schedule.entity.ScheduleJob;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * 计划任务调度器配置
 *
 * @author Guo wentao
 * @date 2022/8/9
 */
@Component
@EnableScheduling
public class SraScheduleConfig implements SchedulingConfigurer {
    private final static Logger logger = LoggerFactory.getLogger(SraScheduleConfig.class);

    private static final ConcurrentHashMap<String, ScheduleJob> JOB_REGISTRY = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, ScheduledFuture<?>> RUNNING_JOB = new ConcurrentHashMap<>();
    private volatile ScheduledTaskRegistrar registrar;

    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @PostConstruct
    public void initialize() {
        // TODO 加载任务数据，并注册
        logger.info("初始化任务配置...");

    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(5, runnable -> {
            Thread thread = new Thread(runnable);
            thread.setName("SRA-Schedule-Thread");
            thread.setDaemon(false);
            return thread;
        });
        taskRegistrar.setScheduler(service);
        this.registrar = taskRegistrar;

    }

    public boolean isExist(String key) {

        return false;
    }

    public void refresh(List<ScheduleJob> scheduleJobList) {
        Collection<ScheduledFuture<?>> runningScheduledFuture = RUNNING_JOB.values();
        for (ScheduledFuture<?> scheduledFuture : runningScheduledFuture) {
            scheduledFuture.cancel(false);
        }

        JOB_REGISTRY.clear();
        for (ScheduleJob scheduleJob : scheduleJobList) {
            JOB_REGISTRY.put(scheduleJob.getId(), scheduleJob);
            // TODO 按照任务信息注册任务
        }
    }

//    public void refresh(List<SraSchedule> tasks) {
//        //取消已经删除的策略任务
//        Set<Integer> sids = scheduledFutures.keySet();
//        for (Integer sid : sids) {
//            if (!exists(tasks, sid)) {
//                scheduledFutures.get(sid).cancel(false);
//            }
//        }
//        for (SraSchedule task : tasks) {
//            String expression = task.getExpression();
//            //计划任务表达式为空则跳过
//            if (!StringUtils.hasLength(expression)) {
//                continue;
//            }
//            //计划任务已存在并且表达式未发生变化则跳过
//            if (scheduledFutures.containsKey(TaskEntity.getTaskId())
//                    && cronTasks.get(TaskEntity.getTaskId()).getExpression().equals(expression)) {
//                continue;
//            }
//            //如果策略执行时间发生了变化，则取消当前策略的任务
//            if (scheduledFutures.containsKey(TaskEntity.getTaskId())) {
//                scheduledFutures.get(TaskEntity.getTaskId()).cancel(false);
//                scheduledFutures.remove(TaskEntity.getTaskId());
//                cronTasks.remove(TaskEntity.getTaskId());
//            }
//            //业务逻辑处理
//            CronTask task = cronTask(TaskEntity, expression);
//
//
//            //执行业务
//            ScheduledFuture<?> future = registrar.getScheduler().schedule(task.getRunnable(), task.getTrigger());
//            cronTasks.put(TaskEntity.getTaskId(), task);
//            scheduledFutures.put(TaskEntity.getTaskId(), future);
//        }
//    }
//
//    /**
//     * 停止 cron 运行
//     */
//    public void stop(List<TaskEntity> tasks) {
//        tasks.forEach(item -> {
//            if (scheduledFutures.containsKey(item.getTaskId())) {
//                // mayInterruptIfRunning设成false话，不允许在线程运行时中断，设成true的话就允许。
//                scheduledFutures.get(item.getTaskId()).cancel(false);
//                scheduledFutures.remove(item.getTaskId());
//            }
//        });
//    }
//
//    /**
//     * 业务逻辑处理
//     */
//    public CronTask cronTask(TaskEntity TaskEntity, String expression) {
//        return new CronTask(() -> {
//            //每个计划任务实际需要执行的具体业务逻辑
//            //采用策略，模式 ，执行我们的job
//            taskSolverChooser.getTask(TaskEntity.getTaskId()).HandlerJob();
//        }, expression);
//    }
//
//    private boolean exists(List<TaskEntity> tasks, Integer tid) {
//        for (TaskEntity TaskEntity : tasks) {
//            if (TaskEntity.getTaskId() == tid) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @PreDestroy
//    public void destroy() {
//        this.registrar.destroy();
//    }

}
