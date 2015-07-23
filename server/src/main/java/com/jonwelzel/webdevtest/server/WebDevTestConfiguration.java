package com.jonwelzel.webdevtest.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.inject.Singleton;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by jwelzel on 21/07/15.
 */
@Singleton
public class WebDevTestConfiguration extends Configuration {

    @NotEmpty
    @JsonProperty
    private String emailAddress;

    @NotEmpty
    @JsonProperty
    private String emailPassword;

    @JsonProperty
    public String getEmailAddress() {
        return emailAddress;
    }

    @JsonProperty
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @JsonProperty
    public String getEmailPassword() {
        return emailPassword;
    }

    @JsonProperty
    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }
}
