package com.assignment.service;

import com.assignment.model.Destination;
import com.assignment.model.User;
import com.assignment.model.VacationPackage;
import com.assignment.repository.DestinationRepository;
import com.assignment.repository.UserRepository;
import com.assignment.repository.VacationPackageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class UserService {
    private final User user;
    VacationPackageRepository vacationPackageRepository;
    UserRepository userRepository;

    public UserService(User user) {
        this.user = user;
        userRepository = new UserRepository();
        vacationPackageRepository = new VacationPackageRepository();
    }

    public List<VacationPackage> getUserPackages() {
        List<VacationPackage> userPackages = vacationPackageRepository.getAllAvailable();
        List<VacationPackage> userBookings = new ArrayList<>(getUserBookings());

        return userPackages.stream()
                .filter(vacationPackage -> userBookings.stream()
                        .noneMatch(booking -> booking.getId().equals(vacationPackage.getId())))
                .collect(Collectors.toList());
    }

    public List<VacationPackage> filterByDestination(List<VacationPackage> list, Destination destination) {
        return list.stream().filter(
                        l -> Objects.equals(l.getDestination().getName(), destination.getName()))
                .collect(Collectors.toList());
    }

    public List<VacationPackage> filterByPrice(List<VacationPackage> list, int priceLow, int priceHigh) {
        return list.stream().filter(
                l -> l.getPrice() >= priceLow && l.getPrice() <= priceHigh
        ).collect(Collectors.toList());
    }

    public List<VacationPackage> filterByPeriod(List<VacationPackage> list, String period) {
        return list.stream().filter(
                l -> Objects.equals(l.getPeriod(), period)
        ).collect(Collectors.toList());
    }

    public void addPackage(User u, VacationPackage p) {

        if (p.getParticipants().size() >= p.getSeats()) {
            p.setStatus(VacationStatus.BOOKED.label);
        } else if (p.getParticipants().size() > 0 && !Objects.equals(p.getStatus(), VacationStatus.IN_PROGRESS.label)) {
            p.setStatus(VacationStatus.IN_PROGRESS.label);
        }
        userRepository.addBooking(u, p);
//        vacationPackageRepository.updatePackage(p);
    }

    public Set<VacationPackage> getUserBookings() {
        return userRepository.getUserBookings(this.user);
    }

    public List<Destination> viewDestinations() {
        DestinationRepository destinationRepository = new DestinationRepository();
        return destinationRepository.getAll();
    }
}
