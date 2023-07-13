package net.cocotea.admin.schedule.core.param;

import net.cocotea.admin.schedule.core.vo.ScheduleJobVO;
import org.sagacity.sqltoy.model.Page;

/**
 * CoCoTea
 *
 * @date 2022-9-2 20:49:35
 */
public class ScheduleJobPageParam extends Page<ScheduleJobVO> {
    private ScheduleJobVO job;

    public ScheduleJobVO getJob() {
        return job;
    }

    public ScheduleJobPageParam setJob(ScheduleJobVO job) {
        this.job = job;
        return this;
    }
}
