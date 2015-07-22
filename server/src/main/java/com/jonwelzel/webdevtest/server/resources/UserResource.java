package com.jonwelzel.webdevtest.server.resources;

import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.models.User;
import com.jonwelzel.webdevtest.server.services.UserServiceInterface;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by jwelzel on 22/07/15.
 */
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserServiceInterface service;

    @Inject
    public UserResource(UserServiceInterface service) {
        this.service = service;
    }

    @GET
    @Path("{email}")
    public User getUserByEmail(@PathParam("email") String email) {
        return service.getUserByEmail(email);
    }

    @POST
    public User save(User user) {
        service.saveUser(user);
        return user;
    }

}
