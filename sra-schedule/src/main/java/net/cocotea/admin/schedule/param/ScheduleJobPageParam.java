package net.cocotea.admin.schedule.param;

import net.cocotea.admin.schedule.vo.ScheduleJobVO;
import org.sagacity.sqltoy.model.Page;

/**
 * CoCoTea
 *
 * @date 2022-9-2 20:49:35
 */
public class ScheduleJobPageParam extends Page<ScheduleJobVO> {
    private ScheduleJobVO scheduleJobVO;

    public ScheduleJobVO getScheduleJobVO() {
        return scheduleJobVO;
    }

    public ScheduleJobPageParam setScheduleJobVO(ScheduleJobVO ScheduleJobVO) {
        this.scheduleJobVO = ScheduleJobVO;
        return this;
    }
}
