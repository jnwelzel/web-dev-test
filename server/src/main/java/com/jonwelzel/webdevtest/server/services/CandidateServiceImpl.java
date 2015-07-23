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
}
