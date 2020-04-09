package com.dgw.orangeviwer.repository;

import com.dgw.orangeviwer.entity.OcrTexts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @program: orange_ocr-parent
 * @description:
 * @author: Mr.Dai
 * @create: 2020-04-08 17:30
 **/
@Repository
public interface OcrTextRepository extends JpaRepository<OcrTexts, Long>, JpaSpecificationExecutor<OcrTexts> {
}
