package com.dgw.orangeserver.service;


import com.dgw.orangeserver.entity.WebsiteConfig;

public interface WebsiteConfigService {

    WebsiteConfig findWebsiteConfig();

    void saveWebsiteConfig(WebsiteConfig websiteConfig);
}
