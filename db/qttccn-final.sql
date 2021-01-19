/*
 Navicat Premium Data Transfer

 Source Server         : databaseMysql
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : qttccn

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 19/01/2021 23:49:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chiphi
-- ----------------------------
DROP TABLE IF EXISTS `chiphi`;
CREATE TABLE `chiphi`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int NULL DEFAULT NULL,
  `id_loaingansach` int NULL DEFAULT NULL,
  `loaitien` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ngaytao` datetime(0) NULL DEFAULT NULL,
  `mota` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sotien` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modified_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chiphi
-- ----------------------------
INSERT INTO `chiphi` VALUES (7, 2, 4, 'VNĐ', '2020-11-26 20:36:00', '123123', '1000', '2021-01-10');
INSERT INTO `chiphi` VALUES (8, 2, 4, '0.22', '2020-10-27 20:36:00', 'Công ty vàng trung quốc', '1500', '2021-01-10');
INSERT INTO `chiphi` VALUES (9, 2, 4, 'VNĐ', '2020-09-27 20:37:00', 'Tiền mua game', '1000', '2021-01-10');
INSERT INTO `chiphi` VALUES (10, 2, 4, 'VNĐ', '2020-08-27 20:40:00', 'Tiền mua game', '800', '2021-01-10');
INSERT INTO `chiphi` VALUES (11, 2, 4, 'VNĐ', '2020-07-23 20:40:00', 'Tiền mua game', '500', '2021-01-10');
INSERT INTO `chiphi` VALUES (12, 2, 4, 'VNĐ', '2020-06-27 20:40:00', 'Tiền mua game', '130', '2021-01-10');
INSERT INTO `chiphi` VALUES (13, 2, 4, 'VNĐ', '2020-05-09 20:41:00', 'Tiền mua game', '190', '2021-01-10');
INSERT INTO `chiphi` VALUES (14, 2, 4, 'VNĐ', '2020-04-17 20:41:00', 'Tiền mua game', '260', '2021-01-10');
INSERT INTO `chiphi` VALUES (15, 2, 4, 'VNĐ', '2020-04-17 20:42:00', 'Tiền mua game', '350', '2021-01-10');
INSERT INTO `chiphi` VALUES (16, 2, 4, 'VNĐ', '2020-03-07 20:42:00', 'Tiền mua game', '360', '2021-01-10');
INSERT INTO `chiphi` VALUES (17, 2, 4, 'VNĐ', '2020-02-14 20:42:00', 'Tiền mua game', '650', '2021-01-10');
INSERT INTO `chiphi` VALUES (19, 2, 3, 'VNĐ', '2021-01-06 22:09:00', 'Tiền mua game', '123123', '2021-01-10');
INSERT INTO `chiphi` VALUES (20, 2, 4, 'VNĐ', '2021-01-13 21:15:00', 'Tiền mua game', '12345', NULL);
INSERT INTO `chiphi` VALUES (21, 2, 4, '23333', '2021-01-01 21:19:00', '123123', '123123', NULL);
INSERT INTO `chiphi` VALUES (22, 2, 4, 'VNĐ', '2021-01-04 21:25:00', 'Tiền mua game', '123123', '2021-01-11');
INSERT INTO `chiphi` VALUES (23, 2, 4, 'VNĐ', '2020-12-30 21:26:00', 'Tiền mua game', '11111', '2021-01-11');
INSERT INTO `chiphi` VALUES (24, 2, 4, 'VNĐ', '2021-01-15 21:27:00', 'Tiền mua game', '312312', '2021-01-11');
INSERT INTO `chiphi` VALUES (25, 2, 4, 'VNĐ', '2020-12-31 21:29:00', 'Tiền mua game', '23123', '2021-01-11');
INSERT INTO `chiphi` VALUES (26, 2, 4, 'VNĐ', '2021-01-06 21:33:00', 'Tiền mua game', '1500000', '2021-01-11');
INSERT INTO `chiphi` VALUES (27, 2, 4, 'VNĐ', '2021-01-07 22:56:00', 'Tiền mua game', '123123', '2021-01-11');
INSERT INTO `chiphi` VALUES (28, 2, 4, 'VNĐ', '2021-01-19 22:58:00', 'Tiền mua game', '123123', '2021-01-19');

-- ----------------------------
-- Table structure for khachhang
-- ----------------------------
DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE `khachhang`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int NULL DEFAULT NULL,
  `tenkhachhang` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ngaysinh` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nghenghiep` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `diachi` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of khachhang
-- ----------------------------
INSERT INTO `khachhang` VALUES (1, 1, 'H4A', 'H3A', 'HA4', 'HA1', 'HA2');
INSERT INTO `khachhang` VALUES (2, 2, 'Huy Lê', '1643-03-06', 'SV', 'HN1', 'test@gmail.com');

-- ----------------------------
-- Table structure for loaingansach
-- ----------------------------
DROP TABLE IF EXISTS `loaingansach`;
CREATE TABLE `loaingansach`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `loaingansach` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tenloaingansach` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id_user` int NULL DEFAULT NULL,
  `han_muc` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of loaingansach
-- ----------------------------
INSERT INTO `loaingansach` VALUES (3, NULL, 'Tét123444', 2, 50);
INSERT INTO `loaingansach` VALUES (4, NULL, 'Test', 2, 85);

-- ----------------------------
-- Table structure for loaithongbao
-- ----------------------------
DROP TABLE IF EXISTS `loaithongbao`;
CREATE TABLE `loaithongbao`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `loaithongbao` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tenloaithongbao` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id_user` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of loaithongbao
-- ----------------------------
INSERT INTO `loaithongbao` VALUES (1, NULL, 'Đóng tiền', 2);

-- ----------------------------
-- Table structure for loaivi
-- ----------------------------
DROP TABLE IF EXISTS `loaivi`;
CREATE TABLE `loaivi`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int NULL DEFAULT NULL,
  `ten_vi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of loaivi
-- ----------------------------
INSERT INTO `loaivi` VALUES (1, 2, 'Ví thông dụng');
INSERT INTO `loaivi` VALUES (2, 2, 'Ví tiết kiệm');

-- ----------------------------
-- Table structure for ngansach
-- ----------------------------
DROP TABLE IF EXISTS `ngansach`;
CREATE TABLE `ngansach`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_ngansach` int NULL DEFAULT NULL,
  `id_user` int NULL DEFAULT NULL,
  `vonglap` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ngaytao` datetime(0) NULL DEFAULT NULL,
  `id_loaingansach` int NULL DEFAULT NULL,
  `loaitien` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sotien` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ngansach
-- ----------------------------
INSERT INTO `ngansach` VALUES (2, NULL, 2, '1233', '2020-12-27 00:00:00', 4, 'vnmd', '1000');
INSERT INTO `ngansach` VALUES (3, NULL, 2, '12', '2020-12-10 17:29:00', 4, '123', '3123');
INSERT INTO `ngansach` VALUES (4, NULL, 2, '1233', '2020-11-26 17:29:00', 4, 'vnd', '1500');
INSERT INTO `ngansach` VALUES (5, NULL, 2, '12', '2020-10-16 21:54:49', 4, 'vnd', '120000');
INSERT INTO `ngansach` VALUES (6, NULL, 2, '12', '2020-09-25 21:55:06', 4, 'vnd', '800');
INSERT INTO `ngansach` VALUES (7, NULL, 2, '12', '2020-08-21 21:55:26', 4, 'vnd', '1800');
INSERT INTO `ngansach` VALUES (8, NULL, 2, '198', '2020-07-23 21:55:45', 4, 'vnd', '2000');
INSERT INTO `ngansach` VALUES (9, NULL, 2, '10', '2020-06-23 21:56:06', 4, 'vnd', '2500');
INSERT INTO `ngansach` VALUES (10, NULL, 2, '45', '2020-05-20 21:56:32', 4, 'vnd', '2200');
INSERT INTO `ngansach` VALUES (11, NULL, 2, '47', '2020-04-15 21:56:49', 4, 'vnd', '1700');
INSERT INTO `ngansach` VALUES (12, NULL, 2, '7', '2020-03-18 21:57:06', 4, 'vnd', '1400');
INSERT INTO `ngansach` VALUES (13, NULL, 2, '78', '2020-02-11 21:57:23', 4, 'vnd', '700');
INSERT INTO `ngansach` VALUES (14, NULL, 2, '89', '2020-01-14 21:57:40', 4, 'vnd', '2700');
INSERT INTO `ngansach` VALUES (16, NULL, 2, 'Mua bỉm', '2021-01-08 22:32:00', 4, 'VNĐ', '1231232');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_role` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_GUEST');

-- ----------------------------
-- Table structure for thongbao
-- ----------------------------
DROP TABLE IF EXISTS `thongbao`;
CREATE TABLE `thongbao`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `noidung` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `idloaithongbao` int NULL DEFAULT NULL,
  `trangthai` bit(1) NULL DEFAULT NULL,
  `ngaytao` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `mota` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id_user` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thongbao
-- ----------------------------

-- ----------------------------
-- Table structure for thongbao_user
-- ----------------------------
DROP TABLE IF EXISTS `thongbao_user`;
CREATE TABLE `thongbao_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int NULL DEFAULT NULL,
  `id_thongbao` int NULL DEFAULT NULL,
  `trangthai` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ngaytaothongbao` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thongbao_user
-- ----------------------------

-- ----------------------------
-- Table structure for thunhap
-- ----------------------------
DROP TABLE IF EXISTS `thunhap`;
CREATE TABLE `thunhap`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int NULL DEFAULT NULL,
  `id_thunhap` int NULL DEFAULT NULL,
  `sotien` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `loaitien` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `kihan` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ngaytao` datetime(0) NULL DEFAULT NULL,
  `mota` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thunhap
-- ----------------------------
INSERT INTO `thunhap` VALUES (2, 2, NULL, '123', 'VNĐ', '12', '2020-12-26 17:59:00', 'Test');
INSERT INTO `thunhap` VALUES (3, 2, NULL, '123', 'test', '6 tjasmh', '2020-12-19 19:18:00', 'qưe2312');
INSERT INTO `thunhap` VALUES (4, 2, NULL, '123', 'VND', '6 THÁNG', '2020-12-27 17:16:45', 'Test');
INSERT INTO `thunhap` VALUES (5, 2, NULL, '123', 'VNĐ', 'VND', '2020-12-27 22:13:48', 'Mua sữa cho con 2\n');
INSERT INTO `thunhap` VALUES (6, 2, NULL, '123', 'VNĐ', 'a', '2020-12-18 22:13:00', 'qwe');
INSERT INTO `thunhap` VALUES (7, 2, NULL, '123', 'VNĐ', '76', '2020-12-09 22:40:00', '123');
INSERT INTO `thunhap` VALUES (8, 2, NULL, '1555', 'VNĐ', 'â', '2020-11-20 22:55:20', '123');
INSERT INTO `thunhap` VALUES (9, 2, NULL, '777', 'VNĐ', 'â', '2020-10-22 22:55:46', '65');
INSERT INTO `thunhap` VALUES (10, 2, NULL, '888', 'VNĐ', 'a', '2020-09-18 23:00:40', '53');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pass` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `id_role` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '$2a$10$7VaF3Y2bRB50/d4DmRo21OyILut0WchH1d0elCWzGqNLD3U7Eb6wi', 1);
INSERT INTO `user` VALUES (2, 'test', '$2a$10$OHMO6gf3wqgp.ysr2D3gH.5zYqa7IHjeiz9ezpscxfi3kpJk9Uic.', 1);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int NULL DEFAULT NULL,
  `id_role` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------

-- ----------------------------
-- Table structure for vi
-- ----------------------------
DROP TABLE IF EXISTS `vi`;
CREATE TABLE `vi`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int NULL DEFAULT NULL,
  `id_loai_vi` int NULL DEFAULT NULL,
  `money` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `modified_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vi
-- ----------------------------
INSERT INTO `vi` VALUES (1, 2, 1, '874525740', 'a233', '2021-01-19 22:59:00');
INSERT INTO `vi` VALUES (2, 2, 2, '1233333', 'asd', '2021-01-06 21:54:34');

SET FOREIGN_KEY_CHECKS = 1;
