package com.vikram.learn.resource

import com.codahale.metrics.annotation.Timed
import com.google.inject.Inject
import com.vikram.learn.api.SalesOrderItem
import com.vikram.learn.provider.SalesOrderItemProvider
import io.swagger.annotations.Api

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import java.sql.Time

@Path('v1/salesOrderItems')
@Api('salesOrder')
class SalesOrderItemResource {

    @Inject
    SalesOrderItemProvider salesOrderItemProvider

    @POST
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    def create(Map newOrderItemMap) {
        List<SalesOrderItem> items = salesOrderItemProvider.create(newOrderItemMap)
        Response
            .status(Response.Status.CREATED)
            .entity(items)
            .build()
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    def get() {
        salesOrderItemProvider.getAll()
    }
}
