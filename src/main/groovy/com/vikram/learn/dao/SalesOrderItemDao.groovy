package com.vikram.learn.dao

import com.vikram.learn.api.SalesOrderItem
import com.vikram.learn.mapper.SalesOrderItemMapper
import org.skife.jdbi.v2.sqlobject.BindBean
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.SqlUpdate
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper


@RegisterMapper(SalesOrderItemMapper.class)
public abstract class SalesOrderItemDao {
        @SqlUpdate('INSERT INTO mydb.salesorderitem (orderid, itemid, ordernumber, materialid, customerid, name, quantity, salesunit, grossamount, deliverydate) values (:salesOrderItem.orderId, :salesOrderItem.itemId, :salesOrderItem.orderNumber, :salesOrderItem.materialId, :salesOrderItem.customerId, :salesOrderItem.name, :salesOrderItem.quantity, :salesOrderItem.salesUnit, :salesOrderItem.grossAmount, :salesOrderItem.deliveryDate)')
        abstract insert(@BindBean('salesOrderItem') SalesOrderItem salesOrderItem)

        @SqlQuery('SELECT * FROM mydb.salesorderitem')
        abstract List<SalesOrderItem> getAll()
}

