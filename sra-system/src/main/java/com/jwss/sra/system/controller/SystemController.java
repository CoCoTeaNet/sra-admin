package com.jwss.sra.system.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.jwss.sra.common.model.ApiResult;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date 2022-1-26 11:36:32
 * @author jwss
 */
@Api(tags = "仪表盘接口")
@Validated
@RestController
@RequestMapping("/dashboard")
public class SystemController {

    @GetMapping("index")
    @SaCheckPermission("system:dashboard:getSystemInfo")
    public ApiResult<String> index() {
        return ApiResult.ok("Hello sss-rbac-admin.");
    }

}
