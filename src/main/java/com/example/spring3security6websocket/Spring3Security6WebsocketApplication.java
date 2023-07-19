package com.example.spring3security6websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Spring3Security6WebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring3Security6WebsocketApplication.class, args);
    }

}
