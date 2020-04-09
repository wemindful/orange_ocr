package com.dgw.orangeviwer.services.impl;

import com.dgw.orangeviwer.entity.OcrAccess;
import com.dgw.orangeviwer.repository.OcrAccessRepository;
import com.dgw.orangeviwer.services.OcrAccessService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @program: orange_ocr-parent
 * @description:
 * @author: Mr.Dai
 * @create: 2020-04-08 18:11
 **/
@Service
public class OcrAccessServiceImpl implements OcrAccessService {

    @Autowired
    private OcrAccessRepository ocrAccessRepository;

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void updatAaccessCount(Date date) {
        OcrAccess accessDate = ocrAccessRepository.findByAccessDate(date);
        if(accessDate==null){
            accessDate = new OcrAccess();
            accessDate.setAccessCount(1);
            accessDate.setAccessDate(new Date());
        }
        accessDate.setAccessCount(accessDate.getAccessCount()+1);
    }
}
