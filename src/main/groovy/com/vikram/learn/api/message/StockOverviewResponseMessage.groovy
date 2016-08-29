package com.vikram.learn.api.message

class StockOverviewResponseMessage {

    List<StockItemOverviewResponseMessage> itemCollection

    StockOverviewResponseMessage(List<StockItemOverviewResponseMessage> stockItemOverviewResponseMessages) {
        this.itemCollection = stockItemOverviewResponseMessages
    }
}
