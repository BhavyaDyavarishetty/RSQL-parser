drop all objects;
create schema if not exists university;
create table university.department
(
  id              integer,
  department_name varchar(50),
  location        varchar(50),
  primary key (id)
);
create table university.student
(
  id    integer,
  name  varchar(50),
  email varchar(50),
  primary key (id)
);
create table university.course
(
  id          integer,
  course_name varchar(50),
  duration    varchar(50),
  department_id integer,
  foreign key (department_id) references university.department (id)
);