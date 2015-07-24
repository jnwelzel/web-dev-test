package com.jonwelzel.webdevtest.server.integration;

import com.jonwelzel.webdevtest.server.WebDevTestApplication;
import com.jonwelzel.webdevtest.server.WebDevTestConfiguration;
import com.jonwelzel.webdevtest.server.helpers.JsonHelper;
import com.jonwelzel.webdevtest.server.models.Candidate;
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
 * Created by jwelzel on 23/07/15.
 */
public class RegisterCandidateTest {

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
    public void shouldHaveCreatedAndUpdatedDateAfterRegistration() {
        final Candidate candidate = JsonHelper.readFixture("candidate_chuck_norris.json", Candidate.class);
        assertThat(candidate).isNotNull();
        assertThat(candidate.getDateCreated()).isNull();
        assertThat(candidate.getDateUpdated()).isNull();

        final Candidate newCandidate = client.target("http://localhost:" + RULE.getLocalPort() + "/candidates")
                .request()
                .post(Entity.entity(candidate, MediaType.APPLICATION_JSON_TYPE))
                .readEntity(Candidate.class);

        assertThat(newCandidate.getDateCreated()).isNotNull();
        assertThat(newCandidate.getDateUpdated()).isNotNull();
    }
}
