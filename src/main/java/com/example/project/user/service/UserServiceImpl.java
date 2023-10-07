package com.example.project.user.service;

import com.example.project.common.exception.ResourceNotFoundException;
import com.example.project.user.controller.port.UserService;
import com.example.project.user.domain.User;
import com.example.project.user.domain.UserCreate;
import com.example.project.user.domain.UserStatus;
import com.example.project.user.domain.UserUpdate;
import com.example.project.user.service.port.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Builder
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmailAndStatus(email, UserStatus.ACTIVE)
                .orElseThrow(()-> new ResourceNotFoundException("Users", email));
    }

    @Override
    public User getById(long id) {
        return userRepository.findByIdAndStatus(id, UserStatus.ACTIVE)
                .orElseThrow(()-> new ResourceNotFoundException("Users", id));
    }

    @Override
    public User create(UserCreate userCreate) {
        User user = User.from(userCreate);
        user = userRepository.save(user);
        return user;
    }

    @Override
    @Transactional
    public User update(UserUpdate userUpdate, long id) {
        User user = getById(id);
        user = user.update(userUpdate);
        return userRepository.save(user);
    }

}
