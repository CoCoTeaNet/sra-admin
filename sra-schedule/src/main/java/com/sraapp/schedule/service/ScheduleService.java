package com.sraapp.schedule.service;

import com.sraapp.common.service.IBaseService;
import com.sraapp.schedule.param.ScheduleJobAddParam;
import com.sraapp.schedule.param.ScheduleJobPageParam;
import com.sraapp.schedule.param.ScheduleJobUpdateParam;
import com.sraapp.schedule.vo.ScheduleJobVO;
import org.sagacity.sqltoy.model.Page;

/**
 * @author Guo wentao
 * @date 2022/8/8
 */
public interface ScheduleService extends IBaseService<Page<ScheduleJobVO>, ScheduleJobPageParam, ScheduleJobAddParam, ScheduleJobUpdateParam> {
}
