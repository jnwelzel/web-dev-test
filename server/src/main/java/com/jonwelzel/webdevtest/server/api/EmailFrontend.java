package com.jonwelzel.webdevtest.server.api;

/**
 * Created by jwelzel on 23/07/15.
 */
public class EmailFrontend extends EmailGeneric {

    private static final String MESSAGE = "Obrigado por se candidatar, assim que tivermos uma " +
            "vaga disponível para programador Front-End entraremos em contato.";

    public EmailFrontend() {
        super(MESSAGE);
    }
}
