package com.dgw.orangeviwer.interceptor;

import com.dgw.orangeviwer.entity.WebsiteAccess;
import com.dgw.orangeviwer.services.LinkService;
import com.dgw.orangeviwer.services.WebsiteAccessService;
import com.dgw.orangeviwer.services.WebsiteConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.util.Date;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {
    Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Autowired
    private WebsiteAccessService websiteAccessService;
    @Autowired
    private LinkService linkService;
    @Autowired
    private WebsiteConfigService websiteConfigService;
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if(modelAndView != null){
            ModelMap modelMap = modelAndView.getModelMap();
            logger.info("正在更新网站访问次数。");
            WebsiteAccess websiteAccess = websiteAccessService.getByAccessDateIs(new Date());
            websiteAccess.setAccessCount(websiteAccess.getAccessCount() + 1);
            websiteAccessService.save(websiteAccess);
            logger.info("加入底部数据。");
            //网站访问次数
            modelMap.addAttribute("websiteAccess", websiteAccessService.getByAccessDateIs(new Date()));
            //链接列表
            modelMap.addAttribute("linkList", linkService.findAllByIsEnable());
            //网站配置
            modelMap.addAttribute("websiteConfig", websiteConfigService.findWebsiteConfig());
        }
    }
}