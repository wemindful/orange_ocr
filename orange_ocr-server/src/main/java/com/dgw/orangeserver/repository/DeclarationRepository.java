package com.dgw.orangeserver.repository;



import com.dgw.orangeserver.entity.Declaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface DeclarationRepository extends JpaRepository<Declaration, Long>, JpaSpecificationExecutor<Declaration> {
    Integer countByArticleInputDate(Date articleInputDate);
}
