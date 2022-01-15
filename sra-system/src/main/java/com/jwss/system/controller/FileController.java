package com.jwss.system.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.jwss.common.model.ApiResult;
import com.jwss.framework.constant.RedisKey;
import com.jwss.framework.service.RedisService;
import com.jwss.system.param.file.VerificationCodeParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;

/**
 * @author jwss
 * @date 2022-1-12 14:25:41
 */
@Api(tags = "文件接口")
@Validated
@RestController
@RequestMapping("/file")
public class FileController {
    @Resource
    private RedisService redisService;

    @ApiOperation(value = "验证码生成")
    @PostMapping("/verificationCode")
    public ApiResult<String> verificationCode(@Valid @RequestBody VerificationCodeParam param){
        // 生成圆圈干扰的验证码
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(
                200, 100, 4, 20
        );
        redisService.save(
                String.format(RedisKey.VERIFY_CODE, param.getCodeType(), param.getOtherParam()),
                captcha.getCode(),
                300L
        );
        return ApiResult.ok(captcha.getImageBase64());
    }

}
