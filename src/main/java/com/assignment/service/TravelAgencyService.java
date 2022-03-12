package com.assignment.service;

import com.assignment.model.Destination;
import com.assignment.model.VacationPackage;
import com.assignment.repository.DestinationRepository;
import com.assignment.repository.VacationPackageRepository;

import javax.transaction.Transactional;
import java.util.List;


public class TravelAgencyService implements TravelAgencyInterface {
    private List<Destination> destinationList;
    private List<VacationPackage> packageList;
    private DestinationRepository destinationRepository;
    private VacationPackageRepository vacationPackageRepository;

    public TravelAgencyService() {
        destinationRepository=new DestinationRepository();
        vacationPackageRepository=new VacationPackageRepository();
        this.destinationList = destinationRepository.getAll();
        this.packageList = vacationPackageRepository.getAll();
    }


    @Override
    public void addDestination(String destinationName) {
        destinationRepository.insertDestination(destinationName);
    }

    @Override
    public void addPackage(VacationPackage p) {
        vacationPackageRepository.insertPackage(p);
    }

    @Override
    public void editPackage(VacationPackage p) {

    }

    @Override
    public void deletePackage(VacationPackage p) {

    }

    @Override
    public void getVacationPackages(Status s) {

    }

    @Override
    public void deleteDestination(Destination d) {
        destinationRepository.deleteDestination(d);
    }

    @Override
    public List<VacationPackage> viewVacationPackages() {
        return vacationPackageRepository.getAll();
    }

    @Override
    public List<Destination> viewDestinations() {
        return destinationRepository.getAll();
    }
}
