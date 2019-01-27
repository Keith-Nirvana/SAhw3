-- MySQL dump 10.13  Distrib 5.7.21, for macos10.13 (x86_64)
--
-- Host: localhost    Database: library_information
-- ------------------------------------------------------
-- Server version	5.7.21

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
-- Table structure for table `Book`
--

DROP TABLE IF EXISTS `Book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Book` (
  `bookId` varchar(20) NOT NULL,
  `bookName` varchar(50) DEFAULT NULL,
  `category` varchar(30) DEFAULT NULL,
  `format` varchar(10) DEFAULT NULL,
  `isBorrowed` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Book`
--

LOCK TABLES `Book` WRITE;
/*!40000 ALTER TABLE `Book` DISABLE KEYS */;
INSERT INTO `Book` VALUES ('N100002','设计模式','1','DOCX',0),('N200030','assignment','0','PDF',0),('N299485','birth-of-oo','0','PDF',0);
/*!40000 ALTER TABLE `Book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Record`
--

DROP TABLE IF EXISTS `Record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Record` (
  `recordId` varchar(50) NOT NULL,
  `bookId` varchar(20) DEFAULT NULL,
  `readerId` varchar(20) DEFAULT NULL,
  `borrowDate` timestamp NULL DEFAULT NULL,
  `returnDate` timestamp NULL DEFAULT NULL,
  `payment` double DEFAULT NULL,
  PRIMARY KEY (`recordId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Record`
--

LOCK TABLES `Record` WRITE;
/*!40000 ALTER TABLE `Record` DISABLE KEYS */;
INSERT INTO `Record` VALUES ('1548475746873','hshjd','161250031','2019-01-26 04:09:07',NULL,NULL),('1548572386068','N100002','161250004','2019-01-27 06:59:46','2019-01-27 07:28:02',0);
/*!40000 ALTER TABLE `Record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `userId` varchar(20) NOT NULL,
  `password` varchar(40) DEFAULT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `department` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `permission` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES ('123','123','Max','文学院','161250004@smail.nju.edu.cn','ADMINISTRATOR',''),('131928473','123','Mike','文学院','131928473@smail.nju.edu.cn','OFFICE','12'),('161250004','123','keil','法学院','12@smail.com','GRADUATE','23'),('161250031','123','kiki','商学院','161250004@smail.nju.edu.cn','OFFICE','234'),('171273930',NULL,'Hellen',NULL,'1818@qq.com','UNDERGRADUATE','1'),('8274855',NULL,'kiii',NULL,'23@qq.com','TEACHER','1'),('FM1237493',NULL,'John','电子学院','FM1237493@smail.nju.edu.cn','UNDERGRADUATE','1'),('FM1237494',NULL,'Keith','工程管理学院','FM1237494@smail.nju.edu.cn','GRADUATE','1'),('TE1237494',NULL,'Harry','文学院','TE1237494@mail.nju.edu.cn','TEACHER','1');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `messageId` varchar(50) NOT NULL,
  `userId` varchar(30) DEFAULT NULL,
  `message` varchar(500) DEFAULT NULL,
  `isRead` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`messageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES ('2019-01-27 12:57:03','AD2937589','131928473[Mike] has change his information on Sun Jan 27 12:57:03 CST 2019',0),('2019-01-27 13:00:38','AD2937589','131928473[Mike] has change his information on Sun Jan 27 13:00:38 CST 2019',0),('2019-01-27 13:19:01','123','161250031[kiki] has change his information on Sun Jan 27 13:19:01 CST 2019',1);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-27 19:16:51
