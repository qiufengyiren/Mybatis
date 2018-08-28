package com.dzq.pojo;

import java.io.Serializable;

public class Users implements Serializable {
    private int id;//id
    private String username;//用户名
    private int password;//密码

    public Users(String username, int password) {

        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + password +
                '}';
    }

    public Users() {
    }
}
