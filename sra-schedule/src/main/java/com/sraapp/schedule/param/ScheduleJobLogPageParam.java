package com.sraapp.schedule.param;

import com.sraapp.schedule.entity.ScheduleJobLog;
import com.sraapp.schedule.vo.ScheduleJobLogVO;
import org.sagacity.sqltoy.model.Page;

/**
 * @author Guo wentao
 * @date 2022/8/29
 */
public class ScheduleJobLogPageParam extends Page<ScheduleJobLog> {

    private ScheduleJobLogVO scheduleJob;

    public ScheduleJobLogVO getScheduleJobVO() {
        return scheduleJob;
    }

    public void setScheduleJobVO(ScheduleJobLogVO scheduleJob) {
        this.scheduleJob = scheduleJob;
    }
}
