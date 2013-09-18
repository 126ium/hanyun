/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/9/13 9:22:45                            */
/*==============================================================*/


drop table if exists t_Image;

drop table if exists t_Resource;

drop table if exists t_ResourceCategory;

drop table if exists t_User;

/*==============================================================*/
/* Table: t_Image                                               */
/*==============================================================*/
create table t_Image
(
   imageId              int not null,
   imageUrl             varchar(1024) not null,
   imageName            varchar(32),
   primary key (imageId)
);

/*==============================================================*/
/* Table: t_Resource                                            */
/*==============================================================*/
create table t_Resource
(
   fileId               int not null,
   userId               int,
   resourceId           int,
   imageId              int,
   fileName             varchar(64) not null,
   fileMD5              char(32) not null,
   fileUrl              varchar(256) not null,
   uploadTime           datetime not null,
   downloadTimes        int not null,
   browseTimes          int not null,
   reviewStatus         int not null,
   primary key (fileId)
);

/*==============================================================*/
/* Table: t_ResourceCategory                                    */
/*==============================================================*/
create table t_ResourceCategory
(
   resourceId           int not null,
   t_R_resourceId       int,
   resuorceName         varchar(64) not null,
   primary key (resourceId)
);

/*==============================================================*/
/* Table: t_User                                                */
/*==============================================================*/
create table t_User
(
   userId               int not null,
   userName             varchar(32) not null,
   userPassword         varchar(32) not null,
   salt                 char(8) not null,
   userRole             int not null,
   userEmail            varchar(64) not null,
   lastLoginIP          varchar(1024) not null,
   lastLoginTime        datetime not null,
   userStatus           int not null,
   avatarUrl            varchar(1024) not null,
   primary key (userId)
);

alter table t_Resource add constraint FK_Belong foreign key (resourceId)
      references t_ResourceCategory (resourceId) on delete restrict on update restrict;

alter table t_Resource add constraint FK_Upload foreign key (userId)
      references t_User (userId) on delete restrict on update restrict;

alter table t_Resource add constraint FK_belong2 foreign key (imageId)
      references t_Image (imageId) on delete restrict on update restrict;

alter table t_ResourceCategory add constraint FK_Has foreign key (t_R_resourceId)
      references t_ResourceCategory (resourceId) on delete restrict on update restrict;

