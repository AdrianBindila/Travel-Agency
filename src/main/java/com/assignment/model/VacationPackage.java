package com.assignment.model;

import java.util.UUID;

public class VacationPackage {
    UUID id;
    String name;
    String price;
    String period;
    String details;
    String status;
    int seatsAvailable;

    public VacationPackage() {
    }

    public VacationPackage(UUID id, String name, String price, String period, String details, String status, int seatsAvailable) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.period = period;
        this.details = details;
        this.status = status;
        this.seatsAvailable = seatsAvailable;
    }
}
