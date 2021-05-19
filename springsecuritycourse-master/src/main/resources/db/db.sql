CREATE DATABASE springsecuritycourse;

use springsecuritycourse;

CREATE TABLE users(
    id int primary key auto_increment,
    email varchar(225),
    first_name varchar(50),
    last_name varchar(100),
    password varchar(225),
    role varchar(20),
    status varchar(20)
);