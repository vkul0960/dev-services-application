package com.vikram.learn.api.message

class InventoryItemResponseMessage {
    UUID itemId
    String materialId
    String plant
    BigDecimal quantity
    String quantityUom

    InventoryItemResponseMessage(UUID itemId, String materialId, String plant, BigDecimal quantity, String quantityUom) {
        this.itemId = itemId
        this.materialId = materialId
        this.plant = plant
        this.quantity = quantity
        this.quantityUom = quantityUom
    }
}
