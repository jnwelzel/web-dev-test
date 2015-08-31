package com.jonwelzel.webdevtest.server.integration;

import com.jonwelzel.webdevtest.server.WebDevTestApplication;
import com.jonwelzel.webdevtest.server.WebDevTestConfiguration;
import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.api.dtos.LoginDto;
import com.jonwelzel.webdevtest.server.api.dtos.LoginResponseDto;
import com.jonwelzel.webdevtest.server.helpers.JsonHelper;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jwelzel on 28/08/15.
 */
public class SessionResourceTest {

    private Client client;

    @ClassRule
    public static final DropwizardAppRule<WebDevTestConfiguration> RULE =
            new DropwizardAppRule<>(WebDevTestApplication.class, null);

    @Before
    public void setUp() throws Exception {
        client = ClientBuilder.newClient();
    }

    @After
    public void tearDown() throws Exception {
        client.close();
    }

    @Test
    public void shouldLoginAdmin() {
        final Candidate admin = JsonHelper.readFixture("admin.json", Candidate.class);
        LoginDto loginDto = new LoginDto("admin@admin.com", "Password@123");

        assertThat(admin).isNotNull();

        final LoginResponseDto loginResponse = client.target("http://localhost:" + RULE.getLocalPort() + "/session/login")
                .request()
                .post(Entity.entity(loginDto, MediaType.APPLICATION_JSON_TYPE))
                .readEntity(LoginResponseDto.class);

        assertThat(loginResponse).isNotNull();
        assertThat(loginResponse.getCandidate().getName()).isEqualTo(admin.getName());
        assertThat(loginResponse.getJwt()).isNotNull();
    }

    @Test
    public void shouldNotLoginAdminWithInvalidPassword() {
        LoginDto loginDto = new LoginDto("admin@admin.com", "Password@123!");

        final Integer status = client.target("http://localhost:" + RULE.getLocalPort() + "/session/login")
                .request()
                .post(Entity.entity(loginDto, MediaType.APPLICATION_JSON_TYPE))
                .getStatus();

        assertThat(status).isNotNull();
        assertThat(status).isEqualTo(403);
    }

}
