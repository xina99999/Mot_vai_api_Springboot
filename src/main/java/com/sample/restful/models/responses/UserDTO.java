package com.sample.restful.models.responses;

import com.sample.restful.entities.User;
import jakarta.persistence.Column;

public class UserDTO {
    private  Long  ID;


    private String userName;


    private String Password;


    private  String Email;

    private String FirstName;


    private String LastName;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public UserDTO() {
    }


    public static UserDTO from(User user)
    {
        UserDTO response = new UserDTO();
        response.setID(user.getID());
        response.setUserName(user.getUserName());
        response.setPassword(user.getPassword());
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        return response;
    }
}
