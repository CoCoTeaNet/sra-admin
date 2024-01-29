package net.cocotea.admin.api.system.controller;

import net.cocotea.admin.api.system.model.vo.SysOverviewVO;
import net.cocotea.admin.api.system.model.vo.SystemInfoVO;
import net.cocotea.admin.api.system.service.SysDashboardService;
import net.cocotea.admin.common.model.ApiResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

import java.util.List;

/**
 * 系统仪表盘接口
 *
 * @author CoCoTea
 * @version 2.0.0
 */
@Validated
@RestController
@RequestMapping("/system/dashboard")
public class SysDashboardController {
    @Resource
    private SysDashboardService sysDashboardService;

    /**
     * 测试服务是否运行成功
     *
     * @return 字符串
     */
    @GetMapping("index")
    public ApiResult<String> index() {
        return ApiResult.ok("Hello SRA-ADMIN.");
    }

    /**
     * 获取系统数据概览
     *
     * @return {@link SysOverviewVO}
     */
    @GetMapping("getCount")
    public ApiResult<List<SysOverviewVO>> getCount() {
        List<SysOverviewVO> voList = sysDashboardService.getCount();
        return ApiResult.ok(voList);
    }

    /**
     * 获取服务器运行信息
     *
     * @return {@link SystemInfoVO}
     */
    @GetMapping("getSystemInfo")
    public ApiResult<SystemInfoVO> getSystemInfo() {
        SystemInfoVO vo = sysDashboardService.getSystemInfo();
        return ApiResult.ok(vo);
    }

}
