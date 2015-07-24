package com.jonwelzel.webdevtest.server.services;

import com.jonwelzel.webdevtest.server.models.Candidate;

import java.util.List;

/**
 * Created by jwelzel on 22/07/15.
 */
public interface CandidateServiceInterface {

    Candidate saveCandidate(Candidate candidate);
    List<Candidate> getAllCandidates();

}
