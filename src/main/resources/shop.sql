/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50634
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-04-04 15:33:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(255) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `commodity_id` varchar(11) NOT NULL,
  `buy_num` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('1', 'zsc', '2', '10');
INSERT INTO `cart` VALUES ('2', 'zsc', '3', '5');
INSERT INTO `cart` VALUES ('3', 'zsc', '11', '1');
INSERT INTO `cart` VALUES ('4', 'zsc', '5', '7');
INSERT INTO `cart` VALUES ('5', 'zsc', '10', '3');
INSERT INTO `cart` VALUES ('6', 'zsc', '9', '4');
INSERT INTO `cart` VALUES ('7', 'zsc', '12', '4');
INSERT INTO `cart` VALUES ('8', 'zsc', '7', '2');
INSERT INTO `cart` VALUES ('9', 'zsc', '13', '1');
INSERT INTO `cart` VALUES ('10', 'aa', '1', '60');
INSERT INTO `cart` VALUES ('11', 'aa', '10', '72');
INSERT INTO `cart` VALUES ('12', 'aa', '11', '14');
INSERT INTO `cart` VALUES ('13', 'aa', '14', '37');
INSERT INTO `cart` VALUES ('16', 'zsc', '1', '3');
INSERT INTO `cart` VALUES ('19', 'zsc', '14', '1');

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `id` varchar(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  `num` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES ('1', '时间简史', '48', '34');
INSERT INTO `commodity` VALUES ('10', 'Effective Java', '58', '52');
INSERT INTO `commodity` VALUES ('12', 'C Primer Plus', '82', '86');
INSERT INTO `commodity` VALUES ('13', '第一行代码', '78', '56');
INSERT INTO `commodity` VALUES ('14', '分类作文', '24', '43');
INSERT INTO `commodity` VALUES ('2', '算法导论', '34', '49');
INSERT INTO `commodity` VALUES ('22', '数学之美', '32', '45');
INSERT INTO `commodity` VALUES ('25', '知识金库', '45', '50');
INSERT INTO `commodity` VALUES ('3', '上帝掷色子', '58', '24');
INSERT INTO `commodity` VALUES ('5', '程序员修炼之道', '32', '88');
INSERT INTO `commodity` VALUES ('7', '代码整洁之道', '26', '15');
INSERT INTO `commodity` VALUES ('8', '疯狂Java讲义', '88', '30');
INSERT INTO `commodity` VALUES ('9', 'javaScript权威指南', '60', '50');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(255) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` int(1) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zsc', 'zsc', '1');
INSERT INTO `user` VALUES ('2', 'zf', 'zf', '1');
INSERT INTO `user` VALUES ('3', 'jgq', 'jgq', '1');
INSERT INTO `user` VALUES ('4', 'xwc', 'xwc', '1');
INSERT INTO `user` VALUES ('5', 'zff', 'zff', '1');
INSERT INTO `user` VALUES ('6', 'admin', 'admin', '2');
