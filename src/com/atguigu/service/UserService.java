package com.atguigu.service;

import com.atguigu.model.User;

public interface UserService {
    User login(User user);

    boolean register(User user);
}
