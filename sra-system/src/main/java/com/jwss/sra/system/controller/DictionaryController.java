package com.jwss.sra.system.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.jwss.sra.common.model.ApiResult;
import com.jwss.sra.system.param.dictionary.DictionaryAddParam;
import com.jwss.sra.system.param.dictionary.DictionaryPageParam;
import com.jwss.sra.system.param.dictionary.DictionaryUpdateParam;
import com.jwss.sra.system.service.IDictionaryService;
import com.jwss.sra.system.vo.DictionaryVO;
import io.swagger.annotations.Api;
import org.sagacity.sqltoy.model.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @date 2022-3-22
 * @author jwss
 */
@Api(tags = "系统字典接口")
@Validated
@RestController
@RequestMapping("/dictionary")
public class DictionaryController {
    @Resource
    private IDictionaryService dictionaryService;

    @PostMapping("/add")
    @SaCheckPermission("system:dictionary:add")
    public ApiResult<String> add(@Valid @RequestBody DictionaryAddParam param) {
        boolean b = dictionaryService.add(param);
        return ApiResult.flag(b);
    }

    @PostMapping("/deleteBatch")
    @SaCheckPermission("system:dictionary:deleteBatch")
    public ApiResult<String> deleteBatch(@Valid @RequestBody List<String> list) {
        boolean b = dictionaryService.deleteBatch(list);
        return ApiResult.flag(b);
    }

    @PostMapping("/update")
    @SaCheckPermission("system:dictionary:update")
    public ApiResult<String> update(@Valid @RequestBody DictionaryUpdateParam param) {
        boolean b = dictionaryService.update(param);
        return ApiResult.flag(b);
    }

    @PostMapping("/listByTree")
    @SaCheckPermission("system:dictionary:listByTree")
    public ApiResult<Page<DictionaryVO>> listByTree(@Valid @RequestBody DictionaryPageParam param) {
        Page<DictionaryVO> list = dictionaryService.listByTree(param);
        return ApiResult.ok(list);
    }
}
