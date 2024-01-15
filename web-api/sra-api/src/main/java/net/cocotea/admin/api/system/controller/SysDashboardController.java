package net.cocotea.admin.api.system.controller;

import cn.hutool.json.JSONUtil;
import net.cocotea.admin.api.system.model.vo.SystemInfoVO;
import net.cocotea.admin.api.system.service.SysDashboardService;
import net.cocotea.admin.common.constant.RedisKeyConst;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.service.RedisService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @date 2022-1-26 11:36:32
 * @author CoCoTea
 */
@Validated
@RestController
@RequestMapping("/system/dashboard")
public class SysDashboardController {
    @Resource
    private SysDashboardService sysDashboardService;

    @GetMapping("index")
    public ApiResult<String> index() {
        return ApiResult.ok("Hello SRA-ADMIN.");
    }

    @GetMapping("getCount")
    public ApiResult<List<Map<String, Object>>> getCount() {
        List<Map<String, Object>> count = sysDashboardService.getCount();
        return ApiResult.ok(count);
    }

    @GetMapping("getSystemInfo")
    public ApiResult<SystemInfoVO> getSystemInfo() {
        SystemInfoVO vo = sysDashboardService.getSystemInfo();
        return ApiResult.ok(vo);
    }
    
}
