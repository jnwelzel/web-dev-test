package com.jonwelzel.webdevtest.server.unit;

import com.jonwelzel.webdevtest.server.helpers.JsonHelper;
import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.api.EmailType;
import com.jonwelzel.webdevtest.server.api.SkillGroup;
import com.jonwelzel.webdevtest.server.core.services.EmailServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jwelzel on 23/07/15.
 */
public class EmailServiceTest {

    private Candidate candidate;
    private EmailServiceImpl emailService;

    @Before
    public void setUp() {
        candidate = JsonHelper.readFixture("candidate_chuck_norris.json", Candidate.class);
        emailService = new EmailServiceImpl();
    }

    @Test
    public void shouldHave3TypesOfEmail() {
        assertThat(emailService.getEmailTypesToSend(candidate)).hasSize(3);
    }

    @Test
    public void shouldHave3EmailsToSend() {
        List<EmailType> types = emailService.getEmailTypesToSend(candidate);
        assertThat(types).hasSize(3);
        assertThat(emailService.getEmailsForTypes(types, candidate.getEmail())).hasSize(3);
    }

    @Test
    public void shouldHaveScoreForMobile() {
        assertThat(candidate.isMobile()).isTrue();
    }

    @Test
    public void shouldHaveScoreForFrontend() {
        assertThat(candidate.isFrontend()).isTrue();
    }

    @Test
    public void shouldHaveScoreForBackend() {
        assertThat(candidate.isBackend()).isTrue();
    }

}
