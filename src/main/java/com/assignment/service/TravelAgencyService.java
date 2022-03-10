package com.assignment.service;

import com.assignment.model.Destination;
import com.assignment.repository.DestinationRepository;
import com.assignment.repository.VacationPackageRepository;

import java.util.List;

public class TravelAgencyService implements TravelAgencyInterface {
    private List<Destination> destinationList;
    private List<Package> packageList;
    private DestinationRepository destinationRepository;
    private VacationPackageRepository vacationPackageRepository;

    public TravelAgencyService() {
        this.destinationList = destinationRepository.getAll();
        this.packageList = vacationPackageRepository.getAll();
    }

    @Override
    public void addDestination(String destinationName) {
        destinationRepository.insertDestination(new Destination(destinationName));
    }

    @Override
    public void addPackage(Destination d, Package p) {

    }

    @Override
    public void editPackage(Package p) {

    }

    @Override
    public void deletePackage(Package p) {

    }

    @Override
    public void getVacationPackages(Status s) {

    }

    @Override
    public void deleteDestination(Destination d) {

    }

    @Override
    public List<Package> viewVacationPackages() {
        return null;
    }

    @Override
    public List<Destination> viewDestinations() {
        return null;
    }
}
