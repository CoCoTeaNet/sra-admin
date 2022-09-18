package com.sraapp.schedule;

import com.sraapp.common.model.BusinessException;
import com.sraapp.schedule.entity.ScheduleJob;
import com.sraapp.schedule.param.ScheduleJobLogAddParam;
import com.sraapp.schedule.service.IScheduleJobLogService;
import com.sraapp.schedule.service.IScheduleJobRegistryService;
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
    private final IScheduleJobLogService scheduleJobLogService;
    private StopWatch stopWatch;
    private Date triggerTime;
    private ScheduleJob job;
    private String operator;
    private boolean started = false;
    private boolean finished = false;

    public ScheduleContext(IScheduleJobRegistryService scheduleJobRegistryService, IScheduleJobLogService scheduleJobLogService, ScheduleJob job, String operator) {
        this.scheduleJobRegistryService = scheduleJobRegistryService;
        this.scheduleJobLogService = scheduleJobLogService;
        this.job = job;
        this.operator = operator;
    }

    public void start() {
        synchronized (this) {
            if (started) {
                throw new RuntimeException("非法操作，同一个上下文不能被多个任务持有...");
            }
            started = true;
        }
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
        synchronized (this) {
            if (finished) {
                throw new RuntimeException("非法操作，同一个上下文不能被多个任务持有...");
            }
            finished = true;
        }
        stopWatch.stop();
        logger.info("计划任务: {} 执行耗时: {}ms", job.getName(), stopWatch.getLastTaskTimeMillis());
        try {
            ScheduleJobLogAddParam param = new ScheduleJobLogAddParam()
                    .setJobId(job.getId())
                    .setExeResult(result)
                    .setTriggerBy(operator)
                    .setTriggerTime(triggerTime)
                    .setFinishTime(new Date())
                    .setSpendTimeMillis(stopWatch.getLastTaskTimeMillis());
            scheduleJobLogService.add(param);
        } catch (BusinessException e) {
            throw new RuntimeException(e);
        }
    }
}
