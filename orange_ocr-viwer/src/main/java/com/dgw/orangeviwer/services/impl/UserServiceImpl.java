package com.dgw.orangeviwer.services.impl;

import com.dgw.orangeviwer.entity.User;
import com.dgw.orangeviwer.repository.UserRepository;
import com.dgw.orangeviwer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @program: orange_ocr-parent
 * @description:
 * @author: Mr.Dai
 * @create: 2020-04-06 23:00
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByUserId(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        Optional<User> optionalUser = userRepository.findUserByUsername(username);
        return optionalUser.orElse(null);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
