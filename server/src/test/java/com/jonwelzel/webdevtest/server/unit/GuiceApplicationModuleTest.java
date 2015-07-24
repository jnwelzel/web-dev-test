package com.jonwelzel.webdevtest.server.unit;

import com.carlosbecker.guice.GuiceModules;
import com.carlosbecker.guice.GuiceTestRunner;
import com.google.inject.Inject;
import com.jonwelzel.webdevtest.server.di.ApplicationModule;
import com.jonwelzel.webdevtest.server.persistence.InMemoryStore;
import com.jonwelzel.webdevtest.server.services.EmailServiceImpl;
import com.jonwelzel.webdevtest.server.services.EmailServiceInterface;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jwelzel on 23/07/15.
 * Every Guice-managed bean, class, whatever, should be covered by these tests.
 */
@RunWith(GuiceTestRunner.class)
@GuiceModules(ApplicationModule.class)
public class GuiceApplicationModuleTest {

    @Inject
    private InMemoryStore store;

    @Inject
    private EmailServiceInterface emailService;

    @Test
    public void shouldInjectInMemoryStore() {
        assertThat(store).isNotNull();
    }

    @Test
    public void shouldInjectEmailServiceImplInstance() {
        assertThat(emailService).isNotNull();
        assertThat(emailService).isInstanceOf(EmailServiceImpl.class);
    }

}
