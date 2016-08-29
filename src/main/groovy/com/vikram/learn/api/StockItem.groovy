package com.vikram.learn.api

class StockItem {
    UUID id
    String materialId
    String description
    BigDecimal totalStock
    BigDecimal expectedPos
    BigDecimal receivedPos
    String unitOfMeasure
    String supplierName
    String street
    String postalCode
    String city
    String state

    StockItem(Map newStockItemMap) {
        this.id = UUID.randomUUID()
        this.materialId = newStockItemMap.materialId
        this.description = newStockItemMap.description
        this.totalStock = newStockItemMap.totalStock
        this.expectedPos = newStockItemMap.expectedPos
        this.receivedPos = newStockItemMap.receivedPos
        this.unitOfMeasure = newStockItemMap.unitOfMeasure
        this.supplierName = newStockItemMap.supplierName
        this.street = newStockItemMap.street
        this.postalCode = newStockItemMap.postalCode
        this.city = newStockItemMap.city
        this.state = newStockItemMap.state
    }

    StockItem(UUID id, String materialId, String description, BigDecimal totalStock, BigDecimal expectedPos, BigDecimal receivedPos, String unitOfMeasure, String supplierName, String street, String postalCode, String city, String state) {
        this.id = id
        this.materialId = materialId
        this.description = description
        this.totalStock = totalStock
        this.expectedPos = expectedPos
        this.receivedPos = receivedPos
        this.unitOfMeasure = unitOfMeasure
        this.supplierName = supplierName
        this.street = street
        this.postalCode = postalCode
        this.city = city
        this.state = state
    }
}
