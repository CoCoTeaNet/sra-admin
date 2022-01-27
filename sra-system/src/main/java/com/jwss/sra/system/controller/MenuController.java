package com.jwss.sra.system.controller;

import com.jwss.sra.common.model.ApiResult;
import com.jwss.sra.system.param.menu.MenuUpdateParam;
import com.jwss.sra.system.param.menu.MenuAddParam;
import com.jwss.sra.system.service.IMenuService;
import com.jwss.sra.system.vo.MenuVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @date 2022-1-16 15:37:26
 * @author jwss
 */
@Api(tags = "系统菜单接口")
@Validated
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private IMenuService menuService;

    @ApiOperation("新增菜单")
    @PostMapping("add")
    public ApiResult<String> add(@Valid @RequestBody MenuAddParam param) {
        boolean b = menuService.add(param);
        return ApiResult.flag(b);
    }

    @ApiOperation("删除菜单")
    @PostMapping("delete/{id}")
    public ApiResult<String> delete(@PathVariable String id) {
        boolean b = menuService.delete(id);
        return ApiResult.flag(b);
    }

    @ApiOperation("更新菜单")
    @PostMapping("update")
    public ApiResult<String> update(@Valid @RequestBody MenuUpdateParam param) {
        boolean b = menuService.update(param);
        return ApiResult.flag(b);
    }

    @ApiOperation("获取菜单树")
    @GetMapping("listByTree")
    public ApiResult<List<MenuVO>> listByTree() {
        List<MenuVO> menus = menuService.listByTree();
        return ApiResult.ok(menus);
    }

    @ApiOperation("获取菜单树")
    @GetMapping("listByRoleId/{roleId}")
    public ApiResult<List<MenuVO>> listByRoleId(@PathVariable String roleId) {
        List<MenuVO> menus = menuService.listByRoleId(roleId);
        return ApiResult.ok(menus);
    }
}
