package com.example.spring3security6websocket.service.impl;

import com.example.spring3security6websocket.dao.entity.Message;
import com.example.spring3security6websocket.dao.entity.Status;
import com.example.spring3security6websocket.dao.entity.User;
import com.example.spring3security6websocket.dto.ChatMessageDto;
import com.example.spring3security6websocket.repository.MessageRepository;
import com.example.spring3security6websocket.repository.UserRepository;
import com.example.spring3security6websocket.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    public void save(ChatMessageDto chatMessageDto) {
        User receiver = userRepository.findByEmail(chatMessageDto.getReceiver());
        User sender = userRepository.findByEmail(chatMessageDto.getSender());

        Message message = new Message();
        message.setText(chatMessageDto.getMessage());
        message.setReceiver(receiver);
        message.setSender(sender);
        message.setCreated(new Date());
        message.setUpdated(new Date());
        message.setStatus(Status.ACTIVE);
        messageRepository.save(message);
    }
}
