package com.assignment.service;

import com.assignment.model.User;
import com.assignment.model.VacationPackage;


public interface UserServiceInterface {
    enum Criterion {
        DESTINATION,
        PRICE,
        PERIOD
    }
    void register(String username, String password);

    void login(User user);

    void getVacationPackages();

    void filterPackages(Criterion c);

    void bookVacation(User user, VacationPackage vp);

    void getBookedVacations(User user);
}
