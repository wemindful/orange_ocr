package com.dgw.orangeviwer.services.impl;

import com.dgw.orangeviwer.entity.Message;
import com.dgw.orangeviwer.repository.MessageRepository;
import com.dgw.orangeviwer.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }
}
