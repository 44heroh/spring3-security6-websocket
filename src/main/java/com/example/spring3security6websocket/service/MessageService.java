package com.example.spring3security6websocket.service;

import com.example.spring3security6websocket.dto.ChatMessageDto;

public interface MessageService {

    public void save(ChatMessageDto chatMessageDto);
}
