package com.jwss.sra.system.controller;

import com.jwss.sra.system.service.ICodeGeneratorService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 代码生成器 控制器
 * @date 2022-1-12 14:25:41
 * @author jwss
 */
@Api(tags = "代码生成器接口")
@Validated
@Controller
@RequestMapping("/codeGenerator")
public class CodeGeneratorController {
    @Resource
    private ICodeGeneratorService codeGeneratorService;

    @GetMapping("/getByTableName")
    public String getByTableName(ModelMap model) {
        Map<String, Object> objectMap = codeGeneratorService.getEntityCode();
        model.put("objectMap", objectMap);
        return "entity-generator";
    }
}
