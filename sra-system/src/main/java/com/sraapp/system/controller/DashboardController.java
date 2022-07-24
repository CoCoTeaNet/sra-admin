package com.sraapp.system.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.sraapp.common.model.ApiResult;
import com.sraapp.system.service.IDashboardService;
import com.sraapp.system.vo.SystemInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

/**
 * @date 2022-1-26 11:36:32
 * @author jwss
 */
@Api(tags = "仪表盘接口")
@Validated
@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    @Resource
    private IDashboardService dashboardService;

    @GetMapping("index")
    @SaCheckPermission("system:dashboard:getSystemInfo")
    public ApiResult<String> index() {
        return ApiResult.ok("Hello sss-rbac-admin.");
    }

    @ApiOperation("获取数量统计")
    @GetMapping("getCount")
    @SaCheckPermission("system:dashboard:getCount")
    public ApiResult<List<Map<String, Object>>> getCount() {
        List<Map<String, Object>> count = dashboardService.getCount();
        return ApiResult.ok(count);
    }

    @ApiOperation("获取系统信息")
    @GetMapping("getSystemInfo")
    @SaCheckPermission("system:dashboard:getSystemInfo")
    @SaCheckLogin
    public ApiResult<SystemInfoVO> getSystemInfo() throws UnknownHostException {
        SystemInfoVO vo = dashboardService.getSystemInfo();
        return ApiResult.ok(vo);
    }

}
