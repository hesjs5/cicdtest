DROP TABLE IF EXISTS MEMBER;

CREATE TABLE MEMBER
(
    id bigint auto_increment primary key,
    name varchar(20) not null,
    age int not null,
    grade varchar(20) not null
);