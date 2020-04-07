package com.dgw.orangeviwer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

/**
 * @program: orange_ocr-parent
 * @description: Index 控制器
 * @author: Mr.Dai
 * @create: 2020-04-06 18:01
 **/
@Controller
@Api(value = "首页跳转接口",tags={"首页操作接口"})
public class IndexController {

    @ApiOperation(value = "跳转index页面")
    @ApiResponse(code = 200,message = "跳转成功")
    @ApiImplicitParam(name = "session",defaultValue = "0",required = false,value = "默认对象")
    @GetMapping(value = {"/index"})
    public String index(@ApiIgnore HttpSession session){
        return "index";
    }
}
