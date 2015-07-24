package com.jonwelzel.webdevtest.server.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static io.dropwizard.testing.FixtureHelpers.fixture;

/**
 * Created by jwelzel on 23/07/15.
 */
public class JsonHelper {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
    private static final Logger log = LoggerFactory.getLogger(JsonHelper.class.getName());

    public static ObjectMapper getMapperInstance() {
        return MAPPER;
    }

    public static <T> T readFixture(String path, Class<T> clazz) {
        try {
            return MAPPER.readValue(fixture("fixtures/" + path), clazz);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

}
