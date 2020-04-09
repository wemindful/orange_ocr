package com.dgw.orangeserver.repository;



import com.dgw.orangeserver.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>, JpaSpecificationExecutor<Message> {

    int countByIsRead(Integer isRead);

    List<Message> findAllByIsRead(Integer isRead);

}
