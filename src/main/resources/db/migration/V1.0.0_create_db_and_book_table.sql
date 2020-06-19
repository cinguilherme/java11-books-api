create database books_db;

create table if not exists `book` (
    `id` int not null auto_increment primary key,
    `name` varchar(255) not null,
);