package com.jonwelzel.webdevtest;

import com.hubspot.dropwizard.guice.GuiceBundle;
import com.jonwelzel.webdevtest.di.ApplicationModule;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by jwelzel on 21/07/15.
 */
public class WebDevTestApplication extends Application<WebDevTestConfiguration> {

    private GuiceBundle<WebDevTestConfiguration> guiceBundle;

    public static void main(String[] args) throws Exception {
        new WebDevTestApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<WebDevTestConfiguration> bootstrap) {
        guiceBundle = GuiceBundle.<WebDevTestConfiguration>newBuilder()
                .addModule(new ApplicationModule())
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(WebDevTestConfiguration.class)
                .build();
        bootstrap.addBundle(guiceBundle);
        bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(bootstrap
                .getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false)));
    }

    @Override
    public void run(WebDevTestConfiguration webDevTestConfiguration, Environment environment) throws Exception {

    }

}
