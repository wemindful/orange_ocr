package com.dgw.orangeserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    private static final long serialVersionUID = 3392729947020278189L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    private String roleName;
    private Integer isEnable;

    @ManyToMany
    @JoinTable(name = "UserRole",joinColumns = {@JoinColumn(name = "roleId")},inverseJoinColumns = {@JoinColumn(name = "userId")})
    private List<User> userList;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "RoleMenu",joinColumns = {@JoinColumn(name = "roleId")},inverseJoinColumns = {@JoinColumn(name = "menuId")})
    private List<Menu> menuList;


    @Transient
    private Integer isHave;

    public Role(Long roleId,String roleName, Integer isEnable) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.isEnable = isEnable;
    }
}
