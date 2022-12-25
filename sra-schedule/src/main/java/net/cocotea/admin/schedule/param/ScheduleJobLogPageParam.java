package net.cocotea.admin.schedule.param;

import net.cocotea.admin.schedule.vo.ScheduleJobLogVO;
import org.sagacity.sqltoy.model.Page;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Guo wentao
 * @date 2022/8/29
 */
public class ScheduleJobLogPageParam extends Page<ScheduleJobLogVO> implements Serializable {

    private static final long serialVersionUID = -206977374259097534L;
    private ScheduleJobLogVO scheduleJobLogVO;
    private List<LocalDateTime> triggerTimeRange;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public ScheduleJobLogPageParam setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
        return this;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public ScheduleJobLogPageParam setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public List<LocalDateTime> getTriggerTimeRange() {
        return triggerTimeRange;
    }

    public ScheduleJobLogPageParam setTriggerTimeRange(List<LocalDateTime> triggerTimeRange) {
        this.triggerTimeRange = triggerTimeRange;
        return this;
    }

    public ScheduleJobLogVO getScheduleJobLogVO() {
        return scheduleJobLogVO;
    }

    public ScheduleJobLogPageParam setScheduleJobLogVO(ScheduleJobLogVO scheduleJobLogVO) {
        this.scheduleJobLogVO = scheduleJobLogVO;
        return this;
    }
}
