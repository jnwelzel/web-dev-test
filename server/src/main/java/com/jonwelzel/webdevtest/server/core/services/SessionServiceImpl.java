package com.jonwelzel.webdevtest.server.core.services;

import com.jonwelzel.webdevtest.server.api.UserSession;

import java.util.List;

/**
 * Created by jwelzel on 31/08/15.
 */
public class SessionServiceImpl implements SessionServiceInterface {

    @Override
    public UserSession newSession(String address, String agent, String userId) {
        return null;
    }

    @Override
    public List<UserSession> userSessions(String userId) {
        return null;
    }

    @Override
    public UserSession findById(String userId, String sessionId) {
        return null;
    }

}
