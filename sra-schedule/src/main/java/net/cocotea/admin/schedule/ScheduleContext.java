package net.cocotea.admin.schedule;

import net.cocotea.admin.schedule.entity.ScheduleJob;
import net.cocotea.admin.schedule.param.ScheduleJobLogAddParam;
import net.cocotea.admin.schedule.service.IScheduleJobRegistryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final IScheduleJobRegistryService scheduleJobRegistryService;
    private StopWatch stopWatch;
    private Date triggerTime;
    private ScheduleJob job;
    private String operator;
    private String key;

    public ScheduleContext(IScheduleJobRegistryService scheduleJobRegistryService, ScheduleJob job, String operator, String key) {
        this.scheduleJobRegistryService = scheduleJobRegistryService;
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

    private void log(int result) {
        stopWatch.stop();
        logger.info("计划任务: {} 执行耗时: {}ms", job.getName(), stopWatch.getLastTaskTimeMillis());
        ScheduleJobLogAddParam param = new ScheduleJobLogAddParam()
                .setJobId(job.getId())
                .setExeResult(result)
                .setTriggerBy(operator)
                .setTriggerTime(triggerTime)
                .setFinishTime(new Date())
                .setSpendTimeMillis(stopWatch.getLastTaskTimeMillis());
        scheduleJobRegistryService.finish(key, param);
    }
}
