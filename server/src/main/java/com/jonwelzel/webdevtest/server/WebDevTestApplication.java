package com.jonwelzel.webdevtest.server;

import com.hubspot.dropwizard.guice.GuiceBundle;
import com.jonwelzel.webdevtest.server.core.di.ApplicationModule;
import com.jonwelzel.webdevtest.server.core.utils.EnvVarsUtils;
import com.jonwelzel.webdevtest.server.health.EnvironmentVarsCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * Created by jwelzel on 21/07/15.
 */
public class WebDevTestApplication extends Application<WebDevTestConfiguration> {

    private GuiceBundle<WebDevTestConfiguration> guiceBundle;

    public static void main(String[] args) throws Exception {
        new WebDevTestApplication().run(args);
    }

    @Override
    public String getName() {
        return "web-dev-test";
    }

    @Override
    public void initialize(Bootstrap<WebDevTestConfiguration> bootstrap) {
        EnvVarsUtils.checkEnvVars();
        guiceBundle = GuiceBundle.<WebDevTestConfiguration>newBuilder()
                .addModule(new ApplicationModule())
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(WebDevTestConfiguration.class)
                .build();
        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(WebDevTestConfiguration webDevTestConfiguration, Environment environment) throws Exception {
        addCorsFilter(environment);
        environment.healthChecks().register("env vars", new EnvironmentVarsCheck());
    }

    private void addCorsFilter(Environment environment) {
        FilterRegistration.Dynamic filter = environment.servlets().addFilter("CORS",
                CrossOriginFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,POST,DELETE,OPTIONS");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        filter.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        filter.setInitParameter("allowedHeaders",
                "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
        filter.setInitParameter("allowCredentials", "true");
    }

}
