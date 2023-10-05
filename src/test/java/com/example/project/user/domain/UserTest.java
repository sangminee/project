package com.example.project.user.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    public void User는_UserCresteDto_객체로_생성할_수_있다(){
        // given
        UserCreate userCreate = UserCreate.builder()
                .email("test123@gmail.com")
                .nickname("test123")
                .address("Seoul")
                .build();

        // when
        User user = User.from(userCreate);

        // then
        assertThat(user.getId()).isNull();
        assertThat(user.getEmail()).isEqualTo("test123@gmail.com");
        assertThat(user.getNickname()).isEqualTo("test123");
        assertThat(user.getAddress()).isEqualTo("Seoul");
        assertThat(user.getStatus()).isEqualTo(UserStatus.PENDING);
    }

}