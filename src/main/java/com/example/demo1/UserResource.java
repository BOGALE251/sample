package com.example.demo1;

import com.example.demo1.dao.UserDAO;
import com.example.demo1.logging.Loggable;
import com.example.demo1.model.UserModel;
import com.example.demo1.performace.Measurable;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Loggable
@Measurable
@Path("/user")
public class UserResource {

    @Inject
    private Logger logger;

    @Inject
    private UserDAO userDao;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(UserModel user ) {
        if(user.getAge() < 18){
            throw new IllegalArgumentException("Age must be greater than 18");
        }
        if(!user.getCountry().equalsIgnoreCase(Country.FRANCE.name())){
            throw new IllegalArgumentException("Country must be in france");
        }
        userDao.createUser(user);

        return Response.ok("User added !").build();
    }

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@QueryParam("userName") String userName){
        if(userName == null){
            throw new BadRequestException("userName field is empty");
        }
        UserModel user = userDao.getUser(userName);
        if(user==null){
            throw new NotFoundException();
        }
        return Response.ok(user,MediaType.APPLICATION_JSON).build();
    }


}