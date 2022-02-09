package com.jwss.sra.config.swagger;

import com.jwss.sra.config.properties.PackageScanProperties;
import com.jwss.sra.config.satoken.SaTokenConfigure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jwss
 * @date 2022-1-13 21:43:01
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    private static final String VERSION = "1.0.0";
    private final Logger logger = LoggerFactory.getLogger(SaTokenConfigure.class);

    @Resource
    private PackageScanProperties packageScanProperties;

    @Bean
    public Docket createRestApi() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<>();
        ticketPar.name("satoken")
                .description("用户凭证")
                .modelRef(new ModelRef("string")).parameterType("header")
                //header中的ticket参数非必填，传空也可以
                .required(false).build();
        //根据每个方法名也知道当前方法在设置什么参数
        parameters.add(ticketPar.build());
        String swaggerPackages = packageScanProperties.getSwaggerPackages();
        logger.info("################# swaggerPackages=" + swaggerPackages);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .build().globalOperationParameters(parameters)
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerPackages))
                // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档的标题
                .title("SRA-RBAC-ADMIN api")
                // 设置文档的描述
                .description("SRA-RBAC-ADMIN API 接口文档")
                // 设置文档的版本信息-> 1.0.0 Version information
                .version(VERSION)
                // 设置文档的License信息->1.3 License information
                .termsOfServiceUrl("https://www.apache.org")
                .build();
    }
}
