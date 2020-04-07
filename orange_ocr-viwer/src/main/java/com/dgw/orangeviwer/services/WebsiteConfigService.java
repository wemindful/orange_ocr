package com.dgw.orangeviwer.services;


import com.dgw.orangeviwer.entity.WebsiteConfig;

public interface WebsiteConfigService {

    WebsiteConfig findWebsiteConfig();

    void saveWebsiteConfig(WebsiteConfig websiteConfig);
}
