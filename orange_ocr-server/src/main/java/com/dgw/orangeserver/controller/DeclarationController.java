package com.dgw.orangeserver.controller;


import com.dgw.orangeserver.constants.Constants;
import com.dgw.orangeserver.entity.Declaration;
import com.dgw.orangeserver.entity.Pages;
import com.dgw.orangeserver.service.DeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/article")
public class DeclarationController {

    @Autowired
    private DeclarationService declarationService;

    @GetMapping("/list")
    public String article(Integer pageNumber, Long articleId, String articleName,
                          String articleAuthors, Model model) {
        Pages pages = Pages.defaultPages(pageNumber);
        Page<Declaration> articlePage = declarationService.findAllBySearch(pages, articleId, articleName, articleAuthors);
        model.addAttribute("articleList", articlePage.getContent());
        model.addAttribute("totalCount", articlePage.getTotalElements());
        model.addAttribute("pageNumber", pages.getPageNumber());
        model.addAttribute("articleName", articleName);
        model.addAttribute("articleAuthors", articleAuthors);
        model.addAttribute("articleId", articleId);
        model.addAttribute("menuFlag", Constants.ARTICLE_MENU_FLAG);
        return "article/index";
    }

    @GetMapping("/saveOrUpdatePage")
    public String saveOrUpdateArticlePage(Model model, Long articleId) {
        Declaration article = new Declaration();
        if (articleId != null) {
            article = declarationService.findDeclarationByDeclarationId(articleId);
        } else {
            article.setArticleId(0L);
        }
        model.addAttribute("article", article);
        model.addAttribute("menuFlag", Constants.ARTICLE_MENU_FLAG);
        return "article/edit";
    }

    @PostMapping("/updateArticleIsEnable")
    @ResponseBody
    public void updateArticleIsEnable(@RequestParam Long articleId, @RequestParam Integer isEnable) {
        declarationService.updateDeclarationIsEnable(articleId, isEnable);
    }

    @PostMapping("/delete")
    @ResponseBody
    public void deleteArticle(@RequestParam Long articleId) {
        declarationService.deleteDeclaration(articleId);
    }

    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public String saveOrUpdateArticle(@RequestBody Declaration article) {
        declarationService.saveOrUpdateDeclaration(article);
        return "success";
    }
}
