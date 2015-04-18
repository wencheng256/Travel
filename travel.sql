/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : travel

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-04-18 11:50:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adv
-- ----------------------------
DROP TABLE IF EXISTS `adv`;
CREATE TABLE `adv` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `image` text NOT NULL,
  `loc` varchar(20) DEFAULT NULL,
  `link` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `province` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `fk_city_01` (`province`),
  CONSTRAINT `fk_city_01` FOREIGN KEY (`province`) REFERENCES `province` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `content` varchar(300) NOT NULL,
  `User` int(11) NOT NULL,
  `travel` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `fk_comment_01` (`User`),
  KEY `fk_comment_02` (`travel`),
  CONSTRAINT `fk_comment_01` FOREIGN KEY (`User`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_comment_02` FOREIGN KEY (`travel`) REFERENCES `travel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `sort` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `sort` (`sort`),
  CONSTRAINT `label_ibfk_1` FOREIGN KEY (`sort`) REFERENCES `sort` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for location
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `location` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `fk_province_01` (`location`),
  CONSTRAINT `fk_province_01` FOREIGN KEY (`location`) REFERENCES `location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for seller
-- ----------------------------
DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `realname` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `phonenum` varchar(30) NOT NULL,
  `postbox` varchar(30) NOT NULL,
  `productinf` char(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `tip` varchar(200) NOT NULL,
  `price` int(11) NOT NULL,
  `image` text NOT NULL,
  `content` longtext,
  `label` text NOT NULL,
  `city` int(11) NOT NULL,
  `seller` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `fk_ticket_01` (`city`),
  KEY `fk_ticket_02` (`seller`),
  CONSTRAINT `fk_ticket_01` FOREIGN KEY (`city`) REFERENCES `city` (`id`),
  CONSTRAINT `fk_ticket_02` FOREIGN KEY (`seller`) REFERENCES `seller` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ticketlabel
-- ----------------------------
DROP TABLE IF EXISTS `ticketlabel`;
CREATE TABLE `ticketlabel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for travel
-- ----------------------------
DROP TABLE IF EXISTS `travel`;
CREATE TABLE `travel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `tip` varchar(200) NOT NULL,
  `price` int(11) NOT NULL,
  `image` text NOT NULL,
  `content` longtext,
  `label` text NOT NULL,
  `city` int(11) NOT NULL,
  `seller` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `fk_travel_01` (`city`),
  KEY `fk_travel_02` (`seller`),
  CONSTRAINT `fk_travel_01` FOREIGN KEY (`city`) REFERENCES `city` (`id`),
  CONSTRAINT `fk_travel_02` FOREIGN KEY (`seller`) REFERENCES `seller` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `realname` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `phonenum` varchar(30) NOT NULL,
  `postbox` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
