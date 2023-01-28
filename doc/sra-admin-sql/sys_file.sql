create table sys_file
(
    ID            varchar(32)      not null comment '主键ID'
        primary key,
    FILE_NAME     varchar(200)     not null comment '文件名称',
    FILE_SUFFIX   varchar(20)      null comment '文件后缀',
    REAL_PATH     varchar(500)     not null comment '文件真实路径',
    BROWSE_PATH   varchar(500)     not null comment '浏览路径',
    FULL_PATH     varchar(900)     not null comment '文件访问地址',
    FILE_SIZE     bigint default 0 not null comment '文件大小（单位：字节）',
    CREATE_BY     varchar(32)      null comment '创建人',
    CREATE_TIME   datetime         not null comment '创建时间',
    UPDATE_BY     varchar(32)      null comment '更新人',
    UPDATE_TIME   datetime         not null comment '更新时间',
    DELETE_STATUS tinyint          not null comment '删除状态：0删除 1未删除'
)
    comment '系统文件表';
