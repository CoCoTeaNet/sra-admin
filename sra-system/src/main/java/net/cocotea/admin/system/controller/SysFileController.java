package net.cocotea.admin.system.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import net.cocotea.admin.system.service.ISysFileService;
import net.cocotea.admin.common.model.ApiResult;
import net.cocotea.admin.common.model.BusinessException;
import net.cocotea.admin.system.param.file.SysFileAddParam;
import net.cocotea.admin.system.param.file.SysFilePageParam;
import net.cocotea.admin.system.param.file.SysFileUpdateParam;
import net.cocotea.admin.system.vo.SysFileVO;
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
@RequestMapping("/system/file")
@RestController
public class SysFileController {
    @Resource
    private ISysFileService sysFileService;

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/add")
    public ApiResult<?> add(@Valid @RequestBody SysFileAddParam param) throws BusinessException {
        boolean b = sysFileService.add(param);
        return ApiResult.flag(b);
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

}
