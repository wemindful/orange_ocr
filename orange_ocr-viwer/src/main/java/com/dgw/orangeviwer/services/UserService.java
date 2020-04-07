package com.dgw.orangeviwer.services;

import com.dgw.orangeviwer.entity.User;

public interface UserService {

    User findUserByUserId(Long userId);
    User findByUsername(String username);
    void saveUser(User user);
}