package net.cocotea.admin.schedule.service;

import net.cocotea.admin.schedule.param.ScheduleJobLogAddParam;
import net.cocotea.admin.schedule.param.ScheduleJobLogPageParam;
import net.cocotea.admin.schedule.param.ScheduleJobLogUpdateParam;
import net.cocotea.admin.schedule.vo.ScheduleJobLogVO;
import net.cocotea.admin.common.service.IBaseService;
import org.sagacity.sqltoy.model.Page;

/**
 * @author Guo wentao
 * @date 2022/9/1
 */
public interface IScheduleJobLogService extends IBaseService<Page<ScheduleJobLogVO>, ScheduleJobLogPageParam, ScheduleJobLogAddParam, ScheduleJobLogUpdateParam> {
}
