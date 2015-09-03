package com.jonwelzel.webdevtest.server.core.services;

import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.api.UserSession;
import com.jonwelzel.webdevtest.server.core.di.binding.RedisDao;
import com.jonwelzel.webdevtest.server.jdbi.daos.SessionDaoInterface;

import java.util.List;

/**
 * Created by jwelzel on 31/08/15.
 */
public class SessionServiceImpl implements SessionServiceInterface {

    private SessionDaoInterface dao;

    @Inject
    public SessionServiceImpl(@RedisDao SessionDaoInterface dao) {
        this.dao = dao;
    }

    @Override
    public UserSession newSession(UserSession session) {
        return dao.save(session);
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
