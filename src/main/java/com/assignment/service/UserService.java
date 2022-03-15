package com.assignment.service;

import com.assignment.model.User;
import com.assignment.model.VacationPackage;
import com.assignment.repository.UserRepository;
import com.assignment.repository.VacationPackageRepository;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UserService {
    private final User user;
    VacationPackageRepository vacationPackageRepository;
    UserRepository userRepository;

    public UserService(User user) {
        this.user = user;
        userRepository=new UserRepository();
        vacationPackageRepository= new VacationPackageRepository();
    }

    public List<VacationPackage> getPackages() {
        return vacationPackageRepository.getAllAvailable();
    }

    public void addPackage(User u,VacationPackage p){
        userRepository.addBooking(u,p);
        if(p.getParticipants().size()>p.getSeats()){
            p.setStatus(VacationStatus.BOOKED.label);
        }else if(p.getParticipants().size()>0 && !Objects.equals(p.getStatus(), VacationStatus.IN_PROGRESS.label)){
            p.setStatus(VacationStatus.IN_PROGRESS.label);
        }
        vacationPackageRepository.updatePackage(p);
    }

    public Set<VacationPackage> getUserBookings(){
        return userRepository.getUserBookings(this.user);
    }
}
