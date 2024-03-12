package net.cocotea.admin.api.system.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import net.cocotea.admin.api.system.model.dto.SysRoleAddDTO;
import net.cocotea.admin.api.system.model.dto.SysRolePageDTO;
import net.cocotea.admin.api.system.model.dto.SysRoleUpdateDTO;
import net.cocotea.admin.api.system.model.vo.SysRoleMenuVO;
import net.cocotea.admin.api.system.model.vo.SysRoleVO;
import net.cocotea.admin.api.system.service.SysRoleService;
import net.cocotea.admin.common.model.ApiPage;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

@RequestMapping("/system/role")
@RestController
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/add")
    public ApiResult<?> add(@Valid @RequestBody SysRoleAddDTO param) throws BusinessException {
        boolean b = sysRoleService.add(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/update")
    public ApiResult<?> update(@Valid @RequestBody SysRoleUpdateDTO param) throws BusinessException {
        boolean b = sysRoleService.update(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/delete/{id}")
    public ApiResult<?> delete(@PathVariable BigInteger id) throws BusinessException {
        boolean b = sysRoleService.delete(id);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/deleteBatch")
    public ApiResult<?> deleteBatch(@RequestBody List<BigInteger> idList) throws BusinessException {
        boolean b = sysRoleService.deleteBatch(idList);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/grantPermissionsByRoleId")
    public ApiResult<?> grantPermissionsByRoleId(@Valid @RequestBody List<SysRoleMenuVO> param) throws BusinessException {
        boolean b = sysRoleService.grantPermissionsByRoleId(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/listByPage")
    public ApiResult<?> listByPage(@Valid @RequestBody SysRolePageDTO param) throws BusinessException {
        ApiPage<SysRoleVO> p = sysRoleService.listByPage(param);
        return ApiResult.ok(p);
    }
}
