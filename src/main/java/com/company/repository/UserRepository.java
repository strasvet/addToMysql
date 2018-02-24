package com.company.repository;

import com.company.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public User save(User user) {
        entityManager.persist(user);

        return user;
    }

    public User findById(Integer id) {
        return entityManager.find(User.class, id);
    }

    public User update(User user) {

        return entityManager.merge(user);
    }

    public List<User> findAll() {
        return entityManager.createQuery("from User u").getResultList();
    }

    public void deleteUser(User user) {
        entityManager.remove(user);
    }
}
