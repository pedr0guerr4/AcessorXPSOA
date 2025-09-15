-- V1__baseline.sql
create table cliente (
id bigserial primary key,
nome varchar(120) not null,
email varchar(120) not null unique,
perfil varchar(20) not null,
liquidez_disponivel_centavos bigint not null,
currency varchar(3) not null
);


create table objetivo (
id bigserial primary key,
cliente_id bigint not null,
prazo varchar(20) not null,
valor_alvo_centavos bigint not null,
prazo_meses int not null,
constraint fk_obj_cliente foreign key (cliente_id) references cliente(id)
);


create table ativo (
id bigserial primary key,
classe varchar(20) not null,
codigo varchar(40) not null,
risco int not null,
liquidez varchar(10) not null,
tributacao varchar(60),
descricao text
);


create table carteira (
id bigserial primary key,
cliente_id bigint not null,
data_ref varchar(10) not null,
constraint fk_cart_cliente foreign key (cliente_id) references cliente(id)
);


create table alocacao (
id bigserial primary key,
carteira_id bigint not null,
ativo_id bigint not null,
percentual int not null,
constraint fk_aloc_cart foreign key (carteira_id) references carteira(id),
constraint fk_aloc_ativo foreign key (ativo_id) references ativo(id)
);


create table variavel_macro (
id bigserial primary key,
chave varchar(20) not null,
valor varchar(40) not null,
data_ref varchar(10) not null
);