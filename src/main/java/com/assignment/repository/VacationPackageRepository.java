package com.assignment.repository;

import com.assignment.model.VacationPackage;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static com.assignment.repository.Utils.entityManagerFactory;


public class VacationPackageRepository {
    public List<VacationPackage> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<VacationPackage> vacationPackages = entityManager.
                createQuery("select v from VacationPackage v", VacationPackage.class).
                getResultList();
        if (vacationPackages != null) {
            return new ArrayList<>(vacationPackages);
        } else {
            return new ArrayList<>();
        }
    }

    public void insertPackage(VacationPackage vacationPackage) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(vacationPackage);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
