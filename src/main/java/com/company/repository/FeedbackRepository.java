package com.company.repository;

import com.company.model.Feedback;
import com.company.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by dsrpc on 27.02.2018.
 */

@Repository
public class FeedbackRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Feedback save(Feedback feedback){
        entityManager.persist(feedback);
        return feedback;
    }
    public Feedback update(Feedback feedback){
        entityManager.merge(feedback);
        return feedback;
    }
    public Feedback findById(Integer id){
        return entityManager.find(Feedback.class, id);
    }
    public Feedback findByObject(Feedback feedback){
        return entityManager.find(Feedback.class, feedback.getId());
    }
    public List<Feedback> findAll(){
        return entityManager.createQuery("from Feedback").getResultList();
    }
    public List<Feedback> findByUser(User user){
        List feed = entityManager.createQuery("from User u where u.user = :fUser").setParameter("fUser", user).getResultList();
        if (!feed.isEmpty()){
            return (List<Feedback>) feed.get(0);
        }
        return null;
    }
}
