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

INSERT INTO db_sra_v2.sys_user (id, username, nickname, password, sex, email, mobile_phone, account_status, avatar, last_login_ip, last_login_time, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (1699771308310499328, 'admin', 'db_sra_v2-admin', 'B846DAE82F5F32BC871A1E81FF16765030C74595CB89AD9B03D19E37C3777AC5', 0, 'db_sra_v2-admin@qq.com', '1389999999', 1, '650c74c32088821487c0b4d8_微信图片_20230921232652.png', '127.0.0.1', '2023-10-04 00:54:33', 1699771308310499328, '2023-09-07 21:07:55', 1699771308310499328, '2023-10-04 00:54:33', 0, null);
INSERT INTO db_sra_v2.sys_user (id, username, nickname, password, sex, email, mobile_phone, account_status, avatar, last_login_ip, last_login_time, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (1155920405505773568, 'android', 'AndroidUser', '2D66FDFF06FCED9B30A9ED99AB9851D71FB0EF09EA05AD0C954EC911FC27D683', 0, null, null, 1, null, '127.0.0.1', '2023-09-30 00:04:51', 1699771308310499328, '2023-09-25 17:35:01', 1155920405505773568, '2023-09-30 00:04:51', 0, null);
INSERT INTO db_sra_v2.sys_user (id, username, nickname, password, sex, email, mobile_phone, account_status, avatar, last_login_ip, last_login_time, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (1152624974353154048, 'bp@233', 'bp@233', 'B846DAE82F5F32BC871A1E81FF16765030C74595CB89AD9B03D19E37C3777AC5', 0, 'diaoqian19870512@163.com', '', 1, '', '27.47.11.230', '2023-10-14 18:16:49', 1699771308310499328, '2023-09-16 15:20:09', 1152624974353154048, '2023-10-14 18:16:49', 0, null);
INSERT INTO db_sra_v2.sys_user (id, username, nickname, password, sex, email, mobile_phone, account_status, avatar, last_login_ip, last_login_time, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (1152624974256685056, 'tester', 'tester', '43103B9099022C66B0768D7B15455E04B584FED9005BAFB19965E4CA179293BD', 0, 'tester@qq.com', '', 1, '', '127.0.0.1', '2023-12-26 20:52:19', 1699771308310499328, '2023-09-16 15:20:09', 1152624974256685056, '2023-12-26 20:52:19', 0, null);
INSERT INTO db_sra_v2.sys_user (id, username, nickname, password, sex, email, mobile_phone, account_status, avatar, last_login_ip, last_login_time, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (1152624974042775552, 'tric', 'tric', 'B846DAE82F5F32BC871A1E81FF16765030C74595CB89AD9B03D19E37C3777AC5', 0, '473074764@qq.com', '', 1, '', null, null, 1699771308310499328, '2023-09-16 15:20:09', 1699771308310499328, '2023-09-16 19:33:27', 0, null);
INSERT INTO db_sra_v2.sys_user (id, username, nickname, password, sex, email, mobile_phone, account_status, avatar, last_login_ip, last_login_time, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (1152624974156021760, 'bk', 'bk', 'B846DAE82F5F32BC871A1E81FF16765030C74595CB89AD9B03D19E37C3777AC5', 0, 'bk@acg.com', '', 1, '', null, null, 1699771308310499328, '2023-09-16 15:20:09', 1699771308310499328, '2023-09-16 19:33:37', 0, null);
INSERT INTO db_sra_v2.sys_user (id, username, nickname, password, sex, email, mobile_phone, account_status, avatar, last_login_ip, last_login_time, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (1152624973950500864, 'cocotea', 'CoCoTea', 'B846DAE82F5F32BC871A1E81FF16765030C74595CB89AD9B03D19E37C3777AC5', 0, '572315466@qq.com', '', 1, '', null, null, 1699771308310499328, '2023-09-16 15:20:09', 1699771308310499328, '2023-09-16 19:33:32', 0, null);
INSERT INTO db_sra_v2.sys_user (id, username, nickname, password, sex, email, mobile_phone, account_status, avatar, last_login_ip, last_login_time, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (1152624973673676800, 'sys_admin', 'sys_admin', 'B846DAE82F5F32BC871A1E81FF16765030C74595CB89AD9B03D19E37C3777AC5', 0, '572315466@qq.com', null, 1, null, null, null, 1699771308310499328, '2023-09-16 15:20:08', 1699771308310499328, '2023-09-16 15:20:08', 0, null);
