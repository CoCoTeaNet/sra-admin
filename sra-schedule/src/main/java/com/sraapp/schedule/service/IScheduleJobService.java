package com.sraapp.schedule.service;

import com.sraapp.common.model.BusinessException;
import com.sraapp.common.service.IBaseService;
import com.sraapp.schedule.entity.ScheduleJob;
import com.sraapp.schedule.param.ScheduleJobAddParam;
import com.sraapp.schedule.param.ScheduleJobPageParam;
import com.sraapp.schedule.param.ScheduleJobUpdateParam;
import com.sraapp.schedule.vo.ScheduleJobVO;
import org.sagacity.sqltoy.model.Page;

import java.util.List;

/**
 * @author Guo wentao
 * @date 2022/8/8
 */
public interface IScheduleJobService extends IBaseService<Page<ScheduleJobVO>, ScheduleJobPageParam, ScheduleJobAddParam, ScheduleJobUpdateParam> {

    /**
     * 查询所有已启用的计划任务
     *
     * @return 已启用的计划任务列表
     */
    List<ScheduleJob> getAllActiveScheduleJob() throws BusinessException;

    /**
     * 手动执行任务
     *
     * @param id 任务ID
     * @return 任务执行UUID
     */
    String execute(String id) throws BusinessException;

    /**
     * 通过UUID获取手动执行结果
     *
     * @param uuid 任务执行UUID
     * @return 任务执行结果
     */
    boolean getExecuteProgress(String uuid) throws BusinessException;
}
