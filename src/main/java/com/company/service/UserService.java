package com.company.service;

import com.company.model.User;
import com.company.model.UserDetails;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
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
  /*      Query query = entityManager.createQuery("select ud from UserDetails ud where ud.user.id = :userId");
        query.setParameter("userId", userId);

        List resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
*/
/*
        StringBuilder stroka = new StringBuilder();
        Query query = entityManager.createQuery("select u, d from User u ,UserDetails d where d.id=u.id");
        //List result = query.getResultList();

        stroka.append(query.getResultList());
        List result = new ArrayList<>();
        result.add(stroka.toString());
        return result;*/
        return entityManager.createQuery("from User u").getResultList();
    }
    public List findAllAndInfo(){
        Query query = entityManager.createQuery("select u, d from User u ,UserDetails d where d.id=u.id");
       /* List resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }

        return (UserDetails) resultList.get(0);
*/
        //return query.getResultList().get(0);
        StringBuilder stroka = new StringBuilder();
        stroka.append(query.getResultList());
        List result = new ArrayList<>();
        result.add(stroka.toString());
        return result;
    }

    public void deleteUser(User user) {
        entityManager.remove(user);
    }



}
