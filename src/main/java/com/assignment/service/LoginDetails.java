package com.assignment.service;

public class LoginDetails {
    public enum LoginStatus {
        CORRECT,
        INVALID_USERNAME,
        INVALID_PASSWORD,
        NOT_FOUND
    }

    private final String username;
    private final String password;

    public LoginDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginStatus validate() {
        if (username.isEmpty()) return LoginStatus.INVALID_USERNAME;
        if (password.isEmpty()) return LoginStatus.INVALID_PASSWORD;
        if (!find(username, password)) return LoginStatus.NOT_FOUND;
        return LoginStatus.CORRECT;
    }

    private boolean find(String username, String password) {
        return false;
    }
}
