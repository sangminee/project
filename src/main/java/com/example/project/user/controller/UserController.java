package com.example.project.user.controller;

import com.example.project.user.domain.UserCreateDto;
import com.example.project.user.controller.response.UserResponse;
import com.example.project.user.infrastructure.UserEntity;
import com.example.project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // create
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreateDto userCreateDto){
        UserEntity userEntity = userService.create(userCreateDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(UserResponse.of(userEntity));
    }

    // read

    // update

    // delete
}
