package com.jwss.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @date 2022-1-12 14:12:24
 * @author jwss
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.jwss.system"})
public class SraApplicationBoot {

    public static void main(String[] args) {
        SpringApplication.run(SraApplicationBoot.class, args);
    }
}
