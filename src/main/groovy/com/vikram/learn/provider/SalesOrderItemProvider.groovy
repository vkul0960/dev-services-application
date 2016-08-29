package com.vikram.learn.provider

import com.vikram.learn.api.SalesOrderItem
import com.vikram.learn.api.message.SalesOrderItemResponseMessage
import com.vikram.learn.dao.SalesOrderItemDao
import org.skife.jdbi.v2.sqlobject.CreateSqlObject
import org.skife.jdbi.v2.sqlobject.Transaction

abstract class SalesOrderItemProvider {

    @CreateSqlObject
    abstract SalesOrderItemDao salesOrderItemDao()

    @Transaction
    List<SalesOrderItem> create(Map<String, Object> salesOrderItemMap) {
        List<SalesOrderItem> items = buildSalesOrderItems(salesOrderItemMap)
        items.each {item->
            salesOrderItemDao().insert(item)
        }
        items
    }

    Map getAll() {
        List<SalesOrderItem> items = getSalesOrderItems()
        ["LineItems": buildSalesOrderItemResponse(items)]
    }

    public List<SalesOrderItem> getSalesOrderItems() {
        List<SalesOrderItem> items = salesOrderItemDao().getAll()
        items
    }

    private static List<SalesOrderItemResponseMessage> buildSalesOrderItemResponse(List<SalesOrderItem> salesOrderItems) {
        salesOrderItems.collect{item->
            new SalesOrderItemResponseMessage(item.orderNumber, item.grossAmount, item.customerId, item.name,
                                              item.quantity, item.salesUnit, item.deliveryDate)
        }
    }

    private static List<SalesOrderItem> buildSalesOrderItems(Map<String, Object> newSalesOrderItemMap) {
        List<SalesOrderItem> salesOrderItemsList = []
        newSalesOrderItemMap.items.each { newSalesOrderItem ->
            salesOrderItemsList << new SalesOrderItem(UUID.randomUUID(), UUID.randomUUID(), newSalesOrderItem.orderNumber, newSalesOrderItem.materialId,
                    newSalesOrderItem.customerId, newSalesOrderItem.name, newSalesOrderItem.quantity,
                    newSalesOrderItem.salesUnit, newSalesOrderItem.grossAmount, newSalesOrderItem.deliveryDate)
        }
        salesOrderItemsList
    }
}
