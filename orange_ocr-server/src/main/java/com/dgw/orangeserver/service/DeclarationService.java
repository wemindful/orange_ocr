package com.dgw.orangeserver.service;

import com.dgw.orangeserver.entity.Declaration;
import com.dgw.orangeserver.entity.Pages;
import org.springframework.data.domain.Page;

import java.util.Date;

/**
 * @program: orange_ocr-parent
 * @description:
 * @author: Mr.Dai
 * @create: 2020-04-07 18:45
 **/
public interface DeclarationService {

    Page<Declaration> findAllBySearch(Pages pages, Long articleId, String articleName, String articleAuthors);

    Declaration findDeclarationByDeclarationId(Long articleId);

    void updateDeclarationIsEnable(Long articleId, Integer isEnable);

    Integer countByDeclarationInputDate(Date date);

    void deleteDeclaration(Long articleId);

    void saveOrUpdateDeclaration(Declaration article);
}
