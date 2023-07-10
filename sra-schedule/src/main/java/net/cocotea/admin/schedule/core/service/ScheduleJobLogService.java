package net.cocotea.admin.schedule.core.service;

import net.cocotea.admin.schedule.core.param.ScheduleJobLogAddParam;
import net.cocotea.admin.schedule.core.param.ScheduleJobLogPageParam;
import net.cocotea.admin.schedule.core.param.ScheduleJobLogUpdateParam;
import net.cocotea.admin.schedule.core.vo.ScheduleJobLogVO;
import net.cocotea.admin.common.service.IBaseService;
import org.sagacity.sqltoy.model.Page;

/**
 * @author Guo wentao
 * @date 2022/9/1
 */
public interface ScheduleJobLogService extends IBaseService<Page<ScheduleJobLogVO>, ScheduleJobLogPageParam, ScheduleJobLogAddParam, ScheduleJobLogUpdateParam> {
}
