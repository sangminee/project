package com.example.project.user.service;

import com.example.project.common.exception.ResourceNotFoundException;
import com.example.project.mock.FakeUserRepository;
import com.example.project.mock.TestContainer;
import com.example.project.user.controller.port.UserService;
import com.example.project.user.domain.User;
import com.example.project.user.domain.UserCreate;
import com.example.project.user.domain.UserStatus;
import com.example.project.user.domain.UserUpdate;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.project.user.domain.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void init(){
        FakeUserRepository fakeUserRepository = new FakeUserRepository();
        this.userService = UserServiceImpl.builder()
                .userRepository(fakeUserRepository)
                .build();
        User user1 = User.builder()
                .id(1L)
                .email("test123@gmail.com")
                .nickname("test123")
                .address("Seoul")
                .certificationCode("aaa-aaa-aaa-aaa")
                .status(UserStatus.ACTIVE)
                .build();
        User user2 = User.builder()
                .id(2L)
                .email("test124@gmail.com")
                .nickname("test124")
                .address("Seoul")
                .certificationCode("aaa-aaa-aaa-aab")
                .status(UserStatus.PENDING)
                .build();
        fakeUserRepository.save(user1);
        fakeUserRepository.save(user2);
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

    @Test
    void getById로_ACTIVE_상태의_유저를_불러올_수_있다(){
        // given
        // when
        User user = userService.getById(1L);
        // then
        assertThat(user.getStatus()).isEqualTo(UserStatus.ACTIVE);
    }

    @Test
    void getById로_PENDING_상태의_유저를_불러오면_에러를_던진다(){
        // given
        // when
        // then
        assertThatThrownBy(()->{
           userService.getById(2L);
        }).isInstanceOf(ResourceNotFoundException.class);
    }

    @Test
    void getByEmail로_ACTIVE_상태의_유저를_불러올_수_있다(){
        // given
        // when
        User user = userService.getByEmail("test123@gmail.com");
        // then
        assertThat(user.getStatus()).isEqualTo(UserStatus.ACTIVE);
    }

    @Test
    void getByEmail로_PENDING_상태의_유저를_불러오면_에러를_던진다(){
        // given
        // when
        // then
        assertThatThrownBy(()->{
            userService.getByEmail("test124@gmail.com");
        }).isInstanceOf(ResourceNotFoundException.class);
    }

    @Test
    void UserUpdate_로_유저를_수정할_수_있다(){
        // given
        UserUpdate userUpdate = UserUpdate.builder()
                .address("Incheon")
                .nickname("test123-u")
                .build();

        // when
        userService.update(userUpdate, 1);

        // then
        User user = userService.getById(1);
        AssertionsForClassTypes.assertThat(user.getId()).isNotNull();
        AssertionsForClassTypes.assertThat(user.getAddress()).isEqualTo("Incheon");
        AssertionsForClassTypes.assertThat(user.getNickname()).isEqualTo("test123-u");
    }

}