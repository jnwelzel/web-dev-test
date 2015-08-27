package com.jonwelzel.webdevtest.server.core.security;

import com.google.inject.Singleton;
import com.jonwelzel.webdevtest.server.api.Candidate;
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
@Singleton
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {
        Candidate principal = new Candidate();

        if(requestContext.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)
                && !requestContext.getUriInfo().getPath().startsWith("session/login")) {
            Candidate jwtPrincipal = JwtUtils.decode(EnvVarsUtils.getJwtSecret(), requestContext
                    .getHeaderString(HttpHeaders.AUTHORIZATION).split(" ")[1]);
            if(jwtPrincipal != null) {
                principal = jwtPrincipal;
            }
        }

        requestContext.setSecurityContext(new AuthenticationContext(principal));
    }

}
