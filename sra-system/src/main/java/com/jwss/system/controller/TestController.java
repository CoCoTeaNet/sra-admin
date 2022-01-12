package com.jwss.system.controller;

import com.jwss.common.model.ApiResult;
import com.jwss.system.service.IUserService;
import org.sagacity.sqltoy.model.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @date 2022-1-12 14:25:41
 * @author jwss
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private IUserService userService;

    @GetMapping("index")
    public ApiResult<String> index() {
        return ApiResult.ok("Hello sss-rbac-admin.");
    }

    @GetMapping("result")
    public ApiResult<String> getResult() {
        return ApiResult.ok();
    }
}
