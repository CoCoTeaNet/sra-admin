package com.sraapp.schedule.service.impl;

import cn.hutool.core.convert.Convert;
import com.sraapp.common.enums.DeleteStatusEnum;
import com.sraapp.common.model.BusinessException;
import com.sraapp.schedule.entity.ScheduleJob;
import com.sraapp.schedule.param.ScheduleJobAddParam;
import com.sraapp.schedule.param.ScheduleJobPageParam;
import com.sraapp.schedule.param.ScheduleJobUpdateParam;
import com.sraapp.schedule.service.IScheduleJobService;
import com.sraapp.schedule.vo.ScheduleJobVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 计划任务管理服务
 *
 * @author Guo wentao
 * @date 2022/8/9
 */
@Service
public class ScheduleJobServiceImpl implements IScheduleJobService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Override
    public boolean add(ScheduleJobAddParam param) throws BusinessException {
        ScheduleJob scheduleJob = Convert.convert(ScheduleJob.class, param);
        return sqlToyLazyDao.save(scheduleJob) != null;
    }

    @Override
    public boolean deleteBatch(List<String> idList) throws BusinessException {
        List<ScheduleJob> scheduleJobs = new ArrayList<>(idList.size());
        for (String s : idList) {
            ScheduleJob scheduleJob = new ScheduleJob();
            scheduleJob.setId(s).setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
            scheduleJobs.add(scheduleJob);
        }
        return sqlToyLazyDao.updateAll(scheduleJobs) > 0;
    }

    @Override
    public boolean update(ScheduleJobUpdateParam param) throws BusinessException {
        ScheduleJob scheduleJob = Convert.convert(ScheduleJob.class, param);
        return sqlToyLazyDao.update(scheduleJob) > 0;
    }

    @Override
    public Page<ScheduleJobVO> listByPage(ScheduleJobPageParam param) throws BusinessException {
        Page<ScheduleJobVO> page = sqlToyLazyDao.findPageBySql(param, "schedule_scheduleJob_findByPageParam", param.getScheduleJobVO());
        return page;
    }

    @Override
    public boolean delete(String id) throws BusinessException {
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setId(id).setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
        return sqlToyLazyDao.update(scheduleJob) > 0;
    }

    @Override
    public List<ScheduleJob> getAllActiveScheduleJob() {
        return sqlToyLazyDao.findBySql("schedule_scheduleJob_findByEntityParam", new ScheduleJob());
    }
}
