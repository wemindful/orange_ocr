package com.dgw.orangeserver.service.impl;

import com.dgw.orangeserver.entity.Menu;
import com.dgw.orangeserver.repository.MenuRepository;
import com.dgw.orangeserver.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: orange_ocr-parent
 * @description:
 * @author: Mr.Dai
 * @create: 2020-04-07 16:31
 **/
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public void save(Menu menu) {
        menuRepository.save(menu);
    }
}
