package com.jwss.sra.system.controller;

import com.jwss.sra.common.model.ApiResult;
import com.jwss.sra.system.param.menu.MenuPageParam;
import com.jwss.sra.system.param.menu.MenuUpdateParam;
import com.jwss.sra.system.param.menu.MenuAddParam;
import com.jwss.sra.system.service.IMenuService;
import com.jwss.sra.system.vo.MenuVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("批量删除菜单")
    @PostMapping("deleteBatch")
    public ApiResult<String> deleteBatch(@Valid @RequestBody List<String> idList) {
        boolean b = menuService.deleteBatch(idList);
        return ApiResult.flag(b);
    }

    @ApiOperation("更新菜单")
    @PostMapping("update")
    public ApiResult<String> update(@Valid @RequestBody MenuUpdateParam param) {
        boolean b = menuService.update(param);
        return ApiResult.flag(b);
    }

    @ApiOperation("获取菜单树")
    @PostMapping("listByTree")
    public ApiResult<Page<MenuVO>> listByTree(@Valid @RequestBody MenuPageParam pageParam) {
        Page<MenuVO> menus = menuService.listByTree(pageParam);
        return ApiResult.ok(menus);
    }

    @ApiOperation("获取菜单树")
    @GetMapping("listByRoleId/{roleId}")
    public ApiResult<List<MenuVO>> listByRoleId(@PathVariable String roleId) {
        List<MenuVO> menus = menuService.listByRoleId(roleId);
        return ApiResult.ok(menus);
    }
}
