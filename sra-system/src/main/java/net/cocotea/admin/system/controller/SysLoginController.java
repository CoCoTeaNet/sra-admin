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
import net.cocotea.admin.system.param.login.SysCaptchaParam;
import net.cocotea.admin.system.param.login.SysLoginParam;
import net.cocotea.admin.system.service.SysUserService;
import net.cocotea.admin.system.vo.SysLoginUserVO;
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
@RequestMapping("/system")
public class SysLoginController {
    @Resource
    private SysUserService sysUserService;

    @Resource
    private IRedisService redisService;

    @PostMapping("/login")
    public ApiResult<?> login(@Valid @RequestBody SysLoginParam param, HttpServletRequest request) throws BusinessException {
        SysLoginUserVO r = sysUserService.login(param, request);
        return ApiResult.ok(r);
    }

    @PostMapping("/logout")
    public ApiResult<String> logout() {
        if ( StpUtil.isLogin() ) {
            // 删除权限缓存
            redisService.delete(String.format(RedisKey.USER_PERMISSION, StpUtil.getLoginId()));
            redisService.delete(String.format(RedisKey.ONLINE_USER, StpUtil.getLoginId()));
            StpUtil.logout();
        }
        return ApiResult.ok();
    }

    @SaCheckLogin
    @GetMapping("/loginInfo")
    public ApiResult<?> userInfo() {
        SysLoginUserVO r = sysUserService.loginUser();
        return ApiResult.ok(r);
    }

    @PostMapping("/captcha")
    public ApiResult<String> captcha(@Valid @RequestBody SysCaptchaParam param, HttpServletRequest request) {
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
