package com.vikram.learn.dao

import com.vikram.learn.api.StockItem
import com.vikram.learn.mapper.StockItemMapper
import org.skife.jdbi.v2.sqlobject.BindBean
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.SqlUpdate
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper

@RegisterMapper(StockItemMapper)
public abstract class StockItemDao {
    @SqlUpdate('INSERT INTO mydb.itemstock(id, materialid, description, totalstock, expectedpos, receivedpos, unitofmeasure, suppliername, street, postalcode, city, state) values (:stockItem.id, :stockItem.materialId, :stockItem.description, :stockItem.totalStock, :stockItem.expectedPos, :stockItem.receivedPos, :stockItem.unitOfMeasure, :stockItem.supplierName, :stockItem.street, :stockItem.postalCode, :stockItem.city, :stockItem.state)')
    abstract insert(@BindBean('stockItem') StockItem stockItem)

    @SqlQuery('SELECT * FROM mydb.itemstock')
    abstract List<StockItem> getAll()
}
