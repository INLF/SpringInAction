
CREATE TABLE if NOT exists Taco_Order
(
    id identity,
    delivery_Name varchar(50) NOT NULL,
    delivery_Street varchar(50) NOT NULL,
    delivery_City varchar(50) NOT NULL,
    delivery_State varchar(2) NOT NULL,
    delivery_Zip varchar(10) NOT NULL,
    cc_number varchar(16) NOT NULL,
    cc_expiration varchar(5) NOT NULL,
    cc_cvv varchar(3) NOT NULL,
    created_at timestamp not null
);

CREATE TABLE if NOT exists Taco
(
    id identity,
    name varchar(50) not null,
    taco_order bigint not null,
    taco_order_key bigint not null,
    created_at timestamp not null
);

CREATE TABLE if NOT exists Ingredient_Ref
(
    ingredient varchar(4) not null,
    taco bigint not null,
    taco_key bigint not null
);

CREATE TABLE if NOT exists Ingredient
(
    id varchar(4) unique not null,
    name varchar(25) not null,
    type varchar(10) not null
);

alter table Taco add foreign key (taco_order) references Taco_Order(id);
alter table Ingredient_Ref add foreign key (Ingredient) references Ingredient(id);
