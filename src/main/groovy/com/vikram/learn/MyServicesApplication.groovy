package com.vikram.learn

import com.google.inject.Guice
import com.google.inject.Injector
import com.vikram.learn.config.LearnConfiguration
import com.vikram.learn.resource.HellowWorldResource
import com.vikram.learn.resource.InventoryResource
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class MyServicesApplication extends Application<LearnConfiguration> {
    static void  main(String[] args) throws Exception {
        new MyServicesApplication().run(args)
    }

    @Override
    void initialize(Bootstrap<LearnConfiguration> bootstrap){

    }

    @Override
    void run(LearnConfiguration configuration, Environment environment){
        Injector injector = Guice.createInjector(new MyGuiceModule(configuration, environment))
//        final HellowWorldResource resource = new HellowWorldResource(
//                configuration.getTemplate(),
//                configuration.getDefaultName()
//        )
//
//        environment.jersey().register(resource)
        environment.jersey().register(injector.getInstance(InventoryResource))
    }
}
