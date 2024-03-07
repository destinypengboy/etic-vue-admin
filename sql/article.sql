drop table if exists article_nav;
create table article_nav
(
    id             bigint      not null auto_increment comment '导航ID',
    nav_title      varchar(50) not null comment '导航标题',
    nav_type       int(5)      not null comment '导航类型（1html 2跳转链接）',
    nav_content    longblob     default null comment '导航内容',
    status         char(1)      default '0' comment '导航状态（0正常 1关闭）',
    order_num      int(11)      default 99 comment '导航排序',
    comment_status char(1)      default '0' comment '导航是否支持开启评论（0否 1是）（仅导航类型为1的导航生效）',
    create_by      varchar(64)  default '' comment '创建者',
    create_time    datetime comment '创建时间',
    update_by      varchar(64)  default '' comment '更新者',
    update_time    datetime comment '更新时间',
    remark         varchar(255) default null comment '备注',
    primary key (id)
) engine = innodb
  auto_increment = 1 comment = '导航表';

drop table if exists article_article;
create table article_article
(
    id              bigint      not null auto_increment comment '文章ID',
    article_title   varchar(50) not null comment '文章标题',
    article_type    int(5)      not null comment '文章类型（1html 2跳转链接）',
    article_content longblob     default null comment '文章内容',
    status          char(1)      default '0' comment '文章状态（0正常 1关闭）',
    comment_status  char(1)      default '0' comment '文章是否支持开启评论（0否 1是）',
    create_by       varchar(64)  default '' comment '创建者',
    create_time     datetime comment '创建时间',
    update_by       varchar(64)  default '' comment '更新者',
    update_time     datetime comment '更新时间',
    remark          varchar(255) default null comment '备注',
    primary key (id)
) engine = innodb
  auto_increment = 1 comment = '文章表';

drop table if exists article_tag;
create table article_tag
(
    id          bigint      not null auto_increment comment '标签ID',
    tag_title   varchar(50) not null comment '标签标题',
    status      char(1)      default '0' comment '标签状态（0正常 1关闭）',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(255) default null comment '备注',
    primary key (id)
) engine = innodb
  auto_increment = 1 comment = '标签表';

drop table if exists article_category;
create table article_category
(
    id             bigint      not null auto_increment comment '分类ID',
    category_title varchar(50) not null comment '分类标签',
    status         char(1)      default '0' comment '分类状态（0正常 1关闭）',
    create_by      varchar(64)  default '' comment '创建者',
    create_time    datetime comment '创建时间',
    update_by      varchar(64)  default '' comment '更新者',
    update_time    datetime comment '更新时间',
    remark         varchar(255) default null comment '备注',
    primary key (id)
) engine = innodb
  auto_increment = 1 comment = '分类表';

drop table if exists article_config;
create table article_config
(
    id           bigint      not null auto_increment comment '配置ID',
    config_key   varchar(50) not null comment '配置key',
    config_value longblob     default null comment '配置内容',
    create_by    varchar(64)  default '' comment '创建者',
    create_time  datetime comment '创建时间',
    update_by    varchar(64)  default '' comment '更新者',
    update_time  datetime comment '更新时间',
    remark       varchar(255) default null comment '备注',
    primary key (id)
) engine = innodb
  auto_increment = 1 comment = '配置表';