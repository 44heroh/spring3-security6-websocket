package com.example.spring3security6websocket.service;


import com.example.spring3security6websocket.dto.UserDto;
import com.example.spring3security6websocket.model.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
}
