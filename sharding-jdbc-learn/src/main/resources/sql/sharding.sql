create database `sharding-learn-master`;
create database `sharding-learn-slave`;

create table `user`
(
    `id`     int(255) primary key auto_increment,
    username varchar(255),
    password varchar(255),
    age      int
) engine = InnoDB;

create table `user_0`
(
    `id`     int(255) primary key auto_increment,
    username varchar(255),
    password varchar(255),
    age      int
) engine = InnoDB;


create table `user_1`
(
    `id`     int(255) primary key auto_increment,
    username varchar(255),
    password varchar(255),
    age      int
) engine = InnoDB;
