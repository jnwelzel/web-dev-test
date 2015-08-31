package com.jonwelzel.webdevtest.server.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.api.dtos.LoginDto;
import com.jonwelzel.webdevtest.server.api.dtos.LoginResponseDto;
import com.jonwelzel.webdevtest.server.core.security.PasswordHash;
import com.jonwelzel.webdevtest.server.core.services.CandidateServiceInterface;
import com.jonwelzel.webdevtest.server.core.utils.EnvVarsUtils;
import com.jonwelzel.webdevtest.server.core.utils.JwtUtils;
import redis.clients.jedis.JedisPool;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by jwelzel on 27/08/15.
 */
@Path("session")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SessionResource {

    private CandidateServiceInterface candidateService;

    @Inject
    public SessionResource(CandidateServiceInterface candidateService) {
        this.candidateService = candidateService;
    }

    @Path("login")
    @POST
    public LoginResponseDto login(@Valid LoginDto data, @Context JedisPool jedis) throws InvalidKeySpecException, NoSuchAlgorithmException, JsonProcessingException {
        jedis.getResource().hset("test", "foo", "bar");
        final Candidate candidate = candidateService.authenticate(data);
        final String jwt = JwtUtils.encode(EnvVarsUtils.getJwtSecret(), candidate);
        final String sessionId = PasswordHash.createSimpleHash();
        return new LoginResponseDto(candidate, sessionId, jwt);
    }

}
