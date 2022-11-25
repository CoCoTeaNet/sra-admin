package net.cocotea.admin.system.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.framework.constant.RedisKey;
import net.cocotea.admin.framework.service.IRedisService;
import net.cocotea.admin.framework.util.IpUtils;
import net.cocotea.admin.system.param.login.CaptchaParam;
import net.cocotea.admin.system.param.login.LoginParam;
import net.cocotea.admin.system.service.IUserService;
import net.cocotea.admin.system.vo.LoginUserVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author CoCoTea
 */
@Validated
@RestController
public class LoginController {
    @Resource
    private IUserService userService;

    @Resource
    private IRedisService redisService;

    @PostMapping("/login")
    public ApiResult<?> login(@Valid @RequestBody LoginParam param, HttpServletRequest request) throws BusinessException {
        LoginUserVO r = userService.login(param, request);
        return ApiResult.ok(r);
    }

    @SaCheckLogin
    @PostMapping("/logout")
    public ApiResult<String> logout() {
        StpUtil.logout();
        return ApiResult.ok();
    }

    @SaCheckLogin
    @GetMapping("/loginInfo")
    public ApiResult<?> userInfo() {
        LoginUserVO r = userService.loginUser();
        return ApiResult.ok(r);
    }

    @PostMapping("/captcha")
    public ApiResult<String> captcha(@Valid @RequestBody CaptchaParam param, HttpServletRequest request) {
        // 生成圆圈干扰的验证码
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
        redisService.save(
                String.format(RedisKey.VERIFY_CODE, param.getCodeType(), IpUtils.getIp(request)),
                captcha.getCode(),
                300L
        );
        return ApiResult.ok(captcha.getImageBase64());
    }
}
