package net.cocotea.admin.system.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import net.cocotea.admin.system.param.dictionary.SysDictionaryAddParam;
import net.cocotea.admin.system.param.dictionary.SysDictionaryPageParam;
import net.cocotea.admin.system.param.dictionary.SysDictionaryUpdateParam;
import net.cocotea.admin.system.service.SysDictionaryService;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.system.vo.SysDictionaryVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * @author jwss
 * @date 2022-3-22
 */
@Validated
@RestController
@RequestMapping("/system/dictionary")
public class SysDictionaryController {
    @Resource
    private SysDictionaryService sysDictionaryService;

    @PostMapping("/add")
    @SaCheckPermission("system:dictionary:add")
    public ApiResult<String> add(@Valid @RequestBody SysDictionaryAddParam param) throws BusinessException {
        boolean b = sysDictionaryService.add(param);
        return ApiResult.flag(b);
    }

    @PostMapping("/deleteBatch")
    @SaCheckPermission("system:dictionary:deleteBatch")
    public ApiResult<String> deleteBatch(@Valid @RequestBody List<String> list) throws BusinessException {
        boolean b = sysDictionaryService.deleteBatch(list);
        return ApiResult.flag(b);
    }

    @PostMapping("/update")
    @SaCheckPermission("system:dictionary:update")
    public ApiResult<String> update(@Valid @RequestBody SysDictionaryUpdateParam param) throws BusinessException {
        boolean b = sysDictionaryService.update(param);
        return ApiResult.flag(b);
    }

    @PostMapping("/listByTree")
    @SaCheckPermission("system:dictionary:listByTree")
    public ApiResult<?> listByTree(@Valid @RequestBody SysDictionaryPageParam param) {
        Collection<SysDictionaryVO> list = sysDictionaryService.listByTree(param);
        return ApiResult.ok(list);
    }
}
