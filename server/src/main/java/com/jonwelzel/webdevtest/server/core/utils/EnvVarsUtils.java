package com.jonwelzel.webdevtest.server.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jwelzel on 23/07/15.
 */
public class EnvVarsUtils {

    public static final String EMAIL_ADDR = "WEB_DEV_TEST_EMAIL_ADDR";
    public static final String EMAIL_PWD = "WEB_DEV_TEST_EMAIL_PWD";

    private static final Logger log = LoggerFactory.getLogger(EnvVarsUtils.class.getName());

    public static boolean checkEnvVars() {
        String gmailAccountName = System.getenv(EMAIL_ADDR);
        String gmailAccountPwd = System.getenv(EMAIL_PWD);
        if(gmailAccountName == null || gmailAccountName.equals("")
                || gmailAccountPwd == null || gmailAccountPwd.equals("")) {
            String errMsg = "As variáveis de ambiente \"" + EMAIL_ADDR +"\" e " +
                    "\"" + EMAIL_PWD + "\" devem ser definidas";
            throw new IllegalArgumentException(errMsg);
        }

        return true;
    }

    public static String getEmailAccountName() {
        return System.getenv(EMAIL_ADDR);
    }

    public static String getEmailAccountPwd() {
        return System.getenv(EMAIL_PWD);
    }

}
