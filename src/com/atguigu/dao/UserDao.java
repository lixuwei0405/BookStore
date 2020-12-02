package com.atguigu.dao;

import com.atguigu.model.User;

public interface UserDao {
    User login(User user);

    boolean register(User user);
}
