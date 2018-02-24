package com.company.repository;

import com.company.model.UserDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDetailsRepository {

    @PersistenceContext
    private EntityManager entityManager;


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

    public UserDetails searchByCity(String city){
        Query query = entityManager.createQuery("select ud From UserDetails ud.city Like :custCity");
        query.setParameter("custCity", city);
        List resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        return (UserDetails) resultList.get(0);
        //createQuery("SELECT c FROM Customer c WHERE c.name LIKE :custName").setParameter("custName", name).setMaxResults(10).getResultList();
    }

}
