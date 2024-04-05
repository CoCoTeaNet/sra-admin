create table sys_user_role
(
    id      bigint not null comment '用户角色关联id'
        primary key,
    user_id bigint not null comment '用户id',
    role_id bigint not null comment '角色id'
)
    comment '用户角色关联表' engine = MyISAM
                             collate = utf8_unicode_ci
                             row_format = DYNAMIC;

INSERT INTO db_sra_v2.sys_user_role (id, user_id, role_id) VALUES (1699771910151151617, 100, 100);
