package com.assignment.service;

public enum VacationStatus {
    NOT_BOOKED("NOT_BOOKED"),
    IN_PROGRESS("IN_PROGRESS"),
    BOOKED("BOOKED");

    public final String label;

    VacationStatus(String label) {
        this.label = label;
    }
}
