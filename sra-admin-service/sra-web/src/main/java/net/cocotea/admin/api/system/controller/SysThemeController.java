package net.cocotea.admin.api.system.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import net.cocotea.admin.api.system.model.dto.SysThemeUpdateDTO;
import net.cocotea.admin.api.system.model.vo.SysThemeVO;
import net.cocotea.admin.api.system.service.SysThemeService;
import net.cocotea.admin.common.model.ApiResult;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

import jakarta.validation.Valid;

/**
 * 系统主题接口
 *
 * @author CoCoTea
 * @version 2.0.0
 */
@RequestMapping("/system/theme")
@RestController
public class SysThemeController {
    @Resource
    private SysThemeService sysThemeService;

    /**
     * 更新用户主题信息
     *
     * @param updateDTO {@link SysThemeUpdateDTO}
     * @return 成功返回TRUE
     */
    @SaCheckLogin
    @PostMapping("/updateByUser")
    public ApiResult<Boolean> updateByUser(@Valid @RequestBody SysThemeUpdateDTO updateDTO) {
        boolean b = sysThemeService.updateByUser(updateDTO);
        return ApiResult.ok(b);
    }

    /**
     * 获取用户主题信息
     *
     * @return {@link SysThemeVO}
     */
    @SaCheckLogin
    @GetMapping("/loadByUser")
    public ApiResult<SysThemeVO> loadByUser() {
        SysThemeVO b = sysThemeService.loadByUser();
        return ApiResult.ok(b);
    }
}
