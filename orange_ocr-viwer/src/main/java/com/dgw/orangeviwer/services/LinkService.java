package com.dgw.orangeviwer.services;



import com.dgw.orangeviwer.entity.Link;

import java.util.List;

public interface LinkService {

    List<Link> findAllByIsEnable();

    Link findWebLinkConfig();

    void  saveLink(Link link);
}
