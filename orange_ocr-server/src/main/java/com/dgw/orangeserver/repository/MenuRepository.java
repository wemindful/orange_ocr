package com.dgw.orangeserver.repository;

import com.dgw.orangeserver.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: orange_ocr-parent
 * @description:
 * @author: Mr.Dai
 * @create: 2020-04-07 16:30
 **/
@Repository
public interface MenuRepository extends JpaRepository<Menu,Long>{
}
