package com.example.project.user.controller;

import com.example.project.user.controller.port.UserService;
import com.example.project.user.controller.response.UserResponse;
import com.example.project.user.domain.UserCreate;
import com.example.project.user.domain.UserStatus;
import com.example.project.user.service.UserServiceImpl;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Builder
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserCreateController {

    @PostMapping("/test")
    public ResponseEntity<UserResponse> create(@RequestBody UserCreate userCreate){

        UserResponse userResponse = UserResponse.builder()
                .id(1L)
                .email(userCreate.getEmail())
                .nickname(userCreate.getNickname())
                .status(UserStatus.PENDING)
                .lastLoginAt(0L)
                .build();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userResponse);
    }

}
