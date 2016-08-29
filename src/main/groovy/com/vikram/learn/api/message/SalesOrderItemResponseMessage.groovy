package com.vikram.learn.api.message

class SalesOrderItemResponseMessage {
    Integer soId
    BigDecimal grossAmount
    String customerId
    String name
    BigDecimal quantity
    String quantityUnit
    String deliveryDate

    SalesOrderItemResponseMessage(Integer soId, BigDecimal grossAmount, String customerId, String name, BigDecimal quantity, String quantityUnit, String deliveryDate) {
        this.soId = soId
        this.grossAmount = grossAmount
        this.customerId = customerId
        this.name = name
        this.quantity = quantity
        this.quantityUnit = quantityUnit
        this.deliveryDate = deliveryDate
    }
}
