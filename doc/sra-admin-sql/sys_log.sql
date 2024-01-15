create table sys_log
(
    id          bigint       not null comment '日志编号'
        primary key,
    ip_address  varchar(128) not null comment '请求ip地址',
    operator    bigint       null comment '操作人员',
    request_way varchar(10)  not null comment '请求方式',
    log_status  tinyint      null comment '日志状态;0异常 1成功',
    log_type    tinyint      null comment '日志类型：1登录 2操作 ',
    create_time datetime     not null comment '创建时间'
)
    comment '系统操作日志表' engine = MyISAM
                             collate = utf8_unicode_ci
                             row_format = DYNAMIC;

create index sys_log_request_way_index
    on sys_log (request_way);
