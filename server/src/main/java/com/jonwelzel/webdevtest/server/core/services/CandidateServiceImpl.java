package com.jonwelzel.webdevtest.server.core.services;

import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.core.di.binding.MockDao;
import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.jdbi.daos.CandidateDaoInterface;

import java.util.List;

/**
 * Created by jwelzel on 22/07/15.
 */
public class CandidateServiceImpl implements CandidateServiceInterface {

    private CandidateDaoInterface dao;
    private EmailServiceInterface emailService;

    @Inject
    public CandidateServiceImpl(@MockDao CandidateDaoInterface dao, EmailServiceInterface emailService) {
        this.dao = dao;
        this.emailService = emailService;
    }

    @Override
    public Candidate saveCandidate(Candidate candidate) {
        candidate = dao.save(candidate);
        emailService.sendRegistrationEmails(candidate);
        return candidate;
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return dao.findAll();
    }
}
