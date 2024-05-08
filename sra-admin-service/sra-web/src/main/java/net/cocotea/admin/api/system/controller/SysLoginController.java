package net.cocotea.admin.api.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import net.cocotea.admin.api.system.model.dto.SysCaptchaDTO;
import net.cocotea.admin.api.system.model.dto.SysLoginDTO;
import net.cocotea.admin.api.system.model.vo.SysLoginUserVO;
import net.cocotea.admin.api.system.service.SysUserService;
import net.cocotea.admin.common.constant.RedisKeyConst;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.common.service.RedisService;
import net.cocotea.admin.common.util.IpUtils;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.validation.Valid;

/**
 * 系统登录相关接口
 *
 * @author CoCoTea
 */
@RestController
@RequestMapping("/system")
public class SysLoginController {
    @Resource
    private SysUserService userService;

    @Resource
    private RedisService redisService;

    /**
     * 后台系统用户登录
     *
     * @param dto     {@link SysLoginDTO}
     * @param request {@link HttpServletRequest}
     * @return {@link ApiResult}
     */
    @PostMapping("/login")
    public ApiResult<?> login(@Valid @RequestBody SysLoginDTO dto, HttpServletRequest request) throws BusinessException {
        userService.login(dto, request);
        return ApiResult.ok();
    }

    /**
     * 后台系统用户退出登录
     *
     * @return {@link ApiResult}
     */
    @PostMapping("/logout")
    public ApiResult<?> logout() {
        // 删除权限缓存
        redisService.delete(String.format(RedisKeyConst.USER_PERMISSION, StpUtil.getLoginId()));
        redisService.delete(String.format(RedisKeyConst.ONLINE_USER, StpUtil.getLoginId()));
        StpUtil.logout();
        return ApiResult.ok();
    }

    /**
     * 获取用户登录信息
     *
     * @return {@link SysLoginUserVO}
     */
    @GetMapping("/loginInfo")
    public ApiResult<SysLoginUserVO> loginInfo() {
        SysLoginUserVO r = userService.loginUser();
        return ApiResult.ok(r);
    }

    /**
     * 获取后台登录验证码
     *
     * @param captchaDTO {@link SysCaptchaDTO}
     * @param request    {@link HttpServletRequest}
     * @return Base64格式验证码
     */
    @PostMapping("/captcha")
    public ApiResult<String> captcha(@Valid @RequestBody SysCaptchaDTO captchaDTO, HttpServletRequest request) {
        // 生成圆圈干扰的验证码
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
        redisService.save(
                String.format(RedisKeyConst.VERIFY_CODE, captchaDTO.getCodeType(), IpUtils.getIp(request)),
                captcha.getCode(),
                300L
        );
        return ApiResult.ok(captcha.getImageBase64());
    }
}
