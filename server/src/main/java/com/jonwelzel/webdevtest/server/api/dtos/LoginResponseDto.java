package com.jonwelzel.webdevtest.server.api.dtos;

import com.jonwelzel.webdevtest.server.api.Candidate;

/**
 * Created by jwelzel on 31/08/15.
 */
public class LoginResponseDto {

    private Candidate candidate;
    private String sessionId;
    private String jwt;

    public LoginResponseDto() {
    }

    public LoginResponseDto(Candidate candidate, String sessionId, String jwt) {
        this.candidate = candidate;
        this.sessionId = sessionId;
        this.jwt = jwt;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
