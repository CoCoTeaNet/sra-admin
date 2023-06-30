package net.cocotea.admin.system.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.system.param.theme.SysThemeUpdateParam;
import net.cocotea.admin.system.service.SysThemeService;
import net.cocotea.admin.system.vo.SysThemeVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Validated
@RequestMapping("/system/theme")
@RestController
public class SysThemeController {
    @Resource
    private SysThemeService sysThemeService;

    @SaCheckLogin
    @PostMapping("/updateByUser")
    public ApiResult<?> updateByUser(@RequestBody SysThemeUpdateParam param) {
        boolean b = sysThemeService.updateByUser(param);
        return ApiResult.ok(b);
    }

    @SaCheckLogin
    @GetMapping("/loadByUser")
    public ApiResult<?> loadByUser() {
        SysThemeVO b = sysThemeService.loadByUser();
        return ApiResult.ok(b);
    }
}
