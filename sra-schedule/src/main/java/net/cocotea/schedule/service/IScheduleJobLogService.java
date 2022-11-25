package net.cocotea.schedule.service;

import net.cocotea.common.service.IBaseService;
import net.cocotea.schedule.param.*;
import net.cocotea.schedule.vo.ScheduleJobLogVO;
import net.cocotea.schedule.param.ScheduleJobLogAddParam;
import net.cocotea.schedule.param.ScheduleJobLogPageParam;
import net.cocotea.schedule.param.ScheduleJobLogUpdateParam;
import org.sagacity.sqltoy.model.Page;

/**
 * @author Guo wentao
 * @date 2022/9/1
 */
public interface IScheduleJobLogService extends IBaseService<Page<ScheduleJobLogVO>, ScheduleJobLogPageParam, ScheduleJobLogAddParam, ScheduleJobLogUpdateParam> {
}
