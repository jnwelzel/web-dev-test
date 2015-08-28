package com.jonwelzel.webdevtest.server.core.exceptions.web;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Created by jwelzel on 28/08/15.
 */
public class InvalidPasswordException extends WebApplicationException {

    public InvalidPasswordException() {
        super("A senha informada não é válida", Response.Status.FORBIDDEN);
    }
}
