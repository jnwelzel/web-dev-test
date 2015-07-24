package com.jonwelzel.webdevtest.server.unit;

import com.jonwelzel.webdevtest.server.helpers.JsonHelper;
import com.jonwelzel.webdevtest.server.models.Candidate;
import com.jonwelzel.webdevtest.server.models.EmailType;
import com.jonwelzel.webdevtest.server.models.SkillGroup;
import com.jonwelzel.webdevtest.server.services.EmailServiceImpl;
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
    public void shouldHaveScore2ForMobile() {
        assertThat(emailService.calculateGroupScore(candidate.getSkillsByGroup(SkillGroup.MOBILE))).isEqualTo(2);
    }

    @Test
    public void shouldHaveScore3ForFrontend() {
        assertThat(emailService.calculateGroupScore(candidate.getSkillsByGroup(SkillGroup.FRONTEND))).isEqualTo(3);
    }

    @Test
    public void shouldHaveScore2ForBackend() {
        assertThat(emailService.calculateGroupScore(candidate.getSkillsByGroup(SkillGroup.BACKEND))).isEqualTo(2);
    }

}
