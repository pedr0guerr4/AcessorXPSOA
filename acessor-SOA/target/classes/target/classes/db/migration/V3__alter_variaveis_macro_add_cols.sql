-- Adiciona as colunas que faltam (com default para passar no NOT NULL)
alter table variaveis_macro add column if not exists taxa_juros decimal(10,2) default 0 not null;
alter table variaveis_macro add column if not exists cambio     decimal(10,2) default 0 not null;
alter table variaveis_macro add column if not exists tributos   decimal(10,2) default 0 not null;
