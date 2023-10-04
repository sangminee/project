package com.example.project.user.service;

import com.example.project.user.domain.UserCreateDto;
import com.example.project.user.infrastructure.UserEntity;
import com.example.project.user.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity create(UserCreateDto userCreateDto) {
        return userRepository.save(UserEntity.of(userCreateDto));
    }

}
