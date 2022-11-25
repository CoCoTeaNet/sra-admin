package net.cocotea.admin.system.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.core.util.StrUtil;
import net.cocotea.admin.system.param.login.CaptchaParam;
import net.cocotea.admin.system.properties.FileUploadProperties;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.system.util.FileUploadUtils;
import net.cocotea.admin.framework.constant.GlobalValue;
import net.cocotea.admin.framework.constant.RedisKey;
import net.cocotea.admin.framework.service.IRedisService;
import net.cocotea.admin.framework.util.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Resource
    private FileUploadProperties fileUploadProperties;
    @Resource
    private IRedisService redisService;

    @PostMapping("/verificationCode")
    public ApiResult<String> verificationCode(@Valid @RequestBody CaptchaParam param, HttpServletRequest request) {
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
    public ApiResult<String> upload(@RequestParam("file") MultipartFile multipartFile) throws BusinessException {
        logger.info("api[system/upload]filename={}", multipartFile.getOriginalFilename());
        // 过滤js，html，css等语言文件
        if (multipartFile.getOriginalFilename() != null) {
            String[] split = multipartFile.getOriginalFilename().split("\\.");
            String fileType = split[split.length - 1];
            logger.info("api[system/upload]fileType={}", fileType);
            if (StrUtil.isBlank(fileType)) {
                throw new BusinessException("未知文件格式");
            } else {
                boolean flag = fileUploadProperties.getNotSupportFileType().contains(fileType);
                if (flag) {
                    throw new BusinessException("该文件格式不支持上传");
                }
            }
        } else {
            throw new BusinessException("文件名为空.");
        }
        String fileName = FileUploadUtils.saveFile(multipartFile, fileUploadProperties.getLocalUrl());
        return ApiResult.ok(GlobalValue.getServerUrl() + fileUploadProperties.getBrowserUrl() + fileName);
    }

}
