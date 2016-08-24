package com.vikram.learn.resource

import com.codahale.metrics.annotation.Timed
import com.google.inject.Inject
import com.vikram.learn.api.InventoryItem
import com.vikram.learn.provider.InventoryItemProvider
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path('v1/inventory')
@Api('inventory')
class InventoryResource {

    @Inject
    InventoryItemProvider inventoryItemProvider

    @POST
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation('create new inventory')
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'Inventory Request', paramType = 'body', dataType = 'com.vikram.learn.message.InventoryMessage', required = true)
    ])
    def create(@ApiParam(hidden = true) Map newInventoryMap) {
        List<InventoryItem> items = inventoryItemProvider.Create(newInventoryMap)
        Response
            .status(Response.Status.CREATED)
            .entity(items)
            .build()
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation('Get all inventories')
    def get() {
        inventoryItemProvider.getAll()
    }
}
