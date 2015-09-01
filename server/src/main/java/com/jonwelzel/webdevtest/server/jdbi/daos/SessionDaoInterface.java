package com.jonwelzel.webdevtest.server.jdbi.daos;

import com.jonwelzel.webdevtest.server.api.UserSession;

import java.util.List;

/**
 * Created by jwelzel on 31/08/15.
 */
public interface SessionDaoInterface extends BaseDao<UserSession> {

    UserSession findById(String userId, String sessionId);
    List<UserSession> findAllByUser(String userId);
    String USER_SESSIONS = "user_sessions:";
    String USER_SESSION_HASH = "user_session_hash:";

}
