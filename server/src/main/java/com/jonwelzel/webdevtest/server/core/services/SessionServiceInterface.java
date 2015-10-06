package com.jonwelzel.webdevtest.server.core.services;

import com.jonwelzel.webdevtest.server.api.UserSession;

import java.util.List;

/**
 * Created by jwelzel on 31/08/15.
 */
public interface SessionServiceInterface {

    UserSession newSession(UserSession session);
    List<UserSession> userSessions(String userId);
    UserSession findById(String userId, String sessionId);
    UserSession updateSession(UserSession session);
    UserSession destroySession(String userId, String sessionId);

}
