package com.assignment.service;

import com.assignment.model.User;
import com.assignment.repository.UserRepository;

public class LoginDetails {
    private final String username;
    private final String password;
    private User user;

    public LoginDetails(String username, String password) {
        this.username = username;
        this.password = password;
        this.user = null;
    }

    public User getUser() {
        return user;
    }

    public LoginStatus validate() {
        if (username.isEmpty()) return LoginStatus.EMPTY_USERNAME;
        if (password.isEmpty()) return LoginStatus.EMPTY_PASSWORD;
        if (!findLogin(username, password)) return LoginStatus.NOT_FOUND;
        return LoginStatus.CORRECT;
    }

    private boolean findLogin(String username, String password) {
        UserRepository userRepository = new UserRepository();
        this.user = userRepository.findLogin(username, password);
        return (user != null);
    }

}
