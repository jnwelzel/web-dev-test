package com.jonwelzel.webdevtest.server.models;

/**
 * Created by jwelzel on 23/07/15.
 */
public class EmailMobile extends EmailGeneric {

    private static final String MESSAGE = "Obrigado por se candidatar, assim que tivermos uma " +
            "vaga disponível para programador Mobile entraremos em contato.";

    public EmailMobile() {
        super(MESSAGE);
    }
}
