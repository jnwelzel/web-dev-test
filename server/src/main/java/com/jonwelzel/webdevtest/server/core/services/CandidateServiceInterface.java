package com.jonwelzel.webdevtest.server.core.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.api.dtos.LoginDTO;
import com.jonwelzel.webdevtest.server.core.exceptions.web.InvalidPasswordException;
import com.jonwelzel.webdevtest.server.core.exceptions.web.NotFoundByEmailException;

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
    Candidate authenticate(LoginDTO data) throws InvalidKeySpecException, NoSuchAlgorithmException, JsonProcessingException;

}
