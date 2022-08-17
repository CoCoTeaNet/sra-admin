package com.sraapp.system.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import com.sraapp.common.model.ApiResult;
import com.sraapp.common.model.BusinessException;
import com.sraapp.system.service.IMenuService;
import com.sraapp.system.vo.MenuVO;
import com.sraapp.system.param.menu.MenuPageParam;
import com.sraapp.system.param.menu.MenuUpdateParam;
import com.sraapp.system.param.menu.MenuAddParam;
import org.sagacity.sqltoy.model.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @date 2022-1-16 15:37:26
 * @author jwss
 */
@Validated
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private IMenuService menuService;

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("add")
    public ApiResult<String> add(@Valid @RequestBody MenuAddParam param) throws BusinessException {
        boolean b = menuService.add(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("deleteBatch")
    public ApiResult<String> deleteBatch(@Valid @RequestBody List<String> idList) throws BusinessException {
        boolean b = menuService.deleteBatch(idList);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("update")
    public ApiResult<String> update(@Valid @RequestBody MenuUpdateParam param) throws BusinessException {
        boolean b = menuService.update(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("listByPage")
    public ApiResult<Page<MenuVO>> listByPage(@Valid @RequestBody MenuPageParam pageParam) throws BusinessException {
        Page<MenuVO> menus = menuService.listByPage(pageParam);
        return ApiResult.ok(menus);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("listByTree")
    public ApiResult<Page<MenuVO>> listByTree(@Valid @RequestBody MenuPageParam pageParam) {
        Page<MenuVO> menus = menuService.listByTree(pageParam);
        return ApiResult.ok(menus);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @GetMapping("listByRoleId/{roleId}")
    public ApiResult<List<MenuVO>> listByRoleId(@PathVariable String roleId) {
        List<MenuVO> menus = menuService.listByRoleId(roleId);
        return ApiResult.ok(menus);
    }
}
