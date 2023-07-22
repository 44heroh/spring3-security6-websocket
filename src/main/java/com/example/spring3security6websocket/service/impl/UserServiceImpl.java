package com.example.spring3security6websocket.service.impl;

import com.example.spring3security6websocket.dto.UserDto;
import com.example.spring3security6websocket.dao.entity.ERole;
import com.example.spring3security6websocket.dao.entity.Role;
import com.example.spring3security6websocket.dao.entity.User;
import com.example.spring3security6websocket.repository.RoleRepository;
import com.example.spring3security6websocket.repository.UserRepository;
import com.example.spring3security6websocket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDto userDto) {
        Role role = roleRepository.findByName(String.valueOf(ERole.ROLE_USER));

        List<Role> roles = Arrays.asList(role);
        User user = new User(userDto.getName(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()),
                roles);
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
