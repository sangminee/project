package com.example.project.user.service.port;

import com.example.project.user.domain.User;
import com.example.project.user.domain.UserStatus;

import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findByIdAndStatus(long id, UserStatus active);

    Optional<User> findByEmailAndStatus(String email, UserStatus active);
}
