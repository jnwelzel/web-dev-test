package com.jonwelzel.webdevtest.server.core.exceptions.web;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Created by jwelzel on 28/08/15.
 */
public class NotFoundByEmailException extends WebApplicationException {

    private String email;

    public NotFoundByEmailException(String email) {
        super("Nenhum registro com o email \"" + email + "\" foi encontrado", Response.Status.NOT_FOUND);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
