package net.cocotea.admin.api.system.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import net.cocotea.admin.api.system.model.dto.SysVersionAddDTO;
import net.cocotea.admin.api.system.model.dto.SysVersionPageDTO;
import net.cocotea.admin.api.system.model.dto.SysVersionUpdateDTO;
import net.cocotea.admin.api.system.model.vo.SysVersionVO;
import net.cocotea.admin.api.system.service.SysVersionService;
import net.cocotea.admin.common.model.ApiPage;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

import jakarta.validation.Valid;
import java.math.BigInteger;
import java.util.List;

/**
 * 系统版本管理接口
 *
 * @author CoCoTea
 * @version 2.0.0
 */
@RequestMapping("/system/version")
@RestController
public class SysVersionController {
    @Resource
    private SysVersionService sysVersionService;

    /**
     * 新增版本信息
     *
     * @param addDTO {@link SysVersionAddDTO}
     * @return 成功返回TRUE
     */
    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/add")
    public ApiResult<Boolean> add(@Valid @RequestBody SysVersionAddDTO addDTO) throws BusinessException {
        boolean b = sysVersionService.add(addDTO);
        return ApiResult.ok(b);
    }

    /**
     * 批量删除版本
     *
     * @param idList id集合
     * @return 成功返回TRUE
     */
    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/deleteBatch")
    public ApiResult<Boolean> deleteBatch(@RequestBody List<BigInteger> idList) throws BusinessException {
        boolean b = sysVersionService.deleteBatch(idList);
        return ApiResult.ok(b);
    }

    /**
     * 更新版本信息
     *
     * @param updateDTO {@link SysVersionUpdateDTO}
     * @return 成功返回TRUE
     */
    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/update")
    public ApiResult<Boolean> update(@Valid @RequestBody SysVersionUpdateDTO updateDTO) throws BusinessException {
        boolean b = sysVersionService.update(updateDTO);
        return ApiResult.ok(b);
    }

    /**
     * 分页查询版本信息
     *
     * @param pageDTO {@link SysVersionPageDTO}
     * @return {@link ApiPage<SysVersionVO>}
     */
    @PostMapping("/listByPage")
    public ApiResult<ApiPage<SysVersionVO>> listByPage(@Valid @RequestBody SysVersionPageDTO pageDTO) throws BusinessException {
        ApiPage<SysVersionVO> r = sysVersionService.listByPage(pageDTO);
        return ApiResult.ok(r);
    }

}
