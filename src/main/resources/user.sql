/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : my_blog

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2018-03-22 21:29:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `head` varchar(255) DEFAULT NULL,
  `home_url` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `admin` tinyint(4) DEFAULT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `last_login_ip` varchar(50) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', null, null, 'b', '2', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('7', null, null, 'c', '3', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('8', null, null, 'd', '4', null, null, null, null, null, null, null, null, null, null);
