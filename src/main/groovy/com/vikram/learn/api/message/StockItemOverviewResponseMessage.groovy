package com.vikram.learn.api.message

import com.vikram.learn.api.SalesOrderItem
import com.vikram.learn.api.StockItem

class StockItemOverviewResponseMessage {

    StockItem stockItem
    List<SalesOrderItemResponseMessage> salesOrderItemResponseMessages
}
