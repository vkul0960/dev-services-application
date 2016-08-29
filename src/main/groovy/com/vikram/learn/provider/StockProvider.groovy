package com.vikram.learn.provider

import com.google.inject.Inject
import com.vikram.learn.api.SalesOrderItem
import com.vikram.learn.api.StockItem
import com.vikram.learn.api.message.BusinessPartner
import com.vikram.learn.api.message.SalesOrderItemResponseMessage
import com.vikram.learn.api.message.StockItemOverviewResponseMessage
import com.vikram.learn.api.message.StockItemResponseMessage
import com.vikram.learn.api.message.StockOverviewResponseMessage
import com.vikram.learn.dao.SalesOrderItemDao
import com.vikram.learn.dao.StockItemDao
import org.skife.jdbi.v2.sqlobject.CreateSqlObject
import org.skife.jdbi.v2.sqlobject.Transaction

abstract class StockProvider {

    @Inject
    SalesOrderItemProvider salesOrderItemProvider

    @CreateSqlObject
    abstract StockItemDao stockItemDao()

    @CreateSqlObject
    abstract SalesOrderItemDao salesOrderItemDao()

    @Transaction
    List<StockItem> create(Map<String, Object> newStockMap) {
        List<StockItem> items = buildStockItems(newStockMap)
        items.each { item ->
            stockItemDao().insert(item)
        }
        items
    }

    Map stockOverview() {
        List<StockItemResponseMessage> stockItemResponseMessages = []
        List<StockItem> stockItems = stockItemDao().getAll()
        List<SalesOrderItem> salesOrderItems = salesOrderItemDao().getAll()
        stockItems.each { stockItem ->
            BusinessPartner businessPartner = new BusinessPartner(stockItem.supplierName,
                    stockItem.street,
                    stockItem.postalCode,
                    stockItem.city,
                    stockItem.state)
            List<SalesOrderItemResponseMessage> soItemsForProduct = salesOrderItems.findAll {
                it.materialId == stockItem.materialId
            }.collect { items ->
                new SalesOrderItemResponseMessage(items.orderNumber, items.grossAmount, items.customerId,
                        items.name, items.quantity, items.salesUnit, items.deliveryDate)
            }
            stockItemResponseMessages << new StockItemResponseMessage(stockItem.materialId,
                    stockItem.description,
                    stockItem.totalStock,
                    stockItem.expectedPos,
                    stockItem.receivedPos,
                    stockItem.unitOfMeasure,
                    businessPartner,
                    soItemsForProduct
            )
        }
        ["itemCollection": stockItemResponseMessages]
    }

    private static List<StockItem> buildStockItems(Map<String, Object> newStockItem) {
        newStockItem.items.collect { item ->
            new StockItem([materialId   : item.materialId,
                           description  : item.description,
                           totalStock   : item.totalStock,
                           expectedPos  : item.expectedPos,
                           receivedPos  : item.receivedPos,
                           unitOfMeasure: item.unitOfMeasure,
                           supplierName : item.supplierName,
                           street       : item.street,
                           postalCode   : item.postalCode,
                           city         : item.city,
                           state        : item.state])
        }
    }
}
