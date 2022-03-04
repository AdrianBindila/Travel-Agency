package com.assignment.service;

public enum LoginStatus {
    CORRECT,
    EMPTY_USERNAME("Username field is empty!"),
    EMPTY_PASSWORD("Password field is empty!"),
    NOT_FOUND("Username/Password not found!");
    public final String label;

    LoginStatus() {
        this.label = "";
    }

    LoginStatus(String label) {
        this.label = label;
    }
}
