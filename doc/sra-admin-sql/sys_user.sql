create table sys_user
(
    id              bigint            not null comment '用户id'
        primary key,
    username        varchar(30)       not null comment '登录账号',
    nickname        varchar(30)       not null comment '用户昵称',
    password        varchar(64)       not null comment '密码',
    sex             tinyint           not null comment '用户性别;0未知 1男 2女',
    email           varchar(128)      null comment '用户邮箱',
    mobile_phone    varchar(20)       null comment '手机号',
    account_status  tinyint           not null comment '账号状态;0停用 1正常 2冻结 3封禁',
    avatar          varchar(255)      null comment '头像地址',
    last_login_ip   varchar(64)       null comment '最后登录ip',
    last_login_time datetime          null comment '最后登录时间',
    create_by       bigint            not null comment '创建人',
    create_time     datetime          not null comment '创建时间',
    update_by       bigint            null comment '更新人',
    update_time     datetime          null comment '更新时间',
    is_deleted      tinyint default 0 not null comment '是否删除',
    revision        int               null comment '乐观锁'
)
    comment '系统用户表' engine = MyISAM
                         collate = utf8_unicode_ci
                         row_format = DYNAMIC;

INSERT INTO db_sra_v2.sys_user (id, username, nickname, password, sex, email, mobile_phone, account_status, avatar, last_login_ip, last_login_time, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (1699771308310499328, 'admin', 'admin@cocotea', 'CE8F380B21D530FF53B6E4CA10652BAC4EA0133212032DC2065CE8A347D07707', 0, 'db_sra_v2-admin@qq.com', '1389999999', 1, '650c74c32088821487c0b4d8_微信图片_20230921232652.png', '127.0.0.1', '2024-04-22 15:33:45', 1699771308310499328, '2023-09-07 21:07:55', 1699771308310499328, '2024-04-22 15:33:45', 0, null);
