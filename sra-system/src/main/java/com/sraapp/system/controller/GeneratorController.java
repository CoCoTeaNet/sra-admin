package com.sraapp.system.controller;

import com.sraapp.common.model.ApiResult;
import com.sraapp.system.param.generator.TablePageParam;
import com.sraapp.system.service.IGeneratorService;
import com.sraapp.system.vo.TableVO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
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
@Validated
@RestController
@RequestMapping("/codeGenerator")
public class GeneratorController {
    @Resource
    private IGeneratorService generatorService;

    @GetMapping("/getByTableName")
    public ApiResult<String> getByTableName(ModelMap model,
                                            @RequestParam("tableName") String tableName,
                                            @RequestParam("dbName") String dbName,
                                            @RequestParam("type") Integer type) throws TemplateException, IOException {
        Map<String, Object> objectMap = generatorService.getEntityCode(dbName, tableName);
        model.put("objectMap", objectMap);
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setClassForTemplateLoading(GeneratorController.class, "/templates/");
        Template template;
        if (type == 0) {
            template = configuration.getTemplate("java-generator.ftl");
        } else {
            template = configuration.getTemplate("ts-generator.ftl");
        }
        return ApiResult.ok(FreeMarkerTemplateUtils.processTemplateIntoString(template, model));
    }

    @ResponseBody
    @PostMapping("/findTablesByPage")
    public ApiResult<Page<TableVO>> findTablesByPage(@Validated @RequestBody TablePageParam param) {
        Page<TableVO> vo = generatorService.findTablesByPage(param);
        return ApiResult.ok(vo);
    }

}
