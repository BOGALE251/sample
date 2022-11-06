package com.example.demo1.dao;

import com.example.demo1.logging.Loggable;
import com.example.demo1.model.UserModel;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Loggable
@RequestScoped
public class UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    public void createUser(UserModel user){
        entityManager.persist(user);
    }

    public UserModel getUser(String userName){
        TypedQuery<UserModel> typedQuery
                = entityManager.createQuery("SELECT u FROM UserModel u WHERE u.userName=:userName", UserModel.class);
        typedQuery.setParameter("userName", userName);
        return typedQuery.getSingleResult();
    }
}
