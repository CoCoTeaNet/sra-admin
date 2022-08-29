package com.sraapp.schedule.controller;

import com.sraapp.common.model.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/schedule")
public class JobConfigController {
    private final static Logger logger = LoggerFactory.getLogger(JobConfigController.class);

    @GetMapping("/new")
    public ApiResult<?> createNewJob(String jobName,
                                     @RequestParam(required = false,
                                             defaultValue = "* * * * * ?") String cron) {

        return ApiResult.ok();
    }
}
