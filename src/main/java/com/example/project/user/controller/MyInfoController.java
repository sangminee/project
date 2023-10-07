package com.example.project.user.controller;

import com.example.project.user.controller.port.UserService;
import com.example.project.user.controller.response.MyInfoResponse;
import com.example.project.user.domain.User;
import com.example.project.user.domain.UserUpdate;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Builder
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class MyInfoController {

    private final UserService userService;

    // read

    @PutMapping
    public ResponseEntity<MyInfoResponse> update(@RequestBody UserUpdate userUpdate,
                                                 @RequestHeader("EMAIL") String email){
        User user = userService.getByEmail(email);
        user = userService.update(userUpdate, user.getId());
        return ResponseEntity
                .ok()
                .body(MyInfoResponse.from(user));
    }

    // delete
}
