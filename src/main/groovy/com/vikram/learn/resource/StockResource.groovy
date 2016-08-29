package com.vikram.learn.resource
//Created By VKUL0960
import com.codahale.metrics.annotation.Timed
import com.google.inject.Inject
import com.vikram.learn.api.StockItem
import com.vikram.learn.provider.StockProvider

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response


@Path('v1/stockResource')
class StockResource {

    @Inject
    StockProvider stockProvider

    @POST
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    def create(Map newStockMap) {
        List<StockItem> items = stockProvider.create(newStockMap)
        Response
                .status(Response.Status.CREATED)
                .entity(items)
                .build()
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    def get() {
        stockProvider.stockOverview()
    }
}
