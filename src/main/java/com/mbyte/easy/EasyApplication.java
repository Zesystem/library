package com.mbyte.easy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * SpringBoot启动类
 * @author  戴书博
 */
@SpringBootApplication
@EnableScheduling
public class EasyApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EasyApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EasyApplication.class);
    }
}
