package com.jonwelzel.webdevtest.server.api;

/**
 * Created by jwelzel on 23/07/15.
 */
public interface EmailInterface {

    String getSubject();
    String getMessage();
    String getTo();
    void setTo(String to);

}
