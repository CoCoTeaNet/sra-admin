create table sys_role_menu
(
    id      bigint not null comment '角色菜单关联id'
        primary key,
    role_id bigint not null comment '角色id',
    menu_id bigint not null comment '菜单id'
)
    comment '角色菜单关联表' engine = MyISAM
                             collate = utf8_unicode_ci
                             row_format = DYNAMIC;

INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459720, 100, 100);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459719, 100, 101);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459718, 100, 102);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152708680044527620, 100, 103);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459717, 100, 104);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459716, 100, 105);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459715, 100, 106);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459714, 100, 107);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459713, 100, 108);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152708680044527619, 100, 109);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152708680044527618, 100, 110);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152708680044527617, 100, 111);
