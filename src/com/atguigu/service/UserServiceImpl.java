package com.atguigu.service;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.UserDaoImpl;
import com.atguigu.model.User;

public class UserServiceImpl implements UserService{
    private UserDao userDao = new UserDaoImpl();


    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public boolean register(User user) {
        return userDao.register(user);
    }
}
