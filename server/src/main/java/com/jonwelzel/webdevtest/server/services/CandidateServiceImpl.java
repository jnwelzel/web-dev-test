package com.jonwelzel.webdevtest.server.services;

import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.di.binding.MockDao;
import com.jonwelzel.webdevtest.server.models.Candidate;
import com.jonwelzel.webdevtest.server.persistence.daos.CandidateDaoInterface;

/**
 * Created by jwelzel on 22/07/15.
 */
public class CandidateServiceImpl implements CandidateServiceInterface {

    private CandidateDaoInterface dao;

    @Inject
    public CandidateServiceImpl(@MockDao CandidateDaoInterface dao) {
        this.dao = dao;
    }

    @Override
    public Candidate saveCandidate(Candidate candidate) {
        // TODO se salvou mandar os emails
        return dao.save(candidate);
    }
}
