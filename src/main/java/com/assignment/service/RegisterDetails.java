package com.assignment.service;

public class RegisterDetails {
    public enum RegisterStatus {
        CORRECT,
        INVALID_FNAME,
        INVALID_LNAME,
        INVALID_EMAIL,
        INVALID_USERNAME,
        INVALID_PASSWORD,
        INVALID_CONFIRMPASS
    }

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String username;
    private final String password;
    private final String confirmedPassword;

    public RegisterDetails(String firstName, String lastName, String email, String username, String password, String confirmedPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

    public RegisterStatus validate() {
        if (!validateName(firstName)) return RegisterStatus.INVALID_FNAME;
        if (!validateName(lastName)) return RegisterStatus.INVALID_LNAME;
        if (!validateEmail(email)) return RegisterStatus.INVALID_EMAIL;
        if (!validateUsername(username)) return RegisterStatus.INVALID_USERNAME;
        if (!validateUsername(password)) return RegisterStatus.INVALID_PASSWORD;
        if (!validateConfPass(password, confirmedPassword)) return RegisterStatus.INVALID_CONFIRMPASS;
        return RegisterStatus.CORRECT;
    }

    private boolean validateName(String name) {
        return false;
    }

    private boolean validateEmail(String email) {
        return false;
    }

    private boolean validateUsername(String username) {
        //username too short
        return false;
    }

    private boolean validatePassword(String password) {
        //password 8 char, must contain number and letter
        return false;
    }

    private boolean validateConfPass(String password, String confirmedPassword) {
        return false;
    }
}
