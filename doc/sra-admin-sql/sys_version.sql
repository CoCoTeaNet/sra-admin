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

INSERT INTO db_sra_v2.sys_version (id, update_no, update_desc, platform_name, download_url, create_by, create_time, update_by, update_time) VALUES (1150555582509367296, 'v2.0.0', '1. SpringBoot升到3.x并且相关核心框架保持兼容
2. 整体架构重新优化
3. 主键ID使用连续不重复的雪花算法 
4. 移除前端项目，但后台提供在线api文档（前端项目将移动到另一个仓库）
5. 登录界面优化
6. 移除调度模块和内容管理模块（考虑插件模式引入）
7. 数据库结构优化 
8. 尽量使用sqltoy-plus来读取数据，兼容多种数据库
9. 引入smart-doc无侵入代码生成接口文档', 'web', 'https://gitee.com/momoljw/sss-rbac-admin/tree/v2-master/', 1699771308310499328, '2023-09-10 22:17:07', 1699771308310499328, '2024-04-22 15:40:31');
