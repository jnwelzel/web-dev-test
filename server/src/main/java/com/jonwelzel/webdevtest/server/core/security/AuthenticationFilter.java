package com.jonwelzel.webdevtest.server.core.security;

import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.api.UserSession;
import com.jonwelzel.webdevtest.server.core.services.SessionServiceInterface;
import com.jonwelzel.webdevtest.server.core.utils.EnvVarsUtils;
import com.jonwelzel.webdevtest.server.core.utils.JwtUtils;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

/**
 * Created by jwelzel on 27/08/15.
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    final SessionServiceInterface sessionService;

    @Inject
    public AuthenticationFilter(SessionServiceInterface sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public void filter(ContainerRequestContext requestContext) {
        Candidate principal = new Candidate();

        if(requestContext.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)
                && !requestContext.getUriInfo().getPath().startsWith("session/login")) {
            Candidate jwtPrincipal = JwtUtils.decode(EnvVarsUtils.getJwtSecret(), requestContext
                    .getHeaderString(HttpHeaders.AUTHORIZATION).split(" ")[1]);
            UserSession userSession = sessionService.findById(jwtPrincipal.getId(), jwtPrincipal.getSessionId());
            if(jwtPrincipal != null && userSession != null) {
                sessionService.updateSession(userSession);
                principal = jwtPrincipal;
            }
        }

        requestContext.setSecurityContext(new AuthenticationContext(principal));
    }

}
