package com.sraapp.schedule.service.impl;

import com.sraapp.common.model.BusinessException;
import com.sraapp.schedule.param.ScheduleJobLogAddParam;
import com.sraapp.schedule.param.ScheduleJobLogPageParam;
import com.sraapp.schedule.param.ScheduleJobLogUpdateParam;
import com.sraapp.schedule.service.IScheduleJobLogService;
import com.sraapp.schedule.vo.ScheduleJobLogVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Guo wentao
 * @project sss-rbac-admin
 * @date 2022-09-03 11:42:37
 */
@Service
public class ScheduleJobLogServiceImpl implements IScheduleJobLogService {
    @Override
    public boolean add(ScheduleJobLogAddParam param) throws BusinessException {
        return false;
    }

    @Override
    public boolean deleteBatch(List<String> idList) throws BusinessException {
        return false;
    }

    @Override
    public boolean update(ScheduleJobLogUpdateParam param) throws BusinessException {
        return false;
    }

    @Override
    public ScheduleJobLogVO listByPage(ScheduleJobLogPageParam param) throws BusinessException {
        return null;
    }

    @Override
    public boolean delete(String id) throws BusinessException {
        return false;
    }
}
