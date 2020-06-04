package com.dgw.orangeviwer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: orange_ocr-parent
 * @description: tess4j.tessdata.path
 * @author: Mr.Dai
 * @create: 2020-06-04 18:54
 **/
@Data
@Component
@ConfigurationProperties(prefix = "tess4j.tessdata")
public class TessData {
    public String path;
    public boolean test;
}
