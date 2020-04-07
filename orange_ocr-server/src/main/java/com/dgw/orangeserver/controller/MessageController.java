package com.dgw.orangeserver.controller;


import com.dgw.orangeserver.constants.Constants;
import com.dgw.orangeserver.entity.Message;
import com.dgw.orangeserver.entity.Pages;
import com.dgw.orangeserver.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/list")
    public String message(Integer pageNumber, String name, String email, Model model) {
        Page<Message> messagePage = messageService.findAllMessageBySearch(Pages.defaultPages(pageNumber), name, email);
        model.addAttribute("messageList", messagePage.getContent());
        model.addAttribute("totalCount", messagePage.getTotalElements());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("menuFlag", Constants.MESSAGE_MENU_FLAG);
        return "message/index";
    }

    @GetMapping("/messageInfo")
    public String messageInfo(Long messageId, Model model) {
        Message message = messageService.findMessageByMessageId(messageId);
        if(message.getIsRead() == 0){
            messageService.updateMessageIsRead(messageId);
        }
        model.addAttribute("message", message);
        model.addAttribute("menuFlag", Constants.MESSAGE_MENU_FLAG);
        return "message/edit";
    }

    @PostMapping("/delete")
    @ResponseBody
    public void deleteMessage(@RequestParam Long messageId) {
        messageService.deleteMessage(messageId);
    }

}
