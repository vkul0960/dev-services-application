package com.vikram.learn.api.message

import com.vikram.learn.api.SalesOrderItem
import com.vikram.learn.api.StockItem

class StockItemOverviewResponseMessage {

    StockItemResponseMessage stockItemResponseMessage
    List<SalesOrderItemResponseMessage> lineItems

    StockItemOverviewResponseMessage(StockItemResponseMessage stockItemResponseMessage, List<SalesOrderItemResponseMessage> salesOrderItemResponseMessages) {
        this.stockItemResponseMessage = stockItemResponseMessage
        this.lineItems = salesOrderItemResponseMessages
    }
}
