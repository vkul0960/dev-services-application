package com.vikram.learn.message

import com.fasterxml.jackson.annotation.JsonCreator
import org.hibernate.validator.constraints.NotEmpty

import javax.validation.Valid

class InventoryItemMessage {

    @NotEmpty
    String materialId

    @Valid
    List<LocationMessage> locations

    @JsonCreator
    InventoryItemMessage(Map<String, Object> message) {
        this.materialId = message.materialId
        this.locations = message.locations
    }
}
