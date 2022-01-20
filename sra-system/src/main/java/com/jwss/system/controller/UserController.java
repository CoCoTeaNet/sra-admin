package com.jwss.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.jwss.common.model.ApiResult;
import com.jwss.common.model.BusinessException;
import com.jwss.system.param.user.UserAddParam;
import com.jwss.system.param.user.UserLoginParam;
import com.jwss.system.service.IUserService;
import com.jwss.system.vo.LoginUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    @PostMapping("/add")
    public ApiResult<String> add(@Valid @RequestBody UserAddParam param){
        boolean b = userService.add(param);
        return ApiResult.flag(b);
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
