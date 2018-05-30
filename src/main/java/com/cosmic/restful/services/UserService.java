package com.cosmic.restful.services;

import com.cosmic.restful.dao.UserDao;
import com.cosmic.restful.models.ModelsFactory;
import com.cosmic.restful.models.User;

import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;


public class UserService {



    private UserDao userDao;


    public Response createUser(){
        User user1 = ModelsFactory.createUser();
        user1.setEmail("test@gmail.com");
        user1.setPassword("culo");
        System.out.println(user1.getUuid());
        userDao.save(user1);
        return Response.ok().build();
    }
}
