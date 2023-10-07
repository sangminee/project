package com.example.project.user.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserUpdate {
    private String nickname;
    private String address;
}
