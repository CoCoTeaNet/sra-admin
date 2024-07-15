create table if not exists sys_dictionary
(
    id              bigint            not null comment '字典id'
        primary key,
    parent_id       bigint            null comment '父级id',
    dictionary_name varchar(30)       not null comment '字典名称',
    remark          varchar(255)      null comment '备注',
    sort            int               not null comment '排序号',
    enable_status   tinyint default 1 null comment '启用状态;0关闭 1启用',
    create_by       bigint            not null comment '创建人',
    create_time     datetime          not null comment '创建时间',
    update_by       bigint            null comment '更新人',
    update_time     datetime          null comment '更新时间',
    is_deleted      tinyint default 0 not null comment '是否删除',
    revision        int               null comment '乐观锁'
)
    comment '系统字典表' engine = MyISAM
                         collate = utf8_unicode_ci
                         row_format = DYNAMIC;

create table if not exists sys_file
(
    id          bigint            not null comment '文件id'
        primary key,
    file_name   varchar(200)      not null comment '文件名称',
    file_suffix varchar(20)       null comment '文件后缀',
    real_path   varchar(500)      not null comment '文件真实路径',
    file_size   bigint  default 0 not null comment '文件大小（单位：字节）',
    create_by   bigint            null comment '创建人',
    create_time datetime          not null comment '创建时间',
    update_by   bigint            null comment '更新人',
    update_time datetime          not null comment '更新时间',
    is_share    tinyint default 0 null comment '是否共享',
    is_deleted  tinyint default 0 not null comment '是否删除'
)
    comment '系统文件表' engine = MyISAM
                         collate = utf8_unicode_ci
                         row_format = DYNAMIC;

create table if not exists sys_log
(
    id          bigint       not null comment '日志编号'
        primary key,
    ip_address  varchar(128) not null comment '请求ip地址',
    operator    bigint       null comment '操作人员',
    request_way varchar(10)  not null comment '请求方式',
    log_status  tinyint      null comment '日志状态;0异常 1成功',
    log_type    tinyint      null comment '日志类型：1登录 2操作 ',
    api_path    varchar(255) null comment '接口请求路径',
    create_time datetime     not null comment '创建时间'
)
    comment '系统操作日志表' engine = MyISAM
                             collate = utf8_unicode_ci
                             row_format = DYNAMIC;

create index sys_log_request_way_index
    on sys_log (request_way);

create table if not exists sys_menu
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

create table if not exists sys_notify
(
    id          bigint                                  not null comment '通知ID'
        primary key,
    title       varchar(200)                            not null comment '通知标题',
    memo        varchar(900)                            null comment '消息内容',
    jump_url    varchar(200)                            null comment '跳转链接、ID、等等',
    notify_type varchar(20)                             not null comment '通知类型',
    is_global   tinyint   default 0                     not null comment '是否全局',
    receiver    bigint                                  null comment '接收人',
    level       tinyint   default 1                     not null comment '通知等级',
    notify_time timestamp default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '通知时间',
    create_by   bigint                                  null comment '创建人',
    create_time timestamp default '0000-00-00 00:00:00' not null comment '创建时间',
    is_deleted  tinyint   default 0                     not null comment '是否删除'
)
    comment '系统通知表' collate = utf8_unicode_ci;

create index sys_notify_idx1
    on sys_notify (notify_type, is_deleted, create_time);

create index sys_notify_idx2
    on sys_notify (receiver);

create table if not exists sys_role
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

create table if not exists sys_role_menu
(
    id      bigint not null comment '角色菜单关联id'
        primary key,
    role_id bigint not null comment '角色id',
    menu_id bigint not null comment '菜单id'
)
    comment '角色菜单关联表' engine = MyISAM
                             collate = utf8_unicode_ci
                             row_format = DYNAMIC;

create table if not exists sys_theme
(
    id            bigint            not null comment '系统主题id'
        primary key,
    user_id       bigint            null comment '用户id',
    layout_mode   tinyint default 0 not null comment '布局模式：0默认',
    primary_color varchar(8)        null comment '主题颜色',
    color_2       varchar(8)        null comment '颜色2',
    color_3       varchar(8)        null comment '颜色3',
    color_4       varchar(8)        null comment '颜色4',
    is_dark       tinyint default 0 null comment '是否暗黑模式'
)
    comment '系统主题表' engine = MyISAM
                         collate = utf8_unicode_ci
                         row_format = DYNAMIC;

create table if not exists sys_user
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

create table if not exists sys_user_role
(
    id      bigint not null comment '用户角色关联id'
        primary key,
    user_id bigint not null comment '用户id',
    role_id bigint not null comment '角色id'
)
    comment '用户角色关联表' engine = MyISAM
                             collate = utf8_unicode_ci
                             row_format = DYNAMIC;

create table if not exists sys_version
(
    id            bigint       not null comment '版本id'
        primary key,
    update_no     varchar(20)  null comment '更新版本号',
    update_desc   varchar(900) null comment '版本更新描述',
    platform_name varchar(10)  null comment '系统平台名称',
    download_url  varchar(200) null comment '下载地址',
    create_by     bigint       not null comment '创建人',
    create_time   datetime     not null comment '创建时间',
    update_by     bigint       null comment '更新人',
    update_time   datetime     null comment '更新时间'
)
    comment '系统版本更新记录表' engine = MyISAM
                                 collate = utf8_unicode_ci
                                 row_format = DYNAMIC;

