package com.assignment.service;

import com.assignment.model.Destination;
import com.assignment.model.VacationPackage;
import com.assignment.repository.DestinationRepository;
import com.assignment.repository.VacationPackageRepository;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.List;


public class TravelAgencyService implements TravelAgencyInterface {
    private final List<Destination> destinationList;
    private final List<VacationPackage> packageList;
    private final DestinationRepository destinationRepository;
    private final VacationPackageRepository vacationPackageRepository;

    public TravelAgencyService() {
        destinationRepository = new DestinationRepository();
        vacationPackageRepository = new VacationPackageRepository();
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
        vacationPackageRepository.updatePackage(p);
    }

    @Override
    public void deletePackage(VacationPackage p) {
        vacationPackageRepository.deletePackage(p);
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

    public VacationPackage makePackageFromFields(Integer id, Destination destination, String name, int price, String dateFrom, String dateTo, String details, String seats) {
        String period = dateFrom + " / " + dateTo;
        int noOfSeats = 0;
        try {
            noOfSeats = Integer.parseInt(seats);
        } catch (NumberFormatException e) {
            Alert numberError = new Alert(Alert.AlertType.ERROR, "Seats must be a number", ButtonType.OK);
            numberError.showAndWait();
        }
        return new VacationPackage(id, destination, name, price, period, details, noOfSeats);
    }

    public VacationPackage makePackageFromFields(Destination destination, String name, int price, String dateFrom, String dateTo, String details, String seats) {
        String period = dateFrom + " / " + dateTo;
        int noOfSeats = 0;
        try {
            noOfSeats = Integer.parseInt(seats);
        } catch (NumberFormatException e) {
            Alert numberError = new Alert(Alert.AlertType.ERROR, "Seats must be a number", ButtonType.OK);
            numberError.showAndWait();
        }
        return new VacationPackage(destination, name, price, period, details, noOfSeats);
    }
}
