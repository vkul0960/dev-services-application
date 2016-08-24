package com.vikram.learn.mapper

import com.vikram.learn.api.InventoryItem
import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper

import java.sql.ResultSet
import java.sql.SQLException

class InventoryItemMapper implements ResultSetMapper<InventoryItem> {
    @Override
    InventoryItem map(final int index, final ResultSet resultSet, final StatementContext context) throws SQLException {
        return new InventoryItem((UUID) resultSet.getObject('id'),
                (UUID) resultSet.getObject('itemid'),
                resultSet.getString('materialid'),
                resultSet.getString('plant'),
                resultSet.getBigDecimal('quantity'),
                resultSet.getString('quantityuom'))
    }
}
