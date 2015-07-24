package com.jonwelzel.webdevtest.server.services;

import com.jonwelzel.webdevtest.server.models.Candidate;
import com.jonwelzel.webdevtest.server.models.EmailInterface;
import com.jonwelzel.webdevtest.server.models.EmailType;
import com.jonwelzel.webdevtest.server.models.Skill;

import java.util.List;

/**
 * Created by jwelzel on 21/07/15.
 */
public interface EmailServiceInterface {

    void sendEmail(EmailInterface email);
    void sendRegistrationEmails(Candidate candidate);
    List<EmailInterface> getEmailsForTypes(List<EmailType> emailTypes, String candidateEmail);
    List<EmailType> getEmailTypesToSend(Candidate candidate);
    Integer calculateGroupScore(List<Skill> skills);

}
