package com.sraapp.schedule.controller;

import com.sraapp.common.model.ApiResult;
import com.sraapp.common.model.BusinessException;
import com.sraapp.schedule.param.ScheduleJobAddParam;
import com.sraapp.schedule.param.ScheduleJobPageParam;
import com.sraapp.schedule.param.ScheduleJobUpdateParam;
import com.sraapp.schedule.service.ScheduleService;
import com.sraapp.schedule.vo.ScheduleJobVo;
import org.sagacity.sqltoy.model.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/schedule")
@RestController
public class ScheduleJobController {
    @Resource
    private ScheduleService scheduleService;

    @PostMapping("/add")
    public ApiResult<?> add(@RequestBody ScheduleJobAddParam param) throws BusinessException {
        boolean r = scheduleService.add(param);
        return ApiResult.ok(r);
    }

    @PostMapping("/deleteBatch")
    public ApiResult<?> deleteBatch(@RequestBody List<String> param) throws BusinessException {
        boolean r = scheduleService.deleteBatch(param);
        return ApiResult.ok(r);
    }

    @PostMapping("/listByPage")
    public ApiResult<?> listByPage(@RequestBody ScheduleJobPageParam param) throws BusinessException {
        Page<ScheduleJobVo> r = scheduleService.listByPage(param);
        return ApiResult.ok(r);
    }

    @PostMapping("/update")
    public ApiResult<?> update(@RequestBody ScheduleJobUpdateParam param) throws BusinessException {
        boolean r = scheduleService.update(param);
        return ApiResult.ok(r);
    }
}
