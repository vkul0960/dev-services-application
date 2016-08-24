package com.vikram.learn.message

import spock.lang.Specification

class InventoryItemMessageTest extends Specification {
    void 'should create valid inventory item message with all attributes'() {
        given:
        String materialId = '12345'

        when:
        InventoryItemMessage inventoryItemMessage = new InventoryItemMessage([materialId: materialId,
                                                                              locations : [[plant  : '1050',
                                                                                            batches: [[batchId: '12345', quantity: 12, quantityUom: 'CS'],
                                                                                                      [batchId: '45678', quantity: 16, quantityUom: 'CS']]],
                                                                                           [plant  : '1305',
                                                                                            batches: [[batchId: '12345', quantity: 14, quantityUom: 'CS'],
                                                                                                      [batchId: '45678', quantity: 18, quantityUom: 'CS']]]]])

        then:
        inventoryItemMessage.locations.size() == 2
        inventoryItemMessage.locations[0].plant == '1050'
        inventoryItemMessage.locations[1].plant == '1305'
    }
}
