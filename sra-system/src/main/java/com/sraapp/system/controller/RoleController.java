package com.sraapp.system.controller;

import com.sraapp.common.model.ApiResult;
import com.sraapp.common.model.BusinessException;
import com.sraapp.system.service.IRoleService;
import com.sraapp.system.vo.RoleMenuVO;
import com.sraapp.system.vo.RoleVO;
import com.sraapp.system.param.role.RoleAddParam;
import com.sraapp.system.param.role.RolePageParam;
import com.sraapp.system.param.role.RoleUpdateParam;
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

    @PostMapping("/add")
    public ApiResult<String> add(@Valid @RequestBody RoleAddParam param) throws BusinessException {
        boolean b = roleService.add(param);
        return ApiResult.flag(b);
    }

    @PostMapping("/update")
    public ApiResult<String> update(@Valid @RequestBody RoleUpdateParam param) throws BusinessException {
        boolean b = roleService.update(param);
        return ApiResult.flag(b);
    }

    @PostMapping("/delete/{id}")
    public ApiResult<String> delete(@PathVariable String id) throws BusinessException {
        boolean b = roleService.delete(id);
        return ApiResult.flag(b);
    }

    @PostMapping("/deleteBatch")
    public ApiResult<String> deleteBatch(@RequestBody List<String> idList) throws BusinessException {
        boolean b = roleService.deleteBatch(idList);
        return ApiResult.flag(b);
    }

    @PostMapping("/grantPermissionsByRoleId")
    public ApiResult<String> grantPermissionsByRoleId(@Valid @RequestBody List<RoleMenuVO> param) throws BusinessException {
        boolean b = roleService.grantPermissionsByRoleId(param);
        return ApiResult.flag(b);
    }

    @PostMapping("/listByPage")
    public ApiResult<Page<RoleVO>> listByPage(@Valid @RequestBody RolePageParam param) throws BusinessException {
        Page<RoleVO> p = roleService.listByPage(param);
        return ApiResult.ok(p);
    }
}
