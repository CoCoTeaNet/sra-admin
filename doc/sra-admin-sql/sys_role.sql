create table sys_role
(
    id          bigint            not null comment '角色id'
        primary key,
    role_name   varchar(30)       not null comment '角色名称',
    role_key    varchar(255)      not null comment '角色标识',
    remark      varchar(255)      null comment '备注',
    sort        int               null comment '显示排序',
    create_by   bigint            not null comment '创建人',
    create_time datetime          not null comment '创建时间',
    update_by   bigint            null comment '更新人',
    update_time datetime          null comment '更新时间',
    is_deleted  tinyint default 0 not null comment '是否删除',
    revision    int               null comment '乐观锁'
)
    comment '系统角色表' engine = MyISAM
                         collate = utf8_unicode_ci
                         row_format = DYNAMIC;

INSERT INTO db_sra_v2.sys_role (id, role_name, role_key, remark, sort, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (1699771910151151616, '超级管理员', 'role:super:admin', null, null, 1699771308310499328, '2023-09-07 21:10:17', null, null, 0, null);
INSERT INTO db_sra_v2.sys_role (id, role_name, role_key, remark, sort, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (1150175648716701696, '普通用户', 'simple:user', null, 1, 1699771308310499328, '2023-09-09 21:07:24', 1699771308310499328, '2023-09-09 21:07:24', 0, null);
