package com.jwss.sra.system.controller;

import com.jwss.sra.common.model.ApiResult;
import com.jwss.sra.system.param.generator.TablePageParam;
import com.jwss.sra.system.service.ICodeGeneratorService;
import com.jwss.sra.system.vo.TableVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sagacity.sqltoy.model.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 代码生成器 控制器
 * @date 2022-1-12 14:25:41
 * @author jwss
 */
@Api(tags = "代码生成器-控制器")
@Validated
@Controller
@RequestMapping("/codeGenerator")
public class CodeGeneratorController {
    @Resource
    private ICodeGeneratorService codeGeneratorService;

    @ApiOperation("根据表名称生成实体类属性集合")
    @GetMapping("/getByTableName/{tableName}")
    public String getByTableName(ModelMap model, @PathVariable String tableName) {
        Map<String, Object> objectMap = codeGeneratorService.getEntityCode(tableName);
        model.put("objectMap", objectMap);
        return "entity-generator";
    }

    @ResponseBody
    @ApiOperation("分页获取表名称")
    @PostMapping("/findTablesByPage")
    public ApiResult<Page<TableVO>> findTablesByPage(@Validated @RequestBody TablePageParam param) {
        Page<TableVO> vo = codeGeneratorService.findTablesByPage(param);
        return ApiResult.ok(vo);
    }

}
