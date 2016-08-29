package com.vikram.learn.api.message

class StockItemResponseMessage {
    String materialId
    String description
    BigDecimal totalStock
    BigDecimal expectedPos
    BigDecimal receivedPos
    String unitOfMeasure
    String receiveDate
    BusinessPartner businessPartner
    List<SalesOrderItemResponseMessage> lineItems

    StockItemResponseMessage(String materialId, String description, BigDecimal totalStock, BigDecimal expectedPos, BigDecimal receivedPos, String unitOfMeasure, BusinessPartner businessPartner, List<SalesOrderItemResponseMessage> salesOrderItemResponseMessages) {
        this.materialId = materialId
        this.description = description
        this.totalStock = totalStock
        this.expectedPos = expectedPos
        this.receivedPos = receivedPos
        this.unitOfMeasure = unitOfMeasure
        this.receiveDate = "2016-08-29T22:00:00"
        this.businessPartner = businessPartner
        this.lineItems = salesOrderItemResponseMessages
    }
}
