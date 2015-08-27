package com.jonwelzel.webdevtest.server.core.security;

import com.jonwelzel.webdevtest.server.api.AccountType;
import com.jonwelzel.webdevtest.server.api.Candidate;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

/**
 * Created by jwelzel on 27/08/15.
 */
public class AuthenticationContext implements SecurityContext {

    private Candidate candidate;

    public AuthenticationContext(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public Principal getUserPrincipal() {
        return candidate;
    }

    @Override
    public boolean isUserInRole(String s) {
        return candidate != null && AccountType.valueOf(s) == candidate.getAccountType();
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public String getAuthenticationScheme() {
        return null;
    }

}
