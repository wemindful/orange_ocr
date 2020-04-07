package com.dgw.orangeserver.service;


import com.dgw.orangeserver.entity.Pages;
import com.dgw.orangeserver.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {

    Page<User> findAllBySearch(Pages pages, Long userId, String username);

    User findUserByUserId(Long userId);

    String saveOrUpdateUser(User user);

    void updateUserIsEnable(Long userId, Integer isEnable);

    void deleteUser(Long userId);

    User findByUsername(String username);

}
