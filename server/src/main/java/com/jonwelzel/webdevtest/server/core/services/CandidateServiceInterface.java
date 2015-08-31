package com.jonwelzel.webdevtest.server.core.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.api.dtos.LoginDto;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * Created by jwelzel on 22/07/15.
 */
public interface CandidateServiceInterface {

    Candidate saveCandidate(Candidate candidate);
    List<Candidate> getAllCandidates();
    List<Candidate> getAllCandidatesMasked();
    Candidate authenticate(LoginDto data) throws InvalidKeySpecException, NoSuchAlgorithmException, JsonProcessingException;

}
