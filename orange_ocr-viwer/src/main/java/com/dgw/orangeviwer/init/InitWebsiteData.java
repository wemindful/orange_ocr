package com.dgw.orangeviwer.init;

import com.dgw.orangeviwer.constants.Constant;
import com.dgw.orangeviwer.entity.Link;
import com.dgw.orangeviwer.entity.WebsiteAccess;
import com.dgw.orangeviwer.entity.WebsiteConfig;
import com.dgw.orangeviwer.services.LinkService;
import com.dgw.orangeviwer.services.WebsiteAccessService;
import com.dgw.orangeviwer.services.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

@Component
public class InitWebsiteData {

    private Logger logger=Logger.getLogger(InitWebsiteData.class.getName());

    @Autowired
    private WebsiteAccessService websiteAccessService;

    @Autowired
    private WebsiteConfigService websiteConfigService;

    @Autowired
    private LinkService linkService;

    @PostConstruct
    public void initWebsiteVisits(){
        // 初始化目录
        try {
            File directory = new File("");
            File canonicalFile = directory.getCanonicalFile();
            Constant.IMAGE_PATH=canonicalFile.getAbsolutePath();
        } catch (IOException e) {
            logger.warning("初始化目录失败!");
            e.printStackTrace();
        }

        //查询当日是否存在访问表记录，不存在则插入
        if(websiteAccessService.getByAccessDateIs(new Date()) == null){
            WebsiteAccess websiteAccess = new WebsiteAccess();
            websiteAccess.setAccessCount(1);
            websiteAccess.setAccessDate(new Date());
            websiteAccessService.save(websiteAccess);
        }
        //查询当日是否存在配置表记录，不存在则插入
        if(websiteConfigService.findWebsiteConfig()==null){
            WebsiteConfig websiteConfig = new WebsiteConfig();
            websiteConfig.setId(1L);
            websiteConfig.setAboutPageArticleId(7L);
            websiteConfig.setBlogName("橙子OCR");
            websiteConfig.setAuthorName("dgw");
            websiteConfig.setDomainName("Daiguowei.cn");
            websiteConfig.setRecordNumber("辽ICP备17014944号-1");
            websiteConfig.setEmailUsername("1242556354@qq.com");
            websiteConfigService.saveWebsiteConfig(websiteConfig);
        }
        // 查询当日是否存在链接记录，不存在则插入
        if(linkService.findWebLinkConfig()==null){
            Link link = new Link();
            link.setLinkId(1L);;
            link.setLinkName("Wei 博客");
            link.setLinkUrl("https://www.cnblogs.com/dgwblog/");
            link.setRemark("我的博客");
            linkService.saveLink(link);
        }
    }
}