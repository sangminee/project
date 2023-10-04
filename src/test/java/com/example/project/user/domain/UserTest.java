package com.example.project.user.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void User는_UserCresteDto_객체로_생성할_수_있다(){
        // given
        UserCreateDto userCreateDto = UserCreateDto.builder()
                .email("test111@gmail.com")
                .nickname("sangmin")
                .address("Seoul")
                .build();

        // when
        User user = User.from(userCreateDto);

        // then
        assertThat(user.getId()).isNull();
        assertThat(user.getEmail()).isEqualTo("test111@gmail.com");
        assertThat(user.getNickname()).isEqualTo("sangmin");
        assertThat(user.getAddress()).isEqualTo("Seoul");
        assertThat(user.getStatus()).isEqualTo(UserStatus.PENDING);
    }

}