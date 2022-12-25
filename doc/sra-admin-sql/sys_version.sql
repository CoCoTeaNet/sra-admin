create table sys_version
(
    ID            varchar(32)  not null
        primary key,
    UPDATE_NO     varchar(20)  null comment '更新版本号',
    UPDATE_DESC   varchar(900) null comment '版本更新描述',
    PLATFORM_NAME varchar(10)  null comment '系统平台名称',
    DOWNLOAD_URL  varchar(200) null comment '下载地址',
    CREATE_BY     varchar(32)  not null comment '创建人',
    CREATE_TIME   datetime     not null comment '创建时间',
    UPDATE_BY     varchar(32)  not null comment '更新人',
    UPDATE_TIME   datetime     not null comment '更新时间'
)
    comment '系统版本更新记录表';

INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('1fc2b2e8b759487eb5d24a18da766724', 'v1.0.2', '1. 修复已知BUG & 优化UI.
2. 新增字典表维护.
3. 补充权限缓存以及角色鉴权.
4. 后台系统新增实体类代码生成器.
5. 增加操作日志功能.', 'web', '', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 00:45:15', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:03:23');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('235d7f32012145b8a7aa6e82c2fd1b3b', 'v1.1.1', '1. 修复已知BUG.
2. 优化UI界面.
3. 更改是否枚举标识.
4. 优化任务调度代码.', 'web', '', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:08:54', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:09:34');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('2add0d3910f640a3876009e49ad93494', 'v1.1.0', '1. 修复已知BUG.
2. 新增CMS模块.
3. 新增任务调度模块.
4. 更改GAV,优化UI界面.
5. 移除swagger.', 'web', '', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:05:43', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:06:25');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('3c882adf3ea040cfb32daf5fb0d11812', 'v1.1.3', '1.新增VO实体类代码生成；
2.新增版本号管理功能；', 'web', null, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:14:09', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:14:09');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('503e3cc107fd4e2991d8cf1423bbd4e6', 'v1.1.2', '1. 修复文件上传XSS安全漏洞.
2. 增加图片上传格式限制.
3. 升级springboot到2.7.4版本
4. 升级mysql连接器到8.0.30版本', 'web', null, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:10:07', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:10:07');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('6ee72c610c7d4d47bc1db567cebbaeac', 'v1.0.1', '基于SpringBoot，后端核心技术采用Sqltoy操作数据库以及Sa-Token鉴权，前端使用Vue3+TS+Element-plus。                   是一款前后端分离、开箱即用的后台权限管理系统。', 'web', 'https://gitee.com/momoljw/sss-rbac-admin', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-29 23:06:36', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:03:27');
INSERT INTO DB_SRA_V1.sys_version (ID, UPDATE_NO, UPDATE_DESC, PLATFORM_NAME, DOWNLOAD_URL, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME) VALUES ('d4b60c17d49248748d27a8332d9d02d5', 'v1.0.3', '1. 修复已知BUG.
2. 新增CMS模块.', 'web', '', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:03:17', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-10-30 03:07:54');
