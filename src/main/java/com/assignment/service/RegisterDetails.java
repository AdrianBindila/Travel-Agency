package com.assignment.service;

import com.assignment.model.User;
import com.assignment.repository.UserRepository;

import java.util.Objects;
import java.util.regex.Pattern;

public class RegisterDetails {
    private final User user;
    private final String confirmedPassword;
    private final UserRepository userRepository;

    public RegisterDetails(String firstName, String lastName, String email, String username, String password, String confirmedPassword) {
        this.user = new User(email, username, password, firstName, lastName);
        this.confirmedPassword = confirmedPassword;
        this.userRepository = new UserRepository();
    }

    public User registerUser() {
        userRepository.insert(user);
        return user;
    }

    public RegisterStatus validate() {
        if (validateName(user.getFirstName())) return RegisterStatus.INVALID_FNAME;
        if (validateName(user.getLastname())) return RegisterStatus.INVALID_LNAME;
        if (!validateEmail(user.getEmail())) return RegisterStatus.INVALID_EMAIL;
        if (!validateUsername(user.getUsername())) return RegisterStatus.INVALID_USERNAME;
        if (!validatePassword(user.getPassword())) return RegisterStatus.INVALID_PASSWORD;
        if (!validateConfPass(user.getPassword(), confirmedPassword)) return RegisterStatus.INVALID_CONFIRMPASS;
        return RegisterStatus.CORRECT;
    }

    private boolean validateName(String name) {//name shouldn't contain numbers and first letter should be capital
        return name.isEmpty() || !name.chars().allMatch(Character::isLetter) || !Character.isUpperCase(name.charAt(0));
    }

    private boolean validateEmail(String email) {
        String emailPattern = "^(.+)@(.+)$";
        return Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE).matcher(email).find() && !findEmail(email);
    }

    private boolean findEmail(String email) {
        return (userRepository.findEmail(email) != null);
    }

    private boolean validateUsername(String username) {
        //username too short - at least 4 chars
        return (username.length() > 3) && !findUsername(username);
    }

    private boolean findUsername(String username) {
        return (userRepository.findUsername(username) != null);
    }

    private boolean validatePassword(String password) {
        //password 8 char, must contain number
        return (password.length() > 7 && password.chars().anyMatch(Character::isDigit));
    }

    private boolean validateConfPass(String password, String confirmedPassword) {
        return (Objects.equals(password, confirmedPassword));
    }
}
