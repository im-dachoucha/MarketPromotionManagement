create table admin
(
    id       serial
        primary key,
    email    varchar(255) not null,
    password varchar(255) not null
);

alter table admin
    owner to postgres;

create table store
(
    id    serial
        primary key,
    city  varchar(255) not null,
    phone varchar(255) not null,
    email varchar(255) not null
);

alter table store
    owner to postgres;

create table storeadmin
(
    id       serial
        primary key,
    storeid  integer      not null
        references store,
    email    varchar(255) not null,
    password varchar(255) not null
);

alter table storeadmin
    owner to postgres;

create table department
(
    id   serial
        primary key,
    name varchar(255) not null
);

alter table department
    owner to postgres;

create table subdepartment
(
    id           serial
        primary key,
    name         varchar(255) not null,
    departmentid integer      not null
        references department
);

alter table subdepartment
    owner to postgres;

create table departmentmanager
(
    id           serial
        primary key,
    email        varchar(255) not null,
    password     varchar(255) not null,
    departmentid integer      not null
        references department,
    storeid      integer      not null
        references store
);

alter table departmentmanager
    owner to postgres;

create table promotion
(
    id              serial
        primary key,
    description     varchar(255),
    comment         varchar(255),
    state           varchar(255) default 'pending'::character varying not null,
    startdate       date                                              not null,
    enddate         date                                              not null,
    discount        numeric(3, 2)                                     not null,
    subdepartmentid integer                                           not null
        references subdepartment,
    storeid         integer                                           not null
        references store
);

alter table promotion
    owner to postgres;

