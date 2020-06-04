package com.dgw.orangeviwer;

import com.dgw.orangeviwer.config.TessData;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.IOException;

@SpringBootApplication
@EnableKnife4j
@EnableConfigurationProperties
public class OrangeViwerApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(OrangeViwerApplication.class, args);
    }

}

