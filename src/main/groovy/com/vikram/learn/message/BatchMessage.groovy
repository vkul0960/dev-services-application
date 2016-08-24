package com.vikram.learn.message

import com.fasterxml.jackson.annotation.JsonCreator
import org.hibernate.validator.constraints.NotEmpty

class BatchMessage {

    @NotEmpty
    String batchId

    @NotEmpty
    BigDecimal quantity

    @NotEmpty
    String quantityUom

    @JsonCreator
    BatchMessage(Map message) {
        this.batchId = message.batchId
        this.quantity = message.quantity
        this.quantityUom = message.quantityUom
    }
}
