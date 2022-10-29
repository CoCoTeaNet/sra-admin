package com.sraapp.system.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import com.sraapp.common.model.ApiResult;
import com.sraapp.common.model.BusinessException;
import com.sraapp.system.param.version.VersionAddParam;
import com.sraapp.system.param.version.VersionPageParam;
import com.sraapp.system.param.version.VersionUpdateParam;
import com.sraapp.system.service.IVersionService;
import com.sraapp.system.vo.VersionVO;
import org.sagacity.sqltoy.model.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Validated
@RequestMapping("/version")
@RestController
public class VersionController {
    @Resource
    private IVersionService versionService;
    
    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/add")
    public ApiResult<?> add(@Valid @RequestBody VersionAddParam param) throws BusinessException {
        boolean b = versionService.add(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/deleteBatch")
    public ApiResult<?> deleteBatch(@RequestBody List<String> param) throws BusinessException {
        boolean b = versionService.deleteBatch(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/update")
    public ApiResult<?> update(@Valid @RequestBody VersionUpdateParam param) throws BusinessException {
        boolean b = versionService.update(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/listByPage")
    public ApiResult<?> listByPage(@Valid @RequestBody VersionPageParam param) throws BusinessException {
        Page<VersionVO> r = versionService.listByPage(param);
        return ApiResult.ok(r);
    }
    
}
