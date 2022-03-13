package com.assignment.service;

import com.assignment.model.Destination;
import com.assignment.model.VacationPackage;

import java.util.List;


public interface TravelAgencyInterface {

    void addDestination(String destinationName);

    void addPackage(VacationPackage p);

    void editPackage(VacationPackage p);

    void deletePackage(VacationPackage p);

    void deleteDestination(Destination d);

    List<VacationPackage> viewVacationPackages();

    List<Destination> viewDestinations();
}
