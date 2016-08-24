package com.vikram.learn.dao

import com.vikram.learn.api.InventoryItem
import com.vikram.learn.mapper.InventoryItemMapper
import org.skife.jdbi.v2.sqlobject.Bind
import org.skife.jdbi.v2.sqlobject.BindBean
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.SqlUpdate
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper

@RegisterMapper(InventoryItemMapper.class)
public abstract class  InventoryItemDao {
    @SqlUpdate('INSERT INTO mydb.inventoryitem (itemid, id, materialid, plant, quantity, quantityuom) values (:inventoryItem.itemId, :inventoryItem.id, :inventoryItem.materialId, :inventoryItem.plant, :inventoryItem.quantity, :inventoryItem.quantityUom)')
    abstract insert(@BindBean('inventoryItem') InventoryItem inventoryItem)

    @SqlQuery('SELECT * FROM mydb.inventoryitem')
    abstract List<InventoryItem> getAll()
}
