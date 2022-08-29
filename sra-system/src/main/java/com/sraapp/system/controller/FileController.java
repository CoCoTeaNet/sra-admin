package com.sraapp.system.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.sraapp.common.model.ApiResult;
import com.sraapp.config.properties.FileUploadProperties;
import com.sraapp.system.param.file.VerificationCodeParam;
import com.sraapp.system.util.FileUploadUtils;
import com.sraapp.framework.constant.GlobalValue;
import com.sraapp.framework.constant.RedisKey;
import com.sraapp.framework.service.IRedisService;
import com.sraapp.framework.util.IpUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author jwss
 * @date 2022-1-12 14:25:41
 */
@Validated
@RestController
@RequestMapping("/file")
public class FileController {
    @Resource
    private FileUploadProperties fileUploadProperties;
    @Resource
    private IRedisService redisService;

    @PostMapping("/verificationCode")
    public ApiResult<String> verificationCode(@Valid @RequestBody VerificationCodeParam param, HttpServletRequest request){
        // 生成圆圈干扰的验证码
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
        redisService.save(
                String.format(RedisKey.VERIFY_CODE, param.getCodeType(), IpUtils.getIp(request)),
                captcha.getCode(),
                300L
        );
        return ApiResult.ok(captcha.getImageBase64());
    }

    @PostMapping("/upload")
    public ApiResult<String> upload(@RequestParam("file") MultipartFile multipartFile) {
        String fileName = FileUploadUtils.saveMultipartFile(multipartFile, fileUploadProperties.getLocalUrl());
        return ApiResult.ok(GlobalValue.getServerUrl() + fileUploadProperties.getBrowserUrl() + fileName);
    }

}
