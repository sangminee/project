package com.example.project.user.controller;

import com.example.project.user.controller.response.UserResponse;
import com.example.project.user.domain.UserCreate;
import com.example.project.user.domain.UserStatus;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

class UserCreateControllerTest{

    @Test
    void UserCreate를_가지고_UserResponse를_생성할_수_있다(){
        // given
        UserCreateController userCreateController = UserCreateController.builder().build();
        UserCreate userCreate = UserCreate.builder()
                .email("test123@gmail.com")
                .nickname("test123")
                .address("Seoul")
                .build();

        // when
        ResponseEntity<UserResponse> result = userCreateController.create(userCreate);

        // then
        assertThat(result.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().getId()).isEqualTo(1L);
        assertThat(result.getBody().getEmail()).isEqualTo("test123@gmail.com");
        assertThat(result.getBody().getNickname()).isEqualTo("test123");
        assertThat(result.getBody().getStatus()).isEqualTo(UserStatus.PENDING);
        assertThat(result.getBody().getLastLoginAt()).isEqualTo(0L);
    }

}