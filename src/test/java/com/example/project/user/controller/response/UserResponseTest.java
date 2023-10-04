package com.example.project.user.controller.response;

import com.example.project.user.domain.User;
import com.example.project.user.domain.UserStatus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserResponseTest {

    @Test
    public void User로_응답을_생성할_수_있다(){
        // given
        User user = User.builder()
                .id(1L)
                .email("test111@gmail.com")
                .nickname("sangmin")
                .address("Seoul")
                .status(UserStatus.ACTIVE)
                .lastLoginAt(100L)
                .certificationCode("aaaaa-aaaaa-aaaaaa-aaaaaaaaaaaab")
                .build();

        // when
        UserResponse userResponse = UserResponse.from(user);

        // then
        assertThat(userResponse.getId()).isEqualTo(1);
        assertThat(userResponse.getEmail()).isEqualTo("test111@gmail.com");
        assertThat(userResponse.getStatus()).isEqualTo(UserStatus.ACTIVE);
        assertThat(userResponse.getLastLoginAt()).isEqualTo(100L);
    }

}