package com.jwss.system.controller;

import com.jwss.common.model.ApiResult;
import com.jwss.system.param.menu.MenuAddParam;
import com.jwss.system.param.menu.MenuPageParam;
import com.jwss.system.service.IMenuService;
import com.jwss.system.vo.MenuVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sagacity.sqltoy.model.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @date 2022-1-16 15:37:26
 * @author jwss
 */
@Api(tags = "菜单接口")
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

    @ApiOperation("分页查询菜单")
    @PostMapping("listByPage")
    public ApiResult<Page<MenuVO>> listByPage(@Valid @RequestBody MenuPageParam param) {
        Page<MenuVO> list = menuService.listByPage(param);
        return ApiResult.ok(list);
    }
}
