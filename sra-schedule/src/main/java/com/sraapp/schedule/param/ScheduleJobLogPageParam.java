package com.sraapp.schedule.param;

import com.sraapp.schedule.entity.ScheduleJobLog;
import org.sagacity.sqltoy.model.Page;

/**
 * @author Guo wentao
 * @date 2022/8/29
 */
public class ScheduleJobLogPageParam extends Page<ScheduleJobLog> {

    private ScheduleJobLog scheduleJob;

    public ScheduleJobLog getScheduleJob() {
        return scheduleJob;
    }

    public void setScheduleJob(ScheduleJobLog scheduleJob) {
        this.scheduleJob = scheduleJob;
    }
}
