CREATE TABLE IF NOT EXISTS mydb.inventoryitem(
    itemid uuid primary key not null,
    id uuid not null,
    materialid text not null,
    plant text not null,
    quantity numeric,
    quantityuom text
);