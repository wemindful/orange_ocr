package com.dgw.orangeserver.controller;

import com.dgw.orangeserver.constants.Constants;
import com.dgw.orangeserver.entity.OcrTexts;
import com.dgw.orangeserver.entity.Pages;
import com.dgw.orangeserver.service.OcrTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tag")
public class OcrTextController {

    @Autowired
    private OcrTextService tagService;

    @GetMapping("/list")
    public String tag(Integer pageNumber, Long tagId, String tagName, Model model) {
        Page<OcrTexts> tagPage = tagService.findAllBySearch(Pages.defaultPages(pageNumber),
                tagId, tagName);
        model.addAttribute("tagList", tagPage.getContent());
        model.addAttribute("totalCount", tagPage.getTotalElements());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("tagId", tagId);
        model.addAttribute("tagName", tagName);
        model.addAttribute("menuFlag", Constants.TAG_MENU_FLAG);
        return "tag/index";
    }

    @PostMapping("/delete")
    @ResponseBody
    public void deleteTag(@RequestParam Long tagId) {
        tagService.deleteTagByTagId(tagId);
    }
}
