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
  `content` text NOT NULL,
  `author` varchar(100) default NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `aboutinfo`
--

LOCK TABLES `aboutinfo` WRITE;
/*!40000 ALTER TABLE `aboutinfo` DISABLE KEYS */;
INSERT INTO `aboutinfo` VALUES (1,'公司介绍','公司介绍内容。',NULL,'2010-06-27 22:26:26'),(2,'业务范围','<h3 style=\"margin-left: 40px; color: red\">\r\n	<code>业务范围介绍</code></h3>\r\n',NULL,'2010-07-25 10:37:35'),(3,'人员介绍','介绍内容',NULL,'2010-06-17 20:39:48'),(4,'美好回忆','<p>\r\n	美好回忆介绍。</p>\r\n',NULL,'2010-06-27 17:46:32');
/*!40000 ALTER TABLE `aboutinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `ID` int(10) NOT NULL auto_increment,
  `TYPE` varchar(20) NOT NULL,
  `TITLE` varchar(50) NOT NULL,
  `CONTENT` text NOT NULL,
  `USERNAME` varchar(30) NOT NULL,
  `ADDTIME` datetime NOT NULL,
  `COVERLINK` varchar(100) NOT NULL,
  `PRICE` varchar(10) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'food','美食文章','<img alt=\"\" src=\"http://localhost:8080/ula/images/editorimages/1277627975078.png\" style=\"width: 558px; height: 544px\" />','admin','2010-07-02 08:17:09','http://localhost:8080/ula/images/editorimages/1277627975078.png','23');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
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
INSERT INTO `city` VALUES (1,'大连简介','内容 可以有图片','intro','2010-06-17 20:55:03'),(2,'大连历史有关。','大连历史内容','history','2010-06-18 08:59:05'),(3,'保险','关于保险的内容，添加。','insurance','2010-07-09 10:11:22'),(4,'法律常识','<p>\r\n	法律常识的俄文内容。修改测试通过。</p>\r\n','commonlaw','2010-07-09 10:52:17'),(5,'手机信息','手机信息俄文内容。修改通过。','cellphone','2010-07-09 10:53:28'),(6,'实用建议','<p>\r\n	实用建议俄文内容。修改测试通过。</p>\r\n','advice','2010-07-09 10:54:09');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(200) NOT NULL,
  `content` text NOT NULL,
  `tag` char(20) default NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,'俄罗斯客户联系方式','内容','','2010-06-27 22:27:00'),(2,'中国客户联系方式','中国客户联系方式','','2010-06-17 21:15:38'),(3,'个人游客','联系方式内容','','2010-06-17 21:15:26');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `Id` int(11) NOT NULL auto_increment,
  `customer` varchar(50) NOT NULL,
  `email` varchar(50) default NULL,
  `feedback` text NOT NULL,
  `feedbackdate` datetime NOT NULL,
  `fromwhere` varchar(1000) default NULL,
  `reply` text,
  `replydate` datetime default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (4,'鲁赫','luhe@mgial.com','测试。','2010-07-09 16:22:49','中国','hi, how are you? test page.','2010-07-13 15:46:09'),(7,'测试者','ceshi','测试留言','2010-07-15 21:33:49','测试国家','','2010-07-15 21:34:26');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
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
INSERT INTO `interface` VALUES (3,'关于我们','','aboutus'),(6,'公司介绍','','company'),(7,'业务范围','','business'),(8,'团队介绍','','team'),(9,'美好回忆','','memory'),(10,'关于城市','','city'),(11,'大连介绍','','city_intro'),(13,'大连历史','','city_history'),(15,'景点、公园','','city_tourspot'),(21,'市内','','city_tourspot_city'),(22,'旅顺','','city_tourspot_lvshun'),(23,'开发区 |   金石滩','','city_tourspot_devzone'),(24,'大连美食','','food'),(25,'大连居住','','house'),(26,'大连购物','','shopping'),(27,'大连交通','','transportation'),(28,'大连治疗','','therapy'),(29,'大连节日','','festival'),(30,'展会信息','','exhibit'),(31,'旅游项目','','program'),(32,'本月推荐','','monthrecommend'),(33,'常规行程','','schedule_regular'),(34,'治疗行程','','schedule_therapy'),(35,'汉语学习','','schedule_chinesestudy'),(36,'夏令营','','schedule_summercamp'),(37,'温泉游','','schedule_hotspring'),(38,'展览','','schedule_exhibit'),(39,'乡村游','','schedule_countryside'),(41,'特色服务','','special'),(42,'签证','','special_visa'),(43,'酒店预订','','special_hotelbooking'),(44,'各项委托','','commission'),(45,'俄罗斯留学生之家','','special_russianstudents'),(46,'联系我们','','contactus'),(47,'客户入口','','client_entrance'),(48,'俄罗斯客户','','client_russian'),(49,'中国客户','','client_chinese'),(50,'游客入口','','client_visitor');
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
INSERT INTO `link` VALUES (10,'雅虎','yahoo.com','2010-06-27 22:30:09'),(11,'微软','microsoft.com','2010-06-18 15:30:53'),(12,'脸书','facebook.com','2010-06-18 16:01:54'),(14,'账号','account.test.com','2010-06-18 16:06:00'),(16,'鲁赫的博客','imluhe.ycool.com','2010-06-27 22:28:37');
/*!40000 ALTER TABLE `link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(200) NOT NULL,
  `content` text NOT NULL,
  `tag` char(20) default NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'支付方式','支付方式添加','payment','2010-07-09 10:54:46');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pic`
--

DROP TABLE IF EXISTS `pic`;
CREATE TABLE `pic` (
  `PICID` int(10) NOT NULL auto_increment,
  `PICNAME` varchar(100) NOT NULL,
  `PICPATH` varchar(200) NOT NULL,
  `PICTIME` datetime NOT NULL,
  `PICUSER` varchar(30) NOT NULL,
  `PICTAG` varchar(10) NOT NULL,
  PRIMARY KEY  (`PICID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pic`
--

LOCK TABLES `pic` WRITE;
/*!40000 ALTER TABLE `pic` DISABLE KEYS */;
INSERT INTO `pic` VALUES (1,'service_lifecycle.png','/images/editorimages/1277627975078.png','2010-06-27 16:39:35','admin','editor'),(3,'activity_lifecycle.png','/images/editorimages/1277628694421.png','2010-06-27 16:51:34','admin','editor'),(4,'activity_lifecycle.png','/images/editorimages/1277782520390.png','2010-06-29 11:35:20','admin','editor');
/*!40000 ALTER TABLE `pic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
CREATE TABLE `program` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(200) NOT NULL,
  `content` text NOT NULL,
  `tag` char(20) default NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `program`
--

LOCK TABLES `program` WRITE;
/*!40000 ALTER TABLE `program` DISABLE KEYS */;
INSERT INTO `program` VALUES (1,'本月推荐','内容','recommend','2010-07-22 23:20:09'),(2,'常规行程','内容','regular','2010-06-15 15:44:50'),(3,'治疗行程','内容','therapy','2010-06-15 15:34:52'),(4,'汉语学习','内容','chineselearning','2010-06-18 08:38:19'),(5,'夏令营行程','内容','summercamp','2010-06-15 15:34:32'),(6,'温泉游行程','内容','hotspring','2010-06-18 09:00:55'),(7,'展览','内容','exhibition','2010-06-24 12:38:54'),(8,'乡村游','内容','countryside','2010-06-18 08:42:44');
/*!40000 ALTER TABLE `program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation_hotel`
--

DROP TABLE IF EXISTS `reservation_hotel`;
CREATE TABLE `reservation_hotel` (
  `Id` int(11) NOT NULL auto_increment,
  `name` varchar(200) NOT NULL,
  `tel` varchar(200) default NULL,
  `email` varchar(200) NOT NULL,
  `hotelName` varchar(200) NOT NULL,
  `roomCategory` varchar(200) NOT NULL,
  `checkinDate` date NOT NULL,
  `checkoutDate` date NOT NULL,
  `men` int(5) NOT NULL default '0',
  `women` int(5) NOT NULL default '0',
  `kids` int(5) NOT NULL default '0',
  `remarks` text,
  `order_date` datetime NOT NULL,
  `done` varchar(5) default '''''',
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reservation_hotel`
--

LOCK TABLES `reservation_hotel` WRITE;
/*!40000 ALTER TABLE `reservation_hotel` DISABLE KEYS */;
INSERT INTO `reservation_hotel` VALUES (3,'鲁赫','135','email','hi','hey','2010-07-16','2010-07-30',0,0,0,'hi how are you?','2010-07-16 23:17:58','no'),(4,'鲁赫','135','email','hi','hey','2010-07-16','2010-08-27',0,0,0,'hi how are you?','2010-07-16 23:18:11','no');
/*!40000 ALTER TABLE `reservation_hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation_hotel_backup`
--

DROP TABLE IF EXISTS `reservation_hotel_backup`;
CREATE TABLE `reservation_hotel_backup` (
  `Id` int(11) NOT NULL auto_increment,
  `name` varchar(200) NOT NULL,
  `tel` varchar(200) default NULL,
  `email` varchar(200) NOT NULL,
  `hotelName` varchar(200) NOT NULL,
  `roomCategory` varchar(200) NOT NULL,
  `checkinDate` date NOT NULL,
  `checkoutDate` date NOT NULL,
  `men` int(5) NOT NULL default '0',
  `women` int(5) NOT NULL default '0',
  `kids` int(5) NOT NULL default '0',
  `remarks` text,
  `order_date` datetime NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reservation_hotel_backup`
--

LOCK TABLES `reservation_hotel_backup` WRITE;
/*!40000 ALTER TABLE `reservation_hotel_backup` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation_hotel_backup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation_travel`
--

DROP TABLE IF EXISTS `reservation_travel`;
CREATE TABLE `reservation_travel` (
  `Id` int(11) NOT NULL auto_increment,
  `touristNum` int(5) NOT NULL default '0',
  `startDate` date NOT NULL,
  `returnDate` date NOT NULL,
  `replyDeadline` date default NULL,
  `requirement` text,
  `contactName` varchar(50) NOT NULL default '0',
  `contactGender` varchar(50) NOT NULL,
  `contactPhone` varchar(50) default NULL,
  `contactEmail` varchar(50) default NULL,
  `order_date` date NOT NULL,
  `done` varchar(5) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reservation_travel`
--

LOCK TABLES `reservation_travel` WRITE;
/*!40000 ALTER TABLE `reservation_travel` DISABLE KEYS */;
INSERT INTO `reservation_travel` VALUES (2,2,'2010-07-05','2010-07-15','2010-07-02','hi','lh','male','135000763993','lh','2010-07-17','no');
/*!40000 ALTER TABLE `reservation_travel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation_travel_backup`
--

DROP TABLE IF EXISTS `reservation_travel_backup`;
CREATE TABLE `reservation_travel_backup` (
  `Id` int(11) NOT NULL auto_increment,
  `touristNum` int(5) NOT NULL default '0',
  `startDate` date NOT NULL,
  `returnDate` date NOT NULL,
  `replyDeadline` date default NULL,
  `requirement` text,
  `contactName` varchar(50) NOT NULL default '0',
  `contactGender` varchar(50) NOT NULL,
  `contactPhone` varchar(50) default NULL,
  `contactEmail` varchar(50) default NULL,
  `order_date` date NOT NULL,
  `done` varchar(5) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reservation_travel_backup`
--

LOCK TABLES `reservation_travel_backup` WRITE;
/*!40000 ALTER TABLE `reservation_travel_backup` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation_travel_backup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `special`
--

DROP TABLE IF EXISTS `special`;
CREATE TABLE `special` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(200) NOT NULL,
  `content` text NOT NULL,
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
  `USERID` int(10) NOT NULL auto_increment,
  `USERNAME` varchar(30) NOT NULL,
  `REALNAME` varchar(30) NOT NULL,
  `PASSWORD` varchar(32) NOT NULL,
  `USERROLE` varchar(10) NOT NULL,
  PRIMARY KEY  (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin','123','admin'),(3,'admin2','admin','123','user'),(4,'admin3','admin3','123','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visa`
--

DROP TABLE IF EXISTS `visa`;
CREATE TABLE `visa` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(200) NOT NULL,
  `content` text NOT NULL,
  `tag` char(20) default NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `visa`
--

LOCK TABLES `visa` WRITE;
/*!40000 ALTER TABLE `visa` DISABLE KEYS */;
INSERT INTO `visa` VALUES (1,'签证','内容','visa','2010-06-18 08:58:56'),(3,'票务代购','内容','ticket','2010-06-27 22:26:50'),(4,'租车服务','内容','carrental','2010-06-18 09:01:03'),(5,'翻译服务','内容','translation','2010-06-16 04:38:46'),(6,'纪念品代购','内容','translation','2010-06-27 22:29:31'),(7,'俄罗斯留学生之家','内容','russianstudents','2010-06-24 12:40:48');
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

-- Dump completed on 2010-07-26  8:41:41
