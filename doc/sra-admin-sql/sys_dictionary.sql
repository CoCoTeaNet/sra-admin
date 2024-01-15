create table sys_dictionary
(
    id              bigint            not null comment '字典id'
        primary key,
    parent_id       bigint            null comment '父级id',
    dictionary_name varchar(30)       not null comment '字典名称',
    remark          varchar(255)      null comment '备注',
    sort            int               not null comment '排序号',
    enable_status   tinyint default 1 null comment '启用状态;0关闭 1启用',
    create_by       bigint            not null comment '创建人',
    create_time     datetime          not null comment '创建时间',
    update_by       bigint            null comment '更新人',
    update_time     datetime          null comment '更新时间',
    is_deleted      tinyint default 0 not null comment '是否删除',
    revision        int               null comment '乐观锁'
)
    comment '系统字典表' engine = MyISAM
                         collate = utf8_unicode_ci
                         row_format = DYNAMIC;

INSERT INTO db_sra_v2.sys_dictionary (id, parent_id, dictionary_name, remark, sort, enable_status, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (1150473524625817600, 0, '院系', ' 院系名称：大学里的院系，院一般指的都是学院，比如管理学院、法学院这种，系指的就是院里面的专业，比如中文系、哲...', 0, 1, 1699771308310499328, '2023-09-10 16:51:03', 1699771308310499328, '2023-09-10 17:05:17', 0, null);
INSERT INTO db_sra_v2.sys_dictionary (id, parent_id, dictionary_name, remark, sort, enable_status, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (1150473797792448512, 1150473524625817600, '计算机学院', 'c#，c，c++', 1, 1, 1699771308310499328, '2023-09-10 16:52:08', 1699771308310499328, '2023-09-10 16:52:08', 0, null);
INSERT INTO db_sra_v2.sys_dictionary (id, parent_id, dictionary_name, remark, sort, enable_status, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (1150473906559139840, 0, '参数', null, 0, 1, 1699771308310499328, '2023-09-10 16:52:34', 1699771308310499328, '2023-09-10 16:56:17', 1, null);
INSERT INTO db_sra_v2.sys_dictionary (id, parent_id, dictionary_name, remark, sort, enable_status, create_by, create_time, update_by, update_time, is_deleted, revision) VALUES (1150475027587547136, 0, '学科分类', null, 0, 0, 1699771308310499328, '2023-09-10 16:57:01', 1699771308310499328, '2023-09-10 16:57:01', 0, null);
