package com.assignment.service;

import com.assignment.model.Destination;
import com.assignment.model.VacationPackage;

import java.util.List;

enum Status {
    NOT_BOOKED,
    IN_PROGRESS,
    BOOKED
}

public interface TravelAgencyInterface {

    void addDestination(String destinationName);

    void addPackage(VacationPackage p);

    void editPackage(VacationPackage p);

    void deletePackage(VacationPackage p);

    void getVacationPackages(Status s);

    void deleteDestination(Destination d);

    List<VacationPackage> viewVacationPackages();

    List<Destination> viewDestinations();
}
