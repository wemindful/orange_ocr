package com.dgw.orangeviwer.services.impl;


import com.dgw.orangeviwer.entity.WebsiteConfig;
import com.dgw.orangeviwer.repository.WebsiteConfigRepository;
import com.dgw.orangeviwer.services.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebsiteConfigServiceImpl implements WebsiteConfigService {

    @Autowired
    private WebsiteConfigRepository websiteConfigRepository;

    @Override
    @Cacheable(value = "websiteConfig", key = "#page")
    public WebsiteConfig findWebsiteConfig() {
        Optional<WebsiteConfig> websiteConfigOptional = websiteConfigRepository.findById(1L);
        if (websiteConfigOptional.isPresent()) {
            return websiteConfigOptional.get();
        }
        return null;
    }

    @Override
    public void saveWebsiteConfig(WebsiteConfig websiteConfig) {
        websiteConfigRepository.save(websiteConfig);
    }
}
