drop table orders if exists ;

create table orders(
    id bigint IDENTITY not null primary key ,
    customerName varchar(100),
    amount double

)

