package com.sraapp.system.controller;

import com.sraapp.common.model.ApiResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date 2022-1-12 14:25:41
 * @author jwss
 */
@Validated
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("index")
    public ApiResult<String> index() {
        return ApiResult.ok("Hello sss-rbac-admin.");
    }
}
