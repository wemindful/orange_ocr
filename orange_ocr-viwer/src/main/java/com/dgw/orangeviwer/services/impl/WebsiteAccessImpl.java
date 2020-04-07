package com.dgw.orangeviwer.services.impl;


import com.dgw.orangeviwer.entity.WebsiteAccess;
import com.dgw.orangeviwer.repository.WebsiteAccessRepository;
import com.dgw.orangeviwer.services.WebsiteAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WebsiteAccessImpl implements WebsiteAccessService {

    @Autowired
    private WebsiteAccessRepository websiteAccessRepository;

    @Override
    public WebsiteAccess getByAccessDateIs(Date accessDate) {
        return websiteAccessRepository.getByAccessDateIs(accessDate);
    }

    @Override
    public void save(WebsiteAccess websiteAccess) {
        websiteAccessRepository.save(websiteAccess);
    }
}
