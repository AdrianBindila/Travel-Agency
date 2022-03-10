package com.assignment.service;

import com.assignment.model.Destination;

import java.util.List;

enum Status {
    NOT_BOOKED,
    IN_PROGRESS,
    BOOKED
}

public interface TravelAgencyInterface {

    void addDestination(String destinationName);

    void addPackage(Destination d, Package p);

    void editPackage(Package p);

    void deletePackage(Package p);

    void getVacationPackages(Status s);

    void deleteDestination(Destination d);

    List<Package> viewVacationPackages();

    List<Destination> viewDestinations();
}
