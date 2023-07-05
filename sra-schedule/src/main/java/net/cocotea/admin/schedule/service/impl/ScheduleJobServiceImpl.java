package net.cocotea.admin.schedule.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.UUID;
import net.cocotea.admin.common.enums.ActiveEnum;
import net.cocotea.admin.common.enums.DeleteStatusEnum;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.schedule.entity.ScheduleJob;
import net.cocotea.admin.schedule.param.ScheduleJobAddParam;
import net.cocotea.admin.schedule.param.ScheduleJobPageParam;
import net.cocotea.admin.schedule.param.ScheduleJobUpdateParam;
import net.cocotea.admin.schedule.service.ScheduleJobRegistryService;
import net.cocotea.admin.schedule.service.ScheduleJobService;
import net.cocotea.admin.schedule.vo.ScheduleJobVO;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.sagacity.sqltoy.model.Page;
import org.springframework.scheduling.support.CronExpression;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 计划任务管理服务
 *
 * @author Guo wentao
 * @date 2022/8/9
 */
@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {
    @Resource
    private SqlToyLazyDao sqlToyLazyDao;

    @Resource
    private ScheduleJobRegistryService scheduleJobRegistryService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean add(ScheduleJobAddParam param) throws BusinessException {
        ScheduleJob scheduleJob = Convert.convert(ScheduleJob.class, param);
        if (!CronExpression.isValidExpression(scheduleJob.getCornExpression())) {
            throw new BusinessException("非法Cron表达式，请检查表达式格式");
        }
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean update(ScheduleJobUpdateParam param) throws BusinessException {
        ScheduleJob scheduleJob = Convert.convert(ScheduleJob.class, param);
        if (!CronExpression.isValidExpression(scheduleJob.getCornExpression())) {
            throw new BusinessException("非法Cron表达式，请检查表达式格式");
        }
        Long row = sqlToyLazyDao.update(scheduleJob);
        if (row > 0) {
            try {
                if (Objects.equals(scheduleJob.getActive(), ActiveEnum.ACTIVE.getCode())) {
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
        return sqlToyLazyDao.findPageBySql(param, "schedule_scheduleJob_findByPageParam", param.getJob());
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
    public List<ScheduleJob> getAllActiveScheduleJob() throws BusinessException {
        ScheduleJob scheduleJob = new ScheduleJob().setActive(ActiveEnum.ACTIVE.getCode());
        return sqlToyLazyDao.findBySql("schedule_scheduleJob_findByEntityParam", scheduleJob);
    }

    @Override
    public String execute(String id) throws BusinessException {
        String uuid = UUID.fastUUID().toString(true);
        ScheduleJob scheduleJob = new ScheduleJob().setId(id);
        try {
            scheduleJobRegistryService.start(uuid, sqlToyLazyDao.load(scheduleJob));
            return uuid;
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public boolean getExecuteProgress(String uuid) throws BusinessException {
        return !scheduleJobRegistryService.isRunning(uuid);
    }
}
