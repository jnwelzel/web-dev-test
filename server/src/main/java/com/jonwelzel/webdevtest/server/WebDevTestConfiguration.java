package com.jonwelzel.webdevtest.server;

import com.bendb.dropwizard.redis.JedisFactory;
import com.google.common.net.HostAndPort;
import io.dropwizard.Configuration;

/**
 * Created by jwelzel on 21/07/15.
 */
public class WebDevTestConfiguration extends Configuration {

    public JedisFactory buildJedisFactory() {
        JedisFactory jedisFactory = new JedisFactory();
        jedisFactory.setEndpoint(HostAndPort.fromHost("localhost"));
        return jedisFactory;
    }

}
