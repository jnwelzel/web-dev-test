package com.jonwelzel.webdevtest.server.resources;

import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.models.Candidate;
import com.jonwelzel.webdevtest.server.services.CandidateServiceInterface;

import javax.ws.rs.*;
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
    public Candidate submitForm(Candidate candidate) {
        // curl -H "Content-Type: application/json" http://localhost:8080/candidates --data @candidate_me.json
        candidate = service.saveCandidate(candidate);
        return candidate;
    }

    @GET
    public List<Candidate> list() {
        return service.getAllCandidates();
    }

}
