package net.cocotea.admin.system.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import net.cocotea.admin.system.param.role.SysRoleAddParam;
import net.cocotea.admin.system.param.role.SysRolePageParam;
import net.cocotea.admin.system.param.role.SysRoleUpdateParam;
import net.cocotea.admin.system.service.SysRoleService;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.system.vo.SysRoleMenuVO;
import net.cocotea.admin.system.vo.SysRoleVO;
import org.sagacity.sqltoy.model.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author jwss
 */
@Validated
@RequestMapping("/system/role")
@RestController
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/add")
    public ApiResult<String> add(@Valid @RequestBody SysRoleAddParam param) throws BusinessException {
        boolean b = sysRoleService.add(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/update")
    public ApiResult<String> update(@Valid @RequestBody SysRoleUpdateParam param) throws BusinessException {
        boolean b = sysRoleService.update(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/delete/{id}")
    public ApiResult<String> delete(@PathVariable String id) throws BusinessException {
        boolean b = sysRoleService.delete(id);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/deleteBatch")
    public ApiResult<String> deleteBatch(@RequestBody List<String> idList) throws BusinessException {
        boolean b = sysRoleService.deleteBatch(idList);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/grantPermissionsByRoleId")
    public ApiResult<String> grantPermissionsByRoleId(@Valid @RequestBody List<SysRoleMenuVO> param) throws BusinessException {
        boolean b = sysRoleService.grantPermissionsByRoleId(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/listByPage")
    public ApiResult<Page<SysRoleVO>> listByPage(@Valid @RequestBody SysRolePageParam param) throws BusinessException {
        Page<SysRoleVO> p = sysRoleService.listByPage(param);
        return ApiResult.ok(p);
    }
}
