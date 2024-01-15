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

INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459720, 1699771910151151616, 1150555102374805504);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459719, 1699771910151151616, 1150484898768764928);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459718, 1699771910151151616, 1150500181449392128);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152708680044527620, 1150175648716701696, 1150551297079918592);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459717, 1699771910151151616, 1150464392514519040);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459716, 1699771910151151616, 1150130227206176768);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459715, 1699771910151151616, 1150266364558065664);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459714, 1699771910151151616, 1699771910151151618);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459713, 1699771910151151616, 1150191026649972736);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152708680044527619, 1150175648716701696, 1150500181449392128);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152708680044527618, 1150175648716701696, 1150129636463624192);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152708680044527617, 1150175648716701696, 1150563411119063040);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459712, 1699771910151151616, 1150560507641479168);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459721, 1699771910151151616, 1152680658427985920);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152680757929459722, 1699771910151151616, 1152680259889414144);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152708680044527616, 1150175648716701696, 1152708188493070336);
INSERT INTO db_sra_v2.sys_role_menu (id, role_id, menu_id) VALUES (1152708680044527621, 1150175648716701696, 1152680259889414144);
