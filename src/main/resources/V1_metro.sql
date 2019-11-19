/*
 Navicat Premium Data Transfer

 Source Server         : Localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : metro

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 09/10/2019 10:23:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_area
-- ----------------------------
DROP TABLE IF EXISTS `tbl_area`;
CREATE TABLE `tbl_area`  (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_kana` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `area` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `city_id` int(11) NOT NULL,
  `chome_area` int(11) NOT NULL DEFAULT 0,
  `koaza_area` int(11) NOT NULL DEFAULT 0,
  `multi_post_area` int(11) NOT NULL DEFAULT 0,
  `post_id` int(11) NOT NULL,
  `old_post_id` int(11) NOT NULL,
  PRIMARY KEY (`area_id`) USING BTREE,
  INDEX `city_id`(`city_id`) USING BTREE,
  INDEX `post_id`(`post_id`) USING BTREE,
  INDEX `old_post_id`(`old_post_id`) USING BTREE,
  CONSTRAINT `tbl_area_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `tbl_city` (`city_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tbl_area_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `tbl_post` (`post_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `tbl_area_ibfk_3` FOREIGN KEY (`old_post_id`) REFERENCES `tbl_old_post` (`old_post_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 131071 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_city
-- ----------------------------
DROP TABLE IF EXISTS `tbl_city`;
CREATE TABLE `tbl_city`  (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `city_kana` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `city` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `prefecture_id` int(11) NOT NULL,
  PRIMARY KEY (`city_id`) USING BTREE,
  UNIQUE INDEX `city`(`city_kana`, `city`, `prefecture_id`) USING BTREE,
  UNIQUE INDEX `city_code`(`code`) USING BTREE,
  INDEX `prefecture_id`(`prefecture_id`) USING BTREE,
  CONSTRAINT `tbl_city_ibfk_1` FOREIGN KEY (`prefecture_id`) REFERENCES `tbl_prefecture` (`prefecture_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2048 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_old_post
-- ----------------------------
DROP TABLE IF EXISTS `tbl_old_post`;
CREATE TABLE `tbl_old_post`  (
  `old_post_id` int(11) NOT NULL AUTO_INCREMENT,
  `old_post_code` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`old_post_id`) USING BTREE,
  UNIQUE INDEX `old_post_code`(`old_post_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8192 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_post
-- ----------------------------
DROP TABLE IF EXISTS `tbl_post`;
CREATE TABLE `tbl_post`  (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_code` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `update_show` int(11) NOT NULL DEFAULT 0,
  `change_reason` int(11) NOT NULL DEFAULT 0,
  `multi_area` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`post_id`) USING BTREE,
  UNIQUE INDEX `post_code`(`post_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 131071 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_prefecture
-- ----------------------------
DROP TABLE IF EXISTS `tbl_prefecture`;
CREATE TABLE `tbl_prefecture`  (
  `prefecture_id` int(11) NOT NULL AUTO_INCREMENT,
  `prefecture_kana` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `prefecture` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `prefecture_code` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`prefecture_id`) USING BTREE,
  UNIQUE INDEX `prefecture_code`(`prefecture_code`) USING BTREE,
  UNIQUE INDEX `prefecture`(`prefecture_kana`, `prefecture`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
