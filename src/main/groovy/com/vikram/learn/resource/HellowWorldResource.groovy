package com.vikram.learn.resource

import com.codahale.metrics.annotation.Timed
import com.google.common.base.Optional
import com.vikram.learn.api.Saying

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType
import java.util.concurrent.atomic.AtomicLong

@Path('/hello-world')
@Produces(MediaType.APPLICATION_JSON)
class HellowWorldResource {
    private String template
    private String defaultName
    private AtomicLong counter

    HellowWorldResource(String template, String defaultName) {
        this.template = template
        this.defaultName = defaultName
        this.counter = new AtomicLong()
    }

    @GET
    @Timed
    Saying sayHello(@QueryParam("name") Optional<String> name){
        final String value = String.format(template,name.or(defaultName))
        new Saying(counter.incrementAndGet(),value)
    }


}
