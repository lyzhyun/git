/*
Author:myit
Date:2016\11\12
Desc:database

*/
/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 11                       */
/* Created on:     2016-11-12 16:40:39                          */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_EMP_ROLE_EMP_ROLE_T_EMPLOY') then
    alter table emp_role
       delete foreign key FK_EMP_ROLE_EMP_ROLE_T_EMPLOY
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_EMP_ROLE_EMP_ROLE2_T_ROLE') then
    alter table emp_role
       delete foreign key FK_EMP_ROLE_EMP_ROLE2_T_ROLE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ROLE_PRI_BELONG_T_ROLE') then
    alter table role_pri
       delete foreign key FK_ROLE_PRI_BELONG_T_ROLE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_ROLE_PRI_OWN_T_PRIVIL') then
    alter table role_pri
       delete foreign key FK_ROLE_PRI_OWN_T_PRIVIL
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_T_DEPT_ORG_DEPT_T_ORG') then
    alter table t_dept
       delete foreign key FK_T_DEPT_ORG_DEPT_T_ORG
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_T_EMPLOY_DEPT_EMP_T_DEPT') then
    alter table t_employee
       delete foreign key FK_T_EMPLOY_DEPT_EMP_T_DEPT
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_T_LEADER_INHERITAN_T_EMPLOY') then
    alter table t_leader
       delete foreign key FK_T_LEADER_INHERITAN_T_EMPLOY
end if;

if exists(
   select 1 from sys.systable 
   where table_name='emp_role'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table emp_role
end if;

if exists(
   select 1 from sys.systable 
   where table_name='role_pri'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table role_pri
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_dept'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_dept
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_employee'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_employee
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_leader'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_leader
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_org'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_org
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_privilege'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_privilege
end if;

if exists(
   select 1 from sys.systable 
   where table_name='t_role'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table t_role
end if;

/*==============================================================*/
/* Table: emp_role                                              */
/*==============================================================*/
create table emp_role 
(
   emp_id               varchar(32)                    not null,
   role_id              varchar(32)                    not null,
   state                integer                        null,
   constraint PK_EMP_ROLE primary key (emp_id, role_id)
);

comment on column emp_role.state is 
'tzgg ֪ͨ٫٦';

/*==============================================================*/
/* Table: role_pri                                              */
/*==============================================================*/
create table role_pri 
(
   role_id              varchar(32)                    not null,
   pri_id               varchar(32)                    not null,
   constraint PK_ROLE_PRI primary key (role_id, pri_id)
);

/*==============================================================*/
/* Table: t_dept                                                */
/*==============================================================*/
create table t_dept 
(
   detp_id              varchar(32)                    not null,
   org_id               varchar(32)                    not null,
   name                 varchar(50)                    null,
   constraint PK_T_DEPT primary key (detp_id)
);

/*==============================================================*/
/* Table: t_employee                                            */
/*==============================================================*/
create table t_employee 
(
   emp_id               varchar(32)                    not null,
   detp_id              varchar(32)                    not null,
   name                 varchar(50)                    not null,
   constraint PK_T_EMPLOYEE primary key (emp_id)
);

/*==============================================================*/
/* Table: t_leader                                              */
/*==============================================================*/
create table t_leader 
(
   emp_id               varchar(32)                    not null,
   detp_id              varchar(32)                    null,
   name                 varchar(50)                    not null,
   position             integer                        null,
   constraint PK_T_LEADER primary key (emp_id)
);

/*==============================================================*/
/* Table: t_org                                                 */
/*==============================================================*/
create table t_org 
(
   org_id               varchar(32)                    not null,
   name                 varchar(50)                    null,
   constraint PK_T_ORG primary key (org_id)
);

/*==============================================================*/
/* Table: t_privilege                                           */
/*==============================================================*/
create table t_privilege 
(
   pri_id               varchar(32)                    not null,
   name                 varchar(50)                    null,
   constraint PK_T_PRIVILEGE primary key (pri_id)
);

/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
create table t_role 
(
   role_id              varchar(32)                    not null,
   name                 varchar(50)                    null,
   constraint PK_T_ROLE primary key (role_id)
);

alter table emp_role
   add constraint FK_EMP_ROLE_EMP_ROLE_T_EMPLOY foreign key (emp_id)
      references t_employee (emp_id)
      on update restrict
      on delete restrict;

alter table emp_role
   add constraint FK_EMP_ROLE_EMP_ROLE2_T_ROLE foreign key (role_id)
      references t_role (role_id)
      on update restrict
      on delete restrict;

alter table role_pri
   add constraint FK_ROLE_PRI_BELONG_T_ROLE foreign key (role_id)
      references t_role (role_id)
      on update restrict
      on delete restrict;

alter table role_pri
   add constraint FK_ROLE_PRI_OWN_T_PRIVIL foreign key (pri_id)
      references t_privilege (pri_id)
      on update restrict
      on delete restrict;

alter table t_dept
   add constraint FK_T_DEPT_ORG_DEPT_T_ORG foreign key (org_id)
      references t_org (org_id)
      on update restrict
      on delete restrict;

alter table t_employee
   add constraint FK_T_EMPLOY_DEPT_EMP_T_DEPT foreign key (detp_id)
      references t_dept (detp_id)
      on update restrict
      on delete restrict;

alter table t_leader
   add constraint FK_T_LEADER_INHERITAN_T_EMPLOY foreign key (emp_id)
      references t_employee (emp_id)
      on update restrict
      on delete restrict;

/*
Author:myit
Date:2016\11\15
Desc:database

*/


drop table if exists complain;

/*==============================================================*/
/* Table: complain                                              */
/*==============================================================*/
create table complain
(
   comp_id              varchar(32) not null,
   comp_company         varchar(100),
   comp_name            varchar(20),
   comp_mobile          varchar(20),
   is_NM                bool,
   comp_time            datetime,
   comp_title           varchar(200) not null,
   to_comp_name         varchar(20),
   to_comp_dept         varchar(100),
   comp_content         text,
   state                varchar(1),
   primary key (comp_id)
);


drop table if exists complain_reply;

/*==============================================================*/
/* Table: complain_reply                                        */
/*==============================================================*/
create table complain_reply
(
   reply_id             varchar(32) not null,
   comp_id              varchar(32) not null,
   replyer              varchar(20),
   reply_dept           varchar(100),
   reply_time           datetime,
   reply_content        varchar(300),
   primary key (reply_id)
);

alter table complain_reply add constraint FK_comp_reply foreign key (comp_id)
      references complain (comp_id) on delete restrict on update restrict;



