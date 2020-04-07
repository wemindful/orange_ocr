package com.dgw.orangeserver.service;



import com.dgw.orangeserver.entity.OcrTexts;
import com.dgw.orangeserver.entity.Pages;
import org.springframework.data.domain.Page;

import java.util.Date;

public interface OcrTextService {

    Page<OcrTexts> findAllBySearch(Pages pages, Long tagId, String tagName);

    OcrTexts saveTag(OcrTexts tag);

    void deleteTagByTagId(Long tagId);

    OcrTexts findTagByTagName(String tagName);

    Integer countByTagInputDate(Date tagInputdate);

    Long count();


}
