package com.jonwelzel.webdevtest.server.api;

import java.util.Hashtable;

/**
 * Created by jwelzel on 23/07/15.
 */
public class EmailFactory {

    private static Hashtable<EmailType, EmailInterface> emailTypes;

    static {
        emailTypes = new Hashtable<>();
        emailTypes.put(EmailType.BACKEND, new EmailBackend());
        emailTypes.put(EmailType.FRONTEND, new EmailFrontend());
        emailTypes.put(EmailType.MOBILE, new EmailMobile());
        emailTypes.put(EmailType.GENERIC, new EmailGeneric());
    }

    public static EmailInterface New(EmailType type) {
        if(!emailTypes.containsKey(type)) {
            throw new IllegalArgumentException("Invalid email type");
        }
        return emailTypes.get(type);
    }

}
