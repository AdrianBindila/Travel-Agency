package com.assignment.repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class Utils {
    public static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.Assignment1");

}
