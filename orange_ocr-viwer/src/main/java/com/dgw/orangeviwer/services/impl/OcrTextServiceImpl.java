package com.dgw.orangeviwer.services.impl;

import com.dgw.orangeviwer.entity.OcrTexts;
import com.dgw.orangeviwer.repository.OcrTextRepository;
import com.dgw.orangeviwer.services.OcrTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: orange_ocr-parent
 * @description:
 * @author: Mr.Dai
 * @create: 2020-04-08 17:31
 **/
@Service
public class OcrTextServiceImpl implements OcrTextService {

    @Autowired
    private OcrTextRepository ocrTextRepository;

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void save(OcrTexts ocrTexts) {
            ocrTextRepository.save(ocrTexts);
    }
}
