package com.example.project.user.controller.port;

import com.example.project.user.domain.User;
import com.example.project.user.domain.UserCreate;
import com.example.project.user.domain.UserUpdate;

public interface UserService {

    User getByEmail(String email);

    User getById(long id);

    User create(UserCreate userCreate);

    User update(UserUpdate userUpdate, long id);
}
