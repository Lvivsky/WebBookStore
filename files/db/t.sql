create database store;

use store;

drop table user;
drop table bucket;
drop table product;

create table user(
    id int primary key auto_increment,
    email varchar(50) not null unique,
    password varchar(50) not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    picture varchar(50),
    role enum('user', 'admin') default 'user'
);

select * from user;

create table bucket(
	id int primary key auto_increment,
    purchase_date timestamp
);

create table product(
	id int primary key auto_increment,
    name varchar(50) not null,
    description varchar(50),
    price double not null,
    picture varchar(50),
    bucket_id int,
    foreign key (bucket_id) references bucket(id)
);

insert into user values(1, 'admin@admin', '123', 'admin','admin','admin');