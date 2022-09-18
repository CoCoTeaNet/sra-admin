create table sche_job_log
(
    ID                varchar(32)      not null comment '主键ID'
        primary key,
    JOB_ID            varchar(32)      not null comment '任务ID',
    TRIGGER_TIME      datetime         null comment '任务触发时间',
    TRIGGER_BY        varchar(32)      null comment '任务触发人',
    EXE_RESULT        char             null comment '任务执行结果;0失败 1成功',
    SPEND_TIME_MILLIS bigint           null comment '任务执行耗时ms',
    FINISH_TIME       datetime         null comment '任务完成时间',
    CREATE_TIME       datetime         null comment '创建时间',
    CREATE_BY         varchar(32)      null comment '创建人',
    UPDATE_TIME       datetime         null comment '更新时间',
    UPDATE_BY         varchar(32)      null comment '更新人',
    DELETE_STATUS     char default '0' not null comment '删除状态;0删除 1未删除',
    REVISION          int              null comment '乐观锁',
    SORT              int              null comment '排序'
)
    comment '计划任务执行日志表';
