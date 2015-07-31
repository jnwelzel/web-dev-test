package com.jonwelzel.webdevtest.server.core.services;

import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.api.EmailFactory;
import com.jonwelzel.webdevtest.server.api.EmailInterface;
import com.jonwelzel.webdevtest.server.api.EmailType;
import com.jonwelzel.webdevtest.server.core.concurrent.EmailThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwelzel on 22/07/15.
 */
public class EmailServiceImpl implements EmailServiceInterface {

    private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class.getName());

    @Override
    public void sendEmail(EmailInterface email) {
        log.info("Enviando email para \"" + email.getTo() + "\"...");
        new Thread(new EmailThread(email), "SendEmailThread").start();
    }

    @Override
    public void sendRegistrationEmails(Candidate candidate) {
        List<EmailType> emailTypes = getEmailTypesToSend(candidate);
        List<EmailInterface> emails = getEmailsForTypes(emailTypes, candidate.getEmail());
        for(EmailInterface email : emails) {
            sendEmail(email);
        }
    }

    @Override
    public List<EmailInterface> getEmailsForTypes(List<EmailType> emailTypes, String candidateEmail) {
        if(candidateEmail == null || candidateEmail.equals("")) {
            throw new IllegalArgumentException("O email do candidato não pode estar nulo");
        }

        List<EmailInterface> emails = new ArrayList<>();
        for(EmailType type : emailTypes) {
            EmailInterface email = EmailFactory.New(type);
            email.setTo(candidateEmail);
            emails.add(email);
        }
        return emails;
    }

    @Override
    public List<EmailType> getEmailTypesToSend(Candidate candidate) {
        if(candidate.getSkills() == null || candidate.getSkills().isEmpty()) {
            throw new IllegalArgumentException("As habilidades do candidato não podem estar nulas");
        }

        List<EmailType> types = new ArrayList<>();
        if(candidate.isFrontend()) {
            types.add(EmailType.FRONTEND);
        }
        if(candidate.isBackend()) {
            types.add(EmailType.BACKEND);
        }
        if(candidate.isMobile()) {
            types.add(EmailType.MOBILE);
        }
        if(types.isEmpty()) {
            types.add(EmailType.GENERIC);
        }
        return types;
    }

}
