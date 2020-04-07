package com.dgw.orangeserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @program: orange_ocr-parent
 * @description:
 * @author: Mr.Dai
 * @create: 2020-04-07 16:06
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long menuId;
    private String menuName;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "RoleMenu",joinColumns = {@JoinColumn(name="menuId")},inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> roleList;

    public Menu(long id, String index_menu_flag) {
        this.menuId=id;
        this.menuName=index_menu_flag;
    }
}
