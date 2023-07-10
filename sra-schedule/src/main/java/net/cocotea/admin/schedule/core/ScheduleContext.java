package net.cocotea.admin.schedule.core;

import net.cocotea.admin.schedule.core.entity.ScheduleJob;
import net.cocotea.admin.schedule.core.param.ScheduleJobLogAddParam;
import net.cocotea.admin.schedule.core.service.ScheduleJobRegistryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StopWatch;

import java.util.Date;

/**
 * @author Guo wentao
 * @project sss-rbac-admin
 * @date 2022-09-17 22:57:25
 */
public class ScheduleContext {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleContext.class);
    private static final int EXEC_RESULT_SUCCESS = 1;
    private static final int EXEC_RESULT_FAILURE = 0;
    private final ScheduleJobRegistryService scheduleJobRegistryService;
    private final ApplicationContext applicationContext;
    private StopWatch stopWatch;
    private Date triggerTime;
    private final ScheduleJob job;
    private final String operator;
    private final String key;

    public ScheduleJob getJob() {
        return job;
    }

    public ScheduleContext(ScheduleJobRegistryService scheduleJobRegistryService, ApplicationContext applicationContext, ScheduleJob job, String operator, String key) {
        this.scheduleJobRegistryService = scheduleJobRegistryService;
        this.applicationContext = applicationContext;
        this.job = job;
        this.operator = operator;
        this.key = key;
    }

    public void start() {
        triggerTime = new Date();
        stopWatch = new StopWatch();
        stopWatch.start(job.getName());
    }

    public void success() {
        log(EXEC_RESULT_SUCCESS);
    }

    public void failure(Exception e) {
        log(EXEC_RESULT_FAILURE);
    }

    public Object getJobInstance(Class<?> clazz) {
        try {
            return applicationContext.getBean(clazz);
        } catch (Exception ignore) {
        }
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception ignore) {
        }
        return null;
    }

    private void log(int result) {
        stopWatch.stop();
        logger.info("计划任务: {} 执行耗时: {}ms", job.getName(), stopWatch.getLastTaskTimeMillis());
        ScheduleJobLogAddParam param = new ScheduleJobLogAddParam()
                .setJobId(job.getId())
                .setExeResult(result)
                .setTriggerBy(operator)
                .setTriggerTime(triggerTime)
                .setFinishTime(new Date())
                .setSpendTimeMillis(stopWatch.getLastTaskTimeMillis())
                .setCreateBy(operator)
                .setUpdateBy(operator);
        scheduleJobRegistryService.finish(key, param);
    }
}
