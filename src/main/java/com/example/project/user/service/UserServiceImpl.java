package com.example.project.user.service;

import com.example.project.user.controller.port.UserService;
import com.example.project.user.domain.User;
import com.example.project.user.domain.UserCreate;
import com.example.project.user.service.port.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Builder
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public User create(UserCreate userCreate) {
        User user = User.from(userCreate);
        user = userRepository.save(user);
        return user;
    }

}
