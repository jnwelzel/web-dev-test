package com.jonwelzel.webdevtest.server.models;

/**
 * Created by jwelzel on 23/07/15.
 */
public class EmailBackend extends EmailGeneric {

    private static final String MESSAGE = "Obrigado por se candidatar, assim que tivermos uma " +
            "vaga disponível para programador Back-End entraremos em contato.";

    public EmailBackend() {
        super(MESSAGE);
    }
}
