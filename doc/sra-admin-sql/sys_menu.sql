create table sys_menu
(
    id               bigint            not null comment '菜单id'
        primary key,
    menu_name        varchar(30)       not null comment '菜单名称',
    permission_code  varchar(64)       null comment '权限编号',
    router_path      varchar(255)      null comment '路由地址',
    parent_id        bigint            null comment '父级id',
    menu_type        tinyint           null comment '按钮类型;0目录 1菜单 2按钮',
    is_menu          tinyint           null comment '是否菜单',
    menu_status      tinyint default 0 null comment '菜单状态：0显示 1隐藏',
    component_path   varchar(64)       null comment '组件路径',
    is_external_link tinyint default 0 null comment '是否外链',
    icon_path        varchar(255)      null comment '菜单图标',
    sort             int               null comment '显示顺序',
    create_by        bigint            not null comment '创建人',
    create_time      datetime          not null comment '创建时间',
    update_by        bigint            null comment '更新人',
    update_time      datetime          null comment '更新时间',
    is_deleted       tinyint default 0 not null comment '是否删除',
    revision         int               null comment '乐观锁'
)
    comment '系统菜单表' engine = MyISAM
                         collate = utf8_unicode_ci
                         row_format = DYNAMIC;

INSERT INTO db_sra_v2.sys_menu (id, menu_name, permission_code, router_path, parent_id, menu_type, is_menu, menu_status, component_path, is_external_link, icon_path, sort, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (100, '菜单管理', 'system:admin:menu', '/admin/sys-menu-manager', 0, 1, 1, 0, '3', 0, 'Menu', 65, 1699771308310499328, '2022-03-08 05:57:24', 1699771308310499328, '2023-09-10 23:08:58', 0, null);
INSERT INTO db_sra_v2.sys_menu (id, menu_name, permission_code, router_path, parent_id, menu_type, is_menu, menu_status, component_path, is_external_link, icon_path, sort, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (101, '个人中心', ':admin:user-center', '/admin/sys-user-center', 0, 1, 1, 0, '', 0, 'Apple', 98, 1699771308310499328, '2023-09-09 18:04:34', 1699771308310499328, '2023-09-10 23:05:45', 0, null);
INSERT INTO db_sra_v2.sys_menu (id, menu_name, permission_code, router_path, parent_id, menu_type, is_menu, menu_status, component_path, is_external_link, icon_path, sort, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (102, '角色管理', ':admin:role-manager', '/admin/sys-role-manager', 0, 1, 1, 0, '', 0, 'UserFilled', 60, 1699771308310499328, '2023-09-09 18:06:55', 1699771308310499328, '2023-09-10 23:06:34', 0, null);
INSERT INTO db_sra_v2.sys_menu (id, menu_name, permission_code, router_path, parent_id, menu_type, is_menu, menu_status, component_path, is_external_link, icon_path, sort, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (103, '用户管理', ':admin:user-manager', '/admin/sys-user-manager', 0, 1, 1, 0, '', 0, 'User', 70, 1699771308310499328, '2023-09-09 22:08:30', 1699771308310499328, '2023-09-10 23:06:39', 0, null);
INSERT INTO db_sra_v2.sys_menu (id, menu_name, permission_code, router_path, parent_id, menu_type, is_menu, menu_status, component_path, is_external_link, icon_path, sort, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (104, '权限管理', ':admin:permission-manager', '/admin/sys-permission-manager', 0, 1, 1, 0, '', 0, 'Operation', 63, 1699771308310499328, '2023-09-10 03:07:52', 1699771308310499328, '2023-09-10 23:11:33', 0, null);
INSERT INTO db_sra_v2.sys_menu (id, menu_name, permission_code, router_path, parent_id, menu_type, is_menu, menu_status, component_path, is_external_link, icon_path, sort, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (105, '字典管理', ':admin:dictionary-manager', '/admin/sys-dictionary-manager', 0, 1, 1, 0, '', 0, 'Notebook', 50, 1699771308310499328, '2023-09-10 16:14:46', 1699771308310499328, '2023-09-10 23:12:06', 0, null);
INSERT INTO db_sra_v2.sys_menu (id, menu_name, permission_code, router_path, parent_id, menu_type, is_menu, menu_status, component_path, is_external_link, icon_path, sort, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (106, '系统日志', ':admin:log-manager', '/admin/sys-log-manager', 0, 1, 1, 0, '', 0, 'Monitor', 10, 1699771308310499328, '2023-09-10 17:36:15', 1699771308310499328, '2023-09-10 23:07:32', 0, null);
INSERT INTO db_sra_v2.sys_menu (id, menu_name, permission_code, router_path, parent_id, menu_type, is_menu, menu_status, component_path, is_external_link, icon_path, sort, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (107, '文件管理', ':admin:sys-file-manager', '/admin/sys-file-manager', 0, 1, 1, 0, '', 0, 'FolderOpened', 20, 1699771308310499328, '2023-09-10 18:36:59', 1699771308310499328, '2023-09-10 23:11:52', 0, null);
INSERT INTO db_sra_v2.sys_menu (id, menu_name, permission_code, router_path, parent_id, menu_type, is_menu, menu_status, component_path, is_external_link, icon_path, sort, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (108, '文件回收站', ':admin:sys-recycle-manage', '/admin/sys-recycle-manager', 0, 1, 1, 0, '', 0, 'FolderDelete', 15, 1699771308310499328, '2023-09-10 22:00:05', 1699771308310499328, '2023-09-10 23:11:12', 0, null);
INSERT INTO db_sra_v2.sys_menu (id, menu_name, permission_code, router_path, parent_id, menu_type, is_menu, menu_status, component_path, is_external_link, icon_path, sort, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (109, '版本管理', ':admin:sys-version-manager', '/admin/sys-version-manager', 0, 1, 1, 0, '', 0, 'MostlyCloudy', 9, 1699771308310499328, '2023-09-10 22:15:13', 1699771308310499328, '2023-09-10 23:12:17', 0, null);
INSERT INTO db_sra_v2.sys_menu (id, menu_name, permission_code, router_path, parent_id, menu_type, is_menu, menu_status, component_path, is_external_link, icon_path, sort, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (110, '服务监控', ':admin:dashboard', '/admin/dashboard', 0, 1, 1, 0, '', 0, 'Monitor', 99, 1699771308310499328, '2023-09-10 22:36:41', 1699771308310499328, '2023-09-10 22:51:35', 0, null);
INSERT INTO db_sra_v2.sys_menu (id, menu_name, permission_code, router_path, parent_id, menu_type, is_menu, menu_status, component_path, is_external_link, icon_path, sort, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (111, '系统首页', ':admin:home', '/admin/home', 0, 1, 1, 0, '', 0, 'HomeFilled', 100, 1699771308310499328, '2023-09-10 22:48:14', 1699771308310499328, '2023-09-10 23:05:56', 0, null);
