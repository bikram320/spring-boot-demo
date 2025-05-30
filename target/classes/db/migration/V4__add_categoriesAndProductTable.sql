create table categories
(
    id   tinyint auto_increment
        primary key,
    name varchar(255) not null
);
create table product
(
    id          bigint auto_increment
        primary key,
    name        varchar(255)   not null,
    price       decimal(10, 2) not null,
    category_id tinyint        null,
    constraint product_categories_id_fk
        foreign key (category_id) references categories (id)
);