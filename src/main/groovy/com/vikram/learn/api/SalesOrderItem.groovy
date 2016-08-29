package com.vikram.learn.api

import java.math.RoundingMode

class SalesOrderItem {
    UUID orderId
    UUID itemId
    Integer orderNumber
    String materialId
    String customerId
    String name
    BigDecimal quantity
    String salesUnit
    BigDecimal grossAmount
    String deliveryDate

    SalesOrderItem(Map salesOrderItemMap) {
        orderId = salesOrderItemMap.orderId
        itemId = UUID.randomUUID()
        materialId = salesOrderItemMap.materialId
        customerId = salesOrderItemMap.customerId
        name = salesOrderItemMap.name
        quantity = salesOrderItemMap.quantity
        salesUnit = salesOrderItemMap.salesUnit
        grossAmount = salesOrderItemMap.grossAmount
        deliveryDate = salesOrderItemMap.deliveryDate
    }

    SalesOrderItem(UUID orderId, UUID itemId, Integer orderNumber, String materialId, String customerId, String name, BigDecimal quantity, String salesUnit, BigDecimal grossAmount, String deliveryDate) {
        this.orderId = orderId
        this.itemId = itemId
        this.orderNumber = orderNumber
        this.materialId = materialId
        this.customerId = customerId
        this.name = name
        this.quantity = quantity
        this.quantity = this.quantity.setScale(2,RoundingMode.HALF_UP)
        this.salesUnit = salesUnit
        this.grossAmount = grossAmount
        this.grossAmount = this.grossAmount.setScale(2,RoundingMode.HALF_UP)
        this.deliveryDate = deliveryDate
    }
}
