package com.vikram.learn.api

import spock.lang.Specification
class InventoryItemTest extends Specification {
    void 'Should return new inventory item id' () {
        given:
        UUID id = UUID.randomUUID()
        String materialId = '123456'
        String plant = '1050'
        BigDecimal quantity = 10.0
        String quantityUom = 'CS'

        when:
        InventoryItem inventoryItem = new InventoryItem([id:id,
                                                         materialId: materialId,
                                                         plant:plant,
                                                         quantity: quantity,
                                                         quantityUom: quantityUom])

        then:
        assert inventoryItem.itemId instanceof UUID
        assert inventoryItem.itemId != null
        println(inventoryItem)
    }
}
