package net.cocotea.admin.system.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.system.param.theme.SysThemeUpdateParam;
import net.cocotea.admin.system.service.ISysThemeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Validated
@RequestMapping("/system/theme")
@RestController
public class SysThemeController {
    @Resource
    private ISysThemeService sysThemeService;

    @SaCheckLogin
    @PostMapping("/updateByUser")
    public ApiResult<?> updateByUser(@RequestBody SysThemeUpdateParam param) {
        boolean b = sysThemeService.updateByUser(param);
        return ApiResult.ok(b);
    }
}
