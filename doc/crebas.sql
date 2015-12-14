/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/12/10 13:42:19                          */
/*==============================================================*/


drop table if exists Message;

drop table if exists Reply;

drop table if exists Topic;

drop table if exists TopicCollect;

drop table if exists User;

drop table if exists ups;

/*==============================================================*/
/* Table: Message                                               */
/*==============================================================*/
create table Message
(
   id                   bigint not null,
   masterId             bigint,
   authorId             bigint,
   topicId              bigint,
   replyId              bigint,
   hasRead              bool default false,
   createAt             datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: Reply                                                 */
/*==============================================================*/
create table Reply
(
   id                   bigint not null,
   content              varchar(2048),
   topicId              bigint,
   authorId             bigint,
   parentReplyId        bigint,
   createAt             datetime,
   updateAt             datetime,
   contentIsHtml        bool,
   deleted              bool default false,
   primary key (id)
);

/*==============================================================*/
/* Table: Topic                                                 */
/*==============================================================*/
create table Topic
(
   id                   bigint not null,
   title                varchar(500),
   content              varchar(2048),
   authorId             bigint,
   top                  bool default false,
   good                 bool default false,
   islock               bool default false,
   visitCount           int default 0,
   replyCount           int default 0,
   collectCount         int default 0,
   createAt             datetime,
   updateAt             datetime,
   lastReply            varchar(50),
   lastReplyAt          datetime,
   contentIsHtml        bool,
   tab                  varchar(50),
   deleted              bool default false,
   primary key (id)
);

/*==============================================================*/
/* Table: TopicCollect                                          */
/*==============================================================*/
create table TopicCollect
(
   userId               bigint not null,
   topicId              bigint not null,
   createAt             datetime not null,
   primary key (userId, topicId)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   id                   bigint not null,
   name                 varchar(100),
   loginName            varchar(100),
   pass                 varchar(100),
   email                varchar(100),
   url                  varchar(200),
   profileImageUrl      varchar(300),
   location             varchar(200),
   signature            varchar(500),
   profile              varchar(200),
   weibo                varchar(200),
   avatar               varchar(200),
   githubId             varchar(200),
   githubUserName       varchar(100),
   githubAccessToken    varchar(200),
   isBlock              bool,
   score                int default 0,
   topicCount           int default 0,
   replyCount           int default 0,
   followCount          int default 0,
   collectTagCount      int default 0,
   collectTopicCount    int default 0,
   createAt             datetime,
   updateAt             datetime,
   isStar               bool,
   level                varchar(20),
   active               bool default false,
   receiveReplyMail     bool default false,
   receiveAtMail        bool default false,
   fromWp               bool,
   retrieveTime         int,
   retrieveKey          varchar(100),
   accessToken          varchar(50),
   primary key (id)
);

alter table User comment '用户表';

/*==============================================================*/
/* Table: ups                                                   */
/*==============================================================*/
create table ups
(
   id                   bigint not null,
   replyId              bigint not null,
   userId               bigint not null,
   primary key (id)
);

