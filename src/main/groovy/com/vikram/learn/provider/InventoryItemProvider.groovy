package com.vikram.learn.provider

import com.vikram.learn.api.InventoryItem
import com.vikram.learn.api.message.InventoryItemResponseMessage
import com.vikram.learn.api.message.InventoryResponseMessage
import com.vikram.learn.dao.InventoryItemDao
import com.vikram.learn.message.InventoryItemMessage
import com.vikram.learn.message.InventoryMessage
import org.skife.jdbi.v2.sqlobject.CreateSqlObject
import org.skife.jdbi.v2.sqlobject.Transaction

abstract class InventoryItemProvider {

    @CreateSqlObject
    abstract InventoryItemDao inventoryItemDao()

    @Transaction
    List<InventoryItem> Create(Map<String, Object> inventoryMap) {
        List<InventoryItem> items = buildInventoryItems(inventoryMap)
        items.each {item->
            inventoryItemDao().insert(item)
        }
        items
    }

    Map getAll() {
        List<InventoryItem> items = inventoryItemDao().getAll()
        [inventories:buildInventoryResponse(items)]
    }

    private List<InventoryItem> buildInventoryItems(Map<String, Object> inventoryMap) {
        InventoryMessage inventoryMessage = new InventoryMessage(inventoryMap)
        List<InventoryItem> items = createInventoryItems(inventoryMessage.items)
        items
    }

    private List<InventoryItem> createInventoryItems(List<InventoryItemMessage> inventoryItemMessages) {
        List<InventoryItem> items = []
        UUID id = UUID.randomUUID()
        inventoryItemMessages.each { itemMessage ->
            itemMessage.locations.each { location ->
                BigDecimal quantity = location.batches.sum({ it.quantity })
                items << new InventoryItem([id   : id, materialId: itemMessage.materialId,
                                            plant: location.plant, quantity: quantity, quantityUom: 'CS'])
            }
        }
        items
    }

    private List<InventoryResponseMessage> buildInventoryResponse(List<InventoryItem> items) {
        List<InventoryResponseMessage> inventoryResponseMessage = []
        items.groupBy {it.id}.collect {inventoryId, inventoryItems->
            List<InventoryItemResponseMessage> inventoryItemResponseMessage = inventoryItems.collect{it->
                new InventoryItemResponseMessage(it.itemId, it.materialId, it.plant, it.quantity, it.quantityUom)
            }
            inventoryResponseMessage << new InventoryResponseMessage(inventoryId, inventoryItemResponseMessage)
        }
        inventoryResponseMessage
    }
}
