package com.jonwelzel.webdevtest.server.core.security;

import com.google.inject.Singleton;
import com.jonwelzel.webdevtest.server.api.Candidate;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by jwelzel on 27/08/15.
 */
@Singleton
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if(requestContext.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {

        } else {
            requestContext.setSecurityContext(new AuthenticationContext(new Candidate()));
        }
    }

}
