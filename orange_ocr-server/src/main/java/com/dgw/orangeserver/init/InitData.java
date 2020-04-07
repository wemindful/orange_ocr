package com.dgw.orangeserver.init;


import com.dgw.orangeserver.entity.*;
import com.dgw.orangeserver.repository.RoleRepository;
import com.dgw.orangeserver.service.LinkService;
import com.dgw.orangeserver.service.MenuService;
import com.dgw.orangeserver.service.UserService;
import com.dgw.orangeserver.service.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class InitData {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private WebsiteConfigService websiteConfigService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private LinkService linkService;

    @PostConstruct
    private void initRoleData() {

        // 初始化 menu
        Menu menu1 = new Menu(1L, "/static/**");
        Menu menu2 = new Menu(2L, "/");
        Menu menu3 = new Menu(3L, "/index/**");
        Menu menu4 = new Menu(4L, "/article/**");
        Menu menu5 = new Menu(5L, "/tag/**");
        Menu menu6 = new Menu(6L, "/link/**");
        Menu menu7 = new Menu(7L, "/user/**");
        Menu menu8 = new Menu(7L, "/message/**");
        Menu menu9 = new Menu(7L, "/system/**");

        menuService.save(menu1);
        menuService.save(menu2);
        menuService.save(menu3);
        menuService.save(menu4);
        menuService.save(menu5);
        menuService.save(menu6);
        menuService.save(menu7);
        menuService.save(menu8);
        menuService.save(menu9);


        // 初始化 角色
        Role role_user = new Role(1L, "ROLE_USER", 1);
        Role role_admin = new Role(2L, "ROLE_ADMIN", 1);
        Role role_superadmin = new Role(3L, "ROLE_SUPERADMIN", 1);
        Role role_systemadmin = new Role(4L, "ROLE_SYSTEMADMIN", 1);


        List<Menu> role_superadmin_list=new ArrayList<>();
        role_superadmin_list.addAll(Arrays.asList(menu1,menu2,menu3
                ,menu4,menu5,menu6,menu7,menu8,menu9));


        role_superadmin.setMenuList(role_superadmin_list);

        List<Role> roleList = new ArrayList<>();
        roleList.add(role_user);
        roleList.add(role_admin);
        roleList.add(role_superadmin);
        roleList.add(role_systemadmin);

        roleRepository.saveAll(roleList);


        // 初始化用户
        User user = userService.findUserByUserId(1L);
        if (user == null) {
            userService.saveOrUpdateUser(new User(1L, "admin", "123", "admin@springboot.cn", 1, roleList));

        }

        // 初始化 网站配置
        WebsiteConfig websiteConfig = websiteConfigService.findWebsiteConfig();
        if (websiteConfig == null) {
            websiteConfigService.saveWebsiteConfig(new WebsiteConfig(1L, "橙子OCR", "dgw", 7L, "辽ICP备17014944号-1", "Daiguowei.cn", "1242556354@qq.com"));
        }
        // 查询当日是否存在链接记录，不存在则插入
        if(linkService.findWebLinkConfig()==null){
            Link link = new Link();
            link.setLinkId(1L);;
            link.setLinkName("Wei 博客");
            link.setLinkUrl("https://www.cnblogs.com/dgwblog/");
            link.setRemark("我的博客");
            linkService.saveOrUpdateLink(link);
        }
    }
}
