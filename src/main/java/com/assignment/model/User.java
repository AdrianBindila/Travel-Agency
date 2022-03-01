package com.assignment.model;

import java.util.ArrayList;
import java.util.UUID;

public class User {
    UUID id;
    String email;
    String username;
    String password;
    String firstName;
    String lastname;
    ArrayList<VacationPackage> bookings;

    public User() {
    }

    public User(UUID id, String email, String username, String password, String firstName, String lastname, ArrayList<VacationPackage> bookings) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
        this.bookings = bookings;
    }
}
