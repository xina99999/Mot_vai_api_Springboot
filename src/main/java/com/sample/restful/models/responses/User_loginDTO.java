package com.sample.restful.models.responses;

import com.sample.restful.entities.User;

public class User_loginDTO {
    private String userName;
    private String password;

    public User_loginDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static User_loginDTO from(User user){
        User_loginDTO response = new User_loginDTO();
        response.setUserName(user.getUserName());
        response.setPassword(user.getPassword());
        return response;
    }
}
