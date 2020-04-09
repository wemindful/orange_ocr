package com.dgw.orangeserver.repository;



import com.dgw.orangeserver.entity.WebsiteAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public interface WebsiteAccessRepository extends JpaRepository<WebsiteAccess, Long> {

    WebsiteAccess getByAccessDateIs(Date accessDate);
}
