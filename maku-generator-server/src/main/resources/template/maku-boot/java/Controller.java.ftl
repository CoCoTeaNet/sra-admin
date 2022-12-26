package ${package}.${moduleName}.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import ${package}.${moduleName}.service.I${ClassName}Service;
import ${package}.common.model.ApiResult;
import ${package}.common.model.BusinessException;
import ${package}.${moduleName}.param.${ClassName}AddParam;
import ${package}.${moduleName}.param.${ClassName}PageParam;
import ${package}.${moduleName}.param.${ClassName}UpdateParam;
import ${package}.${moduleName}.vo.${ClassName}VO;
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
@RequestMapping("/${moduleName}/${className}")
@RestController
public class ${ClassName}Controller {
    @Resource
    private I${ClassName}Service ${className}Service;

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/add")
    public ApiResult<?> add(@Valid @RequestBody ${ClassName}AddParam param) throws BusinessException {
        boolean b = ${className}Service.add(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/deleteBatch")
    public ApiResult<?> deleteBatch(@RequestBody List<String> param) throws BusinessException {
        boolean b = ${className}Service.deleteBatch(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/update")
    public ApiResult<?> update(@Valid @RequestBody ${ClassName}UpdateParam param) throws BusinessException {
        boolean b = ${className}Service.update(param);
        return ApiResult.flag(b);
    }

    @SaCheckRole(value = {"role:super:admin", "role:simple:admin"}, mode = SaMode.OR)
    @PostMapping("/listByPage")
    public ApiResult<?> listByPage(@Valid @RequestBody ${ClassName}PageParam param) throws BusinessException {
        Page<${ClassName}VO> r = ${className}Service.listByPage(param);
        return ApiResult.ok(r);
    }

}
