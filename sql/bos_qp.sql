/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/3/11 15:44:53                           */
/*==============================================================*/


drop table if exists auth_function;

drop table if exists auth_role;

drop table if exists role_function;

drop table if exists t_user;

drop table if exists user_role;

/*==============================================================*/
/* Table: auth_function                                         */
/*==============================================================*/
create table auth_function
(
   id                   varchar(32) not null,
   name                 varchar(255),
   code                 varchar(255),
   description          varchar(255),
   page                 varchar(255),
   generatemenu         varchar(255),
   zindex               int,
   pid                  varchar(32),
   primary key (id),
   key AK_Key_2 (name)
);

/*==============================================================*/
/* Table: auth_role                                             */
/*==============================================================*/
create table auth_role
(
   id                   varchar(32) not null,
   name                 varchar(255),
   code                 varchar(255),
   description          varchar(255),
   primary key (id),
   key AK_Key_2 (name)
);

/*==============================================================*/
/* Table: role_function                                         */
/*==============================================================*/
create table role_function
(
   role_id              varchar(32) not null,
   function_id          varchar(32) not null,
   primary key (role_id, function_id)
);

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   varchar(32) not null,
   username             varchar(20),
   password             varchar(32),
   salary               double,
   birthday             date,
   gender               varchar(10),
   station              varchar(40),
   telephone            varchar(11),
   remark               varchar(255),
   primary key (id)
);

/*==============================================================*/
/* Table: user_role                                             */
/*==============================================================*/
create table user_role
(
   user_id              varchar(32) not null,
   role_id              varchar(32) not null,
   primary key (user_id, role_id)
);

alter table auth_function add constraint FK_Reference_1x foreign key (pid)
      references auth_function (id) on delete restrict on update restrict;

alter table role_function add constraint FK_Reference_2x foreign key (function_id)
      references auth_function (id) on delete restrict on update restrict;

alter table role_function add constraint FK_Reference_3x foreign key (role_id)
      references auth_role (id) on delete restrict on update restrict;

alter table user_role add constraint FK_Reference_4x foreign key (user_id)
      references t_user (id) on delete restrict on update restrict;

alter table user_role add constraint FK_Reference_5x foreign key (role_id)
      references auth_role (id) on delete restrict on update restrict;

