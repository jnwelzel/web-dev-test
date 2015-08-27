package com.jonwelzel.webdevtest.server.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jonwelzel.webdevtest.server.api.Candidate;
import io.dropwizard.jackson.Jackson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jwelzel on 27/08/15.
 */
public class JwtUtils {

    private static final String PRINCIPAL_CLAIM = "principal";
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    public static String encode(String secretKey, Candidate principal) throws JsonProcessingException {
        Map<String, Object> jwtClaims = new HashMap<>();
        jwtClaims.put(PRINCIPAL_CLAIM, MAPPER.writeValueAsString(principal));
        return Jwts.builder().setClaims(jwtClaims).signWith(SignatureAlgorithm.HS512, secretKey).compact();
    }

    public static Candidate decode(String secretKey, String token) throws IOException {
        final Candidate principal = MAPPER.readValue((String) Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody().get(PRINCIPAL_CLAIM), Candidate.class);
        return principal;
    }

}
