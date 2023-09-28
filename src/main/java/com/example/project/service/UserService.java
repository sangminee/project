package com.example.project.service;

import com.example.project.model.dto.UserCreateDto;
import com.example.project.repository.UserEntity;
import com.example.project.repository.UserRepository;
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
