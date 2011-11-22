-- MySQL dump 10.13  Distrib 5.1.45, for Win32 (ia32)
--
-- Host: localhost    Database: ula
-- ------------------------------------------------------
-- Server version	5.1.45-community

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
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(20) NOT NULL,
  `TITLE` varchar(50) NOT NULL,
  `CONTENT` text NOT NULL,
  `USERNAME` varchar(30) NOT NULL,
  `ADDTIME` datetime NOT NULL,
  `COVERLINK` varchar(100) NOT NULL,
  `PRICE` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'devzone','开发区','<p>\r\n	别乱码</p>\r\n','admin','2010-06-20 10:58:57','/images/1277002594310.jpg','22'),(2,'dalian','大连','<p>\r\n	&aelig;&micro;&egrave;&macr;</p>\r\n','admin','2010-06-20 11:03:09','ss','2'),(5,'devzone','金石滩','<p>\r\n	哈哈</p>\r\n','admin','2010-06-20 11:18:29','ss2',''),(6,'lvshun','龙王塘','<p>\r\n	&aelig;&eacute;&iexcl;&ordm;</p>\r\n','admin','2010-06-20 11:22:26','/ss','2'),(7,'dalian','å¤§è¿','<p>\r\n	å¤§è¿</p>\r\n','admin','2010-06-20 11:24:39','ssr',''),(11,'lvshun','旅顺不乱码','<p>\r\n	哈哈</p>\r\n','admin','2010-06-20 11:41:57','ss',''),(12,'food','美食2','<p>\r\n	美食2</p>\r\n','admin','2010-06-20 14:37:24','1',''),(14,'housing','居住','<p>\r\n	ssss</p>\r\n','admin','2010-06-20 15:47:43','ss','22'),(15,'devzone','开发区','<h3 style=\"color: blue\">\r\n	开发区</h3>\r\n','admin','2010-06-21 09:46:53','s','3'),(16,'food','美食2','<p>\r\n	美食</p>\r\n','admin','2010-06-21 09:51:19','s','44'),(17,'shopping','购物了','<p>\r\n	哈哈</p>\r\n','admin','2010-06-21 11:48:55','ss','22');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pic`
--

DROP TABLE IF EXISTS `pic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pic` (
  `PICID` int(10) NOT NULL AUTO_INCREMENT,
  `PICNAME` varchar(100) NOT NULL,
  `PICPATH` varchar(200) NOT NULL,
  `PICTIME` datetime NOT NULL,
  `PICUSER` varchar(30) NOT NULL,
  `PICTAG` varchar(10) NOT NULL,
  PRIMARY KEY (`PICID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pic`
--

LOCK TABLES `pic` WRITE;
/*!40000 ALTER TABLE `pic` DISABLE KEYS */;
INSERT INTO `pic` VALUES (1,'ofc3.jpg','/images/1277002594310.jpg','2010-06-20 10:56:34','admin','common'),(2,'42.jpg','/images/1277004323665.jpg','2010-06-20 11:25:23','admin','common');
/*!40000 ALTER TABLE `pic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `USERID` int(10) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(30) NOT NULL,
  `REALNAME` varchar(30) NOT NULL,
  `PASSWORD` varchar(32) NOT NULL,
  `USERROLE` varchar(10) NOT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin','123','admin'),(3,'admin2','admin','123','user'),(4,'admin3','admin3','123','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2010-06-22 16:33:28
