package com.jonwelzel.webdevtest.server.health;

import com.codahale.metrics.health.HealthCheck;
import com.jonwelzel.webdevtest.server.core.utils.EnvVarsUtils;

/**
 * Created by jwelzel on 27/07/15.
 */
public class EnvironmentVarsCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        if (EnvVarsUtils.checkEnvVars()) {
            return Result.healthy("WEB_DEV_TEST_EMAIL_ADDR=" + System.getenv(EnvVarsUtils.EMAIL_ADDR)
                    + " WEB_DEV_TEST_EMAIL_PWD=" + System.getenv(EnvVarsUtils.EMAIL_PWD));
        } else {
            return Result.unhealthy("As variaveis de ambiente WEB_DEV_TEST_EMAIL_ADDR e "
                    + "WEB_DEV_TEST_EMAIL_PWD nao foram definidas.");
        }
    }

}
