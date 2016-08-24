package com.vikram.learn.message

import spock.lang.Specification

class BatchMessageTest extends Specification {
    void 'should create valid batch message with all attributes'() {
        given:
        String batchId = '12345'
        BigDecimal quantity = 12.0
        String quantityUom = 'CS'

        when:
        BatchMessage batchMessage = new BatchMessage([batchId: batchId, quantity: quantity, quantityUom: quantityUom])

        then:
        batchMessage.batchId == batchId
        batchMessage.quantity == quantity
        batchMessage.quantityUom == quantityUom
    }
}
