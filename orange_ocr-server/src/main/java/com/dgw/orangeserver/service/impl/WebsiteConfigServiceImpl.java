package com.dgw.orangeserver.service.impl;


import com.dgw.orangeserver.entity.WebsiteConfig;
import com.dgw.orangeserver.repository.WebsiteConfigRepository;
import com.dgw.orangeserver.service.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebsiteConfigServiceImpl implements WebsiteConfigService {

    @Autowired
    private WebsiteConfigRepository websiteConfigRepository;

    @Override
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
