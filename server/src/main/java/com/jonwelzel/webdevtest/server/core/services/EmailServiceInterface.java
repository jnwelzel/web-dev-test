package com.jonwelzel.webdevtest.server.core.services;

import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.api.EmailInterface;
import com.jonwelzel.webdevtest.server.api.EmailType;
import com.jonwelzel.webdevtest.server.api.Skill;

import java.util.List;

/**
 * Created by jwelzel on 21/07/15.
 */
public interface EmailServiceInterface {

    void sendEmail(EmailInterface email);
    void sendRegistrationEmails(Candidate candidate);
    List<EmailInterface> getEmailsForTypes(List<EmailType> emailTypes, String candidateEmail);
    List<EmailType> getEmailTypesToSend(Candidate candidate);

}
