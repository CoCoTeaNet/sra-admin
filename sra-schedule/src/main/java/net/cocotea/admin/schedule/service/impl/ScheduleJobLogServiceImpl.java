package net.cocotea.admin.schedule.service.impl;

import net.cocotea.admin.schedule.entity.ScheduleJobLog;
import net.cocotea.admin.schedule.param.ScheduleJobLogAddParam;
import net.cocotea.admin.schedule.param.ScheduleJobLogPageParam;
import net.cocotea.admin.schedule.param.ScheduleJobLogUpdateParam;
import net.cocotea.admin.schedule.service.ScheduleJobLogService;
import net.cocotea.admin.schedule.vo.ScheduleJobLogVO;
import net.cocotea.admin.common.enums.DeleteStatusEnum;
import cn.hutool.core.convert.Convert;
import net.cocotea.admin.common.model.BusinessException;
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
public class ScheduleJobLogServiceImpl implements ScheduleJobLogService {

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
            ScheduleJobLog scheduleJobLog = new ScheduleJobLog();
            scheduleJobLog.setId(s).setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
            scheduleJobs.add(scheduleJobLog);
        }
        return sqlToyLazyDao.updateAll(scheduleJobs) > 0;
    }

    @Override
    public boolean update(ScheduleJobLogUpdateParam param) throws BusinessException {
        throw new BusinessException("不支持更新操作");
    }

    @Override
    public Page<ScheduleJobLogVO> listByPage(ScheduleJobLogPageParam param) throws BusinessException {
        if (param.getTriggerTimeRange() != null && !param.getTriggerTimeRange().isEmpty()) {
            param.setBeginTime(param.getTriggerTimeRange().get(0)).setEndTime(param.getTriggerTimeRange().get(1));
        }
        return sqlToyLazyDao.findPageBySql(param, "schedule_scheduleJobLog_findByPageParam", param.getJobLog());
    }

    @Override
    public boolean delete(String id) throws BusinessException {
        ScheduleJobLog scheduleJobLog = new ScheduleJobLog()
                .setId(id)
                .setDeleteStatus(DeleteStatusEnum.DELETE.getCode());
        return sqlToyLazyDao.update(scheduleJobLog) > 0;
    }
}
