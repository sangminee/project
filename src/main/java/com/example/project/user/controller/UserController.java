package com.example.project.user.controller;

import com.example.project.user.controller.port.UserService;
import com.example.project.user.controller.response.UserResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Builder
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable long id){
        return ResponseEntity
                .ok()
                .body(UserResponse.from(userService.getById(id)));
    }

}
