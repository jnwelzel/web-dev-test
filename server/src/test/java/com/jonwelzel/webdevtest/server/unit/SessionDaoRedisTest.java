package com.jonwelzel.webdevtest.server.unit;

import com.jonwelzel.webdevtest.server.api.UserSession;
import com.jonwelzel.webdevtest.server.helpers.JsonHelper;
import static com.jonwelzel.webdevtest.server.jdbi.daos.SessionDaoInterface.*;
import com.jonwelzel.webdevtest.server.jdbi.daos.SessionDaoRedisImpl;
import io.dropwizard.jackson.Jackson;
import org.apache.commons.lang3.NotImplementedException;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.Date;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jwelzel on 01/09/15.
 */
public class SessionDaoRedisTest {

    private UserSession session;

    @Before
    public void setUp() {
        final String id = "abc123";
        final String address = "127.0.0.1";
        final String agent = "Mozilla Firefox";
        final Date lastAccess = new Date();
        session = new UserSession(id, address, agent, lastAccess, "userId");
    }

    @Test
    public void shouldConvertObjectToMap() {
        final Map<String, Object> result = JsonHelper.getMapperInstance().convertValue(session, Map.class);

        assertThat(result.containsKey("id")).isTrue();
        assertThat(result.get("id")).isEqualTo(session.getId());

        assertThat(result.containsKey("address")).isTrue();
        assertThat(result.get("address")).isEqualTo(session.getAddress());

        assertThat(result.containsKey("lastAccess")).isTrue();
        assertThat(result.get("lastAccess")).isEqualTo(session.getLastAccess().getTime());
    }

    @Test
    public void shouldSaveNewSessionInRedis() {
        Jedis mockJedis = mock(Jedis.class);
        Client mockClient = mock(Client.class);
        Transaction spyTx = spy(new Transaction(mockClient));
        when(mockJedis.multi()).thenReturn(spyTx);

        doNothing().when(mockClient).lpush(anyString(), anyString());
        doNothing().when(mockClient).hmset(anyString(), anyMap());

        SessionDaoRedisImpl dao = new SessionDaoRedisImpl(mockJedis);
        dao.save(session);

        verify(mockClient).lpush(USER_SESSIONS + session.getUserId(), session.getId());
        verify(mockClient).hmset(USER_SESSION_HASH + session.getId(), Jackson.newObjectMapper().convertValue(session, Map.class));
    }

    @Test(expected = NotImplementedException.class)
    public void shouldThrowExceptionWhenFindAll() {
        Jedis mockJedis = mock(Jedis.class);

        SessionDaoRedisImpl dao = new SessionDaoRedisImpl(mockJedis);
        dao.findAll();
    }

}
