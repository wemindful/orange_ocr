package com.dgw.orangeviwer.controller;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import com.dgw.orangeviwer.entity.User;
import com.dgw.orangeviwer.services.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.logging.Logger;

/**
 * @program: orange_ocr-parent
 * @description: User CRUD
 * @author: Mr.Dai
 * @create: 2020-04-06 18:36
 **/
@Controller
@Api(value="用户controller",tags={"用户操作接口"})
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @ApiOperation(value = "跳转login页面")
    @ApiResponse(code = 200,message = "跳转成功")
    @GetMapping(value = {"/login"})
    public String login(){
        return "login";
    }

    @ApiOperation(value = "登录方法")
    @ApiImplicitParam(name = "user",value = "用户参数",required = true,dataType = "String")
    @PostMapping("/login")
    public String login(User user,@ApiIgnore HttpSession session){
        if(user!=null){
            User userx = userService.findByUsername(user.getUsername());
            MD5 md5 = SecureUtil.md5();
            String passmd5 = md5.digestHex16(user.getPassword());
            if(userx.getUsername().equals(user.getUsername())&&passmd5.equals(userx.getPassword())){
                session.setAttribute("user",userx.getUsername());
                return "index";
            }
        }
        return "login";
    }

    @ApiOperation(value = "跳转register页面")
    @ApiResponse(code = 200,message = "跳转成功")
    @GetMapping(value = {"/register"})
    public String register(){
        return "register";
    }

    @ApiOperation(value = "注册方法")
    @ApiResponse(code = 200,message = "跳转成功")
    @ApiImplicitParam(name = "user",value = "用户参数",required = true,dataType = "String")
    @PostMapping(value = {"/register"})
    public String register(User user,@ApiIgnore Model model){
        if(user!=null){
            User user1 = userService.findByUsername(user.getUsername());
            if(user1==null){
                user.setIsEnable(1);
                MD5 md5 = SecureUtil.md5();
                String passmd5 = md5.digestHex16(user.getPassword());
                user.setPassword(passmd5);
                userService.saveUser(user);
                return "login";
            }
            model.addAttribute("msg","该用户已经注册");
        }
        return "register";
    }
}
