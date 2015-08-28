package com.jonwelzel.webdevtest.server.unit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jonwelzel.webdevtest.server.api.Candidate;
import com.jonwelzel.webdevtest.server.core.utils.EnvVarsUtils;
import com.jonwelzel.webdevtest.server.core.utils.JwtUtils;
import com.jonwelzel.webdevtest.server.helpers.JsonHelper;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jwelzel on 28/08/15.
 */
public class JwtUtilsTest {

    @Test
    public void shouldEncodeAndDecodeToken() throws JsonProcessingException {
        final Candidate candidate = JsonHelper.readFixture("candidate_chuck_norris.json", Candidate.class);
        final String jwtSecret = EnvVarsUtils.getJwtSecret();
        final String token = JwtUtils.encode(jwtSecret, candidate);

        assertThat(candidate).isNotNull();
        assertThat(token).isNotNull();

        final Candidate decodedCandidate = JwtUtils.decode(jwtSecret, token);
        assertThat(decodedCandidate).isNotNull();
        assertThat(decodedCandidate.getName().equals(candidate.getName()));
    }

}
