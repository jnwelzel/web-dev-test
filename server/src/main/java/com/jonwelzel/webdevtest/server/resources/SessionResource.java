package com.jonwelzel.webdevtest.server.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.api.UserSession;
import com.jonwelzel.webdevtest.server.api.dtos.LoginDto;
import com.jonwelzel.webdevtest.server.api.dtos.LoginResponseDto;
import com.jonwelzel.webdevtest.server.core.services.CandidateServiceInterface;
import com.jonwelzel.webdevtest.server.core.services.SessionServiceInterface;
import com.jonwelzel.webdevtest.server.core.utils.EnvVarsUtils;
import com.jonwelzel.webdevtest.server.core.utils.JwtUtils;
import eu.bitwalker.useragentutils.UserAgent;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
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
    @GET
    @RolesAllowed({"USER", "ADMIN"})
    public List<UserSession> userSessions(@Context SecurityContext sc) {
        Candidate candidate = (Candidate) sc.getUserPrincipal();

        return sessionService.userSessions(candidate.getId());
    }

    @DELETE
    @RolesAllowed({"USER", "ADMIN"})
    public Response logout() {
        return null;
    }

    private UserSession buildNewSession(Candidate candidate, HttpServletRequest request) {
        UserSession session = new UserSession();
        String today = String.valueOf(new Date().getTime());

        session.setId(candidate.getSessionId());
        session.setAddress(request.getRemoteAddr());
        session.setAgent(formatUserAgent(request.getHeader(HttpHeaders.USER_AGENT)));
        session.setDateCreated(today);
        session.setLastAccess(today);
        session.setUserId(candidate.getId());

        return session;
    }

    private String formatUserAgent(String ua) {
        UserAgent agent = UserAgent.parseUserAgentString(ua);

        return agent.getOperatingSystem() + " - " + agent.getBrowser() + " v" + agent.getBrowserVersion();
    }

}
