package com.dgw.orangeviwer.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: orange_ocr-parent
 * @description:
 * @author: Mr.Dai
 * @create: 2020-04-08 18:30
 **/
@Controller
public class AppErrorController implements ErrorController {

    private final  static String ERRORPATH = "/error";

    @Override
    public String getErrorPath() {
        return ERRORPATH;
    }

    @RequestMapping(value = ERRORPATH)
    public String handleError(){
        return "error";
    }
}
