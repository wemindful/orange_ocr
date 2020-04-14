package com.dgw.orangeviwer;

import com.dgw.orangeviwer.constants.Constant;
import com.dgw.orangeviwer.utils.TesseractMul;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import net.sourceforge.tess4j.Tesseract;
import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationHome;

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
