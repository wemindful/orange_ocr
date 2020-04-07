package com.dgw.orangeviwer.repository;

import com.dgw.orangeviwer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @program: orange_ocr-parent
 * @description:
 * @author: Mr.Dai
 * @create: 2020-04-06 22:55
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}
