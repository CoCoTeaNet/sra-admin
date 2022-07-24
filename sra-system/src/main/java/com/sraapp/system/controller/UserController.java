package com.sraapp.system.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import com.sraapp.common.model.ApiResult;
import com.sraapp.common.model.BusinessException;
import com.sraapp.system.service.IUserService;
import com.sraapp.system.vo.LoginUserVO;
import com.sraapp.system.vo.UserVO;
import com.sraapp.system.param.user.UserAddParam;
import com.sraapp.system.param.user.UserLoginParam;
import com.sraapp.system.param.user.UserPageParam;
import com.sraapp.system.param.user.UserUpdateParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sagacity.sqltoy.model.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author jwss
 */
@Api(tags = "系统用户接口")
@Validated
@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    private IUserService userService;

    @ApiOperation(value = "新增用户")
    @SaCheckPermission("system:user:add")
    @PostMapping("/add")
    public ApiResult<String> add(@Valid @RequestBody UserAddParam param) throws BusinessException {
        boolean b = userService.add(param);
        return ApiResult.flag(b);
    }

    @ApiOperation(value = "更新用户信息")
    @SaCheckPermission("system:user:update")
    @PostMapping("/update")
    public ApiResult<String> update(@Valid @RequestBody UserUpdateParam param) throws BusinessException {
        boolean b = userService.update(param);
        return ApiResult.flag(b);
    }

    @ApiOperation(value = "删除用户")
    @SaCheckPermission("system:user:delete")
    @PostMapping("/delete/{id}")
    public ApiResult<String> delete(@PathVariable String id) throws BusinessException {
        boolean b = userService.delete(id);
        return ApiResult.flag(b);
    }

    @ApiOperation(value = "批量删除用户")
    @SaCheckPermission("system:user:delete")
    @PostMapping("/deleteBatch")
    public ApiResult<String> deleteBatch(@RequestBody List<String> idList) throws BusinessException {
        boolean b = userService.deleteBatch(idList);
        return ApiResult.flag(b);
    }

    @ApiOperation(value = "分页获取用户")
    @SaCheckPermission("system:user:listByPage")
    @PostMapping("/listByPage")
    public ApiResult<Page<UserVO>> listByPage(@Valid @RequestBody UserPageParam param) throws BusinessException {
        Page<UserVO> list = userService.listByPage(param);
        return ApiResult.ok(list);
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public ApiResult<LoginUserVO> login(@Valid @RequestBody UserLoginParam param, HttpServletRequest request) throws BusinessException {
        LoginUserVO s = userService.login(param, request);
        return ApiResult.ok(s);
    }

    @ApiOperation(value = "用户退出登录")
    @PostMapping("/logout")
    public ApiResult<String> logout() {
        StpUtil.logout();
        return ApiResult.ok();
    }

    @ApiOperation(value = "用户获取个人详细信息")
    @SaCheckLogin
    @GetMapping("/getDetail")
    public ApiResult<UserVO> getDetail() {
        UserVO vo = userService.getDetail();
        return ApiResult.ok(vo);
    }
}
