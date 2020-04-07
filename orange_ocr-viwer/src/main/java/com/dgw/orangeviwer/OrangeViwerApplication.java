package com.dgw.orangeviwer;

import com.dgw.orangeviwer.constants.Constant;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@SpringBootApplication
@EnableKnife4j
public class OrangeViwerApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(OrangeViwerApplication.class, args);
    }

}
