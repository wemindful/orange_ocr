package com.dgw.orangeviwer.services.impl;


import com.dgw.orangeviwer.entity.Link;
import com.dgw.orangeviwer.entity.WebsiteConfig;
import com.dgw.orangeviwer.repository.LinkRepository;
import com.dgw.orangeviwer.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Override
    @Cacheable(value = "link")
    public List<Link> findAllByIsEnable() {
        return linkRepository.findAll();
    }

    @Cacheable(value ="link" ,key = "#Link.linkId")
    @Override
    public Link findWebLinkConfig() {
        Optional<Link> websiteConfigOptional = linkRepository.findById(1L);
        if (websiteConfigOptional.isPresent()) {
            return websiteConfigOptional.get();
        }
        return null;
    }

    @Override
    public void saveLink(Link link) {
        linkRepository.save(link);
    }
}
