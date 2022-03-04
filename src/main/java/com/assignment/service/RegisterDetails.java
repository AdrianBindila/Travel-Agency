package com.assignment.service;

import java.util.Objects;
import java.util.regex.Pattern;

public class RegisterDetails {
    

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
        if (!validatePassword(password)) return RegisterStatus.INVALID_PASSWORD;
        if (!validateConfPass(password, confirmedPassword)) return RegisterStatus.INVALID_CONFIRMPASS;
        return RegisterStatus.CORRECT;
    }

    private boolean validateName(String name) {//name shouldn't contain numbers and first letter should be capital
        return !name.isEmpty() && name.chars().allMatch(Character::isLetter) && Character.isUpperCase(name.charAt(0));
    }

    private boolean validateEmail(String email) {
        //{address}@{domain}
        //email must be unique - must not already exist in DB
        String emailPattern = "^(.+)@(\\\\S+)$";
        return Pattern.compile(emailPattern).matcher(email).matches() && !findEmail(email);
    }

    private boolean findEmail(String email) {
        //TODO
        return false;
    }

    private boolean validateUsername(String username) {
        //username too short - at least 4 chars
        return (username.length() > 3) && !findUsername(username);
    }

    private boolean findUsername(String username) {
        //TODO
        return false;
    }

    private boolean validatePassword(String password) {
        //password 8 char, must contain number
        return (password.length() > 7 && password.chars().anyMatch(Character::isDigit));
    }

    private boolean validateConfPass(String password, String confirmedPassword) {
        return (Objects.equals(password, confirmedPassword));
    }
}
