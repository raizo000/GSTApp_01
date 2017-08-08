package com.gst.Model;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

public class SearchCriteria {
    @NotBlank(message = "username can't empty!")
    String username;
    List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
