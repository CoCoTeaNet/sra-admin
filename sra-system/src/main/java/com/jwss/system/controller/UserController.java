package com.jwss.system.controller;

import com.jwss.common.model.ApiResult;
import com.jwss.system.param.UserAddParam;
import com.jwss.system.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jwss
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    private IUserService userService;

    @PostMapping("/add")
    public ApiResult<String> add(@RequestBody UserAddParam param){
        boolean b = userService.add(param);
        return ApiResult.flag(b);
    }
}
