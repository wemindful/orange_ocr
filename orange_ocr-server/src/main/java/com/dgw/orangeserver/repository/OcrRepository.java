package com.dgw.orangeserver.repository;

import com.dgw.orangeserver.entity.OcrAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: orange_ocr-parent
 * @description:
 * @author: Mr.Dai
 * @create: 2020-04-08 14:33
 **/
@Repository
public interface OcrRepository extends JpaRepository<OcrAccess,Long> {
}
