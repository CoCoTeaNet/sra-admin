package net.cocotea.system.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import net.cocotea.common.model.ApiResult;
import net.cocotea.common.model.BusinessException;
import net.cocotea.system.service.IRoleService;
import net.cocotea.system.vo.RoleMenuVO;
import net.cocotea.system.vo.RoleVO;
import net.cocotea.system.param.role.RoleAddParam;
import net.cocotea.system.param.role.RolePageParam;
import net.cocotea.system.param.role.RoleUpdateParam;
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
@RequestMapping("/role")
@RestController
public class RoleController {
    @Resource
    private IRoleService roleService;

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/add")
    public ApiResult<String> add(@Valid @RequestBody RoleAddParam param) throws BusinessException {
        boolean b = roleService.add(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/update")
    public ApiResult<String> update(@Valid @RequestBody RoleUpdateParam param) throws BusinessException {
        boolean b = roleService.update(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/delete/{id}")
    public ApiResult<String> delete(@PathVariable String id) throws BusinessException {
        boolean b = roleService.delete(id);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/deleteBatch")
    public ApiResult<String> deleteBatch(@RequestBody List<String> idList) throws BusinessException {
        boolean b = roleService.deleteBatch(idList);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/grantPermissionsByRoleId")
    public ApiResult<String> grantPermissionsByRoleId(@Valid @RequestBody List<RoleMenuVO> param) throws BusinessException {
        boolean b = roleService.grantPermissionsByRoleId(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/listByPage")
    public ApiResult<Page<RoleVO>> listByPage(@Valid @RequestBody RolePageParam param) throws BusinessException {
        Page<RoleVO> p = roleService.listByPage(param);
        return ApiResult.ok(p);
    }
}
