package com.jwss.sra.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author jwss
 * @date 2022-1-12 14:12:24
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.jwss.sra.system", "com.jwss.sra.config", "com.jwss.sra.framework"})
public class SraApplicationBoot {

    public static void main(String[] args) {
        SpringApplication.run(SraApplicationBoot.class, args);
    }
}
