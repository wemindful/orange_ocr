package com.dgw.orangeadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: orange_ocr-parent
 * @description: OrangeAdminApplication
 * @author: Mr.Dai
 * @create: 2020-04-09 01:01
 **/
@SpringBootApplication
@EnableAdminServer
public class OrangeAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrangeAdminApplication.class,args);
    }
}
