package com.jwss.sra.bootstrap;

import cn.hutool.system.SystemUtil;
import com.jwss.sra.framework.constant.GlobalValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

/**
 * @author jwss
 * @date 2022-1-12 14:12:24
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.jwss.sra.system", "com.jwss.sra.config", "com.jwss.sra.framework"})
public class SraApplicationBoot {
    private static final Logger logger = LoggerFactory.getLogger(SraApplicationBoot.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SraApplicationBoot.class, args);
        Environment environment = context.getEnvironment();
        String[] urls = {
                String.format("http://localhost:%s%s", environment.getProperty("server.port"), environment.getProperty("server.servlet.context-path")),
                String.format("%s:%s%s", SystemUtil.getHostInfo().getAddress(), environment.getProperty("server.port"), environment.getProperty("server.servlet.context-path"))
        };
        logger.info("接口访问地址：{} || http://{}", urls[0], urls[1]);
        logger.info("接口文档地址：{}/doc.html || http://{}/doc.html", urls[0], urls[1]);
        logger.info("测试接口访问：{}/test/index || http://{}/test/index", urls[0], urls[1]);
        GlobalValue.START_TIME = System.currentTimeMillis();
    }
}
