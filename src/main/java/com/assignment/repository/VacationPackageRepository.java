package com.assignment.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static com.assignment.repository.Utils.entityManagerFactory;

@Transactional
public class VacationPackageRepository {
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    //remember to close the transaction after the query
}
