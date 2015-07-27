package com.jonwelzel.webdevtest.server.api;

/**
 * Created by jwelzel on 23/07/15.
 */
public class EmailGeneric implements EmailInterface {

    private String subject = "Obrigado por se candidatar";
    private String message = "Obrigado por se candidatar, assim que tivermos uma vaga " +
            "disponível para programador entraremos em contato.";
    private String to;

    public EmailGeneric(String to, String subject, String message) {
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    public EmailGeneric(String message) {
        this.message = message;
    }

    public EmailGeneric() {
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public void setTo(String to) {
        this.to = to;
    }
}
