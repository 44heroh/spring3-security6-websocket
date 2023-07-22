package com.example.spring3security6websocket.dto;

import java.time.LocalDateTime;

public class ChatMessageDto {

    private String sender;

    private String receiver;

    private String message;

    private LocalDateTime localDateTime;

    public ChatMessageDto() {
        this.localDateTime = LocalDateTime.now();
    }

    public ChatMessageDto(String sender, String receiver, String message) {
        this();
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "ChatMessageDto{" +
                "sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", message='" + message + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
