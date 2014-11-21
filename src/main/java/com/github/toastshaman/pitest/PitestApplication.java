package com.github.toastshaman.pitest;

import com.github.toastshaman.pitest.persistence.TodoStore;
import com.github.toastshaman.pitest.resources.TodoResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class PitestApplication extends Application<PitestConfiguration> {

    @Override
    public void initialize(Bootstrap<PitestConfiguration> bootstrap) {
    }

    @Override
    public void run(PitestConfiguration pitestConfiguration, Environment environment) throws Exception {
        environment.jersey().register(new TodoResource(new TodoStore()));
    }
}
