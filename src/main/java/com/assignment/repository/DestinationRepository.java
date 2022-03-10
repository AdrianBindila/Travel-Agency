package com.assignment.repository;

import com.assignment.model.Destination;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static com.assignment.repository.Utils.entityManagerFactory;

@Transactional
public class DestinationRepository {
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void insertDestination(Destination destination) {
        entityManager.persist(destination);
        entityManager.getTransaction().commit();
    }

    public Destination find(String name) {
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
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Destination> criteriaQuery = cb.createQuery(Destination.class);
//        Root<Destination> root = criteriaQuery.from(Destination.class);
//        criteriaQuery.select(root);
        List<Destination> destinationList=entityManager.
                createQuery("select d from Destination d", Destination.class).
                getResultList();
        if(destinationList!=null){
            return new ArrayList<>(destinationList);
        }
        else {
            return new ArrayList<>();
        }
    }
}
