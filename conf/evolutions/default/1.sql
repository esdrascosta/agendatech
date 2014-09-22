# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table evento (
  id                        integer not null,
  email_para_contato        varchar(255),
  descricao                 text,
  site                      varchar(255),
  twitter                   varchar(255),
  nome                      varchar(255),
  constraint pk_evento primary key (id))
;

create sequence evento_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists evento;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists evento_seq;

