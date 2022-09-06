package com.sraapp.schedule.service.impl;

import cn.hutool.core.convert.Convert;
import com.sraapp.common.enums.ActiveEnum;
import com.sraapp.common.enums.DeleteStatusEnum;
import com.sraapp.common.model.BusinessException;
import com.sraapp.schedule.entity.ScheduleJob;
import com.sraapp.schedule.param.ScheduleJobAddParam;
import com.sraapp.schedule.param.ScheduleJobPageParam;
import com.sraapp.schedule.param.ScheduleJobUpdateParam;
import com.sraapp.schedule.service.IScheduleJobRegistryService;
import com.sraapp.schedule.service.IScheduleJobService;
import com.sraapp.schedule.vo.ScheduleJobVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Resource
    private IScheduleJobRegistryService scheduleJobRegistryService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean add(ScheduleJobAddParam param) throws BusinessException {
        ScheduleJob scheduleJob = Convert.convert(ScheduleJob.class, param);
        Object save = sqlToyLazyDao.save(scheduleJob);
        try {
            scheduleJobRegistryService.flushJob(scheduleJob);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        return save != null;
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
        Long row = sqlToyLazyDao.update(scheduleJob);
        if (row > 0) {
            try {
                if (scheduleJob.getActive() == 1) {
                    scheduleJobRegistryService.flushJob(scheduleJob);
                } else {
                    scheduleJobRegistryService.removeJob(scheduleJob.getId());
                }
            } catch (Exception e) {
                throw new BusinessException(e.getMessage());
            }
            return true;
        }
        return false;
    }

    @Override
    public Page<ScheduleJobVO> listByPage(ScheduleJobPageParam param) throws BusinessException {
        return sqlToyLazyDao.findPageBySql(param, "schedule_scheduleJob_findByPageParam", param.getScheduleJobVO());
    }

    @Override
    public boolean delete(String id) throws BusinessException {
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setId(id).setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
        Long row = sqlToyLazyDao.update(scheduleJob);
        if (row > 0) {
            try {
                scheduleJobRegistryService.removeJob(id);
            } catch (Exception e) {
                throw new BusinessException(e.getMessage());
            }
            return true;
        }
        return false;
    }

    @Override
    public List<ScheduleJob> getAllActiveScheduleJob() {
        ScheduleJob scheduleJob = new ScheduleJob().setActive(ActiveEnum.ACTIVE.getCode());
        return sqlToyLazyDao.findBySql("schedule_scheduleJob_findByEntityParam", scheduleJob);
    }
}
