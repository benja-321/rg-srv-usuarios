create schema if not exists gur;

create user usuario_own;

create table gur.usuario(
usuario varchar(20) not null,
password varchar(30) not null,
nivel int not null
);

alter table gur.usuario
add constraint pk_usuarios primary key(usuario);

grant select, insert, update, delete
on all tables in schema gur to usuario_own;

insert into gur.usuario values ('admin', 'admin', 5);