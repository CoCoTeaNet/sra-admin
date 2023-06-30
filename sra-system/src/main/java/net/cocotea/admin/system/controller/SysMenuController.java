package net.cocotea.admin.system.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import net.cocotea.admin.system.param.menu.SysMenuAddParam;
import net.cocotea.admin.system.param.menu.SysMenuPageParam;
import net.cocotea.admin.system.param.menu.SysMenuUpdateParam;
import net.cocotea.admin.system.service.SysMenuService;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.system.vo.SysMenuVO;
import org.sagacity.sqltoy.model.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * @date 2022-1-16 15:37:26
 * @author jwss
 */
@Validated
@RestController
@RequestMapping("/system/menu")
public class SysMenuController {
    @Resource
    private SysMenuService sysMenuService;

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("add")
    public ApiResult<String> add(@Valid @RequestBody SysMenuAddParam param) throws BusinessException {
        boolean b = sysMenuService.add(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("deleteBatch")
    public ApiResult<String> deleteBatch(@Valid @RequestBody List<String> idList) throws BusinessException {
        boolean b = sysMenuService.deleteBatch(idList);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("update")
    public ApiResult<String> update(@Valid @RequestBody SysMenuUpdateParam param) throws BusinessException {
        boolean b = sysMenuService.update(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("listByPage")
    public ApiResult<Page<SysMenuVO>> listByPage(@Valid @RequestBody SysMenuPageParam pageParam) throws BusinessException {
        Page<SysMenuVO> menus = sysMenuService.listByPage(pageParam);
        return ApiResult.ok(menus);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("listByTree")
    public ApiResult<?> listByTree(@Valid @RequestBody SysMenuPageParam param) {
        Collection<SysMenuVO> menus = sysMenuService.listByTree(param);
        return ApiResult.ok(menus);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("listByTreeAsRoleSelection")
    public ApiResult<?> listByTreeAsRoleSelection(@Valid @RequestBody SysMenuPageParam pageParam) {
        Collection<SysMenuVO> menus = sysMenuService.listByTreeAsRoleSelection(pageParam);
        return ApiResult.ok(menus);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @GetMapping("listByRoleId/{roleId}")
    public ApiResult<List<SysMenuVO>> listByRoleId(@PathVariable String roleId) {
        List<SysMenuVO> menus = sysMenuService.listByRoleId(roleId);
        return ApiResult.ok(menus);
    }
}
