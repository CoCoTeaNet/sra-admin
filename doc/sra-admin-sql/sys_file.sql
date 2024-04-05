create table sys_file
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

