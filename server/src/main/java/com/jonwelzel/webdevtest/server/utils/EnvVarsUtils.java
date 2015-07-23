package com.jonwelzel.webdevtest.server.utils;

/**
 * Created by jwelzel on 23/07/15.
 */
public class EnvVarsUtils {

    private static final String EMAIL_ADDR = "WEB_DEV_TEST_EMAIL_ADDR";
    private static final String EMAIL_PWD = "WEB_DEV_TEST_EMAIL_PWD";

    public static void checkEnvVars() {
        String gmailAccountName = System.getenv(EMAIL_ADDR);
        String gmailAccountPwd = System.getenv(EMAIL_PWD);
        if(gmailAccountName == null || gmailAccountName.equals("")
                || gmailAccountPwd == null || gmailAccountPwd.equals("")) {
            throw new IllegalArgumentException("As variáveis de ambiente \"" + EMAIL_ADDR +"\" e " +
                    "\"" + EMAIL_PWD + "\" devem ser definidas");
        }
    }

    public static String getEmailAccountName() {
        return System.getenv(EMAIL_ADDR);
    }

    public static String getEmailAccountPwd() {
        return System.getenv(EMAIL_PWD);
    }

}
