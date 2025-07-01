create table usuario(
	idusuario		serial			primary key,
	nome			varchar(150)	not null,
	email			varchar(100)	not null unique,
	senha			varchar(40)		not null
);

create table contato(
	idcontato		serial			primary key,
	nome			varchar(150)	not null,
	email			varchar(100)	not null,
	telefone		varchar(15)		not null,
	observacoes		varchar(500)	not null,
	idusuario		integer			not null,
	foreign key(idusuario)
		references usuario(idusuario));