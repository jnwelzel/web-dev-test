package com.jonwelzel.webdevtest.server.jdbi.daos;

import com.jonwelzel.webdevtest.server.api.UserSession;
import io.dropwizard.jackson.Jackson;
import org.apache.commons.lang3.NotImplementedException;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jwelzel on 31/08/15.
 */
public class SessionDaoRedisImpl implements SessionDaoInterface {

    final Jedis jedis;

    public SessionDaoRedisImpl(Jedis jedis) {
        this.jedis = jedis;
    }

    @Override
    public List<UserSession> findAll() {
        throw new NotImplementedException("Essa funcionalidade não é suportada para sessões");
    }

    @Override
    public UserSession findById(String id) {
        throw new NotImplementedException("Favor utilizar \"findById(String userId, String sessionId)\"");
    }

    @Override
    public UserSession save(UserSession session) {
        session.setLastAccess(new Date());
        Transaction tx = jedis.multi();
        tx.rpush(USER_SESSIONS + session.getUserId(), session.getId());
        tx.hmset(USER_SESSION_HASH + session.getUserId() + ":" + session.getId(), Jackson.newObjectMapper().convertValue(session, Map.class));
        tx.exec();

        return session;
    }

    @Override
    public UserSession update(UserSession session) {
        jedis.hmset(USER_SESSION_HASH + session.getUserId() + ":" + session.getId(), Jackson.newObjectMapper().convertValue(session, Map.class));

        return session;
    }

    @Override
    public UserSession delete(UserSession session) {
        Transaction tx = jedis.multi();
        tx.lrem(USER_SESSIONS + session.getUserId(), 1, session.getId());
        tx.del(USER_SESSION_HASH + session.getUserId() + ":" + session.getId());
        tx.exec();

        return session;
    }

    @Override
    public UserSession findById(String userId, String sessionId) {
        List<String> sessionFields = jedis.hmget(USER_SESSION_HASH + userId + ":" + sessionId, "id",
                "address", "agent", "lastAccess", "userId");

        return buildFromFields(sessionFields);
    }

    @Override
    public List<UserSession> findAllByUser(String userId) {
        List<UserSession> sessions = new ArrayList<>();
        List<String> userSessions = jedis.lrange(USER_SESSIONS + userId, 0, -1);
        for(String sessionId : userSessions) {
            sessions.add(buildFromFields(jedis.hmget(USER_SESSION_HASH + userId + ":" + sessionId, "id",
                    "address", "agent", "lastAccess", "userId")));
        }

        return sessions;
    }

    private UserSession buildFromFields(List<String> fieldValues) {
        if(fieldValues == null || fieldValues.size() != 5)
            throw new IllegalArgumentException("A lista de valores do objeto da sessão deve conter 5 itens");

        return new UserSession(fieldValues.get(0), fieldValues.get(1), fieldValues.get(2),
                new Date(Long.getLong(fieldValues.get(3))), fieldValues.get(4));
    }

}
