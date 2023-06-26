create table sys_theme
(
    ID            varchar(32)          not null comment '系统主题ID'
        primary key,
    USER_ID       varchar(32)          null comment '用户ID',
    LAYOUT_MODE   tinyint(1) default 0 not null comment '布局模式：0默认',
    PRIMARY_COLOR varchar(8)           null comment '主题颜色',
    COLOR_2       varchar(8)           null comment '颜色2',
    COLOR_3       varchar(8)           null comment '颜色3',
    COLOR_4       varchar(8)           null comment '颜色4',
    IS_DARK       tinyint(1) default 0 null comment '是否暗黑模式：0否 1是'
)
    comment '系统主题表' engine = InnoDB;

INSERT INTO DB_SRA_V1.sys_theme (ID, USER_ID, LAYOUT_MODE, PRIMARY_COLOR, COLOR_2, COLOR_3, COLOR_4, IS_DARK) VALUES ('578b3d8484d24612943c871bd1f4dc55', '7d7f2f72dd0e4b6080373a3cc1469a15', 0, '#409EFF', '#a0cfff', '#337ecc', '#ecf5ff', 0);
