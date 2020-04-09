/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : orange_ocr

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 09/04/2020 00:50:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for declaration
-- ----------------------------
DROP TABLE IF EXISTS `declaration`;
CREATE TABLE `declaration`  (
  `article_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `article_authors` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `article_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `article_input_date` date NULL DEFAULT NULL,
  `article_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_top` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for link
-- ----------------------------
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link`  (
  `link_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `link_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `link_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`link_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of link
-- ----------------------------
INSERT INTO `link` VALUES (1, 'Wei 博客', 'https://www.cnblogs.com/dgwblog/', '我的博客');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '/static/**');
INSERT INTO `menu` VALUES (2, '/');
INSERT INTO `menu` VALUES (3, '/index/**');
INSERT INTO `menu` VALUES (4, '/article/**');
INSERT INTO `menu` VALUES (5, '/tag/**');
INSERT INTO `menu` VALUES (6, '/link/**');
INSERT INTO `menu` VALUES (7, '/system/**');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `message_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_read` int(11) NULL DEFAULT NULL,
  `message_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `message_input_date` datetime(0) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subject` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, '123@qq.com', NULL, '你好,离开\n\n　　我带着你的平安祝福\n\n　　重逢\n\n　　我兑现了对你的承诺', '2020-04-08 10:27:49', '哈哈', '关于合作');

-- ----------------------------
-- Table structure for ocraccess
-- ----------------------------
DROP TABLE IF EXISTS `ocraccess`;
CREATE TABLE `ocraccess`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `access_count` int(11) NULL DEFAULT NULL,
  `access_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of ocraccess
-- ----------------------------
INSERT INTO `ocraccess` VALUES (1, 4, '2020-04-08');

-- ----------------------------
-- Table structure for ocrtexts
-- ----------------------------
DROP TABLE IF EXISTS `ocrtexts`;
CREATE TABLE `ocrtexts`  (
  `text_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `access_date` datetime(0) NULL DEFAULT NULL,
  `apply_people` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tag_input_date` date NULL DEFAULT NULL,
  `text_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`text_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ocrtexts
-- ----------------------------
INSERT INTO `ocrtexts` VALUES (1, '2020-04-08 15:02:12', '123', '123', '2020-04-08', '123');
INSERT INTO `ocrtexts` VALUES (2, '2020-04-08 09:40:02', 'dgwity', 'E:\\GItHubRepository\\orange_ocr\\orange_ocr-parent\\img', '2020-04-08', '项目是使用springboot+jpa  想在控制台输出格式化的sql，总是无效，最终');
INSERT INTO `ocrtexts` VALUES (3, '2020-04-08 09:54:57', 'dgwity', 'E:\\GItHubRepository\\orange_ocr\\orange_ocr-parent\\img', '2020-04-08', '代 线 文 孕 识 别 ,0CR 服 务 0CR Orange\n');
INSERT INTO `ocrtexts` VALUES (4, '2020-04-08 10:23:23', 'dgwity', 'img/7f413572-0d28-4629-bbd4-ff81b449b04b.png', '2020-04-08', '代 线 文 孕 识 别 ,0CR 服 务 0CR Orange\n');
INSERT INTO `ocrtexts` VALUES (5, '2020-04-08 11:32:08', 'test', 'img/75a68c86-5c77-439c-b2bd-649ac81231ae.png', '2020-04-08', '套 程 安 排\n');
INSERT INTO `ocrtexts` VALUES (6, '2020-04-08 11:33:18', 'test', 'img/de9701bc-6808-40f3-92f9-d3808c3f1d15.png', '2020-04-08', '套 程 安 排\n');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_enable` int(11) NULL DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 1, 'ROLE_USER');
INSERT INTO `role` VALUES (2, 1, 'ROLE_ADMIN');
INSERT INTO `role` VALUES (3, 1, 'ROLE_SUPERADMIN');
INSERT INTO `role` VALUES (4, 1, 'ROLE_SYSTEMADMIN');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  INDEX `FKfg4e2mb2318tph615gh44ll3`(`menu_id`) USING BTREE,
  INDEX `FKqyvxw2gg2qk0wld3bqfcb58vq`(`role_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (3, 7);
INSERT INTO `role_menu` VALUES (3, 7);
INSERT INTO `role_menu` VALUES (3, 7);
INSERT INTO `role_menu` VALUES (3, 6);
INSERT INTO `role_menu` VALUES (3, 5);
INSERT INTO `role_menu` VALUES (3, 4);
INSERT INTO `role_menu` VALUES (3, 3);
INSERT INTO `role_menu` VALUES (3, 2);
INSERT INTO `role_menu` VALUES (3, 1);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `tag_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag_input_date` date NULL DEFAULT NULL,
  `tag_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_enable` int(11) NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin@springboot.cn', 1, '123', 'admin');
INSERT INTO `user` VALUES (2, '123@qq.com', 1, 'ac59075b964b0715', 'dgwity');
INSERT INTO `user` VALUES (3, 'test@qq.com', 1, 'ac59075b964b0715', 'test');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  INDEX `FKa68196081fvovjhkek5m97n3y`(`role_id`) USING BTREE,
  INDEX `FK859n2jvi8ivhui0rl0esws6o`(`user_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 3);

-- ----------------------------
-- Table structure for website_access
-- ----------------------------
DROP TABLE IF EXISTS `website_access`;
CREATE TABLE `website_access`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `access_count` int(11) NULL DEFAULT NULL,
  `access_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of website_access
-- ----------------------------
INSERT INTO `website_access` VALUES (1, 23148, '2020-04-08');
INSERT INTO `website_access` VALUES (2, 23300, '2020-04-09');
INSERT INTO `website_access` VALUES (3, 23000, '2020-04-07');
INSERT INTO `website_access` VALUES (4, 21100, '2020-04-06');
INSERT INTO `website_access` VALUES (5, 20100, '2020-04-05');
INSERT INTO `website_access` VALUES (6, 19910, '2020-04-04');
INSERT INTO `website_access` VALUES (7, 19810, '2020-04-03');

-- ----------------------------
-- Table structure for website_config
-- ----------------------------
DROP TABLE IF EXISTS `website_config`;
CREATE TABLE `website_config`  (
  `id` bigint(20) NOT NULL,
  `about_page_article_id` bigint(20) NULL DEFAULT NULL,
  `author_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `blog_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `domain_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `record_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of website_config
-- ----------------------------
INSERT INTO `website_config` VALUES (1, 7, 'dgw', '橙子OCR', 'Daiguowei.cn', '1242556354@qq.com', '辽ICP备17014944号-1');

SET FOREIGN_KEY_CHECKS = 1;
