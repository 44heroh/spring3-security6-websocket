package com.example.spring3security6websocket.controller;

import com.example.spring3security6websocket.dto.ChatMessageDto;
import com.example.spring3security6websocket.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    private final SimpMessagingTemplate template;

    private final MessageService messageService;

    @Autowired
    public ChatController(SimpMessagingTemplate template, MessageService messageService) {
        this.template = template;
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String indexPage() {
        return "chat";
    }

    @MessageMapping("/send_message")
    public void messageReceiver(@Payload ChatMessageDto chatMessageDto) {
        logger.info("New message: " + chatMessageDto);
        template.convertAndSendToUser(chatMessageDto.getReceiver(), "/chat_out/receive_message", chatMessageDto);
        messageService.save(chatMessageDto);
    }

}
