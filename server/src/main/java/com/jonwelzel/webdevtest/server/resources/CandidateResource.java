package com.jonwelzel.webdevtest.server.resources;

import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.core.services.CandidateServiceInterface;
import redis.clients.jedis.JedisPool;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by jwelzel on 22/07/15.
 */
@Path("candidates")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CandidateResource {

    private CandidateServiceInterface service;

    @Inject
    public CandidateResource(CandidateServiceInterface service) {
        this.service = service;
    }

    @POST
    public Candidate submitForm(@Valid Candidate candidate) {
        // curl -H "Content-Type: application/json" http://localhost:8080/candidates --data @candidate_me.json
        candidate = service.saveCandidate(candidate);
        return candidate;
    }

    @GET
    @RolesAllowed("ADMIN")
    @Path("list-unmasked")
    public List<Candidate> list() {
        return service.getAllCandidates();
    }

    @GET
    public List<Candidate> listMasked(@Context JedisPool jedis) {
        jedis.getResource().hget("test", "foo");
        return service.getAllCandidatesMasked();
    }

}
