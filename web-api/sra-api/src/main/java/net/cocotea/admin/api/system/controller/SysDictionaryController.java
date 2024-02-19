package net.cocotea.admin.api.system.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import net.cocotea.admin.api.system.model.dto.SysDictionaryAddDTO;
import net.cocotea.admin.api.system.model.dto.SysDictionaryPageDTO;
import net.cocotea.admin.api.system.model.dto.SysDictionaryUpdateDTO;
import net.cocotea.admin.api.system.model.vo.SysDictionaryVO;
import net.cocotea.admin.api.system.service.SysDictionaryService;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

/**
 * 系统字典管理接口
 *
 * @author CoCoTea
 * @version 2.0.0
 */
@Validated
@RestController
@RequestMapping("/system/dictionary")
public class SysDictionaryController {
    @Resource
    private SysDictionaryService sysDictionaryService;

    /**
     * 新增字典
     *
     * @param dictionaryAddDTO {@link SysDictionaryAddDTO}
     * @return 成功返回true
     * @throws BusinessException 业务异常
     */
    @PostMapping("/add")
    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    public ApiResult<Boolean> add(@Valid @RequestBody SysDictionaryAddDTO dictionaryAddDTO) throws BusinessException {
        boolean b = sysDictionaryService.add(dictionaryAddDTO);
        return ApiResult.ok(b);
    }

    /**
     * 批量删除
     *
     * @param list 字典主键ID集合
     * @return 成功返回true
     * @throws BusinessException 业务异常
     */
    @PostMapping("/deleteBatch")
    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    public ApiResult<Boolean> deleteBatch(@Valid @RequestBody List<BigInteger> list) throws BusinessException {
        boolean b = sysDictionaryService.deleteBatch(list);
        return ApiResult.ok(b);
    }

    /**
     * 更新字典信息
     *
     * @param param {@link SysDictionaryUpdateDTO}
     * @return 成功返回true
     * @throws BusinessException 业务异常
     */
    @PostMapping("/update")
    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    public ApiResult<Boolean> update(@Valid @RequestBody SysDictionaryUpdateDTO param) throws BusinessException {
        boolean b = sysDictionaryService.update(param);
        return ApiResult.ok(b);
    }

    /**
     * 分页获取字典树形列表
     *
     * @param dictionaryPageDTO {@link SysDictionaryPageDTO}
     * @return {@link SysDictionaryVO}
     */
    @PostMapping("/listByTree")
    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    public ApiResult<List<SysDictionaryVO>> listByTree(@Valid @RequestBody SysDictionaryPageDTO dictionaryPageDTO) {
        List<SysDictionaryVO> list = sysDictionaryService.listByTree(dictionaryPageDTO);
        return ApiResult.ok(list);
    }
}
