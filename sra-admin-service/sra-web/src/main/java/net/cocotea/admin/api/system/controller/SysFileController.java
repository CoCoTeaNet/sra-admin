package net.cocotea.admin.api.system.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.net.URLEncodeUtil;
import cn.hutool.core.text.CharPool;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import jakarta.validation.Valid;
import net.cocotea.admin.api.system.model.dto.SysFileAddDTO;
import net.cocotea.admin.api.system.model.dto.SysFilePageDTO;
import net.cocotea.admin.api.system.model.dto.SysFileUpdateDTO;
import net.cocotea.admin.api.system.model.vo.SysFileVO;
import net.cocotea.admin.api.system.service.SysFileService;
import net.cocotea.admin.api.system.service.SysUserService;
import net.cocotea.admin.common.enums.IsEnum;
import net.cocotea.admin.common.model.ApiPage;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.common.model.FileInfo;
import net.cocotea.admin.common.util.FileUploadUtils;
import net.cocotea.admin.properties.FileProp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * 系统文件管理接口
 *
 * @author CoCoTea
 * @version 2.0.0
 */
@RequestMapping("/system/file")
@RestController
public class SysFileController {
    private final Logger logger = LoggerFactory.getLogger(SysFileController.class);

    @Resource
    private FileProp fileProp;

    @Resource
    private SysFileService sysFileService;

    @Resource
    private SysUserService sysUserService;

    /**
     * 系统文件上传
     *
     * @param multipartFile {@link MultipartFile}
     * @return true表示成功
     */
    @PostMapping("/upload")
    public ApiResult<Boolean> upload(@RequestParam("file") MultipartFile multipartFile) throws BusinessException {
        // 过滤js，html，css等语言文件
        filter(multipartFile);
        FileInfo fileInfo = FileUploadUtils.saveMultipartFile(multipartFile, fileProp.getDefaultSavePath());
        SysFileAddDTO fileAddDTO = new SysFileAddDTO()
                .setFileName(fileInfo.getFileName())
                .setFileSuffix(fileInfo.getFileSuffix())
                .setFileSize(BigInteger.valueOf(fileInfo.getFileSize()))
                .setRealPath(fileInfo.getFileBasePath());
        sysFileService.add(fileAddDTO);
        logger.debug("文件保存信息: {}", fileInfo);
        return ApiResult.ok(true);
    }

    /**
     * 系统文件下载
     *
     * @param fileId 文件ID
     * @return {@link ResponseEntity}
     */
    @GetMapping("/download/{fileId}")
    public ResponseEntity<StreamingResponseBody> download(@PathVariable("fileId") BigInteger fileId) throws BusinessException, IOException {
        SysFileVO sysFileVO = sysFileService.getUserFile(fileId);
        return getResponseEntity(sysFileVO.getRealPath(), sysFileVO.getFileName());
    }

    /**
     * 系统文件批量删除
     *
     * @param param 文件ID列表
     * @return true表示成功
     */
    @PostMapping("/deleteBatch")
    public ApiResult<Boolean> deleteBatch(@RequestBody List<BigInteger> param) throws BusinessException {
        boolean b = sysFileService.deleteBatch(param);
        return ApiResult.ok(b);
    }

    /**
     * 系统文件信息更新
     *
     * @param sysFileUpdateDTO {@link SysFileUpdateDTO}
     * @return true表示成功
     */
    @PostMapping("/update")
    public ApiResult<Boolean> update(@Valid @RequestBody SysFileUpdateDTO sysFileUpdateDTO) throws BusinessException {
        boolean b = sysFileService.update(sysFileUpdateDTO);
        return ApiResult.ok(b);
    }

    /**
     * 系统文件分页列表
     *
     * @param dto {@link SysFilePageDTO}
     * @return {@link ApiPage<SysFileVO>}
     */
    @PostMapping("/listByPage")
    public ApiResult<ApiPage<SysFileVO>> listByPage(@Valid @RequestBody SysFilePageDTO dto) throws BusinessException {
        dto.setIsDeleted(IsEnum.N.getCode());
        ApiPage<SysFileVO> r = sysFileService.listByPage(dto);
        return ApiResult.ok(r);
    }

    /**
     * 系统回收站文件分页列表
     *
     * @param sysFilePageDTO {@link SysFilePageDTO}
     * @return {@link ApiPage<SysFileVO>}
     */
    @PostMapping("/recycleBinPage")
    public ApiResult<ApiPage<SysFileVO>> recycleBinPage(@Valid @RequestBody SysFilePageDTO sysFilePageDTO) {
        ApiPage<SysFileVO> r = sysFileService.recycleBinPage(sysFilePageDTO);
        return ApiResult.ok(r);
    }

    /**
     * 系统回收站文件批量删除
     *
     * @param ids 文件ID集合
     * @return 成功返回true
     */
    @PostMapping("/recycleBin/deleteBatch")
    public ApiResult<Boolean> recycleBinDeleteBatch(@Valid @RequestBody List<BigInteger> ids) {
        boolean recycled = sysFileService.recycleBinDeleteBatch(ids);
        return ApiResult.ok(recycled);
    }

    /**
     * 系统回收站文件批量恢复
     *
     * @param ids 文件ID集合
     * @return 成功返回true
     */
    @PostMapping("/recycleBin/recoveryBatch")
    public ApiResult<Boolean> recoveryBatch(@Valid @RequestBody List<BigInteger> ids) {
        boolean recoveryBatch = sysFileService.recoveryBatch(ids);
        return ApiResult.ok(recoveryBatch);
    }

    /**
     * 系统用户头像上传
     *
     * @param multipartFile {@link MultipartFile}
     * @return 成功返回true
     */
    @PostMapping("/avatar/upload")
    public ApiResult<Boolean> uploadAvatar(@RequestParam("file") MultipartFile multipartFile) throws BusinessException, IOException {
        if (StrUtil.isBlank(fileProp.getAvatarPath())) {
            throw new BusinessException("未配置相关信息");
        }
        filter(multipartFile);
        String saveName = IdUtil.objectId() + CharPool.UNDERLINE + multipartFile.getOriginalFilename();
        String fullPath = fileProp.getAvatarPath() + saveName;
        File file = new File(fullPath);
        if (!file.exists()) {
            FileUtil.mkdir(fileProp.getAvatarPath());
        }
        multipartFile.transferTo(file);
        sysUserService.doModifyAvatar(saveName);
        return ApiResult.ok(true);
    }

    /**
     * 系统用户头像文件获取
     *
     * @param avatar   头像文件名称
     * @param response {@link HttpServletResponse}
     */
    @GetMapping("/getAvatar")
    public void getAvatar(@RequestParam("avatar") String avatar, HttpServletResponse response) throws BusinessException, IOException {
        String fullPath = fileProp.getAvatarPath() + avatar;
        File file = FileUtil.file(fullPath);
        if (file.exists()) {
            FileUtil.writeToStream(file, response.getOutputStream());
        } else {
            throw new BusinessException("文件不存在");
        }
    }

    private void filter(MultipartFile multipartFile) throws BusinessException {
        if (multipartFile.getOriginalFilename() != null) {
            String[] split = multipartFile.getOriginalFilename().split("\\.");
            String fileType = split[split.length - 1];
            if (StrUtil.isBlank(fileType)) {
                throw new BusinessException("未知文件格式");
            } else {
                boolean flag = fileProp.getNotSupportFiletype().contains(fileType);
                if (flag) {
                    throw new BusinessException("该文件格式不支持上传");
                }
            }
        } else {
            throw new BusinessException("文件名为空");
        }
    }

    private ResponseEntity<StreamingResponseBody> getResponseEntity(String filePath, String fileName) throws IOException {
        String fullPath = fileProp.getDefaultSavePath() + filePath;
        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + URLEncodeUtil.encode(fileName) + "\"");
        headers.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(Files.size(Paths.get(fullPath))));
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(out -> {
                    try (InputStream in = FileUtil.getInputStream(fullPath)) {
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = in.read(buffer)) != -1) {
                            out.write(buffer, 0, bytesRead);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to write file to output stream", e);
                    }
                });
    }

}
