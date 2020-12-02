package com.atguigu.model;

import lombok.Data;

@Data
public class User {
    private int uid;

    private String username;

    private String password;

    private String email;

    public User(int uid, String username, String password, String email) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {
    }


}
