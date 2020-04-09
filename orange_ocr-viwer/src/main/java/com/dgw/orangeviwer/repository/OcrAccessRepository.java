package com.dgw.orangeviwer.repository;

import com.dgw.orangeviwer.entity.OcrAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @program: orange_ocr-parent
 * @description:
 * @author: Mr.Dai
 * @create: 2020-04-08 18:10
 **/
@Repository
public interface OcrAccessRepository extends JpaRepository<OcrAccess,Long> {
        OcrAccess findByAccessDate(Date date);
}
