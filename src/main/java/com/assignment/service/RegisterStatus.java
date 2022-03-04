package com.assignment.service;

public enum RegisterStatus {
    CORRECT,
    INVALID_FNAME("Invalid first name!"),
    INVALID_LNAME("Invalid last name!"),
    INVALID_EMAIL("Invalid email!"),
    INVALID_USERNAME("Invalid username!"),
    INVALID_PASSWORD("Invalid password!"),
    INVALID_CONFIRMPASS("Passwords do not match!");

    public final String label;

    RegisterStatus() {
        this.label = "";
    }

    RegisterStatus(String label) {
        this.label = label;
    }
}
