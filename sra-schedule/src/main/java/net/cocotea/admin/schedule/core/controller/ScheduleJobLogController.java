package net.cocotea.admin.schedule.core.controller;

import net.cocotea.admin.schedule.core.param.ScheduleJobLogPageParam;
import net.cocotea.admin.schedule.core.service.ScheduleJobLogService;
import net.cocotea.admin.schedule.core.vo.ScheduleJobLogVO;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import org.sagacity.sqltoy.model.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/schedule/jobLog")
@RestController
public class ScheduleJobLogController {
    @Resource
    private ScheduleJobLogService scheduleJobLogService;


    @PostMapping("/deleteBatch")
    public ApiResult<?> deleteBatch(@RequestBody List<String> param) throws BusinessException {
        boolean r = scheduleJobLogService.deleteBatch(param);
        return ApiResult.ok(r);
    }

    @PostMapping("/listByPage")
    public ApiResult<?> listByPage(@RequestBody ScheduleJobLogPageParam param) throws BusinessException {
        Page<ScheduleJobLogVO> r = scheduleJobLogService.listByPage(param);
        return ApiResult.ok(r);
    }

}
