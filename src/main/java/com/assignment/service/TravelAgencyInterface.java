package com.assignment.service;

import com.assignment.model.Destination;
enum Status{
    NOT_BOOKED,
    IN_PROGRESS,
    BOOKED
}
public interface TravelAgencyInterface {
    void addDestination(Destination d);
    void addPackage(Destination d, Package p);
    void editPackage(Package p);
    void deletePackage(Package p);
    void getVacationPackages(Status s);
    void deleteDestination(Destination d);
}
