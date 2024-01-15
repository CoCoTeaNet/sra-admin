package net.cocotea.admin.api.system.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import net.cocotea.admin.api.system.model.dto.SysThemeUpdateDTO;
import net.cocotea.admin.api.system.model.vo.SysThemeVO;
import net.cocotea.admin.api.system.service.SysThemeService;
import net.cocotea.admin.common.model.ApiResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

@Validated
@RequestMapping("/system/theme")
@RestController
public class SysThemeController {
    @Resource
    private SysThemeService sysThemeService;

    @SaCheckLogin
    @PostMapping("/updateByUser")
    public ApiResult<?> updateByUser(@RequestBody SysThemeUpdateDTO param) {
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
