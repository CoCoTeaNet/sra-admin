package com.sraapp.schedule.controller;

import com.sraapp.common.model.ApiResult;
import com.sraapp.common.model.BusinessException;
import com.sraapp.schedule.entity.ScheduleJobLog;
import com.sraapp.schedule.param.ScheduleJobLogPageParam;
import com.sraapp.schedule.param.ScheduleJobPageParam;
import com.sraapp.schedule.service.IScheduleJobLogService;
import com.sraapp.schedule.vo.ScheduleJobLogVO;
import com.sraapp.schedule.vo.ScheduleJobVO;
import org.sagacity.sqltoy.model.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Guo wentao
 * @project sss-rbac-admin
 * @date 2022-09-03 16:55:03
 */
@RequestMapping("/schedule/log")
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
