package com.jonwelzel.webdevtest.server.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by jwelzel on 27/08/15.
 */
public class LoginDTO {

    @Email
    @NotEmpty
    @JsonProperty
    private String email;

    @NotEmpty
    @JsonProperty
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
