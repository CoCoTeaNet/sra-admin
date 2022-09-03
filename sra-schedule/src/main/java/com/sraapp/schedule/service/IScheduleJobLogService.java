package com.sraapp.schedule.service;

import com.sraapp.common.service.IBaseService;
import com.sraapp.schedule.param.*;
import com.sraapp.schedule.vo.ScheduleJobLogVO;
import org.sagacity.sqltoy.model.Page;

/**
 * @author Guo wentao
 * @date 2022/9/1
 */
public interface IScheduleJobLogService extends IBaseService<Page<ScheduleJobLogVO>, ScheduleJobLogPageParam, ScheduleJobLogAddParam, ScheduleJobLogUpdateParam> {
}
