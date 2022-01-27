package com.jwss.sra.system.controller;

import com.jwss.sra.common.model.ApiResult;
import com.jwss.sra.system.vo.SystemInfoVO;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date 2022-1-12 14:25:41
 * @author jwss
 */
@Api(tags = "测试接口")
@Validated
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("index")
    public ApiResult<String> index() {
        return ApiResult.ok("Hello sss-rbac-admin.");
    }

    @GetMapping("result")
    public ApiResult<SystemInfoVO> getResult() {
        return ApiResult.ok(new SystemInfoVO());
    }
}
