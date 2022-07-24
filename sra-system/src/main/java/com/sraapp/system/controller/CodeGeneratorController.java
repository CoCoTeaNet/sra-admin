package com.sraapp.system.controller;

import com.sraapp.common.model.ApiResult;
import com.sraapp.system.param.generator.TablePageParam;
import com.sraapp.system.service.ICodeGeneratorService;
import com.sraapp.system.vo.TableVO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sagacity.sqltoy.model.Page;
import org.springframework.ui.ModelMap;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * 代码生成器 控制器
 * @date 2022-1-12 14:25:41
 * @author jwss
 */
@Api(tags = "代码生成器-控制器")
@Validated
@RestController
@RequestMapping("/codeGenerator")
public class CodeGeneratorController {
    @Resource
    private ICodeGeneratorService codeGeneratorService;

    @ApiOperation("根据表名称生成实体类属性集合")
    @GetMapping("/getByTableName/{tableName}")
    public ApiResult<String> getByTableName(ModelMap model, @PathVariable String tableName) throws TemplateException, IOException {
        Map<String, Object> objectMap = codeGeneratorService.getEntityCode(tableName);
        model.put("objectMap", objectMap);
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setClassForTemplateLoading(CodeGeneratorController.class, "/templates/");
        Template template = configuration.getTemplate("entity-generator.ftl");
        return ApiResult.ok(FreeMarkerTemplateUtils.processTemplateIntoString(template, model));
    }

    @ResponseBody
    @ApiOperation("分页获取表名称")
    @PostMapping("/findTablesByPage")
    public ApiResult<Page<TableVO>> findTablesByPage(@Validated @RequestBody TablePageParam param) {
        Page<TableVO> vo = codeGeneratorService.findTablesByPage(param);
        return ApiResult.ok(vo);
    }

}
