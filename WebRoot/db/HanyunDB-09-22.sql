/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/9/22 10:43:16                           */
/*==============================================================*/
drop database if exists hanyun;

create database hanyun;

use hanyun;

drop table if exists t_Image;

drop table if exists t_Resource;

drop table if exists t_ResourceCategory;

drop table if exists t_User;

drop table if exists t_downloadDetails;

drop table if exists t_reviewStatus;

drop table if exists t_userRole;

/*==============================================================*/
/* Table: t_Image                                               */
/*==============================================================*/
create table t_Image
(
   imageId              int not null,
   imageUrl             varchar(1024) not null,
   imageName            varchar(32),
   primary key (imageId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_Resource                                            */
/*==============================================================*/
create table t_Resource
(
   fileId               int not null auto_increment,
   userId               int,
   userRoleId           int not null,
   resourceId           int,
   imageId              int,
   reviewStatusId       int not null,
   fileName             varchar(64) not null,
   fileMD5              char(32) not null,
   fileUrl              varchar(256) not null,
   uploadTime           datetime not null,
   downloadTimes        int not null,
   browseTimes          int not null,
   fileSize             int not null,
   primary key (fileId)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_ResourceCategory                                    */
/*==============================================================*/
create table t_ResourceCategory
(
   resourceId           int not null,
   t_R_resourceId       int,
   resourceName         varchar(64) not null,
   primary key (resourceId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO t_ResourceCategory (resourceId, resourceName) VALUES(1,"文档");
INSERT INTO t_ResourceCategory (resourceId, resourceName) VALUES(2,"图片");
INSERT INTO t_ResourceCategory (resourceId, resourceName) VALUES(3,"视频");
INSERT INTO t_ResourceCategory (resourceId, resourceName) VALUES(4,"音乐");
INSERT INTO t_ResourceCategory VALUES(5,1,"PDF文档");
INSERT INTO t_ResourceCategory VALUES(6,1,"TXT文档");
INSERT INTO t_ResourceCategory VALUES(7,1,"DOC文档");
INSERT INTO t_ResourceCategory VALUES(8,3,"短片");
INSERT INTO t_ResourceCategory VALUES(9,3,"电影");

/*==============================================================*/
/* Table: t_User                                                */
/*==============================================================*/
create table t_User
(
   userId               int not null auto_increment,
   userRoleId           int not null,
   userName             varchar(32) not null,
   userPassword         varchar(32) not null,
   salt                 char(8) not null,
   userEmail            varchar(64) not null,
   lastLoginIP          varchar(1024) not null,
   lastLoginTime        datetime not null,
   avatarUrl            varchar(1024) not null,
   registerIP           varchar(1024) not null,
   registerTime         datetime not null,
   primary key (userId)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_downloadDetails                                     */
/*==============================================================*/
create table t_downloadDetails
(
   downloadId           int not null auto_increment,
   fileId               int not null,
   userId               int not null,
   downloadTime         datetime not null,
   downloadIP           varchar(1024) not null,
   primary key (downloadId)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: t_reviewStatus                                        */
/*==============================================================*/
create table t_reviewStatus
(
   reviewStatusId       int not null,
   reviewStatusName     varchar(1024) not null,
   primary key (reviewStatusId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO t_reviewStatus VALUES(1,"未审核");
INSERT INTO t_reviewStatus VALUES(2,"审核通过");
INSERT INTO t_reviewStatus VALUES(3,"审核未通过");

/*==============================================================*/
/* Table: t_userRole                                            */
/*==============================================================*/
create table t_userRole
(
   userRoleId           int not null,
   userRoleName         varchar(1024) not null,
   primary key (userRoleId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO t_userRole (userRoleId, userRoleName) VALUES(1, "管理员");
INSERT INTO t_userRole (userRoleId, userRoleName) VALUES(2, "普通用户");
INSERT INTO t_userRole (userRoleId, userRoleName) VALUES(3, "游客");


alter table t_Resource add constraint FK_Belong foreign key (resourceId)
      references t_ResourceCategory (resourceId) on delete restrict on update restrict;

alter table t_Resource add constraint FK_Upload foreign key (userId)
      references t_User (userId) on delete restrict on update restrict;

alter table t_Resource add constraint FK_authority foreign key (userRoleId)
      references t_userRole (userRoleId) on delete restrict on update restrict;

alter table t_Resource add constraint FK_belong2 foreign key (imageId)
      references t_Image (imageId) on delete restrict on update restrict;

alter table t_Resource add constraint FK_belong3 foreign key (reviewStatusId)
      references t_reviewStatus (reviewStatusId) on delete restrict on update restrict;

alter table t_ResourceCategory add constraint FK_Has foreign key (t_R_resourceId)
      references t_ResourceCategory (resourceId) on delete restrict on update restrict;

alter table t_User add constraint FK_have foreign key (userRoleId)
      references t_userRole (userRoleId) on delete restrict on update restrict;

alter table t_downloadDetails add constraint FK_downloadResource foreign key (fileId)
      references t_Resource (fileId) on delete restrict on update restrict;

alter table t_downloadDetails add constraint FK_downloadUser foreign key (userId)
      references t_User (userId) on delete restrict on update restrict;

