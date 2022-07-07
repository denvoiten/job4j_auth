create table if not exists employee (
    id serial primary key not null,
    name varchar,
    surname varchar,
    itn varchar,
    hired timestamp
);

create table if not exists person (
    id serial primary key not null,
    login varchar(2000),
    password varchar(2000),
    employeeid int references employee(id)
    );

insert into employee (name, surname, itn, hired)
values('Alex', 'Alexovich', '0987654321', '2022-07-07 11:54'),
      ('Ivan', 'Ivanovich', '1234567890', '2022-07-07 11:55');
insert into person (login, password, employeeid)
values ('alex', '123', 1),
       ('ivanovi4', '12345', 2),
       ('xmx', '345', 1),
       ('ivan', '123', 2);