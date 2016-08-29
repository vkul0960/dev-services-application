package com.vikram.learn.mapper

import com.vikram.learn.api.StockItem
import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper

import java.sql.ResultSet
import java.sql.SQLException

class StockItemMapper implements ResultSetMapper<StockItem> {
    @Override
    StockItem map(int index, ResultSet resultSet, StatementContext context) throws SQLException {
        return new StockItem((UUID) resultSet.getObject('id'),
                resultSet.getString('materialid'),
                resultSet.getString('description'),
                resultSet.getBigDecimal('totalstock'),
                resultSet.getBigDecimal('expectedpos'),
                resultSet.getBigDecimal('receivedpos'),
                resultSet.getString('unitofmeasure'),
                resultSet.getString('suppliername'),
                resultSet.getString('street'),
                resultSet.getString('postalcode'),
                resultSet.getString('city'),
                resultSet.getString('state'))
    }
}
