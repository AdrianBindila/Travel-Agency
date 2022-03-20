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

    public List<VacationPackage> getAllAvailable() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<VacationPackage> vacationPackages = entityManager.
                createQuery("select v from VacationPackage v where v.status not like 'BOOKED'", VacationPackage.class).
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
        entityManager.merge(vacationPackage);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deletePackage(VacationPackage p) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(VacationPackage.class, p.getId()));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updatePackage(VacationPackage p) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(p);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
