package com.atguigu.dao;

import com.atguigu.model.User;
import com.atguigu.utils.BaseDBUtils;

public class UserDaoImpl implements UserDao {
    private BaseDBUtils baseDBUtils = new BaseDBUtils();
    @Override
    public User login(User user) {
        String sql = "select * from t_user where username = ? and password = ?";
        return baseDBUtils.getBean(sql,User.class,user.getUsername(),user.getPassword());
    }

    @Override
    public boolean register(User user) {
        String sql = "insert into t_user values(null,?,?,?)";
        Object[] arr = {user.getUsername(),user.getPassword(),user.getEmail()};
        int i = baseDBUtils.update(sql, arr);
        return i>0;
    }
}
