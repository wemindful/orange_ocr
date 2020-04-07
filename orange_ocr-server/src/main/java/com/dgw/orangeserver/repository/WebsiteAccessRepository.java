package com.dgw.orangeserver.repository;



import com.dgw.orangeserver.entity.WebsiteAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface WebsiteAccessRepository extends JpaRepository<WebsiteAccess, Long> {

    WebsiteAccess getByAccessDateIs(Date accessDate);
}
