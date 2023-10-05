package com.example.project.user.service;

import com.example.project.mock.FakeUserRepository;
import com.example.project.user.controller.port.UserService;
import com.example.project.user.domain.User;
import com.example.project.user.domain.UserCreate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void init(){
        FakeUserRepository fakeUserRepository = new FakeUserRepository();
        this.userService = UserServiceImpl.builder()
                .userRepository(fakeUserRepository)
                .build();
    }

    @Test
    void UserCreate로_User를_생성할_수_있다(){
        // given
        UserCreate userCreate = UserCreate.builder()
                .email("test123@gmail.com")
                .nickname("test123")
                .address("Seoul")
                .build();
        // when
        User user = userService.create(userCreate);

        // then
        assertThat(user.getEmail()).isEqualTo("test123@gmail.com");
        assertThat(user.getNickname()).isEqualTo("test123");
        assertThat(user.getAddress()).isEqualTo("Seoul");
    }

}