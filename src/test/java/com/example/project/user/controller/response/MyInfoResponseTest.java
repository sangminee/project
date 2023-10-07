package com.example.project.user.controller.response;

import com.example.project.user.domain.User;
import com.example.project.user.domain.UserStatus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyInfoResponseTest {

    @Test
    public void User로_MyInfoResponse_객체를_생성할_수_있다(){
        // given
        User user = User.builder()
                .id(1L)
                .email("test123@gmail.com")
                .nickname("test123")
                .address("Seoul")
                .certificationCode("aaa-aaa-aaa-aaa")
                .status(UserStatus.ACTIVE)
                .build();

        // when
        MyInfoResponse myInfoResponse = MyInfoResponse.from(user);

        // then
        assertThat(myInfoResponse).isNotNull();
        assertThat(myInfoResponse.getEmail()).isEqualTo("test123@gmail.com");
        assertThat(myInfoResponse.getNickname()).isEqualTo("test123");
        assertThat(myInfoResponse.getAddress()).isEqualTo("Seoul");
        assertThat(myInfoResponse.getCertificationCode()).isEqualTo("aaa-aaa-aaa-aaa");
        assertThat(myInfoResponse.getStatus()).isEqualTo(UserStatus.ACTIVE);
    }

}