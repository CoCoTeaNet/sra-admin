create table sys_role
(
    ID            varchar(32)  not null comment '主键id'
        primary key,
    REVISION      int          null comment '乐观锁',
    CREATE_BY     varchar(32)  not null comment '创建人',
    CREATE_TIME   datetime     not null comment '创建时间',
    UPDATE_BY     varchar(32)  null comment '更新人',
    UPDATE_TIME   datetime     null comment '更新时间',
    DELETE_STATUS int          not null comment '删除状态;0删除 1未删除',
    ROLE_NAME     varchar(30)  not null comment '角色名称',
    ROLE_KEY      varchar(255) not null comment '角色标识',
    SORT          int          not null comment '显示排序',
    REMARK        varchar(255) null comment '备注'
)
    comment '系统角色表';

INSERT INTO DB_SRA_V1.sys_role (ID, REVISION, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME, DELETE_STATUS, ROLE_NAME, ROLE_KEY, SORT, REMARK) VALUES ('43024d7981bc4c75af318186f890e0ea', null, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-08-25 20:45:05', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-08-25 20:45:05', 1, '演示账号', 'role:demo', 5, null);
INSERT INTO DB_SRA_V1.sys_role (ID, REVISION, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME, DELETE_STATUS, ROLE_NAME, ROLE_KEY, SORT, REMARK) VALUES ('501d753e66094872acb476c405712052', null, '1111111', '2022-01-20 07:53:29', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-09-30 16:28:45', 0, '超级管理员', 'role:super:admin', 0, null);
INSERT INTO DB_SRA_V1.sys_role (ID, REVISION, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME, DELETE_STATUS, ROLE_NAME, ROLE_KEY, SORT, REMARK) VALUES ('643ce9d62ee74c13b7e3977dd84bad7e', null, '520f60b987974cea847eb08c878adf00', '2022-01-22 13:14:56', '520f60b987974cea847eb08c878adf00', '2022-01-22 13:20:33', 1, '普通用户', 'role:simple:user', 1, null);
INSERT INTO DB_SRA_V1.sys_role (ID, REVISION, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME, DELETE_STATUS, ROLE_NAME, ROLE_KEY, SORT, REMARK) VALUES ('b7b3ee869e7a4fe394e9d7aeacec24ca', null, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-08-25 20:24:58', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-08-25 20:43:53', 0, 'asdasdad', 'asaaa', 1, null);
INSERT INTO DB_SRA_V1.sys_role (ID, REVISION, CREATE_BY, CREATE_TIME, UPDATE_BY, UPDATE_TIME, DELETE_STATUS, ROLE_NAME, ROLE_KEY, SORT, REMARK) VALUES ('c7e8c169248047209905d11abea0260c', null, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-27 05:52:01', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-27 05:52:01', 1, '系统管理员', 'role:simple:admin', 3, null);
