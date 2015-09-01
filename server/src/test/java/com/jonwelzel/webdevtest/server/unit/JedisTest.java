package com.jonwelzel.webdevtest.server.unit;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by jwelzel on 01/09/15.
 */
public class JedisTest {

    final Jedis jedis = new Jedis("localhost");
    final int ttl = 5;

    @Test
    public void shouldAddKeyWithTtl() {
        final String key = "foo";
        final String value = "bar";


        jedis.set(key, value);
        jedis.expire(key, ttl);

        assertThat(jedis.get(key)).isEqualTo(value);
        assertThat(jedis.ttl(key)).isEqualTo(ttl);
    }

    @Test
    public void shouldSetHashWithTtl() {
        final String key = "fooSet";
        Map<String, String> map = new HashMap<>();
        map.put("foo", "bar");

        final String setResponse = jedis.hmset(key, map);
        final long expireResponse = jedis.expire(key, ttl);

        assertThat(setResponse).isNotNull();
        assertThat(setResponse).isEqualTo("OK");
        assertThat(expireResponse).isEqualTo(1l);
        assertThat(jedis.ttl(key)).isEqualTo(ttl);
    }

}
