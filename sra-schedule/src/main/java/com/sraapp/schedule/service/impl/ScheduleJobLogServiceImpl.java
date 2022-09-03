package com.sraapp.schedule.service.impl;

import cn.hutool.core.convert.Convert;
import com.sraapp.common.enums.DeleteStatusEnum;
import com.sraapp.common.model.BusinessException;
import com.sraapp.schedule.entity.ScheduleJob;
import com.sraapp.schedule.entity.ScheduleJobLog;
import com.sraapp.schedule.param.ScheduleJobLogAddParam;
import com.sraapp.schedule.param.ScheduleJobLogPageParam;
import com.sraapp.schedule.param.ScheduleJobLogUpdateParam;
import com.sraapp.schedule.service.IScheduleJobLogService;
import com.sraapp.schedule.vo.ScheduleJobLogVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Guo wentao
 * @project sss-rbac-admin
 * @date 2022-09-03 11:42:37
 */
@Service
public class ScheduleJobLogServiceImpl implements IScheduleJobLogService {

    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Override
    public boolean add(ScheduleJobLogAddParam param) throws BusinessException {
        ScheduleJobLog scheduleJob = Convert.convert(ScheduleJobLog.class, param);
        return sqlToyLazyDao.save(scheduleJob) != null;
    }

    @Override
    public boolean deleteBatch(List<String> idList) throws BusinessException {
        List<ScheduleJobLog> scheduleJobs = new ArrayList<>(idList.size());
        for (String s : idList) {
            ScheduleJobLog scheduleJob = new ScheduleJobLog();
            scheduleJob.setId(s).setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
            scheduleJobs.add(scheduleJob);
        }
        return sqlToyLazyDao.updateAll(scheduleJobs) > 0;
    }

    @Override
    public boolean update(ScheduleJobLogUpdateParam param) throws BusinessException {
        throw new BusinessException("不支持更新操作");
    }

    @Override
    public Page<ScheduleJobLogVO> listByPage(ScheduleJobLogPageParam param) throws BusinessException {
        return sqlToyLazyDao.findPageBySql(param, "schedule_scheduleJobLog_findByPageParam", param.getScheduleJobVO());
    }

    @Override
    public boolean delete(String id) throws BusinessException {
        ScheduleJobLog scheduleJobLog = new ScheduleJobLog()
                .setId(id)
                .setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
        return sqlToyLazyDao.update(scheduleJobLog) > 0;
    }
}
