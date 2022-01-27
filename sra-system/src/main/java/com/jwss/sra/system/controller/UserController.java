package com.jwss.sra.system.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import com.jwss.sra.common.model.ApiResult;
import com.jwss.sra.common.model.BusinessException;
import com.jwss.sra.system.param.user.UserAddParam;
import com.jwss.sra.system.param.user.UserLoginParam;
import com.jwss.sra.system.param.user.UserPageParam;
import com.jwss.sra.system.service.IUserService;
import com.jwss.sra.system.vo.LoginUserVO;
import com.jwss.sra.system.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sagacity.sqltoy.model.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

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
    public ApiResult<String> add(@Valid @RequestBody UserAddParam param){
        boolean b = userService.add(param);
        return ApiResult.flag(b);
    }

    @ApiOperation(value = "分页获取用户")
    @SaCheckPermission("system:user:listByPage")
    @PostMapping("/listByPage")
    public ApiResult<Page<UserVO>> listByPage(@Valid @RequestBody UserPageParam param){
        Page<UserVO> list = userService.listByPage(param);
        return ApiResult.ok(list);
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public ApiResult<LoginUserVO> login(@Valid @RequestBody UserLoginParam param) throws BusinessException {
        LoginUserVO s = userService.login(param);
        return ApiResult.ok(s);
    }

    @ApiOperation(value = "用户退出登录")
    @PostMapping("/logout")
    public ApiResult<String> logout(){
        StpUtil.logout();
        return ApiResult.ok();
    }
}
