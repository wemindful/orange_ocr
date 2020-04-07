package com.dgw.orangeviwer.services;



import com.dgw.orangeviwer.entity.WebsiteAccess;

import java.util.Date;

public interface WebsiteAccessService {

    WebsiteAccess getByAccessDateIs(Date accessDate);

    void save(WebsiteAccess websiteAccess);
}
