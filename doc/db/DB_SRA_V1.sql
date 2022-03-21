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

 Date: 21/03/2022 10:10:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
  `SORT` int(0) NOT NULL COMMENT '显示顺序',
  `COMPONENT_PATH` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '组件路径',
  `IS_EXTERNAL_LINK` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '是否外链;0是 1否',
  `ICON_PATH` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单图标',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系统菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('060af5d6d35741efb141bd6599c44d9d', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 08:01:29', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 08:01:35', '0', '撒擦拭擦', '', NULL, '0', '0', '1', 1, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('07d966031dee4f448ac887eb458c18d9', NULL, '1111111', '2022-01-17 11:43:37', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 03:02:52', '1', '角色管理', 'system:admin:role', '/admin/role-manager', '22e97a24b6754a92864f2f358bc46185', '1', '0', 4, '@/views/system/role/index', '1', 'User');
INSERT INTO `sys_menu` VALUES ('0deb2ec9bed34959a76b7d2fcfd056f4', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-30 08:17:22', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-17 03:17:14', '1', '修改用户权限', 'system:user:update', '/user/update', '549ba4d9446f4b8da409b45488242808', '2', '1', 2, '', '1', '');
INSERT INTO `sys_menu` VALUES ('171d885a56b5412fbcf4982a42a81149', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-26 03:30:14', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-17 03:15:34', '1', '新增用户权限', 'system:user:add', 'user/add', '549ba4d9446f4b8da409b45488242808', '1', '1', 2, '', '1', '');
INSERT INTO `sys_menu` VALUES ('22e97a24b6754a92864f2f358bc46185', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-10 08:00:25', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-19 12:42:24', '1', '系统管理', 'system:admin:manager', '  ', '0', '0', '0', 2, 'aaaaaaa', '1', 'Compass');
INSERT INTO `sys_menu` VALUES ('2483fba39ec34e1cbf171b8c877f844f', NULL, '1111111', '2022-01-17 06:36:35', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-08 05:57:24', '1', '菜单管理', 'system:admin:menu', '/admin/menu-manager', '22e97a24b6754a92864f2f358bc46185', '1', '0', 3, '@/views/system/menu/index', '1', 'Menu');
INSERT INTO `sys_menu` VALUES ('3368ccadab224fdaacf8d13ba3e37ed3', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-31 10:49:40', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-18 06:17:19', '1', '统计数量接口', 'system:dashboard:getCount', 'dashboard/getCount', '0', '2', '1', 1, '', '1', '');
INSERT INTO `sys_menu` VALUES ('3b073e1797ba415fbc42367c4a0c855c', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 03:44:41', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 07:56:14', '1', '系统管理', '  ', NULL, '0', '0', '1', 1, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES ('43be00e9a9fc4aa080aca3bed0e38dd6', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-10 07:54:49', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-19 12:42:18', '1', '系统设置', 'system:admin:setting', '/admin/sys-setting', '0', '1', '0', 3, 'empty', '1', 'Tools');
INSERT INTO `sys_menu` VALUES ('549ba4d9446f4b8da409b45488242808', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-17 03:14:56', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 07:38:16', '1', '用户权限', '   ', '/system/user/dir', '3b073e1797ba415fbc42367c4a0c855c', '1', '1', 1, '', '1', 'mdi-account-key');
INSERT INTO `sys_menu` VALUES ('8fc7451c40784a319279e6e80f44c0de', NULL, '1111111', '2022-01-17 06:25:47', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-19 12:13:40', '1', '后台首页', 'system:admin:home', '  ', '0', '0', '0', 1, '@/views/system/home', '1', 'HomeFilled');
INSERT INTO `sys_menu` VALUES ('9aa65aed2def4639a10301bec890c6ce', NULL, '9a101f6fca234002bfa95ecc98fcc6ab', '2022-01-25 07:03:12', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-17 03:17:11', '1', '分页用户权限', 'system:user:listByPage', '/user/listByPage', '549ba4d9446f4b8da409b45488242808', '1', '1', 7, 'nothing', '0', '');
INSERT INTO `sys_menu` VALUES ('9beeb4f8628e477b8e5f853fba5aeec0', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 08:09:55', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-19 12:44:01', '1', '首页', ':admin:home', '/admin/home', '8fc7451c40784a319279e6e80f44c0de', '1', '0', 2, NULL, '1', 'HomeFilled');
INSERT INTO `sys_menu` VALUES ('a1ae4bc73605499c9ad53363e65fdc4f', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-09 15:34:44', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-09 07:18:37', '1', '获取系统信息', 'system:dashboard:getSystemInfo', '/dashboard/getSystemInfo', '0', '2', '1', 1, '', '1', '');
INSERT INTO `sys_menu` VALUES ('b44d335e217c4ac9af095477d9db31ff', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-11 08:21:59', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-19 12:43:59', '1', '仪表盘', 'system:admin:home', '/admin/dashboard', '8fc7451c40784a319279e6e80f44c0de', '1', '0', 1, '@/views/system/home', '1', 'DataBoard');
INSERT INTO `sys_menu` VALUES ('b5b46dac10974d09a59e682c86cb5a57', NULL, '1111111', '2022-01-19 13:29:49', '1111111', '2022-01-19 13:29:49', '1', 'FFFFFFFFFF', 'system:admin:menu', '/admin/menu', '8f7512985da7471b92ac127b01add25d', '1', '0', 3, '@/views/system/menu/index', '1', '');
INSERT INTO `sys_menu` VALUES ('bf9bdd4571d145f4b2dcf4c16b846527', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-30 07:10:37', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-17 03:17:01', '1', '删除用户权限', 'system:user:delete', '/user/delete', '549ba4d9446f4b8da409b45488242808', '1', '1', 3, '@/views/system/user/index', '1', '');
INSERT INTO `sys_menu` VALUES ('c3ac1dd1e29f419e95e54688465e81bb', NULL, '1111111', '2022-01-19 13:30:06', '1111111', '2022-01-19 13:30:06', '1', 'FFFFFFFFFF', 'system:admin:menu', '/admin/menu', '8f7512985da7471b92ac127b01add25d', '1', '0', 3, '@/views/system/menu/index', '1', '');
INSERT INTO `sys_menu` VALUES ('dbdc92f7958d4839aba23a909577ec0b', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-02-10 05:42:57', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-08 06:05:15', '1', '权限管理', 'system:admin:menu', '/admin/permission-manager', '22e97a24b6754a92864f2f358bc46185', '1', '0', 3, '@/views/system/menu/index', '1', 'Management');
INSERT INTO `sys_menu` VALUES ('f696114e32c54a53a6f6e68a020d5ad8', NULL, '1111111', '2022-01-16 11:20:05', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-10 03:56:01', '1', '用户管理', 'user:manager:view', '/admin/user-manager', '22e97a24b6754a92864f2f358bc46185', '1', '0', 2, '@/views/system/user/index', '1', 'UserFilled');

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
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', 'a1ae4bc73605499c9ad53363e65fdc4f', '10d3df37bbde49f89e404f469b7148ab');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '8fc7451c40784a319279e6e80f44c0de', '28cfb7cedbf34b58a60fb5d478f760ae');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '2b7ac8c1bfbb44da8afc951e66cc9a6a', '2a25ec62635f44999c2a341bce99d3b0');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '171d885a56b5412fbcf4982a42a81149', '37ed8561d6f347e9aaf806a1eb45ed4a');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '4bbb62e0fdcd49ebbb7eb4641026b33a', '40bea92394cc46659f8458a3ae629a79');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '3368ccadab224fdaacf8d13ba3e37ed3', '4d6ed5715bd3449fa894e46e4130ee74');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '2483fba39ec34e1cbf171b8c877f844f', '786a8ef66ec14973849b0176f64d8a46');
INSERT INTO `sys_role_menu` VALUES ('643ce9d62ee74c13b7e3977dd84bad7e', '43be00e9a9fc4aa080aca3bed0e38dd6', '7ae95106a6fd4e58847a9496ce949746');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '07d966031dee4f448ac887eb458c18d9', '8544c33640c64fb19b3db723c1e167f7');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', 'dbdc92f7958d4839aba23a909577ec0b', '87c9452ec5de4782b07a3388ad1c3f2b');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '92e58fb1dfdf4359982c6ae2f36e06a3', 'aa7ea1de7b1b43779cd16d087f905aaa');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '43be00e9a9fc4aa080aca3bed0e38dd6', 'ada2fa8ba4d04c03bce58a119fe26c0f');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '9aa65aed2def4639a10301bec890c6ce', 'b4ecb66c428a4960ad19ef9dc660ac89');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '22e97a24b6754a92864f2f358bc46185', 'bb3cb282e53d4e408b68df361b54f572');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', 'f696114e32c54a53a6f6e68a020d5ad8', 'd0901cb87f924289bcf178f99da60460');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', 'b44d335e217c4ac9af095477d9db31ff', 'd69b2e6857764565abc5ff7c299bf4da');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', 'bf9bdd4571d145f4b2dcf4c16b846527', 'e43d13841dad41ee841b58536cddb124');
INSERT INTO `sys_role_menu` VALUES ('501d753e66094872acb476c405712052', '0deb2ec9bed34959a76b7d2fcfd056f4', 'f4ae33efc078437da5cd871e7fb7884e');

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
INSERT INTO `sys_user` VALUES ('08569f9818234ecfbcc4e3ca6065cd07', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-30 07:53:42', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-01-30 07:53:42', '1', 'Testor', 'SRA-1643529222155', 'sra123456', '0', NULL, NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('16062067e966485992e8c1abed367220', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:38:03', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:38:03', '1', 'user11', '用户11号', '123456', '0', '', NULL, NULL, '1', NULL, NULL, NULL);
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
INSERT INTO `sys_user` VALUES ('7d7f2f72dd0e4b6080373a3cc1469a15', NULL, '520f60b987974cea847eb08c878adf00', '2022-01-25 06:31:00', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-19 12:46:08', '1', 'admin', 'sra-admin', 'admin123', '2', '120jja@qq.com', '13811111111', NULL, '1', NULL, '192.168.31.242', '2022-03-19 12:46:08');
INSERT INTO `sys_user` VALUES ('99510ae861c44ab79ecf7af3fd1647fa', NULL, '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:38:22', '7d7f2f72dd0e4b6080373a3cc1469a15', '2022-03-11 02:38:22', '1', 'user14', '用户14号', '123456', '0', '', NULL, NULL, '1', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES ('9a101f6fca234002bfa95ecc98fcc6ab', NULL, '520f60b987974cea847eb08c878adf00', '2022-01-25 06:29:16', '520f60b987974cea847eb08c878adf00', '2022-01-25 06:29:16', '1', 'zhangsan', 'SRA-1643092155976', 'zxc123', '1', NULL, NULL, NULL, '1', NULL, NULL, NULL);
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
INSERT INTO `sys_user_role` VALUES ('08569f9818234ecfbcc4e3ca6065cd07', '643ce9d62ee74c13b7e3977dd84bad7e', '7b8415469207498794844660ebc315e8');
INSERT INTO `sys_user_role` VALUES ('33b5c64e4e1d4a4e996b4240af1be8d6', 'c7e8c169248047209905d11abea0260c', '7e31b85994914c40ad091844734193bc');
INSERT INTO `sys_user_role` VALUES ('426f205361e840f88f46403a00d25ac2', '643ce9d62ee74c13b7e3977dd84bad7e', '8a901403119e419d8f7a1487eedaa5a4');
INSERT INTO `sys_user_role` VALUES ('6e1c954e03474b678de3fff13bfdf85c', '643ce9d62ee74c13b7e3977dd84bad7e', '8cd3b483458f4b4baa626b0a19507dda');
INSERT INTO `sys_user_role` VALUES ('ef32cc84a33146b6bea9e646786724d0', '643ce9d62ee74c13b7e3977dd84bad7e', '8d109191c0f64f1d9b72902fa51e4dad');
INSERT INTO `sys_user_role` VALUES ('daab3a965509494fbd3fe5fb272c6c89', '643ce9d62ee74c13b7e3977dd84bad7e', '9b62e367c32741328f3c1fdb092fb122');
INSERT INTO `sys_user_role` VALUES ('16062067e966485992e8c1abed367220', '643ce9d62ee74c13b7e3977dd84bad7e', 'b5bc330ade6542a0b95dbf401334e8c1');
INSERT INTO `sys_user_role` VALUES ('9a101f6fca234002bfa95ecc98fcc6ab', '643ce9d62ee74c13b7e3977dd84bad7e', 'ce694314aa1640cdb6b0a0584feed97c');
INSERT INTO `sys_user_role` VALUES ('7d7f2f72dd0e4b6080373a3cc1469a15', '501d753e66094872acb476c405712052', 'd57f13fb10a640f9801af944588c6f37');
INSERT INTO `sys_user_role` VALUES ('cf53ae7d5b6842399e1f838ecce67174', '643ce9d62ee74c13b7e3977dd84bad7e', 'e9cc25cd1b7e4884980bdc2d518dd276');
INSERT INTO `sys_user_role` VALUES ('39b5104d2ed341f78fe1e04340232f1e', '643ce9d62ee74c13b7e3977dd84bad7e', 'fbafc9bee9e84f248c9ffc003554a83f');

SET FOREIGN_KEY_CHECKS = 1;
