package net.cocotea.system.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import net.cocotea.common.model.ApiResult;
import net.cocotea.common.model.BusinessException;
import net.cocotea.system.param.dictionary.DictionaryAddParam;
import net.cocotea.system.param.dictionary.DictionaryPageParam;
import net.cocotea.system.param.dictionary.DictionaryUpdateParam;
import net.cocotea.system.service.IDictionaryService;
import net.cocotea.system.vo.DictionaryVO;
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
@RequestMapping("/dictionary")
public class DictionaryController {
    @Resource
    private IDictionaryService dictionaryService;

    @PostMapping("/add")
    @SaCheckPermission("system:dictionary:add")
    public ApiResult<String> add(@Valid @RequestBody DictionaryAddParam param) throws BusinessException {
        boolean b = dictionaryService.add(param);
        return ApiResult.flag(b);
    }

    @PostMapping("/deleteBatch")
    @SaCheckPermission("system:dictionary:deleteBatch")
    public ApiResult<String> deleteBatch(@Valid @RequestBody List<String> list) throws BusinessException {
        boolean b = dictionaryService.deleteBatch(list);
        return ApiResult.flag(b);
    }

    @PostMapping("/update")
    @SaCheckPermission("system:dictionary:update")
    public ApiResult<String> update(@Valid @RequestBody DictionaryUpdateParam param) throws BusinessException {
        boolean b = dictionaryService.update(param);
        return ApiResult.flag(b);
    }

    @PostMapping("/listByTree")
    @SaCheckPermission("system:dictionary:listByTree")
    public ApiResult<?> listByTree(@Valid @RequestBody DictionaryPageParam param) {
        Collection<DictionaryVO> list = dictionaryService.listByTree(param);
        return ApiResult.ok(list);
    }
}
