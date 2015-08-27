package com.jonwelzel.webdevtest.server.resources;

import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.api.dtos.LoginDTO;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Created by jwelzel on 27/08/15.
 */
@Path("session")
public class SessionResource {

    @Path("login")
    @POST
    public Candidate login(@Valid LoginDTO data) {
        return null;
    }

}
