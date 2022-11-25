package net.cocotea.system.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import net.cocotea.common.model.ApiResult;
import net.cocotea.system.service.IDashboardService;
import net.cocotea.system.vo.SystemInfoVO;
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

    @GetMapping("getCount")
    @SaCheckPermission("system:dashboard:getCount")
    public ApiResult<List<Map<String, Object>>> getCount() {
        List<Map<String, Object>> count = dashboardService.getCount();
        return ApiResult.ok(count);
    }

    @GetMapping("getSystemInfo")
    @SaCheckPermission("system:dashboard:getSystemInfo")
    @SaCheckLogin
    public ApiResult<SystemInfoVO> getSystemInfo() throws UnknownHostException {
        SystemInfoVO vo = dashboardService.getSystemInfo();
        return ApiResult.ok(vo);
    }

}
