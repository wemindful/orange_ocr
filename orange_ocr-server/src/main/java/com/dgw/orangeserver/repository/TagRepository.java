package com.dgw.orangeserver.repository;



import com.dgw.orangeserver.entity.OcrTexts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;


public interface TagRepository extends JpaRepository<OcrTexts, Long>, JpaSpecificationExecutor<OcrTexts> {

    OcrTexts findBytextName(String textName);

    Integer countByTagInputDate(Date tagInputdate);
}
