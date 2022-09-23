create table sys_operation_log
(
    ID                varchar(32)  not null comment '主键id'
        primary key,
    LOG_NUMBER        bigint       not null comment '日志编号',
    IP_ADDRESS        varchar(128) not null comment '请求IP地址',
    OPERATOR          varchar(32)  null comment '操作人员',
    REQUEST_WAY       varchar(10)  not null comment '请求方式',
    OPERATION_STATUS  int          null comment '操作状态;0异常 1成功',
    SYSTEM_MODULE     varchar(100) null comment '系统模块',
    OPERATION_TYPE    int          null comment '操作类型;0登录日志 1操作日志',
    OPERATION_ADDRESS varchar(512) null comment '操作地点',
    LOG_TYPE          int          null comment '日志类型',
    OPERATION_TIME    datetime     null comment '操作时间',
    SORT              int          null comment '排序'
)
    comment '系统操作日志表';

create index sys_operation_log_REQUEST_WAY_index
    on sys_operation_log (REQUEST_WAY);

INSERT INTO DB_SRA_V1.sys_operation_log (ID, LOG_NUMBER, IP_ADDRESS, OPERATOR, REQUEST_WAY, OPERATION_STATUS, SYSTEM_MODULE, OPERATION_TYPE, OPERATION_ADDRESS, LOG_TYPE, OPERATION_TIME, SORT) VALUES ('000285783c394ec6a4096e4d7ef11ab8', 1663143386096, '101.39.212.230', '7d7f2f72dd0e4b6080373a3cc1469a15', 'POST', 1, null, null, null, 0, '2022-09-14 08:16:26', null);
INSERT INTO DB_SRA_V1.sys_operation_log (ID, LOG_NUMBER, IP_ADDRESS, OPERATOR, REQUEST_WAY, OPERATION_STATUS, SYSTEM_MODULE, OPERATION_TYPE, OPERATION_ADDRESS, LOG_TYPE, OPERATION_TIME, SORT) VALUES ('00178285c3974e80ae76762edfb2a314', 1657378151167, '192.168.31.242', '7d7f2f72dd0e4b6080373a3cc1469a15', 'POST', 1, null, null, null, 1, '2022-07-09 14:49:11', null);
