create table product (
    id bigint not null auto_increment,
    name varchar(60) not null,
    category varchar(20) not null,
    price decimal(10,2) not null,
    primary key (id)
);