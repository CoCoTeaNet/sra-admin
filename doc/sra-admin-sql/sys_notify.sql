create table sys_notify
(
    id          bigint            not null comment '通知ID'
        primary key,
    title       varchar(200)      not null comment '通知标题',
    memo        varchar(900)      null comment '消息内容',
    jump_url    varchar(200)      null comment '跳转链接、ID、等等',
    notify_type varchar(20)       not null comment '通知类型',
    is_global   tinyint default 0 not null comment '是否全局',
    receiver    bigint            null comment '接收人',
    level       tinyint default 1 not null comment '通知等级',
    notify_time timestamp         not null comment '通知时间',
    create_by   bigint            null comment '创建人',
    create_time timestamp         not null comment '创建时间',
    is_deleted  tinyint default 0 not null comment '是否删除'
)
    comment '系统通知表' collate = utf8_unicode_ci;

create index sys_notify_idx1
    on sys_notify (notify_type, is_deleted, create_time);

create index sys_notify_idx2
    on sys_notify (receiver);

