package com.assignment.model;

import java.util.ArrayList;
import java.util.UUID;

public class Destination {//joins vacay with destination
    UUID id;
    String name;
    ArrayList<VacationPackage> vacationPackages;

    public Destination() {
    }

    public Destination(UUID id, String name, ArrayList<VacationPackage> vacationPackages) {
        this.id = id;
        this.name = name;
        this.vacationPackages = vacationPackages;
    }
}
