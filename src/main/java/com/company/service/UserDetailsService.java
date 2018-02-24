package com.company.service;

import com.company.model.UserDetails;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by dsrpc on 24.02.2018.
 */

@Service
public class UserDetailsService {

    @PersistenceContext
    private EntityManager entityManager;


    //UserDetail options
    public UserDetails save(UserDetails userDetails) {
        entityManager.persist(userDetails);
        return userDetails;
    }

    public UserDetails getByUserId(Integer userId) {
        //Query query = entityManager.createQuery("select ud from com.company.model.UserDetails ud where ud.user.id = :userId");
        Query query = entityManager.createQuery("select ud from UserDetails ud where ud.user.id = :userId");
        query.setParameter("userId", userId);

        List resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }

        return (UserDetails) resultList.get(0);
    }
}
