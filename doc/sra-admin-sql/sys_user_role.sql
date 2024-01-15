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

INSERT INTO db_sra_v2.sys_user_role (id, user_id, role_id) VALUES (1699771910151151617, 1699771308310499328, 1699771910151151616);
INSERT INTO db_sra_v2.sys_user_role (id, user_id, role_id) VALUES (1150237677435502592, 1699771308310499328, 1150175648716701696);
INSERT INTO db_sra_v2.sys_user_role (id, user_id, role_id) VALUES (1150265502859280384, 1150243128814354432, 1150175648716701696);
INSERT INTO db_sra_v2.sys_user_role (id, user_id, role_id) VALUES (1152688646987464704, 1152624974353154048, 1150175648716701696);
INSERT INTO db_sra_v2.sys_user_role (id, user_id, role_id) VALUES (1152688668042870784, 1152624974256685056, 1150175648716701696);
INSERT INTO db_sra_v2.sys_user_role (id, user_id, role_id) VALUES (1152688719838330880, 1152624974042775552, 1150175648716701696);
INSERT INTO db_sra_v2.sys_user_role (id, user_id, role_id) VALUES (1152688743691337728, 1152624973950500864, 1150175648716701696);
INSERT INTO db_sra_v2.sys_user_role (id, user_id, role_id) VALUES (1152688761110282240, 1152624974156021760, 1150175648716701696);
INSERT INTO db_sra_v2.sys_user_role (id, user_id, role_id) VALUES (1155920405673545728, 1155920405505773568, 1150175648716701696);
