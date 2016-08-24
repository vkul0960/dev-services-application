package com.vikram.learn.api

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class InventoryItem {

    UUID id
    UUID itemId
    String materialId
    String plant
    BigDecimal quantity
    String quantityUom

    InventoryItem(Map inventoryItemMap) {
        this.id = inventoryItemMap.id
        this.itemId = UUID.randomUUID()
        this.materialId = inventoryItemMap.materialId
        this.plant = inventoryItemMap.plant
        this.quantity = inventoryItemMap.quantity
        this.quantityUom = inventoryItemMap.quantityUom
    }

    InventoryItem(UUID id, UUID itemId, String materialId, String plant, BigDecimal quantity, String quantityUom) {
        this.id = id
        this.itemId = itemId
        this.materialId = materialId
        this.plant = plant
        this.quantity = quantity
        this.quantityUom = quantityUom
    }
}
