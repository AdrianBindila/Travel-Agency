package com.assignment.service;

import com.assignment.model.User;
import com.assignment.model.VacationPackage;

enum Criterion {
    DESTINATION,
    PRICE,
    PERIOD
}

public interface UserInterface {

    void register(String username, String password);

    void login(User user);

    void getVacationPackages();

    void filterPackages(Criterion c);

    void bookVacation(User user, VacationPackage vp);

    void getBookedVacations(User user);
}
