package com.jonwelzel.webdevtest.server.core.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.api.dtos.LoginDTO;
import com.jonwelzel.webdevtest.server.core.di.binding.MockDao;
import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.core.exceptions.web.InvalidPasswordException;
import com.jonwelzel.webdevtest.server.core.exceptions.web.NotFoundByEmailException;
import com.jonwelzel.webdevtest.server.core.security.PasswordHash;
import com.jonwelzel.webdevtest.server.core.utils.EnvVarsUtils;
import com.jonwelzel.webdevtest.server.core.utils.JwtUtils;
import com.jonwelzel.webdevtest.server.core.utils.StringUtils;
import com.jonwelzel.webdevtest.server.jdbi.daos.CandidateDaoInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * Created by jwelzel on 22/07/15.
 */
public class CandidateServiceImpl implements CandidateServiceInterface {

    private CandidateDaoInterface dao;
    private EmailServiceInterface emailService;
    private static final Logger log = LoggerFactory.getLogger(CandidateServiceImpl.class.getName());

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

    @Override
    public List<Candidate> getAllCandidatesMasked() {
        List<Candidate> all = dao.findAll();
        for(Candidate c : all) {
            c.setName(StringUtils.maskName(c.getName()));
            c.setEmail(StringUtils.maskEmail(c.getEmail()));
        }
        return all;
    }

    @Override
    public Candidate authenticate(LoginDTO data) throws InvalidKeySpecException, NoSuchAlgorithmException, JsonProcessingException {
        Candidate candidate = dao.findByEmail(data.getEmail());
        if (candidate == null)
            throw new NotFoundByEmailException(data.getEmail());

        boolean valid = PasswordHash.validatePassword(data.getPassword(), candidate.getPasswordHash());
        if(!valid)
            throw new InvalidPasswordException();

        candidate.setToken(JwtUtils.encode(EnvVarsUtils.getJwtSecret(), candidate));
        return candidate;
    }

}
