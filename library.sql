/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 20/11/2019 10:55:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `series` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_used` datetime NULL DEFAULT NULL,
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`series`) USING BTREE,
  UNIQUE INDEX `UK_bqa9l0go97v49wwyx4c0u3kpd`(`token`) USING BTREE,
  UNIQUE INDEX `UK_f8t9fsfwc17s6qcbx0ath6l3h`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_generator
-- ----------------------------
DROP TABLE IF EXISTS `sys_generator`;
CREATE TABLE `sys_generator`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `moduleName` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块名称',
  `tableName` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名称',
  `ignoreFlag` int(11) NULL DEFAULT NULL COMMENT '是否忽略前缀1：是',
  `ignorePrefix` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前缀',
  `createRest` int(11) NULL DEFAULT NULL COMMENT '是否生成rest接口1:是',
  `updateTime` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `createTime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_generator
-- ----------------------------
INSERT INTO `sys_generator` VALUES (3, 'admin', 't_person', 1, 't_', 1, '2019-07-13 10:06:35', '2019-07-13 10:06:35');
INSERT INTO `sys_generator` VALUES (4, 'book', 't_book', 1, 't_', 0, '2019-11-02 12:44:52', '2019-11-02 12:44:52');
INSERT INTO `sys_generator` VALUES (5, 'localtion', 't_location', 1, 't_', 0, '2019-11-02 12:45:14', '2019-11-02 12:45:14');
INSERT INTO `sys_generator` VALUES (6, 'publish', 't_publish', 1, 't_', 0, '2019-11-02 12:45:32', '2019-11-02 12:45:32');
INSERT INTO `sys_generator` VALUES (7, 'student', 't_student', 1, 't_', 0, '2019-11-02 12:45:52', '2019-11-02 12:45:52');

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available` bit(1) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKmeds2u6ae5usj0ko0bqj3k0eo`(`parent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available` bit(1) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_num` int(11) NOT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK3fekum3ead5klp7y4lckn5ohi`(`parent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 166 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES (1, b'0', '顶级栏目', 100, NULL, 0, NULL, 0);
INSERT INTO `sys_resource` VALUES (2, b'0', '权限配置', 8, '', 0, '', 1);
INSERT INTO `sys_resource` VALUES (3, b'0', '角色管理', 102, '/role', 0, '/role', 2);
INSERT INTO `sys_resource` VALUES (4, b'0', '权限管理', 103, '/resource', 0, '/resource', 2);
INSERT INTO `sys_resource` VALUES (5, b'0', '用户管理', 101, '/user', 0, '/user', 2);
INSERT INTO `sys_resource` VALUES (6, b'0', '编辑', 100, '/role/editor-role', 1, '/role/editor-role', 3);
INSERT INTO `sys_resource` VALUES (7, b'0', '添加权限节点', 100, '/resource/add-permission', 1, '/resource/add-permission', 4);
INSERT INTO `sys_resource` VALUES (8, b'0', '添加管理员', 100, '/user/add-user', 1, '/user/add-user', 5);
INSERT INTO `sys_resource` VALUES (9, b'0', '添加角色', 100, '/role/add-role', 1, '/role/add-role', 3);
INSERT INTO `sys_resource` VALUES (10, b'0', '删除角色', 100, '/role/delete', 1, '/role/delete', 3);
INSERT INTO `sys_resource` VALUES (11, b'0', '删除用户', 100, '/user/delete-user', 1, '/user/delete-user', 5);
INSERT INTO `sys_resource` VALUES (12, b'0', '删除权限', 100, '/resource/delete', 1, '/resource/delete', 4);
INSERT INTO `sys_resource` VALUES (13, b'0', '启用', 100, '/user/available-user', 1, '/user/available-user', 3);
INSERT INTO `sys_resource` VALUES (14, b'0', '修改管理员密码', 100, '/user/modify-password', 1, '/user/modify-password', 5);
INSERT INTO `sys_resource` VALUES (16, NULL, '权限编辑', 100, '/resource/editor-permission', 1, '/resource/editor-permission', 4);
INSERT INTO `sys_resource` VALUES (150, b'0', '编辑管理员信息', 100, '/user/edit-user', 1, '/user/edit-user', 5);
INSERT INTO `sys_resource` VALUES (154, NULL, '代码生成工具', 1, '/generator/sysGenerator', 0, '/generator/sysGenerator', 1);
INSERT INTO `sys_resource` VALUES (155, NULL, '基础页面生成', 1, '/generator/sysGenerator', 0, '/generator/sysGenerator', 154);
INSERT INTO `sys_resource` VALUES (156, NULL, '微信用户管理', 1, '/admin/person', 0, '/admin/person', 157);
INSERT INTO `sys_resource` VALUES (157, NULL, '微信用户', 1, '', 0, '', 1);
INSERT INTO `sys_resource` VALUES (158, NULL, '图书管理', 1, NULL, 0, NULL, 1);
INSERT INTO `sys_resource` VALUES (159, NULL, '图书信息', 1, '/book/book', 0, '/book/book', 158);
INSERT INTO `sys_resource` VALUES (160, NULL, '位置管理', 1, NULL, 0, NULL, 1);
INSERT INTO `sys_resource` VALUES (161, NULL, '图书位置', 1, '/localtion/location', 0, '/localtion/location', 160);
INSERT INTO `sys_resource` VALUES (162, NULL, '出版社管理', 1, NULL, 0, NULL, 1);
INSERT INTO `sys_resource` VALUES (163, NULL, '出版社', 1, '/publish/publish', 0, '/publish/publish', 162);
INSERT INTO `sys_resource` VALUES (164, NULL, '学生管理', 1, NULL, 0, NULL, 1);
INSERT INTO `sys_resource` VALUES (165, NULL, '学生信息', 1, '/student/student', 0, '/student/student', 164);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available` bit(1) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, NULL, '管理员', '管理员');

-- ----------------------------
-- Table structure for sys_role_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resources`;
CREATE TABLE `sys_role_resources`  (
  `sys_role_id` bigint(20) NOT NULL,
  `resources_id` bigint(20) NOT NULL,
  INDEX `FKog6jj4v6yh9e1ilxk2mwuk75a`(`resources_id`) USING BTREE,
  INDEX `FKsqkqfd2hpr5cc2kbrtgoced2w`(`sys_role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_resources
-- ----------------------------
INSERT INTO `sys_role_resources` VALUES (1, 158);
INSERT INTO `sys_role_resources` VALUES (1, 159);
INSERT INTO `sys_role_resources` VALUES (1, 160);
INSERT INTO `sys_role_resources` VALUES (1, 161);
INSERT INTO `sys_role_resources` VALUES (1, 162);
INSERT INTO `sys_role_resources` VALUES (1, 163);
INSERT INTO `sys_role_resources` VALUES (1, 164);
INSERT INTO `sys_role_resources` VALUES (1, 165);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createtime` datetime NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updatetime` datetime NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `available` bit(1) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex_type` int(11) NULL DEFAULT NULL COMMENT '性别(0.男,1.女)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '2017-07-11 17:42:18', '$2a$10$SIU57gfkh/TsIVYALXBNAeDnQzkm652FT9cg4h8wtEfC306uliyYa', '2019-11-15 00:18:29', 'admin', b'1', '2502266520@qq.com', '17778884349', 1);

-- ----------------------------
-- Table structure for sys_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_roles`;
CREATE TABLE `sys_user_roles`  (
  `sys_user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  INDEX `FKdpvc6d7xqpqr43dfuk1s27cqh`(`roles_id`) USING BTREE,
  INDEX `FKd0ut7sloes191bygyf7a3pk52`(`sys_user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_roles
-- ----------------------------
INSERT INTO `sys_user_roles` VALUES (1, 1);

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_number` int(11) NULL DEFAULT NULL COMMENT '图书编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图书名称',
  `publish_date` datetime NULL DEFAULT NULL COMMENT '出版日期',
  `publish_home` int(11) NULL DEFAULT NULL COMMENT '出版社',
  `storage_location` int(11) NULL DEFAULT NULL COMMENT '存放位置',
  `total_number` int(11) NULL DEFAULT NULL COMMENT '图书总量',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '图书表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (1, 1001, '并发编程艺术', '2014-07-11 02:00:03', 4, 3, 7, '2019-11-11 21:22:20', '2019-11-13 22:10:56');
INSERT INTO `t_book` VALUES (2, 1002, '河北大学', '2016-11-06 00:00:00', 5, 1, 9, '2019-11-11 21:22:51', '2019-11-11 21:22:51');
INSERT INTO `t_book` VALUES (3, 1003, '燕赵出版社', '2019-11-07 00:00:00', 5, 2, 9, '2019-11-11 21:23:19', '2019-11-11 21:32:38');
INSERT INTO `t_book` VALUES (10, 1004, '算法导论', '2019-11-08 00:00:00', 6, 5, 200, '2019-11-13 22:12:01', '2019-11-14 23:24:19');
INSERT INTO `t_book` VALUES (11, 1005, '数据结构', '2019-10-31 00:00:00', 4, 1, 197, '2019-11-13 22:27:08', '2019-11-15 23:19:41');
INSERT INTO `t_book` VALUES (12, 1006, '深入剖析springboot', '2019-10-29 00:00:00', 4, 5, 99, '2019-11-18 13:07:44', '2019-11-18 13:07:44');

-- ----------------------------
-- Table structure for t_book_student
-- ----------------------------
DROP TABLE IF EXISTS `t_book_student`;
CREATE TABLE `t_book_student`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_id` bigint(20) NULL DEFAULT NULL COMMENT '图书的id',
  `student_id` bigint(20) NULL DEFAULT NULL COMMENT '学生的id',
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '图书与学生的中间表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_book_student
-- ----------------------------
INSERT INTO `t_book_student` VALUES (3, 11, 6, '2019-11-18 13:22:57');
INSERT INTO `t_book_student` VALUES (4, 10, 5, '2019-11-18 13:22:59');
INSERT INTO `t_book_student` VALUES (5, 11, 6, '2019-11-18 13:23:03');
INSERT INTO `t_book_student` VALUES (8, 1, 1, '2019-11-18 13:23:06');
INSERT INTO `t_book_student` VALUES (9, 1, 5, '2019-11-18 13:23:09');
INSERT INTO `t_book_student` VALUES (11, 2, 6, '2019-11-18 13:23:12');
INSERT INTO `t_book_student` VALUES (12, 12, 1, '2019-11-18 13:23:22');
INSERT INTO `t_book_student` VALUES (13, 11, 1, '2019-11-18 13:23:24');
INSERT INTO `t_book_student` VALUES (14, 1, 1, '2019-11-19 13:23:28');
INSERT INTO `t_book_student` VALUES (15, 3, 1, '2019-11-19 13:27:22');

-- ----------------------------
-- Table structure for t_location
-- ----------------------------
DROP TABLE IF EXISTS `t_location`;
CREATE TABLE `t_location`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存放位置',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '图书位置表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_location
-- ----------------------------
INSERT INTO `t_location` VALUES (1, '一号书柜', '2019-11-11 17:35:56', '2019-11-11 17:35:56');
INSERT INTO `t_location` VALUES (2, '二号书柜', '2019-11-11 17:36:03', '2019-11-11 17:36:03');
INSERT INTO `t_location` VALUES (3, '三号书柜', '2019-11-11 17:36:11', '2019-11-11 17:36:11');
INSERT INTO `t_location` VALUES (4, '四号书柜', '2019-11-11 17:36:18', '2019-11-11 17:36:18');
INSERT INTO `t_location` VALUES (5, '五号书柜', '2019-11-11 17:36:36', '2019-11-11 17:36:36');

-- ----------------------------
-- Table structure for t_publish
-- ----------------------------
DROP TABLE IF EXISTS `t_publish`;
CREATE TABLE `t_publish`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出版社的名字',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出版社表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_publish
-- ----------------------------
INSERT INTO `t_publish` VALUES (4, '燕赵出版社', '2019-11-06 11:10:42', '2019-11-06 11:10:42');
INSERT INTO `t_publish` VALUES (5, '河北大学出版社', '2019-11-11 17:33:10', '2019-11-11 17:33:10');
INSERT INTO `t_publish` VALUES (6, '网络中心出版社', '2019-11-11 17:33:28', '2019-11-11 17:33:28');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院系',
  `professtion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所学专业',
  `certificate_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借书证号',
  `max_book_num` int(11) NULL DEFAULT NULL COMMENT '最大借书数',
  `arrears_num` int(11) NULL DEFAULT NULL COMMENT '欠费情况',
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (1, '戴书博', '数学与信息科学学院', '软件工程', '20171004083', 15, 0, '2019-11-02 13:02:26', '2019-11-11 19:02:25');
INSERT INTO `t_student` VALUES (2, '张原源', '数学与信息科学学院', '软件工程', '20171004086', 20, 0, '2019-11-02 13:48:52', '2019-11-11 19:02:28');
INSERT INTO `t_student` VALUES (3, '王跃茹', '数学与信息科学学院', '数学类', '20171004080', 20, 2, '2019-11-11 19:02:22', '2019-11-11 19:02:30');
INSERT INTO `t_student` VALUES (5, '杨洋', '数学与信息科学学院', '软件工程', '20171004099', 18, 0, '2019-11-13 22:48:19', '2019-11-13 22:48:19');
INSERT INTO `t_student` VALUES (6, '赵老板', '新闻学院', '新闻', '20091004091', 17, 0, '2019-11-13 22:49:10', '2019-11-13 22:49:10');

SET FOREIGN_KEY_CHECKS = 1;
