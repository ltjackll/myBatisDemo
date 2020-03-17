/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.177.136
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 192.168.177.136:3306
 Source Schema         : demo32

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 17/03/2020 17:39:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for asset_info
-- ----------------------------
DROP TABLE IF EXISTS `asset_info`;
CREATE TABLE `asset_info`  (
  `asset_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `asset_name` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `asset_product_key` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `asset_type` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`asset_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
