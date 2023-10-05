package com.example.project.mock;

import com.example.project.user.controller.UserController;
import com.example.project.user.controller.UserCreateController;
import com.example.project.user.controller.port.UserService;
import com.example.project.user.service.UserServiceImpl;
import com.example.project.user.service.port.UserRepository;
import lombok.Builder;

public class TestContainer {

    public final UserRepository userRepository;
    public final UserService userService;
    public final UserCreateController userCreateController;

    @Builder
    public TestContainer() {
        this.userRepository = new FakeUserRepository();
        this.userService = UserServiceImpl.builder()
                .userRepository(userRepository)
                .build();
        this.userCreateController = UserCreateController.builder()
                .userService(userService)
                .build();
    }
}
