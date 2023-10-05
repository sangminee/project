package com.example.project.user.controller;

import com.example.project.mock.TestContainer;
import com.example.project.user.controller.response.UserResponse;
import com.example.project.user.domain.User;
import com.example.project.user.domain.UserStatus;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

class UserControllerTest{

    @Test
    void 사용자는_특정_유저의_개인정보가_없는_정보를_얻을_수_있다(){
        // given
        TestContainer testContainer = new TestContainer();

        User user = User.builder()
                .id(1L)
                .email("test123@gmail.com")
                .nickname("test123")
                .address("Seoul")
                .certificationCode("aaa-aaa-aaa-aaa")
                .status(UserStatus.ACTIVE)
                .build();
        testContainer.userRepository.save(user);

        // when
        ResponseEntity<UserResponse> result = testContainer.userController.getById(1L);

        // then
        assertThat(result.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().getId()).isEqualTo(1L);
        assertThat(result.getBody().getNickname()).isEqualTo("test123");
        assertThat(result.getBody().getStatus()).isEqualTo(UserStatus.ACTIVE);
    }

}