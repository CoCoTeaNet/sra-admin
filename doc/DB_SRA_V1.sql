/*
 Navicat Premium Data Transfer

 Source Server         : 106.52.139.93
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 106.52.139.93:3306
 Source Schema         : DB_SRA_V1

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 16/05/2022 17:06:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary`  (
  `ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键id',
  `PARENT_ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '父级ID',
  `DICTIONARY_NAME` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '字典名称',
  `REMARK` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  `SORT` int(0) NOT NULL COMMENT '排序号',
  `ENABLE_STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '启用状态;0关闭 1启用',
  `REVISION` int(0) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATE_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '创建人',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `DELETE_STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '删除状态;0删除 1未删除',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系统字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
INSERT INTO `sys_dictionary` VALUES ('05def4554a16480c92377acd67b21cef', '0', '全部院系', '', 3, '0', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-27 14:45:42', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-27 14:46:03', '1');
INSERT INTO `sys_dictionary` VALUES ('5226cbcb04584f799abc06b4fadeade0', '579daa1a65f6456e950f7c61f7df77cd', '项目拓展部', '', 2, '0', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-27 14:47:34', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-27 14:47:34', '1');
INSERT INTO `sys_dictionary` VALUES ('579daa1a65f6456e950f7c61f7df77cd', '0', '部门分类', '查看所有部门', 2, '0', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-27 14:44:50', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-27 14:47:09', '1');
INSERT INTO `sys_dictionary` VALUES ('6f068ff4d4ff496d8c8a43405eb99b25', '05def4554a16480c92377acd67b21cef', '计算机学院', '', 2, '0', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-27 14:46:25', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-27 14:46:25', '1');
INSERT INTO `sys_dictionary` VALUES ('9f22ba4ab59e466eaee9ccba2357a27e', 'f993cb81867b47748ffb0fd5c3a1ded1', '二叉树', '010101', 1, '0', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-27 14:24:44', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-27 14:44:18', '1');
INSERT INTO `sys_dictionary` VALUES ('b24e71a2d2ef451fbd964631ed3e7795', '0', 'aaaaaaaaaaaaaaaaaaa', '', 1, '0', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-27 14:30:28', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-27 14:37:34', '0');
INSERT INTO `sys_dictionary` VALUES ('b30c033dbfe049ea8fef11100b6dfa21', '05def4554a16480c92377acd67b21cef', '财经学院', '', 2, '0', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-27 14:46:32', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-27 14:46:32', '1');
INSERT INTO `sys_dictionary` VALUES ('f993cb81867b47748ffb0fd5c3a1ded1', '0', '树分类', 'tttttt', 1, '0', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-26 04:02:57', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-27 14:29:59', '1');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键id',
  `REVISION` int(0) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATE_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '创建人',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `DELETE_STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '删除状态;0删除 1未删除',
  `MENU_NAME` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '菜单名称',
  `PERMISSION_CODE` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '权限编号',
  `ROUTER_PATH` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '路由地址',
  `PARENT_ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '父主键ID',
  `MENU_TYPE` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '按钮类型;0目录 1菜单 2按钮',
  `IS_MENU` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否菜单',
  `MENU_STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单状态：0显示&启用 1隐藏&关闭 2显示&关闭 3隐藏&启用',
  `SORT` int(0) NOT NULL COMMENT '显示顺序',
  `COMPONENT_PATH` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '组件路径',
  `IS_EXTERNAL_LINK` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否外链;0是 1否',
  `ICON_PATH` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单图标',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系统菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('060af5d6d35741efb141bd6599c44d9d', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 08:01:29', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 08:01:35', '0', '撒擦拭擦', '', NULL, '0', '0', '1', '0', 1, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('07d966031dee4f448ac887eb458c18d9', NULL, '1111111', '2022-01-17 11:43:37', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-23 02:01:42', '1', '角色管理', 'system:admin:role', '/admin/role-manager', '22e97a24b6754a92864f2f358bc46185', '1', '0', '0', 2, '@/views/system/role/index', '1', 'User');
INSERT INTO `sys_menu` VALUES ('092aea434b7f48579c65ff0f4589bcb8', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-05-01 13:59:28', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-05-01 13:59:28', '1', '日志管理', ':admin:operation-log-manager', '/admin/operation-log-manager', '22e97a24b6754a92864f2f358bc46185', '0', '0', '0', 6, NULL, '1', 'ChatDotSquare');
INSERT INTO `sys_menu` VALUES ('0deb2ec9bed34959a76b7d2fcfd056f4', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-30 08:17:22', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-17 03:17:14', '1', '修改用户权限', 'system:user:update', '/user/update', '549ba4d9446f4b8da409b45488242808', '2', '1', '0', 2, '', '1', '');
INSERT INTO `sys_menu` VALUES ('171d885a56b5412fbcf4982a42a81149', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-26 03:30:14', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-26 03:38:16', '1', '新增用户权限', 'system:user:add', 'user/add', '549ba4d9446f4b8da409b45488242808', '1', '1', '0', 2, '', '1', '');
INSERT INTO `sys_menu` VALUES ('22e97a24b6754a92864f2f358bc46185', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-10 08:00:25', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-19 12:42:24', '1', '系统管理', 'system:admin:manager', '  ', '0', '0', '0', '0', 2, 'aaaaaaa', '1', 'Compass');
INSERT INTO `sys_menu` VALUES ('2483fba39ec34e1cbf171b8c877f844f', NULL, '1111111', '2022-01-17 06:36:35', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-08 05:57:24', '1', '菜单管理', 'system:admin:menu', '/admin/menu-manager', '22e97a24b6754a92864f2f358bc46185', '1', '0', '0', 3, '@/views/system/menu/index', '1', 'Menu');
INSERT INTO `sys_menu` VALUES ('2b7c48936fe24e3bb1691f2d267859e3', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-24 15:30:13', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-24 15:30:13', '1', '字典管理', '', NULL, '3b073e1797ba415fbc42367c4a0c855c', '0', '1', '0', 1, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('3368ccadab224fdaacf8d13ba3e37ed3', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-31 10:49:40', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-23 03:59:23', '1', '统计数量接口', 'system:dashboard:getCount', 'dashboard/getCount', '0', '2', '1', '0', 2, '', '1', '');
INSERT INTO `sys_menu` VALUES ('3b073e1797ba415fbc42367c4a0c855c', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 03:44:41', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 07:56:14', '1', '系统管理', '  ', NULL, '0', '0', '1', '0', 1, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('4350efd82f3240e39055e81118045069', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-04-20 14:35:59', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-04-20 14:35:59', '1', '系统工具', 'code-generator', 'code-generator', '0', '0', '0', '0', 3, NULL, '1', 'Tools');
INSERT INTO `sys_menu` VALUES ('43be00e9a9fc4aa080aca3bed0e38dd6', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-10 07:54:49', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-04-02 06:20:12', '1', '404页面', 'system:admin:setting', '/admin/sys-404', '0', '1', '0', '0', 3, 'empty', '1', 'Bell');
INSERT INTO `sys_menu` VALUES ('4815bf75f9eb4a2283c9aa1ab531b3b5', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-24 15:26:00', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-27 15:29:02', '1', '字典管理', ':admin:dictionary-manager', '/admin/dictionary-manager', '22e97a24b6754a92864f2f358bc46185', '1', '0', '0', 4, NULL, '1', 'Files');
INSERT INTO `sys_menu` VALUES ('549ba4d9446f4b8da409b45488242808', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-17 03:14:56', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 07:38:16', '1', '用户权限', '   ', '/system/user/dir', '3b073e1797ba415fbc42367c4a0c855c', '1', '1', '0', 1, '', '1', 'mdi-account-key');
INSERT INTO `sys_menu` VALUES ('54e5e036304f4374ad7749535ae42ef8', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-04-02 06:08:14', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-04-02 06:09:16', '0', '测试隐藏按钮', ':no', '/no', '0', '2', '0', '2', 4, NULL, '1', '');
INSERT INTO `sys_menu` VALUES ('5929445bda3b4748a7c58271d619e940', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-24 15:30:37', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-24 15:31:10', '1', '新增字典', 'system:dictionary:add', NULL, '2b7c48936fe24e3bb1691f2d267859e3', '1', '1', '0', 1, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('6ea46c55bae64af5bc84fb62cb17d157', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-24 15:31:03', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-24 15:31:17', '1', '批量删除', 'system:dictionary:deleteBatch', NULL, '2b7c48936fe24e3bb1691f2d267859e3', '1', '1', '0', 2, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('740548e309f0421098cc1abeedce62f8', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-24 15:32:13', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-24 15:32:13', '1', '列表树字典', 'system:dictionary:listByTree', NULL, '2b7c48936fe24e3bb1691f2d267859e3', '1', '1', '0', 4, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('8fc7451c40784a319279e6e80f44c0de', NULL, '1111111', '2022-01-17 06:25:47', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-04-09 14:28:40', '1', '后台首页', 'system:admin:home', '  ', '0', '0', '0', '0', 1, '@/views/system/home', '1', 'Grid');
INSERT INTO `sys_menu` VALUES ('9aa65aed2def4639a10301bec890c6ce', NULL, '9a101f6fca234002bfa95ecc98fcc6ab', '2022-01-25 07:03:12', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-17 03:17:11', '1', '分页用户权限', 'system:user:listByPage', '/user/listByPage', '549ba4d9446f4b8da409b45488242808', '1', '1', '0', 7, 'nothing', '0', '');
INSERT INTO `sys_menu` VALUES ('9beeb4f8628e477b8e5f853fba5aeec0', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 08:09:55', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-05-10 19:39:21', '1', '系统首页', ':admin:home', '/admin/home', '8fc7451c40784a319279e6e80f44c0de', '1', '0', '0', 1, NULL, '1', 'HomeFilled');
INSERT INTO `sys_menu` VALUES ('a1ae4bc73605499c9ad53363e65fdc4f', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-09 15:34:44', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-09 07:18:37', '1', '获取系统信息', 'system:dashboard:getSystemInfo', '/dashboard/getSystemInfo', '0', '2', '1', '0', 1, '', '1', '');
INSERT INTO `sys_menu` VALUES ('b44d335e217c4ac9af095477d9db31ff', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-11 08:21:59', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-23 01:47:16', '1', '仪表盘', 'system:admin:home', '/admin/dashboard', '8fc7451c40784a319279e6e80f44c0de', '1', '0', '0', 2, '@/views/system/home', '1', 'DataBoard');
INSERT INTO `sys_menu` VALUES ('b5b46dac10974d09a59e682c86cb5a57', NULL, '1111111', '2022-01-19 13:29:49', '1111111', '2022-01-19 13:29:49', '1', 'FFFFFFFFFF', 'system:admin:menu', '/admin/menu', '8f7512985da7471b92ac127b01add25d', '1', '0', '0', 3, '@/views/system/menu/index', '1', '');
INSERT INTO `sys_menu` VALUES ('bde9911685f54350a9346c1b55f610e1', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-24 15:31:41', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-24 15:31:41', '1', '更新字典', 'system:dictionary:update', NULL, '2b7c48936fe24e3bb1691f2d267859e3', '1', '1', '0', 3, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('bf9bdd4571d145f4b2dcf4c16b846527', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-30 07:10:37', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-17 03:17:01', '1', '删除用户权限', 'system:user:delete', '/user/delete', '549ba4d9446f4b8da409b45488242808', '1', '1', '0', 3, '@/views/system/user/index', '1', '');
INSERT INTO `sys_menu` VALUES ('c3ac1dd1e29f419e95e54688465e81bb', NULL, '1111111', '2022-01-19 13:30:06', '1111111', '2022-01-19 13:30:06', '1', 'FFFFFFFFFF', 'system:admin:menu', '/admin/menu', '8f7512985da7471b92ac127b01add25d', '1', '0', '0', 3, '@/views/system/menu/index', '1', '');
INSERT INTO `sys_menu` VALUES ('d1a7966ba08145dd92e30b546906d151', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-04-20 14:36:25', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-04-20 14:39:15', '1', '代码生成', 'code-generator', '/admin/code-generator', '4350efd82f3240e39055e81118045069', '1', '0', '0', 1, NULL, '1', 'MagicStick');
INSERT INTO `sys_menu` VALUES ('dbdc92f7958d4839aba23a909577ec0b', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-10 05:42:57', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-08 06:05:15', '1', '权限管理', 'system:admin:menu', '/admin/permission-manager', '22e97a24b6754a92864f2f358bc46185', '1', '0', '0', 3, '@/views/system/menu/index', '1', 'Management');
INSERT INTO `sys_menu` VALUES ('f696114e32c54a53a6f6e68a020d5ad8', NULL, '1111111', '2022-01-16 11:20:05', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-23 02:01:37', '1', '用户管理', 'user:manager:view', '/admin/user-manager', '22e97a24b6754a92864f2f358bc46185', '1', '0', '0', 1, '@/views/system/user/index', '1', 'UserFilled');

-- ----------------------------
-- Table structure for sys_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation_log`;
CREATE TABLE `sys_operation_log`  (
  `ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键id',
  `LOG_NUMBER` bigint(0) NOT NULL COMMENT '日志编号',
  `IP_ADDRESS` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '请求IP地址',
  `OPERATOR` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作人员',
  `REQUEST_WAY` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '请求方式',
  `OPERATION_STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作状态;0异常 1成功',
  `SYSTEM_MODULE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '系统模块',
  `OPERATION_TYPE` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作类型;0登录日志 1操作日志',
  `OPERATION_ADDRESS` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '操作地点',
  `LOG_TYPE` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '日志类型',
  `OPERATION_TIME` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系统操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_operation_log
-- ----------------------------
INSERT INTO `sys_operation_log` VALUES ('00947a9a72ea4c8ca93e0009898f5057', 1652175873448, '20.24.95.177', '7d7f2f72dd0e4b6080373a3cc1469a15', 'POST', '1', NULL, NULL, NULL, '1', '2022-05-10 09:44:33');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键id',
  `REVISION` int(0) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATE_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '创建人',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `DELETE_STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '删除状态;0删除 1未删除',
  `ROLE_NAME` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '角色名称',
  `ROLE_KEY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '角色标识',
  `SORT` int(0) NOT NULL COMMENT '显示排序',
  `REMARK` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系统角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('501d753e66094872acb476c405712052', NULL, '1111111', '2022-01-20 07:53:29', '1111111', '2022-01-20 07:53:29', '1', '超级管理员', 'role:super:admin', 0, NULL);
INSERT INTO `sys_role` VALUES ('643ce9d62ee74c13b7e3977dd84bad7e', NULL, '520f60b987974cea847eb08c878adf00', '2022-01-22 13:14:56', '520f60b987974cea847eb08c878adf00', '2022-01-22 13:20:33', '1', '普通用户', 'role:simple:user', 1, NULL);
INSERT INTO `sys_role` VALUES ('c7e8c169248047209905d11abea0260c', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-27 05:52:01', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-27 05:52:01', '1', '系统管理员', 'role:simple:admin', 3, NULL);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `ROLE_ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '角色主键ID',
  `MENU_ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '菜单主键ID',
  `ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '6ea46c55bae64af5bc84fb62cb17d157', '00fb0effd2804e8a81a78debf87a0f8a');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '8fc7451c40784a319279e6e80f44c0de', '122dd73fbf604ef8a87661fa0357cf81');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', 'bde9911685f54350a9346c1b55f610e1', '12f4b3ae7d6d4884917887ec47a12785');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '5929445bda3b4748a7c58271d619e940', '18961e2cf19f47b787d63e59aea54317');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', 'f696114e32c54a53a6f6e68a020d5ad8', '228098ee095345a78244713c13e2cab9');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '3b073e1797ba415fbc42367c4a0c855c', '280bb57206a6470db32f52780ef312be');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '43be00e9a9fc4aa080aca3bed0e38dd6', '2f1ad39fc9364511a84280f1b2bbd479');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '740548e309f0421098cc1abeedce62f8', '32aaa27a9866436084c75cac9d886f01');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', 'dbdc92f7958d4839aba23a909577ec0b', '3b6bcba0cda640c2ad54cc6332660fb4');
INSERT INTO `sys_role_menu` VALUES ('643ce9d62ee74c13b7e3977dd84bad7e', '9beeb4f8628e477b8e5f853fba5aeec0', '3e637fbdc49f4da28b7c27b594f523f2');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '2483fba39ec34e1cbf171b8c877f844f', '4906ec2c4d6b4c77b42643c0cc29b55a');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '9aa65aed2def4639a10301bec890c6ce', '6355d72ff056457d8687a1a84ef50b8d');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', 'b44d335e217c4ac9af095477d9db31ff', '693085cbba564271be2f7ba84c193df9');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', 'a1ae4bc73605499c9ad53363e65fdc4f', '6f0751e538824834b8ea920881d19bbc');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '171d885a56b5412fbcf4982a42a81149', '79d19c1afaa04520bbd6a715e756265a');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '092aea434b7f48579c65ff0f4589bcb8', '7ca09a988344454eb5fbdc834f1e1580');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '22e97a24b6754a92864f2f358bc46185', '828bd3c3f2344ae4916c221ddb30e8c5');
INSERT INTO `sys_role_menu` VALUES ('643ce9d62ee74c13b7e3977dd84bad7e', '43be00e9a9fc4aa080aca3bed0e38dd6', '888e81aeb2db4aa7ba07960de3d40e6a');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '4815bf75f9eb4a2283c9aa1ab531b3b5', '9cb6aafca6b14b4ba1aad135a93e40f6');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '07d966031dee4f448ac887eb458c18d9', '9de5764bcffa46b9af4e01ea392375e9');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '4350efd82f3240e39055e81118045069', 'a5296e55c0574fd88bdbe1f5cdec6451');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', 'bf9bdd4571d145f4b2dcf4c16b846527', 'd2488a11cf92415e95740cacba7b7999');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '2b7c48936fe24e3bb1691f2d267859e3', 'dfd641e6f77c4928b7588f2e64dd3c95');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '0deb2ec9bed34959a76b7d2fcfd056f4', 'e18bd4b12b134241a7b28b27fa5d228e');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '3368ccadab224fdaacf8d13ba3e37ed3', 'e252d9cf5d6a4678be081b5786d0cc85');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '9beeb4f8628e477b8e5f853fba5aeec0', 'ed45474e689a4a65a213ad3b2871f06f');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '549ba4d9446f4b8da409b45488242808', 'f1300b11d9f74b1f9e0add1cd91a291d');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', 'd1a7966ba08145dd92e30b546906d151', 'f60b0457cadc464ab32d5df2f98a513b');
INSERT INTO `sys_role_menu` VALUES ('643ce9d62ee74c13b7e3977dd84bad7e', '8fc7451c40784a319279e6e80f44c0de', 'fb37908cd3244b7db16188bd8fef3500');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键id',
  `REVISION` int(0) NULL DEFAULT NULL COMMENT '乐观锁',
  `CREATE_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '创建人',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
  `UPDATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `DELETE_STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '删除状态;0删除 1未删除',
  `USERNAME` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户账号',
  `NICKNAME` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户昵称',
  `PASSWORD` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `SEX` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户性别;0未知 1男 2女',
  `EMAIL` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户邮箱',
  `MOBILE_PHONE` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '手机号',
  `DEPARTMENT_ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '部门id',
  `ACCOUNT_STATUS` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '账号状态;0停用 1正常 2冻结 3封禁',
  `AVATAR` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '头像地址',
  `LAST_LOGIN_IP` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '最后登录IP',
  `LAST_LOGIN_TIME` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系统用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('08569f9818234ecfbcc4e3ca6065cd07', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-30 07:53:42', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-04-13 07:23:15', '0', 'Testor', 'SRA-1643529222155', 'sra123456', '0', NULL, NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('0ccdaa194de94e53b315f12d151c7974', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-30 14:50:29', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-04-13 07:23:40', '1', 'sys_admin', 'sys_admin', '123456', '2', '572315466@qq.com', NULL, NULL, '1', NULL, '192.168.31.242', '2022-03-30 14:50:52');
INSERT INTO `sys_user` VALUES ('16062067e966485992e8c1abed367220', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:38:03', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-04-13 07:23:20', '0', 'user11', '用户11号', '123456', '0', '', NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('18825c343da940f3bcb61aebfef85b82', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:37:42', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:37:42', '1', 'user8', '用户8号', '123456', '0', '', NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('23b6bba45ab4427a8b2f0f37c9d016ae', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-26 03:32:03', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-26 03:32:03', '1', 'Alice', 'SRA-1643167922637', 'alice123', '0', NULL, NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('33b5c64e4e1d4a4e996b4240af1be8d6', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-30 07:37:36', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-31 09:38:08', '1', '测试账号xtgly', 'SRA-1643528255738', 'sra123456', '0', NULL, NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('39b5104d2ed341f78fe1e04340232f1e', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:38:26', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:38:26', '1', 'user15', '用户15号', '123456', '0', '', NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('426f205361e840f88f46403a00d25ac2', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:37:16', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:37:16', '1', 'user5', '用户5号', '123456', '0', '', NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('4ffae10cce6d4d889cbd2d6b7cff5c29', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:38:10', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:38:10', '1', 'user12', '用户12号', '123456', '0', '', NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('520f60b987974cea847eb08c878adf00', NULL, '1111111', '2022-01-14 16:02:41', '21213131231', '2022-01-14 16:02:41', '1', '1111111', 'SRA-1642176160762', 'zxc123', '1', NULL, NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('58dbef03d04e45b8959ff995bf35f572', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:37:24', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:37:24', '1', 'user6', '用户6号', '123456', '0', '', NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('66f3ef0792604f13ad094a42c097fa23', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-27 05:52:35', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-30 07:13:22', '0', 'sraadmin', 'SRA-1643262754922', 'admin123', '0', NULL, NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('6e1c954e03474b678de3fff13bfdf85c', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-10 09:46:52', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-10 09:46:52', '1', 'bobo', 'SRA-1646905611956', '123456', '0', NULL, NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('7d7f2f72dd0e4b6080373a3cc1469a15', NULL, '520f60b987974cea847eb08c878adf00', '2022-01-25 06:31:00', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-05-16 07:20:36', '1', 'admin', 'sra-admin', '2f2abcd4614493ecbea0e3738240a3d8', '0', '120sra@qq.com', '13811111111', NULL, '1', 'http://106.52.139.93:8080/upload/6de51acaafe4f4f4f319b2c5fe971d46.jpg', '202.105.12.219', '2022-05-16 07:20:36');
INSERT INTO `sys_user` VALUES ('99510ae861c44ab79ecf7af3fd1647fa', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:38:22', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:38:22', '1', 'user14', '用户14号', '123456', '0', '', NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('9a101f6fca234002bfa95ecc98fcc6ab', NULL, '520f60b987974cea847eb08c878adf00', '2022-01-25 06:29:16', '9a101f6fca234002bfa95ecc98fcc6ab', '2022-04-09 07:24:59', '1', 'zhangsan', 'SRA-1643092155976', 'zxc123', '1', NULL, NULL, NULL, '1', NULL, '192.168.31.242', '2022-04-09 07:24:59');
INSERT INTO `sys_user` VALUES ('cf53ae7d5b6842399e1f838ecce67174', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:37:03', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:37:03', '1', 'user3', '用户3号', '123456', '0', '', NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('d33cee484ee7481d94cd21b364d7459e', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:38:16', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:38:16', '1', 'user13', '用户13号', '123456', '0', '', NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('d7f199480def49f8baa9e055acf7e763', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:37:48', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:37:48', '1', 'user9', '用户9号', '123456', '0', '', NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('daab3a965509494fbd3fe5fb272c6c89', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:37:56', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:37:56', '1', 'user10', '用户10号', '123456', '0', '', NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('deb6ce00d51143e0b588ccb56bf4c2e6', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-30 07:27:58', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:38:36', '0', 'kkkkkkkaaaa', '卡卡w(ﾟДﾟ)w', '123456', '0', NULL, NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('ef32cc84a33146b6bea9e646786724d0', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:36:54', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:36:54', '1', 'user2', '用户2号', '123456', '0', '', NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('f11528c5af114d3fa5a74a87865f8879', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:37:09', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:37:09', '1', 'user4', '用户4号', '123456', '0', '', NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('f2ed05a1a7684e16a36220c9eaa19237', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-20 14:24:38', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:38:39', '0', 'adwacwads', 'SRA-1645367078094', '123asdad', '0', NULL, NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('fa5a8867e5414b8da8ab7266a4b9575d', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:37:34', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:37:34', '1', 'user7', '用户7号', '123456', '0', '', NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('fd0b8ab420f24472b464e9fdd2ae2ec0', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:08:44', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:08:44', '1', 'user1', 'user一号', '123456', '0', '', NULL, NULL, '1', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `USER_ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户主键ID',
  `ROLE_ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '角色主键ID',
  `ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('99510ae861c44ab79ecf7af3fd1647fa', '643ce9d62ee74c13b7e3977dd84bad7e', '038527581fad4394ad47b5d218768885');
INSERT INTO `sys_user_role` VALUES ('d33cee484ee7481d94cd21b364d7459e', '643ce9d62ee74c13b7e3977dd84bad7e', '0d9fcc4cc5c849ca9f1c5d64f76f3a18');
INSERT INTO `sys_user_role` VALUES ('520f60b987974cea847eb08c878adf00', '501d753e66094872acb476c405712052', '123123');
INSERT INTO `sys_user_role` VALUES ('4ffae10cce6d4d889cbd2d6b7cff5c29', '643ce9d62ee74c13b7e3977dd84bad7e', '4e7b315b4fa04999b0a4109ef20e47d0');
INSERT INTO `sys_user_role` VALUES ('23b6bba45ab4427a8b2f0f37c9d016ae', '643ce9d62ee74c13b7e3977dd84bad7e', '4f0cb2a6ae9c40c5a9cbdaf0f5370146');
INSERT INTO `sys_user_role` VALUES ('d7f199480def49f8baa9e055acf7e763', '643ce9d62ee74c13b7e3977dd84bad7e', '59015b3c4b774ada92b2d583592b0e33');
INSERT INTO `sys_user_role` VALUES ('18825c343da940f3bcb61aebfef85b82', '643ce9d62ee74c13b7e3977dd84bad7e', '5a7d7369485647a0be078a20d863e813');
INSERT INTO `sys_user_role` VALUES ('fd0b8ab420f24472b464e9fdd2ae2ec0', '643ce9d62ee74c13b7e3977dd84bad7e', '60546a142cfd4ab8a0a8db866dc6f209');
INSERT INTO `sys_user_role` VALUES ('f11528c5af114d3fa5a74a87865f8879', '643ce9d62ee74c13b7e3977dd84bad7e', '62f37d86058741b6bbc65108ff219ad1');
INSERT INTO `sys_user_role` VALUES ('58dbef03d04e45b8959ff995bf35f572', '643ce9d62ee74c13b7e3977dd84bad7e', '65f118d3be9243bd9a1902dff0d626cc');
INSERT INTO `sys_user_role` VALUES ('fa5a8867e5414b8da8ab7266a4b9575d', '643ce9d62ee74c13b7e3977dd84bad7e', '77f17a0bc3094810bfabaf340d1cc401');
INSERT INTO `sys_user_role` VALUES ('33b5c64e4e1d4a4e996b4240af1be8d6', 'c7e8c169248047209905d11abea0260c', '7e31b85994914c40ad091844734193bc');
INSERT INTO `sys_user_role` VALUES ('426f205361e840f88f46403a00d25ac2', '643ce9d62ee74c13b7e3977dd84bad7e', '8a901403119e419d8f7a1487eedaa5a4');
INSERT INTO `sys_user_role` VALUES ('6e1c954e03474b678de3fff13bfdf85c', '643ce9d62ee74c13b7e3977dd84bad7e', '8cd3b483458f4b4baa626b0a19507dda');
INSERT INTO `sys_user_role` VALUES ('ef32cc84a33146b6bea9e646786724d0', '643ce9d62ee74c13b7e3977dd84bad7e', '8d109191c0f64f1d9b72902fa51e4dad');
INSERT INTO `sys_user_role` VALUES ('daab3a965509494fbd3fe5fb272c6c89', '643ce9d62ee74c13b7e3977dd84bad7e', '9b62e367c32741328f3c1fdb092fb122');
INSERT INTO `sys_user_role` VALUES ('0ccdaa194de94e53b315f12d151c7974', 'c7e8c169248047209905d11abea0260c', 'b4ff626d6b60496592d8daecdf393e03');
INSERT INTO `sys_user_role` VALUES ('7d7f2f72dd0e4b6080373a3cc1469a15', '501d753e66094872acb476c405712052', 'ce10c4859ca14c30a2fcba0b33ca4389');
INSERT INTO `sys_user_role` VALUES ('9a101f6fca234002bfa95ecc98fcc6ab', '643ce9d62ee74c13b7e3977dd84bad7e', 'ce694314aa1640cdb6b0a0584feed97c');
INSERT INTO `sys_user_role` VALUES ('cf53ae7d5b6842399e1f838ecce67174', '643ce9d62ee74c13b7e3977dd84bad7e', 'e9cc25cd1b7e4884980bdc2d518dd276');
INSERT INTO `sys_user_role` VALUES ('39b5104d2ed341f78fe1e04340232f1e', '643ce9d62ee74c13b7e3977dd84bad7e', 'fbafc9bee9e84f248c9ffc003554a83f');

SET FOREIGN_KEY_CHECKS = 1;
