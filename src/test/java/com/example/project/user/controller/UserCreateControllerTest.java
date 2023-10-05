package com.example.project.user.controller;

import com.example.project.user.controller.response.UserResponse;
import com.example.project.user.domain.UserCreate;
import com.example.project.user.domain.UserStatus;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class UserCreateControllerTest{

    @Test
    void UserCreate를_가지고_UserResponse를_생성할_수_있다(){
        // given
        UserCreate userCreate = UserCreate.builder()
                .email("test123@gmail.com")
                .nickname("test123")
                .address("Seoul")
                .build();

        // when
        UserResponse userResponse = UserResponse.builder()
                .id(1L)
                .email(userCreate.getEmail())
                .nickname(userCreate.getNickname())
                .status(UserStatus.PENDING)
                .lastLoginAt(0L)
                .build();

        // then
        assertThat(userResponse).isNotNull();
        assertThat(userResponse.getId()).isEqualTo(1L);
        assertThat(userResponse.getEmail()).isEqualTo("test123@gmail.com");
        assertThat(userResponse.getNickname()).isEqualTo("test123");
        assertThat(userResponse.getStatus()).isEqualTo(UserStatus.PENDING);
        assertThat(userResponse.getLastLoginAt()).isEqualTo(0L);
    }

}