create database book_shop;

use book_shop;

create table account(
	id int auto_increment,
    email varchar(50) not null unique,
    password varchar(50) not null,
    primary key (id)
);
create table user(
	id int auto_increment,
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    birthday date not null,
    rg_date date not null,
    img varchar(50) default 'uimgdef',
    primary key (id),
    foreign key (id) references account(id)
);



create table book(
	id int auto_increment,
    title varchar(50) not null,
    description_text text,
    img varchar(50) default 'bimgdef',
    price decimal(5,2) not null,
    pages int,
    published_date date not null,
    author_id int,
    primary key (id),
    foreign key (author_id) references user(id)
);
create table user_book(
	user_id int ,
    book_id int,
    primary key (user_id,book_id),
    foreign key (user_id) references user(id),
    foreign key (book_id) references book(id)
);




create table genre(
	id int auto_increment,
    name varchar(50),
    primary key (id)
);
create table book_genre(
	book_id int,
    genre_id int,
    primary key (book_id,genre_id),
    foreign key (book_id) references book(id),
    foreign key (genre_id) references genre(id)
);

drop table subscription;

CREATE TABLE subscription (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) unique NOT NULL,
    description_text TEXT,
    price decimal(5,2) NOT NULL,
    max_book_count INT NOT NULL
);
CREATE TABLE user_subscription (
    user_id INT,
    subscription_id INT,
    PRIMARY KEY (user_id , subscription_id),
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (subscription_id) REFERENCES subscription (id)
);



create table message(
	id int auto_increment,
	sender_id int,
    book_id int,
    message text not null,
    primary key (id),
    foreign key (book_id) references book(id),
    foreign key (sender_id) references user(id)
);














