/*
 Navicat MySQL Data Transfer

 Source Server         : 连接
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : manage

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 18/10/2020 20:11:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (1, '陈平安', '皮皮', '111111111', '11111@11.com');
INSERT INTO `member` VALUES (2, '宁姚', '宁', '22222222', '22222@22.com');
INSERT INTO `member` VALUES (3, '崔东山', '东方神起', '333333', '33333@33.com');
INSERT INTO `member` VALUES (4, '齐静春', '齐先生', '444444', '44444@44.com');

-- ----------------------------
-- Table structure for order_traveller
-- ----------------------------
DROP TABLE IF EXISTS `order_traveller`;
CREATE TABLE `order_traveller`  (
  `orderId` int(11) NOT NULL,
  `travellerId` int(11) NOT NULL,
  INDEX `orderId`(`orderId`) USING BTREE,
  INDEX `travellerId`(`travellerId`) USING BTREE,
  CONSTRAINT `orderId` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `travellerId` FOREIGN KEY (`travellerId`) REFERENCES `traveller` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_traveller
-- ----------------------------
INSERT INTO `order_traveller` VALUES (1, 2);
INSERT INTO `order_traveller` VALUES (1, 3);
INSERT INTO `order_traveller` VALUES (2, 1);
INSERT INTO `order_traveller` VALUES (2, 6);
INSERT INTO `order_traveller` VALUES (3, 5);
INSERT INTO `order_traveller` VALUES (3, 1);
INSERT INTO `order_traveller` VALUES (3, 2);
INSERT INTO `order_traveller` VALUES (4, 2);
INSERT INTO `order_traveller` VALUES (5, 1);
INSERT INTO `order_traveller` VALUES (6, 6);
INSERT INTO `order_traveller` VALUES (6, 5);
INSERT INTO `order_traveller` VALUES (7, 1);
INSERT INTO `order_traveller` VALUES (8, 2);
INSERT INTO `order_traveller` VALUES (8, 3);
INSERT INTO `order_traveller` VALUES (9, 6);
INSERT INTO `order_traveller` VALUES (10, 5);
INSERT INTO `order_traveller` VALUES (11, 3);
INSERT INTO `order_traveller` VALUES (12, 5);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL,
  `orderNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orderTime` timestamp(0) NULL DEFAULT NULL,
  `peopleCount` int(11) NULL DEFAULT NULL,
  `orderDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `payType` int(11) NULL DEFAULT NULL,
  `orderStatus` int(11) NULL DEFAULT NULL,
  `productId` int(11) NULL DEFAULT NULL,
  `memberId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '001', '2018-02-03 07:30:00', 1, '哈哈', 0, 1, 1, 1);
INSERT INTO `orders` VALUES (2, '002', '2020-04-15 10:15:00', 3, '嘻嘻', 1, 1, 1, 2);
INSERT INTO `orders` VALUES (3, '003', '2018-02-03 15:00:00', 2, '没什么', 0, 1, 1, 1);
INSERT INTO `orders` VALUES (4, '004', '2020-04-15 19:00:00', 2, '没什么1', 1, 1, 5, 2);
INSERT INTO `orders` VALUES (5, '005', '2018-02-03 00:00:00', 1, '没什么2', 2, 0, 1, 4);
INSERT INTO `orders` VALUES (6, '006', '2020-04-15 00:00:00', 5, '没什么6', 0, 1, 1, 4);
INSERT INTO `orders` VALUES (7, '007', '2018-02-03 00:00:00', 6, '没什么3', 1, 1, 6, 1);
INSERT INTO `orders` VALUES (8, '008', '2020-04-15 00:00:00', 2, 'aaaaa', 0, 0, 1, 3);
INSERT INTO `orders` VALUES (9, '009', '2018-02-03 00:00:00', 7, '没什么', 0, 1, 7, 1);
INSERT INTO `orders` VALUES (10, '010', '2020-04-15 00:00:00', 2, '没什么2', 2, 1, 4, 1);
INSERT INTO `orders` VALUES (11, '011', '2018-02-03 00:00:00', 2, 'cccc', 1, 0, 2, 3);
INSERT INTO `orders` VALUES (12, '012', '2020-04-15 00:00:00', 2, '没什么', 2, 1, 1, 1);
INSERT INTO `orders` VALUES (14, '014', '2020-09-08 10:30:00', 1, '666', 0, 0, 3, 2);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permissionName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '管理员', '111.com');
INSERT INTO `permission` VALUES (2, '普通号', '222.com');
INSERT INTO `permission` VALUES (4, '测试2', '444.com');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `productNum` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cityName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `departureTime` timestamp(0) NULL DEFAULT NULL,
  `productPrice` double(11, 0) NULL DEFAULT NULL,
  `productDesc` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productStatus` int(11) NULL DEFAULT NULL COMMENT '状态（0关闭 1开启）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '001', '云南一日游', '云南', '2020-04-07 07:30:00', 2100, '云南欢迎你呀22', 1);
INSERT INTO `product` VALUES (2, '002', '昆明三日游', '昆明', '2020-06-06 12:00:00', 1800, '昆明欢迎你', 1);
INSERT INTO `product` VALUES (3, '003', '上海一日游', '上海', '2020-05-08 09:00:00', 3800, '魔都欢迎你', 1);
INSERT INTO `product` VALUES (4, '004', '北京三日游', '北京', '2020-05-09 18:00:00', 5800, '北京我来了', 1);
INSERT INTO `product` VALUES (5, '005', '深圳七日游', '昆明', '2020-04-07 02:00:00', 18000, '深圳欢迎你', 1);
INSERT INTO `product` VALUES (6, '006', '昭通一日游', '昭通', '2020-05-08 15:30:00', 1200, '昭通大山包', 0);
INSERT INTO `product` VALUES (7, '007', '丽江一日游', '昆明', '2020-06-04 00:00:00', 1500, '丽江古镇', 0);
INSERT INTO `product` VALUES (8, '008', '北京二日游', '北京', '2020-09-10 00:00:00', 10000, 'ojbk', 1);
INSERT INTO `product` VALUES (9, '009', '上海五日游', '上海', '2020-09-16 00:00:00', 20000, 'nice', 0);
INSERT INTO `product` VALUES (14, '010', '安徽五日游', '苏州', '2020-10-01 10:00:00', 3000, '安徽人美水美', 1);
INSERT INTO `product` VALUES (15, '011', '湖北7日游', '苏州', '2020-10-23 21:30:00', 300000, '去湖北玩一玩 好玩', 1);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roleDesc` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ADMIN', 'vip');
INSERT INTO `role` VALUES (2, 'USER', 'vip');
INSERT INTO `role` VALUES (5, 'test', '测试角色');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `permissionId` int(11) NULL DEFAULT NULL,
  `roleId` int(11) NULL DEFAULT NULL,
  INDEX `permissionId`(`permissionId`) USING BTREE,
  INDEX `roleId`(`roleId`) USING BTREE,
  CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 1);
INSERT INTO `role_permission` VALUES (2, 2);
INSERT INTO `role_permission` VALUES (1, 1);
INSERT INTO `role_permission` VALUES (2, 1);
INSERT INTO `role_permission` VALUES (1, 2);
INSERT INTO `role_permission` VALUES (1, 5);
INSERT INTO `role_permission` VALUES (2, 5);
INSERT INTO `role_permission` VALUES (4, 1);
INSERT INTO `role_permission` VALUES (4, 2);

-- ----------------------------
-- Table structure for syslog
-- ----------------------------
DROP TABLE IF EXISTS `syslog`;
CREATE TABLE `syslog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Date` datetime(0) NULL DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `executionTime` int(11) NULL DEFAULT NULL,
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of syslog
-- ----------------------------
INSERT INTO `syslog` VALUES (1, '2020-10-18 19:15:29', 'shan', '127.0.0.1', '/product/findAll.do', 22, '[类名] com.ssm_system.controller.ProductController[方法名] findAll');
INSERT INTO `syslog` VALUES (2, '2020-10-18 19:16:17', 'shan', '127.0.0.1', '/orders/findAll.do', 0, '[类名] com.ssm_system.controller.OrdersController[方法名] findAll');
INSERT INTO `syslog` VALUES (3, '2020-10-18 19:22:26', 'shan', '127.0.0.1', '/orders/findAll.do', 79, '[类名] com.ssm_system.controller.OrdersController[方法名] findAll');
INSERT INTO `syslog` VALUES (4, '2020-10-18 19:22:48', 'shan', '127.0.0.1', '/product/findAll.do', 13, '[类名] com.ssm_system.controller.ProductController[方法名] findAll');
INSERT INTO `syslog` VALUES (5, '2020-10-18 19:23:39', 'shan', '127.0.0.1', '/product/findAll.do', 14, '[类名] com.ssm_system.controller.ProductController[方法名] findAll');
INSERT INTO `syslog` VALUES (6, '2020-10-18 19:23:43', 'shan', '127.0.0.1', '/product/findAll.do', 5, '[类名] com.ssm_system.controller.ProductController[方法名] findAll');
INSERT INTO `syslog` VALUES (7, '2020-10-18 19:23:45', 'shan', '127.0.0.1', '/permission/findAll.do', 9, '[类名] com.ssm_system.controller.PermissionController[方法名] findAll');
INSERT INTO `syslog` VALUES (8, '2020-10-18 19:23:48', 'shan', '127.0.0.1', '/role/findAll.do', 11, '[类名] com.ssm_system.controller.RoleController[方法名] findAll');
INSERT INTO `syslog` VALUES (9, '2020-10-18 19:23:50', 'shan', '127.0.0.1', '/user/findAll.do', 9, '[类名] com.ssm_system.controller.UserController[方法名] findAll');
INSERT INTO `syslog` VALUES (10, '2020-10-18 19:44:48', 'shan', '127.0.0.1', '/sysLog/findAll.do', 23, '[类名] com.ssm_system.controller.SyslogController[方法名] findAll');
INSERT INTO `syslog` VALUES (11, '2020-10-18 19:44:49', 'shan', '127.0.0.1', '/sysLog/findAll.do', 8, '[类名] com.ssm_system.controller.SyslogController[方法名] findAll');
INSERT INTO `syslog` VALUES (12, '2020-10-18 19:45:30', 'shan', '127.0.0.1', '/sysLog/findAll.do', 4, '[类名] com.ssm_system.controller.SyslogController[方法名] findAll');
INSERT INTO `syslog` VALUES (13, '2020-10-18 19:45:31', 'shan', '127.0.0.1', '/sysLog/findAll.do', 7, '[类名] com.ssm_system.controller.SyslogController[方法名] findAll');
INSERT INTO `syslog` VALUES (14, '2020-10-18 19:45:31', 'shan', '127.0.0.1', '/sysLog/findAll.do', 7, '[类名] com.ssm_system.controller.SyslogController[方法名] findAll');
INSERT INTO `syslog` VALUES (15, '2020-10-18 19:45:32', 'shan', '127.0.0.1', '/sysLog/findAll.do', 6, '[类名] com.ssm_system.controller.SyslogController[方法名] findAll');
INSERT INTO `syslog` VALUES (16, '2020-10-18 19:45:34', 'shan', '127.0.0.1', '/sysLog/findAll.do', 4, '[类名] com.ssm_system.controller.SyslogController[方法名] findAll');
INSERT INTO `syslog` VALUES (17, '2020-10-18 19:49:52', 'shan', '127.0.0.1', '/sysLog/findAll.do', 26, '[类名] com.ssm_system.controller.SyslogController[方法名] findAll');
INSERT INTO `syslog` VALUES (18, '2020-10-18 19:54:10', 'shan', '127.0.0.1', '/sysLog/findAll.do', 25, '[类名] com.ssm_system.controller.SyslogController[方法名] findAll');
INSERT INTO `syslog` VALUES (19, '2020-10-18 19:57:07', 'shan', '127.0.0.1', '/sysLog/findAll.do', 6, '[类名] com.ssm_system.controller.SyslogController[方法名] findAll');
INSERT INTO `syslog` VALUES (20, '2020-10-18 19:59:32', 'shan', '127.0.0.1', '/sysLog/findAll.do', 29, '[类名] com.ssm_system.controller.SyslogController[方法名] findAll');
INSERT INTO `syslog` VALUES (21, '2020-10-18 20:03:34', 'shan', '127.0.0.1', '/sysLog/findAll.do', 66032, '[类名] com.ssm_system.controller.SyslogController[方法名] findAll');
INSERT INTO `syslog` VALUES (22, '2020-10-18 20:05:52', 'shan', '127.0.0.1', '/sysLog/findAll.do', 16889, '[类名] com.ssm_system.controller.SyslogController[方法名] findAll');
INSERT INTO `syslog` VALUES (23, '2020-10-18 20:05:52', 'shan', '127.0.0.1', '/sysLog/findAll.do', 19807, '[类名] com.ssm_system.controller.SyslogController[方法名] findAll');
INSERT INTO `syslog` VALUES (24, '2020-10-18 20:05:52', 'shan', '127.0.0.1', '/sysLog/findAll.do', 22017, '[类名] com.ssm_system.controller.SyslogController[方法名] findAll');

-- ----------------------------
-- Table structure for traveller
-- ----------------------------
DROP TABLE IF EXISTS `traveller`;
CREATE TABLE `traveller`  (
  `id` int(11) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `credentialsType` int(11) NULL DEFAULT NULL,
  `credentialsNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `travellerType` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of traveller
-- ----------------------------
INSERT INTO `traveller` VALUES (1, '赵龙', '男', '13888888888', 0, '123456789009876543', 0);
INSERT INTO `traveller` VALUES (2, '小明', '男', '1111', 0, '112234454', 1);
INSERT INTO `traveller` VALUES (3, '小张', '男', '13356567777', 1, '111111', 0);
INSERT INTO `traveller` VALUES (4, '晴子', '女', '6666', 1, '55555555555', 0);
INSERT INTO `traveller` VALUES (5, '上校', '男', '114', 2, '89651316878975554', 0);
INSERT INTO `traveller` VALUES (6, '小豆子', '女', '17946564475', 0, '975641173464646564', 1);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `phoneNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '1014@qwe.com', 'tom', '123', 1, '180000000');
INSERT INTO `users` VALUES (2, '101asdasf@asd.cn', 'lili', '456', 0, '1518100');
INSERT INTO `users` VALUES (3, 'asdas@asdas', 'didi', '123', 1, '181002');
INSERT INTO `users` VALUES (4, '1041499672@qq.com', 'shan', '$2a$10$.R7kN2ySuTt96ZFVHGoRYewIMg6kyPpP1SaZFFESoG4vUWC.BaQCy', 1, '18012777547');
INSERT INTO `users` VALUES (5, '11@qq.com', 'qian', '$2a$10$mndi1zuAfC5RiulvgJbzPetmM4stTR6c2v5kqBp9RYs8.ToqirY/a', 1, '12123123');
INSERT INTO `users` VALUES (6, 'asdasd', 'fen', '$2a$10$Icf/PMw9U2J0R09ublRxoOaLpLzPlhXG.wRULLWGUafmxjy55Kdh.', 1, 'asdasfasd');

-- ----------------------------
-- Table structure for users_role
-- ----------------------------
DROP TABLE IF EXISTS `users_role`;
CREATE TABLE `users_role`  (
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userId`, `roleId`) USING BTREE,
  INDEX `roleId`(`roleId`) USING BTREE,
  CONSTRAINT `users_role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `users_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users_role
-- ----------------------------
INSERT INTO `users_role` VALUES (2, 1);
INSERT INTO `users_role` VALUES (3, 1);
INSERT INTO `users_role` VALUES (4, 1);
INSERT INTO `users_role` VALUES (1, 2);
INSERT INTO `users_role` VALUES (2, 2);
INSERT INTO `users_role` VALUES (3, 2);
INSERT INTO `users_role` VALUES (4, 2);
INSERT INTO `users_role` VALUES (6, 2);
INSERT INTO `users_role` VALUES (1, 5);
INSERT INTO `users_role` VALUES (2, 5);

SET FOREIGN_KEY_CHECKS = 1;
