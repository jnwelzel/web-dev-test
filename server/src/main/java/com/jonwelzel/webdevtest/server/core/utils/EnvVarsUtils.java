package com.jonwelzel.webdevtest.server.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jwelzel on 23/07/15.
 */
public class EnvVarsUtils {

    public static final String EMAIL_ADDR = "WEB_DEV_TEST_EMAIL_ADDR";
    public static final String EMAIL_PWD = "WEB_DEV_TEST_EMAIL_PWD";
    public static final String JWT_SECRET = "WEB_DEV_TEST_JWT_SECRET";

    private static final Logger log = LoggerFactory.getLogger(EnvVarsUtils.class.getName());

    public static boolean checkEnvVars() {
        String gmailAccountName = System.getenv(EMAIL_ADDR);
        String gmailAccountPwd = System.getenv(EMAIL_PWD);
        String jwtSecret = System.getenv(JWT_SECRET);
        if(gmailAccountName == null || gmailAccountName.equals("")
                || gmailAccountPwd == null || gmailAccountPwd.equals("")
                || jwtSecret == null || jwtSecret.equals("")) {
            String errMsg = "As variáveis de ambiente \"" + EMAIL_ADDR +"\", " +
                    "\"" + EMAIL_PWD + "\" e \"" + JWT_SECRET + "\" devem ser definidas";
            throw new IllegalArgumentException(errMsg);
        }
        log.info("Env vars health is good");
        return true;
    }

    public static String getEmailAccountName() {
        return System.getenv(EMAIL_ADDR);
    }

    public static String getEmailAccountPwd() {
        return System.getenv(EMAIL_PWD);
    }

    public static String getJwtSecret() {
        return System.getenv(JWT_SECRET);
    }

}
