package com.jsonplaceholder.typicode.utils;

import com.jsonplaceholder.typicode.model.User;

import java.util.List;

public class UsersResponse {

    private int StatusCode;
    private boolean isSuccess;
    private List<User> userList;
    private User user;

    public UsersResponse(int statusCode, List<User> userList) {
        StatusCode = statusCode;
        this.userList = userList;
    }

    public UsersResponse(int statusCode, User user) {
        StatusCode = statusCode;
        this.user = user;
    }

    public UsersResponse(int statusCode, boolean isSuccess, List<User> userList) {
        StatusCode = statusCode;
        this.isSuccess = isSuccess;
        this.userList = userList;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public List<User> getUserList() {
        return userList;
    }

    public User getUser() {
        return user;
    }

}
