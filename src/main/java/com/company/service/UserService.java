package com.company.service;

import com.company.model.User;
import com.company.model.UserDetails;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class UserService {

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
