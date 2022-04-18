package com.jwss.sra.system.controller;

import com.jwss.sra.system.entity.TableCol;
import com.jwss.sra.system.service.ICodeGeneratorService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

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
        List<TableCol> entityCode = codeGeneratorService.getEntityCode();
        model.put("entityCode", entityCode);
        return "entity-generator";
    }
}
