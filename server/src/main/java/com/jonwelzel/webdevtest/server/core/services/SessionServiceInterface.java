package com.jonwelzel.webdevtest.server.core.services;

import com.jonwelzel.webdevtest.server.api.UserSession;

import java.util.List;

/**
 * Created by jwelzel on 31/08/15.
 */
public interface SessionServiceInterface {

    UserSession newSession(String userId, String token);
    List<UserSession> userSessions(String userId);
    UserSession findById(String userId, String token, String sessionId);

}
