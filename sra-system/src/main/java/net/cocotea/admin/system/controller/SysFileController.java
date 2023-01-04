package net.cocotea.admin.system.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import cn.hutool.core.util.StrUtil;
import net.cocotea.admin.common.constant.CharConstant;
import net.cocotea.admin.common.model.FileInfo;
import net.cocotea.admin.framework.constant.GlobalValue;
import net.cocotea.admin.system.entity.SysFile;
import net.cocotea.admin.system.param.file.SysFileAddParam;
import net.cocotea.admin.system.properties.FileUploadProperties;
import net.cocotea.admin.system.service.ISysFileService;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.system.param.file.SysFilePageParam;
import net.cocotea.admin.system.param.file.SysFileUpdateParam;
import net.cocotea.admin.system.util.FileUploadUtils;
import net.cocotea.admin.system.vo.SysFileVO;
import org.sagacity.sqltoy.model.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Validated
@RequestMapping("/system/file")
@RestController
public class SysFileController {
    private final Logger logger = LoggerFactory.getLogger(SysFileController.class);

    @Resource
    private FileUploadProperties fileUploadProperties;

    @Resource
    private ISysFileService sysFileService;

    @PostMapping("/upload")
    public ApiResult<String> upload(@RequestParam("file") MultipartFile multipartFile,
                                    @RequestParam(value = "isSave", required = false) Integer isSave) throws BusinessException {
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
        FileInfo fileInfo = FileUploadUtils.saveMultipartFile(multipartFile, fileUploadProperties.getLocalUrl());
        String browsePath = GlobalValue.getServerUrl() + fileUploadProperties.getBrowserUrl() + fileInfo.getFileBasePath();
        if (isSave != null && isSave == 1) {
            SysFileAddParam param = new SysFileAddParam()
                    .setFileName(fileInfo.getFileName())
                    .setFileSuffix(fileInfo.getFileSuffix())
                    .setFileSize(fileInfo.getFileSize())
                    .setBrowsePath(fileInfo.getFileBasePath())
                    .setRealPath(fileInfo.getRealPath())
                    .setFullPath(browsePath);
            sysFileService.add(param);
        }
        return ApiResult.ok(browsePath);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/deleteBatch")
    public ApiResult<?> deleteBatch(@RequestBody List<String> param) throws BusinessException {
        boolean b = sysFileService.deleteBatch(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/update")
    public ApiResult<?> update(@Valid @RequestBody SysFileUpdateParam param) throws BusinessException {
        boolean b = sysFileService.update(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/listByPage")
    public ApiResult<?> listByPage(@Valid @RequestBody SysFilePageParam param) throws BusinessException {
        Page<SysFileVO> r = sysFileService.listByPage(param);
        return ApiResult.ok(r);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/recycleBinPage")
    public ApiResult<?> recycleBinPage(@Valid @RequestBody SysFilePageParam param) throws BusinessException {
        Page<SysFileVO> r = sysFileService.recycleBinPage(param);
        return ApiResult.ok(r);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/recycleBin/deleteBatch")
    public ApiResult<?> recycleBinDeleteBatch(@Valid @RequestBody List<String> param) throws BusinessException {
        return ApiResult.flag(sysFileService.recycleBinDeleteBatch(param));
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/recycleBin/recoveryBatch")
    public ApiResult<?> recoveryBatch(@Valid @RequestBody List<String> param) throws BusinessException {
        return ApiResult.flag(sysFileService.recoveryBatch(param));
    }

}
