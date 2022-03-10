package com.assignment.repository;

import com.assignment.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import static com.assignment.repository.Utils.entityManagerFactory;

@Transactional
public class UserRepository {
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void insert(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public User findLogin(String username, String password) {
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
}
