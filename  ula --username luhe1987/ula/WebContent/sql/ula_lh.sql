-- MySQL dump 10.10
--
-- Host: localhost    Database: ula
-- ------------------------------------------------------
-- Server version	5.0.27-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aboutinfo`
--

DROP TABLE IF EXISTS `aboutinfo`;
CREATE TABLE `aboutinfo` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(200) NOT NULL,
  `content` varchar(5000) NOT NULL,
  `author` varchar(100) default NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `aboutinfo`
--

LOCK TABLES `aboutinfo` WRITE;
/*!40000 ALTER TABLE `aboutinfo` DISABLE KEYS */;
INSERT INTO `aboutinfo` VALUES (1,'公司介绍','sdfasdf',NULL,'2010-06-17 18:06:25'),(2,'业务范围','aaa\r\n',NULL,'2010-06-17 16:09:20'),(3,'人员介绍','介绍内容',NULL,'2010-06-17 20:39:48'),(4,'美好回忆','美好回忆介绍\r\n',NULL,'2010-06-17 20:18:04');
/*!40000 ALTER TABLE `aboutinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(200) NOT NULL,
  `content` varchar(2000) NOT NULL,
  `tag` char(20) default NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'大连简介','内容 可以有图片','intro','2010-06-17 20:55:03'),(2,'大连历史有关。','大连历史内容','history','2010-06-18 08:59:05');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(200) NOT NULL,
  `content` varchar(2000) NOT NULL,
  `tag` char(20) default NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,'俄罗斯客户联系方式','内容','','2010-06-14 23:03:49'),(2,'中国客户联系方式','中国客户联系方式','','2010-06-17 21:15:38'),(3,'个人游客','联系方式内容','','2010-06-17 21:15:26');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interface`
--

DROP TABLE IF EXISTS `interface`;
CREATE TABLE `interface` (
  `Id` int(11) NOT NULL auto_increment,
  `CN` varchar(100) NOT NULL COMMENT '汉语描述',
  `RU` varchar(100) NOT NULL COMMENT '俄语描述',
  `TAG` varchar(100) NOT NULL COMMENT '索引字段',
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `interface`
--

LOCK TABLES `interface` WRITE;
/*!40000 ALTER TABLE `interface` DISABLE KEYS */;
INSERT INTO `interface` VALUES (3,'关于我们','','aboutus'),(6,'公司介绍','','company'),(7,'业务范围','','business'),(8,'团队介绍','','team'),(9,'美好回忆','','memory'),(10,'关于城市','','city'),(11,'大连介绍','','city_intro'),(13,'大连历史','','city_history'),(15,'景点、公园','','city_tourspot'),(21,'市内','','city_tourspot_city'),(22,'旅顺','','city_tourspot_lvshun'),(23,'开发区 |   金石滩','','city_tourspot_devzone'),(24,'大连美食','','food'),(25,'大连居住','','house'),(26,'大连购物','','shopping'),(27,'大连交通','','transportation'),(28,'大连治疗','','therapy'),(29,'大连节日','','festival'),(30,'展会信息','','exhibit'),(31,'旅游项目','','program'),(32,'本月推荐','','monthrecommend'),(33,'常规行程','','schedule_regular');
/*!40000 ALTER TABLE `interface` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link`
--

DROP TABLE IF EXISTS `link`;
CREATE TABLE `link` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(200) NOT NULL,
  `url` varchar(100) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `link`
--

LOCK TABLES `link` WRITE;
/*!40000 ALTER TABLE `link` DISABLE KEYS */;
INSERT INTO `link` VALUES (10,'雅虎','yahoo.com','2010-06-18 15:30:36'),(11,'微软','microsoft.com','2010-06-18 15:30:53'),(12,'脸书','facebook.com','2010-06-18 16:01:54'),(14,'账号','account.test.com','2010-06-18 16:06:00'),(15,'账号','account.test.com','2010-06-18 16:07:05'),(16,'账号','account.test.com','2010-06-18 16:07:22');
/*!40000 ALTER TABLE `link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(200) NOT NULL,
  `content` varchar(2000) NOT NULL,
  `tag` char(20) default NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'支付方式','支付方式添加','payment','2010-06-18 08:33:37');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
CREATE TABLE `program` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(200) NOT NULL,
  `content` varchar(2000) NOT NULL,
  `tag` char(20) default NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `program`
--

LOCK TABLES `program` WRITE;
/*!40000 ALTER TABLE `program` DISABLE KEYS */;
INSERT INTO `program` VALUES (1,'本月推荐','内容','recommend','2010-06-16 00:29:28'),(2,'常规行程','内容','regular','2010-06-15 15:44:50'),(3,'治疗行程','内容','therapy','2010-06-15 15:34:52'),(4,'汉语学习','内容','chineselearning','2010-06-18 08:38:19'),(5,'夏令营行程','内容','summercamp','2010-06-15 15:34:32'),(6,'温泉游行程','内容','hotspring','2010-06-18 09:00:55'),(7,'展览','内容','exhibition','2010-06-18 08:58:46'),(8,'乡村游','内容','countryside','2010-06-18 08:42:44');
/*!40000 ALTER TABLE `program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `special`
--

DROP TABLE IF EXISTS `special`;
CREATE TABLE `special` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(200) NOT NULL,
  `content` varchar(2000) NOT NULL,
  `tag` char(20) default NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `special`
--

LOCK TABLES `special` WRITE;
/*!40000 ALTER TABLE `special` DISABLE KEYS */;
/*!40000 ALTER TABLE `special` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL auto_increment,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL default '0',
  `email` varchar(30) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visa`
--

DROP TABLE IF EXISTS `visa`;
CREATE TABLE `visa` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(200) NOT NULL,
  `content` varchar(2000) NOT NULL,
  `tag` char(20) default NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `visa`
--

LOCK TABLES `visa` WRITE;
/*!40000 ALTER TABLE `visa` DISABLE KEYS */;
INSERT INTO `visa` VALUES (1,'签证','内容','visa','2010-06-18 08:58:56'),(3,'票务代购','内容','ticket','2010-06-16 04:24:16'),(4,'租车服务','内容','carrental','2010-06-18 09:01:03'),(5,'翻译服务','内容','translation','2010-06-16 04:38:46'),(6,'纪念品代购','内容','translation','2010-06-16 04:24:56'),(7,'俄罗斯留学生之家','内容','russianstudents','2010-06-16 03:38:42');
/*!40000 ALTER TABLE `visa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2010-06-22  3:16:09
