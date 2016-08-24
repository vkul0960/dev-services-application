package com.vikram.learn.api.message

class InventoryResponseMessage {
    UUID id
    List<InventoryItemResponseMessage> items

    InventoryResponseMessage(UUID id, List<InventoryItemResponseMessage> items) {
        this.id = id
        this.items = items
    }
}
