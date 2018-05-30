package com.cosmic.restful.resources;

import com.cosmic.restful.dao.UserDao;
import com.cosmic.restful.models.ModelsFactory;
import com.cosmic.restful.models.User;
import com.cosmic.restful.services.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("users")
public class UserResource {

    @Inject
    private UserDao userDao;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postUser(User user){
        userDao.save(user);
        return Response.ok().build();
    }
}
