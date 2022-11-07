package com.example.demo1.dao;

import com.example.demo1.logging.Loggable;
import com.example.demo1.model.UserModel;
import com.example.demo1.performace.Measurable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import java.util.logging.Logger;

@Loggable
@Measurable
@RequestScoped
@Transactional
public class UserDAO {

    @Inject
    private Logger log;
    @PersistenceContext
    EntityManager entityManager;

    public void createUser(UserModel user) throws BadRequestException {
        if(getUser(user.getUserName())!=null){
            throw new BadRequestException("User already exists");
        }
        entityManager.persist(user);
    }

    public UserModel getUser(String userName){
        log.info("Searching for " + userName);
        TypedQuery<UserModel> typedQuery
                = entityManager.createQuery("SELECT u FROM UserModel u WHERE u.userName=:userName", UserModel.class);
        typedQuery.setParameter("userName", userName);
        try {
            return typedQuery.getSingleResult();
        }catch (Exception e){
            return null;
        }
    }
}
