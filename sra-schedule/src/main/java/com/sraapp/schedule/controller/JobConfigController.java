package com.sraapp.schedule.controller;

import com.sraapp.common.model.ApiResult;
import com.sraapp.schedule.service.IJobConfigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/schedule")
public class JobConfigController {
    @Resource
    private IJobConfigService jobConfigService;

    @GetMapping("/setCorn")
    public ApiResult<?> setCorn(@RequestParam("corn") String corn) {
        jobConfigService.setCorn(corn);
        return ApiResult.ok();
    }
}
