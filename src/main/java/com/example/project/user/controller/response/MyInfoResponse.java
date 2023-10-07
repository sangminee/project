package com.example.project.user.controller.response;

import com.example.project.user.domain.User;
import com.example.project.user.domain.UserStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyInfoResponse {

    private Long id;
    private String email;
    private String nickname;
    private String address;
    private String certificationCode;
    private UserStatus status;
    private Long lastLoginAt;

    public static MyInfoResponse from(User user){
        return MyInfoResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .address(user.getAddress())
                .certificationCode(user.getCertificationCode())
                .status(user.getStatus())
                .lastLoginAt(user.getLastLoginAt())
                .build();
    }

}
