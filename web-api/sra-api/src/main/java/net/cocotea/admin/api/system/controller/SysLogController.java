package net.cocotea.admin.api.system.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import net.cocotea.admin.api.system.model.dto.SysLogPageDTO;
import net.cocotea.admin.api.system.model.vo.SysLogVO;
import net.cocotea.admin.api.system.service.SysLogService;
import net.cocotea.admin.common.model.ApiPage;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/system/log")
public class SysLogController {
    @Resource
    private SysLogService sysLogService;

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/listByPage")
    public ApiResult<?> pageApiResult(@RequestBody SysLogPageDTO param) throws BusinessException {
        ApiPage<SysLogVO> p = sysLogService.listByPage(param);
        return ApiResult.ok(p);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/deleteBatch")
    public ApiResult<?> deleteBatch(@RequestBody List<BigInteger> ids) throws BusinessException {
        boolean b = sysLogService.deleteBatch(ids);
        return ApiResult.flag(b);
    }
}
