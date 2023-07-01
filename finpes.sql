create database finpes;
use finpes;

create table pessoa(
  id integer primary key not null auto_increment,
  nome varchar(50) not null,
  receita varchar(50) not null, 
  valorReceita double not null 
);

create table despesas(
  id integer primary key not null auto_increment,
  descricao varchar(50) not null, 
  valor double not null,
  saldo double not null,
  pessoa_id integer not null,
  foreign key(pessoa_id) references pessoa(id)    
);