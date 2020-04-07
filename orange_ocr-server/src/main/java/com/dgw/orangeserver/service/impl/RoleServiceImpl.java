package com.dgw.orangeserver.service.impl;


import com.dgw.orangeserver.constants.Constants;
import com.dgw.orangeserver.entity.Role;
import com.dgw.orangeserver.repository.RoleRepository;
import com.dgw.orangeserver.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRoleByRoleId(Long roleId) {
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (optionalRole.isPresent()) {
            return optionalRole.get();
        }
        return null;
    }

    @Override
    public List<Role> findAllByIsEnable() {
        return roleRepository.findAllByIsEnable(Constants.YES);
    }

}
