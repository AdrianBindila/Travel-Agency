package com.assignment.repository;

import com.assignment.model.User;
import com.assignment.model.VacationPackage;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Set;

import static com.assignment.repository.Utils.entityManagerFactory;

@Transactional
public class UserRepository {

    public void insert(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public User findLogin(String username, String password) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.
                createQuery("select u from User u where u.username like :username and u.password like :password")
                .setParameter("username", username)
                .setParameter("password", password);
        User user;
        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException e) {
            user = null;
        }
        return user;
    }

    public String findUsername(String username) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.
                createQuery("select u.username from User u where u.username like :username")
                .setParameter("username", username);
        String foundUsername;
        try {
            foundUsername = (String) query.getSingleResult();
        } catch (NoResultException e) {
            foundUsername = null;
        }
        return foundUsername;
    }

    public String findEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.
                createQuery("select u.email from User u where u.email like :email")
                .setParameter("email", email);
        String foundEmail;
        try {
            foundEmail = (String) query.getSingleResult();
        } catch (NoResultException e) {
            foundEmail = null;
        }
        return foundEmail;
    }

    public void addBooking(User u, VacationPackage p) {//TODO: fix duplicate entry
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        u.getVacationPackages().add(p);
        entityManager.merge(u);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Set<VacationPackage> getUserBookings(User u) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Set<VacationPackage> bookings = entityManager.find(User.class, u.getId()).getVacationPackages();
        entityManager.getTransaction().commit();
        entityManager.close();
        return bookings;
    }
}
