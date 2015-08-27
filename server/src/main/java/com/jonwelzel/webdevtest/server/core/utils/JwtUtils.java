package com.jonwelzel.webdevtest.server.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jonwelzel.webdevtest.server.api.Candidate;
import io.dropwizard.jackson.Jackson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jwelzel on 27/08/15.
 */
public class JwtUtils {

    private static final String PRINCIPAL_CLAIM = "principal";
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
    private static final Logger log = LoggerFactory.getLogger(JwtUtils.class.getName());

    public static String encode(String secretKey, Candidate principal) throws JsonProcessingException {
        Map<String, Object> jwtClaims = new HashMap<>();
        jwtClaims.put(PRINCIPAL_CLAIM, MAPPER.writeValueAsString(principal));
        return Jwts.builder().setClaims(jwtClaims).signWith(SignatureAlgorithm.HS512, secretKey).compact();
    }

    public static Candidate decode(String secretKey, String token) {
        final Candidate principal;
        try {
            principal = MAPPER.readValue((String) Jwts.parser().setSigningKey(secretKey)
                    .parseClaimsJws(token).getBody().get(PRINCIPAL_CLAIM), Candidate.class);
        } catch (Throwable e) {
            log.error("Erro ao decodificar token", e);
            return null;
        }
        return principal;
    }

}
