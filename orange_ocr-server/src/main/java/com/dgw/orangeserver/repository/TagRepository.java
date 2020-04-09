package com.dgw.orangeserver.repository;



import com.dgw.orangeserver.entity.OcrTexts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TagRepository extends JpaRepository<OcrTexts, Long>, JpaSpecificationExecutor<OcrTexts> {
    OcrTexts findBytextName(String textName);

    Integer countByTagInputDate(Date tagInputdate);
}
