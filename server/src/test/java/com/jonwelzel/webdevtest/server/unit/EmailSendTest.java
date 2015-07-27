package com.jonwelzel.webdevtest.server.unit;

import com.jonwelzel.webdevtest.server.core.concurrent.EmailThread;
import com.jonwelzel.webdevtest.server.api.EmailFrontend;
import com.jonwelzel.webdevtest.server.api.EmailInterface;
import com.jonwelzel.webdevtest.server.core.utils.EnvVarsUtils;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jwelzel on 23/07/15.
 * WARNING: DO NOT TRY TO RUN THIS FROM INSIDE AN IDE, USE THE TERMINAL
 */
public class EmailSendTest {

    private EmailInterface email;

    @Before
    public void setUp() {
        email = new EmailFrontend();
    }

    @Test
    public void shouldHaveEnvironmentVars() {
        String accName = System.getenv(EnvVarsUtils.EMAIL_ADDR);
        String accPwd = System.getenv(EnvVarsUtils.EMAIL_PWD);
        assertThat(accName).isNotNull();
        assertThat(accPwd).isNotNull();
    }

    @Test
    public void shouldSendEmail() {
        email.setTo(System.getenv(EnvVarsUtils.EMAIL_ADDR) + "@gmail.com"); // Send email to yourself
        new EmailThread(email).run(); // Force to run synchronously
    }

}
