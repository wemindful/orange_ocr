package com.dgw.orangeviwer.controller;

import com.dgw.orangeviwer.entity.Message;
import com.dgw.orangeviwer.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @Autowired
    private MessageService messageService;

    @PostMapping("/contact/sendMail")
    @ResponseBody
    @Transactional(rollbackFor = Throwable.class)
    public String sendMail(@RequestBody Message message) {
        message.setMessageInputDate(new Date());
        message.setIsRead(0);
        messageService.saveMessage(message);
        return "success";
    }
}
