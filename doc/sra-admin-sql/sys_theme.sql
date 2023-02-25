create table sys_theme
(
    ID            varchar(32)          not null comment '系统主题ID'
        primary key,
    USER_ID       varchar(32)          null comment '用户ID',
    LAYOUT_MODE   tinyint(1) default 0 not null comment '布局模式：0默认',
    PRIMARY_COLOR varchar(8)           null comment '主题颜色',
    IS_DARK       tinyint(1) default 0 null comment '是否暗黑模式：0否 1是'
)
    comment '系统主题表';
