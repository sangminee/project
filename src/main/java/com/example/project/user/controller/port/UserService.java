package com.example.project.user.controller.port;

import com.example.project.user.domain.User;
import com.example.project.user.domain.UserCreate;

public interface UserService {

    User create(UserCreate userCreate);

    User getById(long id);

}
