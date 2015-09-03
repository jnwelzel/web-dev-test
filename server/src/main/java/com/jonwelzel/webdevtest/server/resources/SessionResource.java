package com.jonwelzel.webdevtest.server.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.api.UserSession;
import com.jonwelzel.webdevtest.server.api.dtos.LoginDto;
import com.jonwelzel.webdevtest.server.api.dtos.LoginResponseDto;
import com.jonwelzel.webdevtest.server.core.security.AuthenticationContext;
import com.jonwelzel.webdevtest.server.core.services.CandidateServiceInterface;
import com.jonwelzel.webdevtest.server.core.services.SessionServiceInterface;
import com.jonwelzel.webdevtest.server.core.utils.EnvVarsUtils;
import com.jonwelzel.webdevtest.server.core.utils.JwtUtils;
import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.List;

/**
 * Created by jwelzel on 27/08/15.
 */
@Path("session")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SessionResource {

    private CandidateServiceInterface candidateService;
    private SessionServiceInterface sessionService;

    @Inject
    public SessionResource(CandidateServiceInterface candidateService, SessionServiceInterface sessionService) {
        this.candidateService = candidateService;
        this.sessionService = sessionService;
    }

    @Path("login")
    @POST
    public LoginResponseDto login(@Valid LoginDto data, @Context HttpServletRequest request) throws InvalidKeySpecException, NoSuchAlgorithmException, JsonProcessingException {
        Candidate candidate = candidateService.authenticate(data);
        sessionService.newSession(buildNewSession(candidate, request));
        final String jwt = JwtUtils.encode(EnvVarsUtils.getJwtSecret(), candidate);
        return new LoginResponseDto(candidate, jwt);
    }

    @Path("my-sessions")
    public List<UserSession> userSessions(@Context SecurityContext sc) {
        AuthenticationContext ac = (AuthenticationContext) sc;
        Candidate candidate = (Candidate) ac.getUserPrincipal();
        return sessionService.userSessions(candidate.getId());
    }

    private UserSession buildNewSession(Candidate candidate, HttpServletRequest request) {
        UserSession session = new UserSession();
        session.setId(candidate.getSessionId());
        session.setAddress(request.getRemoteAddr());
        UserAgent ua = UserAgent.parseUserAgentString(request.getHeader(HttpHeaders.USER_AGENT));
        session.setAgent(ua.getOperatingSystem() + " - " + ua.getBrowser() + " v" + ua.getBrowserVersion());
        String today = String.valueOf(new Date().getTime());
        session.setDateCreated(today);
        session.setLastAccess(today);
        session.setUserId(candidate.getId());
        return session;
    }

}
