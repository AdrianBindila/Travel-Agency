package com.assignment.service;

public class LoginDetails {
    private final String username;
    private final String password;

    public LoginDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginStatus validate() {
        if (username.isEmpty()) return LoginStatus.EMPTY_USERNAME;
        if (password.isEmpty()) return LoginStatus.EMPTY_PASSWORD;
        if (!findLogin(username, password)) return LoginStatus.NOT_FOUND;
        return LoginStatus.CORRECT;
    }

    private boolean findLogin(String username, String password) {//TODO
        return false;
    }

    public void loginUser(){

    }
}
