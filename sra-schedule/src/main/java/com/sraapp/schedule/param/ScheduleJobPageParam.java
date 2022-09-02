package com.sraapp.schedule.param;

import com.sraapp.schedule.vo.ScheduleJobVo;
import org.sagacity.sqltoy.model.Page;

/**
 * CoCoTea
 * @date 2022-9-2 20:49:35
 */
public class ScheduleJobPageParam extends Page<ScheduleJobVo> {
    private ScheduleJobVo scheduleJobVo;

    public ScheduleJobVo getScheduleJobVo() {
        return scheduleJobVo;
    }

    public ScheduleJobPageParam setScheduleJobVo(ScheduleJobVo scheduleJobVo) {
        this.scheduleJobVo = scheduleJobVo;
        return this;
    }
}
