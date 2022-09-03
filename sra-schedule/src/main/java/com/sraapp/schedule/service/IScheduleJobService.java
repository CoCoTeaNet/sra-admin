package com.sraapp.schedule.service;

import com.sraapp.common.service.IBaseService;
import com.sraapp.schedule.entity.ScheduleJob;
import com.sraapp.schedule.param.ScheduleJobAddParam;
import com.sraapp.schedule.param.ScheduleJobPageParam;
import com.sraapp.schedule.param.ScheduleJobUpdateParam;
import org.sagacity.sqltoy.model.Page;

import java.util.List;

/**
 * @author Guo wentao
 * @date 2022/8/8
 */
public interface IScheduleJobService extends IBaseService<Page<com.sraapp.schedule.vo.ScheduleJobVO>, ScheduleJobPageParam, ScheduleJobAddParam, ScheduleJobUpdateParam> {

    /**
     * 查询所有已启用的计划任务
     *
     * @return 已启用的计划任务列表
     */
    List<ScheduleJob> getAllActiveScheduleJob();
}
