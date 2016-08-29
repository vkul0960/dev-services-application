CREATE TABLE IF NOT EXISTS mydb.salesorderitem(
    orderid uuid not null,
    itemid uuid primary key not null,
    ordernumber numeric not null,
    materialid text not null,
    customerid text not null,
    name text not null,
    quantity numeric,
    salesunit text not null,
    grossamount numeric,
    deliverydate text not null
);