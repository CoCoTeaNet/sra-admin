create table sys_file
(
    id          bigint            not null comment '文件id'
        primary key,
    file_name   varchar(200)      not null comment '文件名称',
    file_suffix varchar(20)       null comment '文件后缀',
    real_path   varchar(500)      not null comment '文件真实路径',
    file_size   bigint  default 0 not null comment '文件大小（单位：字节）',
    create_by   bigint            null comment '创建人',
    create_time datetime          not null comment '创建时间',
    update_by   bigint            null comment '更新人',
    update_time datetime          not null comment '更新时间',
    is_share    tinyint default 0 null comment '是否共享',
    is_deleted  tinyint default 0 not null comment '是否删除'
)
    comment '系统文件表' engine = MyISAM
                         collate = utf8_unicode_ci
                         row_format = DYNAMIC;

INSERT INTO db_sra_v2.sys_file (id, file_name, file_suffix, real_path, file_size, create_by, create_time, update_by, update_time, is_share, is_deleted) VALUES (1150533101132201984, '猫羽雫壁纸_彼岸壁纸', 'jpg', '2023/9/10/猫羽雫壁纸_彼岸壁纸.jpg', 662412, 1699771308310499328, '2023-09-10 20:47:48', 1699771308310499328, '2023-09-10 20:47:48', 0, 0);
INSERT INTO db_sra_v2.sys_file (id, file_name, file_suffix, real_path, file_size, create_by, create_time, update_by, update_time, is_share, is_deleted) VALUES (1154575840740130816, '微信图片_20230921232652.png', 'png', '2023/9/22/微信图片_20230921232652_650c700b2088b5d33677387f.png', 24243, 1699771308310499328, '2023-09-22 00:32:11', 1699771308310499328, '2023-09-22 00:58:24', 0, 1);
INSERT INTO db_sra_v2.sys_file (id, file_name, file_suffix, real_path, file_size, create_by, create_time, update_by, update_time, is_share, is_deleted) VALUES (1154575913314172928, '微信图片_20230921232652.png', 'png', '2023/9/22/微信图片_20230921232652_650c701c2088b5d336773880.png', 24243, 1699771308310499328, '2023-09-22 00:32:29', 1699771308310499328, '2023-09-22 00:58:22', 0, 1);
INSERT INTO db_sra_v2.sys_file (id, file_name, file_suffix, real_path, file_size, create_by, create_time, update_by, update_time, is_share, is_deleted) VALUES (1154576053034827776, '微信图片_20230921232652.png', 'png', '2023/9/22/微信图片_20230921232652_650c703e2088b5d336773881.png', 24243, 1699771308310499328, '2023-09-22 00:33:02', 1699771308310499328, '2023-09-22 00:58:20', 0, 1);
INSERT INTO db_sra_v2.sys_file (id, file_name, file_suffix, real_path, file_size, create_by, create_time, update_by, update_time, is_share, is_deleted) VALUES (1154582221815824384, '微信图片_20230921232652.png', 'png', '2023/9/22/微信图片_20230921232652_650c75fc20888f8e56b5c8c3.png', 24243, 1699771308310499328, '2023-09-22 00:57:33', 1699771308310499328, '2023-09-22 00:58:19', 0, 1);
INSERT INTO db_sra_v2.sys_file (id, file_name, file_suffix, real_path, file_size, create_by, create_time, update_by, update_time, is_share, is_deleted) VALUES (1154582467291660288, '微信图片_20230921232652.png', 'png', '2023/9/22/微信图片_20230921232652_650c763720888f8e56b5c8c4.png', 24243, 1699771308310499328, '2023-09-22 00:58:31', 1699771308310499328, '2023-09-22 00:58:31', 0, 0);
INSERT INTO db_sra_v2.sys_file (id, file_name, file_suffix, real_path, file_size, create_by, create_time, update_by, update_time, is_share, is_deleted) VALUES (1163273553241591808, '微信图片_20230921232652.png', 'png', '2023/10/16/微信图片_20230921232652_652c146b3bbfc42571d339a1.png', 24243, 1152624974256685056, '2023-10-16 00:33:48', 1152624974256685056, '2023-10-16 00:33:48', 0, 0);
