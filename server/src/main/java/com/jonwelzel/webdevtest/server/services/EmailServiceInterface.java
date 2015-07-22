package com.jonwelzel.webdevtest.server.services;

/**
 * Created by jwelzel on 21/07/15.
 */
public interface EmailServiceInterface {

    void sendEmail(String from, String to, String title, String message);

}
