package com.assignment.repository;

import com.assignment.model.Destination;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.assignment.repository.Utils.entityManagerFactory;

public class DestinationRepository {


    public void insertDestination(String destinationName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new Destination(destinationName));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Destination find(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.
                createQuery("select d from Destination d where d.name like :name")
                .setParameter("name", name);
        Destination foundDestination;
        try {
            foundDestination = (Destination) query.getSingleResult();
        } catch (NoResultException e) {
            foundDestination = null;
        }
        return foundDestination;
    }

    public ArrayList<Destination> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Destination> destinationList = entityManager.
                createQuery("select d from Destination d", Destination.class).
                getResultList();
        if (destinationList != null) {
            return new ArrayList<>(destinationList);
        } else {
            return new ArrayList<>();
        }
    }

    public void deleteDestination(Destination d) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Destination.class, d.getId()));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
