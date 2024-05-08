package net.cocotea.admin.api.system.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.validation.Valid;
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

/**
 * 系统用户访问日志接口
 *
 * @author CoCoTea
 * @version v2.0.0
 */
@RestController
@RequestMapping("/system/log")
public class SysLogController {
    @Resource
    private SysLogService sysLogService;

    /**
     * 列表分页查询
     *
     * @param sysLogPageDTO {@link SysLogPageDTO}
     * @return {@link ApiPage<SysLogVO>}
     */
    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/listByPage")
    public ApiResult<ApiPage<SysLogVO>> pageApiResult(@Valid @RequestBody SysLogPageDTO sysLogPageDTO) throws BusinessException {
        ApiPage<SysLogVO> p = sysLogService.listByPage(sysLogPageDTO);
        return ApiResult.ok(p);
    }

    /**
     * 批量删除
     *
     * @param ids 日志ID集合
     * @return 成功返回TRUE
     */
    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/deleteBatch")
    public ApiResult<Boolean> deleteBatch(@RequestBody List<BigInteger> ids) throws BusinessException {
        boolean b = sysLogService.deleteBatch(ids);
        return ApiResult.ok(b);
    }
}
