package com.jonwelzel.webdevtest.server.unit;

import com.jonwelzel.webdevtest.server.api.UserSession;
import com.jonwelzel.webdevtest.server.helpers.JsonHelper;
import com.jonwelzel.webdevtest.server.jdbi.daos.SessionDaoRedisImpl;
import io.dropwizard.jackson.Jackson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.Date;
import java.util.Map;

import static com.jonwelzel.webdevtest.server.jdbi.daos.SessionDaoInterface.USER_SESSIONS;
import static com.jonwelzel.webdevtest.server.jdbi.daos.SessionDaoInterface.USER_SESSION_HASH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.anyMap;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jwelzel on 01/09/15.
 */
public class SessionDaoRedisTest {

    private UserSession session;
    final Jedis jedis = new Jedis("localhost");

    @Before
    public void setUp() {
        final String id = "abc123";
        final String address = "127.0.0.1";
        final String agent = "Mozilla Firefox";
        final String lastAccess = String.valueOf(new Date().getTime());
        session = new UserSession(id, address, agent, lastAccess, "user123");
        session.setDateCreated(lastAccess);
    }

    @After
    public void tearDown() {
        jedis.close();
    }

    @Test
    public void shouldConvertObjectToMap() {
        final Map<String, Object> result = JsonHelper.getMapperInstance().convertValue(session, Map.class);

        assertThat(result.containsKey("id")).isTrue();
        assertThat(result.get("id")).isEqualTo(session.getId());

        assertThat(result.containsKey("address")).isTrue();
        assertThat(result.get("address")).isEqualTo(session.getAddress());

        assertThat(result.containsKey("lastAccess")).isTrue();
        assertThat(result.get("lastAccess")).isEqualTo(session.getLastAccess());
    }

    @Test
    public void shouldSaveNewSessionInRedis() {
        Jedis mockJedis = mock(Jedis.class);
        Client mockClient = mock(Client.class);
        Transaction spyTx = spy(new Transaction(mockClient));
        when(mockJedis.multi()).thenReturn(spyTx);

        doNothing().when(mockClient).rpush(anyString(), anyString());
        doNothing().when(mockClient).hmset(anyString(), anyMap());

        SessionDaoRedisImpl dao = new SessionDaoRedisImpl(mockJedis);
        dao.save(session);

        verify(mockClient).rpush(USER_SESSIONS + session.getUserId(), session.getId());
        verify(mockClient).hmset(USER_SESSION_HASH + session.getUserId() + ":" + session.getId(), Jackson.newObjectMapper().convertValue(session, Map.class));
    }

    @Test
    public void daoShouldCrud() {
        final SessionDaoRedisImpl dao = new SessionDaoRedisImpl(jedis);

        final UserSession sessionSaved = dao.save(session);
        assertThat(sessionSaved).isNotNull();

        final UserSession sessionFromFind = dao.findById(session.getUserId(), session.getId());
        assertThat(sessionFromFind).isNotNull();
        assertThat(sessionFromFind.getUserId()).isEqualTo(session.getUserId());

        final String originalDate = session.getLastAccess();
        final UserSession updatedSession = dao.update(session);
        assertThat(Long.parseLong(originalDate)).isLessThan(Long.parseLong(updatedSession.getLastAccess()));

        final UserSession sessionFromDelete = dao.delete(updatedSession);
        assertThat(sessionFromDelete).isNotNull();
        assertThat(dao.findById(sessionFromDelete.getUserId(), sessionFromDelete.getId())).isNull();
    }

}
