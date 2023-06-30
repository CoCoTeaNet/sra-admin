package net.cocotea.admin.system.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import net.cocotea.admin.system.service.SysVersionService;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.system.param.version.SysVersionAddParam;
import net.cocotea.admin.system.param.version.SysVersionPageParam;
import net.cocotea.admin.system.param.version.SysVersionUpdateParam;
import net.cocotea.admin.system.vo.SysVersionVO;
import org.sagacity.sqltoy.model.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Validated
@RequestMapping("/system/version")
@RestController
public class SysVersionController {
    @Resource
    private SysVersionService sysVersionService;
    
    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/add")
    public ApiResult<?> add(@Valid @RequestBody SysVersionAddParam param) throws BusinessException {
        boolean b = sysVersionService.add(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/deleteBatch")
    public ApiResult<?> deleteBatch(@RequestBody List<String> param) throws BusinessException {
        boolean b = sysVersionService.deleteBatch(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/update")
    public ApiResult<?> update(@Valid @RequestBody SysVersionUpdateParam param) throws BusinessException {
        boolean b = sysVersionService.update(param);
        return ApiResult.flag(b);
    }

    @SaCheckLogin
    @PostMapping("/listByPage")
    public ApiResult<?> listByPage(@Valid @RequestBody SysVersionPageParam param) throws BusinessException {
        Page<SysVersionVO> r = sysVersionService.listByPage(param);
        return ApiResult.ok(r);
    }
    
}
