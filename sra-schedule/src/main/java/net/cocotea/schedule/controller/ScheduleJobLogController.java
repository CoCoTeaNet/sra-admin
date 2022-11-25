package net.cocotea.schedule.controller;

import net.cocotea.common.model.ApiResult;
import net.cocotea.common.model.BusinessException;
import net.cocotea.schedule.service.IScheduleJobLogService;
import net.cocotea.schedule.vo.ScheduleJobLogVO;
import net.cocotea.schedule.param.ScheduleJobLogPageParam;
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
    private IScheduleJobLogService scheduleJobLogService;


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
