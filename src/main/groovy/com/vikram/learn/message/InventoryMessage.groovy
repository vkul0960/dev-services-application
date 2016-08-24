package com.vikram.learn.message

import javax.validation.Valid

class InventoryMessage {

    @Valid
    List<InventoryItemMessage> items

    InventoryMessage(Map<String, Object> message) {
        this.items = message.items
    }
}
