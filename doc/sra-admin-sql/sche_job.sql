create table sche_job
(
    ID              varchar(32)   not null comment '主键id'
        primary key,
    NAME            varchar(90)   not null comment '任务名称',
    TYPE            int default 0 not null comment '配置类型;0类模式 1函数模式',
    CLASS_NAME      varchar(500)  null comment '任务对应类名',
    METHOD_NAME     varchar(200)  null comment '方法名',
    PARAMETERS      varchar(900)  null comment '参数JSON对象',
    CORN_EXPRESSION varchar(64)   not null comment 'Cron表达式',
    DESCRIPTION     varchar(900)  null comment '任务描述',
    ACTIVE          int default 0 not null comment '是否启用;0未启用 1启用',
    NEXT_EXE_TIME   datetime      null comment '下一次执行时间',
    CREATE_TIME     datetime      not null comment '创建时间',
    CREATE_BY       varchar(32)   not null comment '创建人',
    UPDATE_TIME     datetime      null comment '更新时间',
    UPDATE_BY       varchar(32)   null comment '更新人',
    DELETE_STATUS   int default 0 not null comment '删除状态;0删除 1未删除',
    REVISION        int           null comment '乐观锁',
    SORT            int           null comment '排序'
)
    comment '计划任务表';

INSERT INTO DB_SRA_V1.sche_job (ID, NAME, TYPE, CLASS_NAME, METHOD_NAME, PARAMETERS, CORN_EXPRESSION, DESCRIPTION, ACTIVE, NEXT_EXE_TIME, CREATE_TIME, CREATE_BY, UPDATE_TIME, UPDATE_BY, DELETE_STATUS, REVISION, SORT) VALUES ('3d1f9250e1a74981acafbbe34b0fad3c', '文章内容爬取任务', 1, 'jobs.net.cocotea.schedule.ContentSpider', 'test', '{"param":"this is params."}', '0/2 * * * * ?', 'testtesttesttest', 0, null, '2022-09-03 16:01:42', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-09-23 03:01:38', '7d7f2f72dd0e4b6080373a3cc1469a15', 1, null, 1);
INSERT INTO DB_SRA_V1.sche_job (ID, NAME, TYPE, CLASS_NAME, METHOD_NAME, PARAMETERS, CORN_EXPRESSION, DESCRIPTION, ACTIVE, NEXT_EXE_TIME, CREATE_TIME, CREATE_BY, UPDATE_TIME, UPDATE_BY, DELETE_STATUS, REVISION, SORT) VALUES ('906c407f7a1b47ca85a9b75b765f4742', '任务测试2123123', 1, 'jobs.net.cocotea.schedule.MethodModeSample', 'run', '{"param":"123"}', '* * * * * ?', 'ojoaijdo', 0, null, '2022-09-03 09:32:15', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-09-18 14:08:29', '7d7f2f72dd0e4b6080373a3cc1469a15', 1, null, 1);
INSERT INTO DB_SRA_V1.sche_job (ID, NAME, TYPE, CLASS_NAME, METHOD_NAME, PARAMETERS, CORN_EXPRESSION, DESCRIPTION, ACTIVE, NEXT_EXE_TIME, CREATE_TIME, CREATE_BY, UPDATE_TIME, UPDATE_BY, DELETE_STATUS, REVISION, SORT) VALUES ('cac252c5dd7a47b8b6bfa0078fc8495f', '测试任务22', 0, 'com.sraapp.corn.Test1', 'test11111', '{id:''002''}', '1-2 * * * * *', 'cs2222222', 0, '2022-09-03 17:16:22', '2022-09-03 07:36:02', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-09-04 06:26:07', '7d7f2f72dd0e4b6080373a3cc1469a15', 0, null, 2);
