CREATE TABLE IF NOT EXISTS mydb.itemstock(
    id uuid primary key not null,
    materialid text not null,
    description text not null,
    totalStock numeric,
    expectedpos numeric,
    receivedpos numeric,
    unitofmeasure text not null,
    suppliername text not null,
    street text not null,
    postalcode text not null,
    city text not null,
    state text not null
);