DROP TABLE IF EXISTS MEMBER;
DROP TABLE IF EXISTS TEAM;

CREATE TABLE TEAM
(
    id         bigint auto_increment primary key,
    name       varchar(20) not null,
    start_date DATE        not null,
    end_date   DATE        not null
);

CREATE TABLE MEMBER
(
    id         bigint auto_increment primary key,
    name       varchar(20) not null,
    age        int         not null,
    grade      varchar(20) not null,
    image_name varchar(100) null,
    team_id    bigint null,
    FOREIGN KEY (team_id) REFERENCES TEAM (id)
);
