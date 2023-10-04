package com.example.project.user.controller.response;

import com.example.project.user.domain.UserStatus;
import com.example.project.user.infrastructure.UserEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private Long id;
    private String email;
    private String nickname;
    private UserStatus status;
    private Long lastLoginAt;

    public static UserResponse of(UserEntity userEntity){
        return UserResponse.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .nickname(userEntity.getNickname())
                .status(userEntity.getStatus())
                .lastLoginAt(userEntity.getLastLoginAt())
                .build();
    }
}
