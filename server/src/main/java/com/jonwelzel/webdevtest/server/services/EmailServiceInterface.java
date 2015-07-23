package com.jonwelzel.webdevtest.server.services;

import com.jonwelzel.webdevtest.server.models.Candidate;
import com.jonwelzel.webdevtest.server.models.EmailInterface;

/**
 * Created by jwelzel on 21/07/15.
 */
public interface EmailServiceInterface {

    void sendEmail(EmailInterface email);
    void sendRegistrationEmails(Candidate candidate);

}
