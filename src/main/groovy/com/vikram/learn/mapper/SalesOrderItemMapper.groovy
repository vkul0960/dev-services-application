package com.vikram.learn.mapper

import com.vikram.learn.api.SalesOrderItem
import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper

import java.sql.ResultSet
import java.sql.SQLException

class SalesOrderItemMapper implements ResultSetMapper<SalesOrderItem> {
    @Override
    SalesOrderItem map(int index, ResultSet resultSet, StatementContext context) throws SQLException {
        return new SalesOrderItem((UUID) resultSet.getObject('orderid'),
                (UUID) resultSet.getObject('itemid'),
                resultSet.getInt('ordernumber'),
                resultSet.getString('materialid'),
                resultSet.getString('customerid'),
                resultSet.getString('name'),
                resultSet.getBigDecimal('quantity'),
                resultSet.getString('salesunit'),
                resultSet.getBigDecimal('grossamount'),
                resultSet.getString('deliverydate')
        )
    }
}
