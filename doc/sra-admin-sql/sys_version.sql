create table sys_version
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

INSERT INTO db_sra_v2.sys_version (id, update_no, update_desc, platform_name, download_url, create_by, create_time, update_by, update_time) VALUES (1150555582509367296, 'v2.0.0', '全新全新全新全新全新全新全新全新全新', 'web', 'https://gitee.com/momoljw/db_sra_v2', 1699771308310499328, '2023-09-10 22:17:07', 1699771308310499328, '2023-09-10 22:31:31');
