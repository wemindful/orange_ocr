package com.dgw.orangeserver.service;



import com.dgw.orangeserver.entity.Role;

import java.util.List;


public interface RoleService {

    Role findRoleByRoleId(Long roleId);

    List<Role> findAllByIsEnable();

}
