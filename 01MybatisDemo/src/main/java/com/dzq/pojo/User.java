package com.dzq.pojo;

public class User {
    private int id;//id
    private String username;//用户名
    private String password;//密码

    public User( String username, String password) {

        this.username = username;
        this.password = password;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User() {
    }
}
