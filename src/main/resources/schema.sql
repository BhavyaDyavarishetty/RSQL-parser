drop all objects;
create table department
(
  id              integer,
  department_name varchar(50),
  location        varchar(50),
  primary key (id)
);
create table student
(
  id    integer,
  name  varchar(50),
  email varchar(50),
  primary key (id)
);
create table course
(
  id          integer,
  course_name varchar(50),
  duration    varchar(50),
  department_id integer,
  foreign key (department_id) references department (id)
);