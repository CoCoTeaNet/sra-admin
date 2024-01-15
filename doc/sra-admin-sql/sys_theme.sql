create table sys_theme
(
    id            bigint            not null comment '系统主题id'
        primary key,
    user_id       bigint            null comment '用户id',
    layout_mode   tinyint default 0 not null comment '布局模式：0默认',
    primary_color varchar(8)        null comment '主题颜色',
    color_2       varchar(8)        null comment '颜色2',
    color_3       varchar(8)        null comment '颜色3',
    color_4       varchar(8)        null comment '颜色4',
    is_dark       tinyint default 0 null comment '是否暗黑模式'
)
    comment '系统主题表' engine = MyISAM
                         collate = utf8_unicode_ci
                         row_format = DYNAMIC;

