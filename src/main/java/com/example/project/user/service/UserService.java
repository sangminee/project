package com.example.project.user.service;

import com.example.project.user.domain.User;
import com.example.project.user.domain.UserCreate;
import lombok.Builder;

@Builder
public class UserService {

    public User create(UserCreate userCreate) {
        // service 는 다른 계층이므로 UserResponse가 여기서 만들어져서 다시 Controller로 가는 흐름이 만들어 지면 안됨
        // userCreate를 가지로 domain 계층에서의 user를 만들어 줌
        User user = User.from(userCreate);
        return user;
    }
}
