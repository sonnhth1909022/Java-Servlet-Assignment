package com.demo.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {

    private String username;
    private String password;

    public UserEntity() {
    }

    public boolean checkLogin() {
        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123"))
            return true;
        return false;
    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
