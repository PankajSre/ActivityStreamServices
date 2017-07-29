-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: activitystream
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `circle`
--

DROP TABLE IF EXISTS `circle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `circle` (
  `circleId` int(11) NOT NULL,
  `circleName` varchar(255) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`circleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `circle`
--

LOCK TABLES `circle` WRITE;
/*!40000 ALTER TABLE `circle` DISABLE KEYS */;
INSERT INTO `circle` VALUES (0,NULL,NULL,NULL,'\0'),(7,'DigiNxt','advik@gmail.com','2017-07-26 18:14:17',''),(10,'Stackroute','pankaj@gmail.com','2017-07-26 18:56:42','');
/*!40000 ALTER TABLE `circle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (23);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `messageId` int(11) NOT NULL,
  `circleId` int(11) NOT NULL,
  `maximumSize` bigint(20) NOT NULL,
  `messageSize` bigint(20) NOT NULL,
  `messageText` varchar(255) DEFAULT NULL,
  `messageType` varchar(255) DEFAULT NULL,
  `receiverEmailId` varchar(255) DEFAULT NULL,
  `senderEmailId` varchar(255) DEFAULT NULL,
  `sentDate` datetime DEFAULT NULL,
  PRIMARY KEY (`messageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (15,7,10000000,15,'I am Doing fine','Text','pankaj@gmail.com','advik@gmail.com','2017-07-27 13:55:40'),(16,7,10000000,15,'I am Doing fine','Text','pankaj@gmail.com','advik@gmail.com','2017-07-27 14:31:19'),(17,7,10000000,15,'I am Doing fine','Text','pankaj@gmail.com','advik@gmail.com','2017-07-27 14:45:22'),(18,7,10000000,15,'I am Doing fine','Text','pankaj@gmail.com','advik@gmail.com','2017-07-27 14:52:29'),(19,7,10000000,15,'I am Doing fine','Text','pankaj@gmail.com','advik@gmail.com','2017-07-27 14:58:01');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `emailId` varchar(255) NOT NULL,
  `isActive` bit(1) NOT NULL,
  `mobileNumber` bigint(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`emailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('krishna@gmail.com','\0',9876543212,'krishna','krishna'),('ram@gmail.com','',800724072,'ram','ram');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_circle`
--

DROP TABLE IF EXISTS `user_circle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_circle` (
  `circle_id` int(11) NOT NULL AUTO_INCREMENT,
  `circle_name` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`circle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_circle`
--

LOCK TABLES `user_circle` WRITE;
/*!40000 ALTER TABLE `user_circle` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_circle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usercircle`
--

DROP TABLE IF EXISTS `usercircle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usercircle` (
  `circleId` int(11) NOT NULL,
  `circleName` varchar(255) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`circleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usercircle`
--

LOCK TABLES `usercircle` WRITE;
/*!40000 ALTER TABLE `usercircle` DISABLE KEYS */;
INSERT INTO `usercircle` VALUES (21,'Stackroute','pankaj@gmail.com','2017-07-28 17:26:32','\0'),(22,'Hackers','raman@gmail.com','2017-07-28 17:26:59','');
/*!40000 ALTER TABLE `usercircle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermessage`
--

DROP TABLE IF EXISTS `usermessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usermessage` (
  `messageId` int(11) NOT NULL,
  `circleId` int(11) NOT NULL,
  `maximumSize` bigint(20) NOT NULL,
  `messageSize` bigint(20) NOT NULL,
  `messageText` varchar(255) DEFAULT NULL,
  `messageType` varchar(255) DEFAULT NULL,
  `receiverEmailId` varchar(255) DEFAULT NULL,
  `senderEmailId` varchar(255) DEFAULT NULL,
  `sentDate` datetime DEFAULT NULL,
  PRIMARY KEY (`messageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermessage`
--

LOCK TABLES `usermessage` WRITE;
/*!40000 ALTER TABLE `usermessage` DISABLE KEYS */;
INSERT INTO `usermessage` VALUES (12,7,10000000,10,'Hello Dear','Text','advik@gmail.com','pankaj@gmail.com','2017-07-27 13:07:48'),(13,7,10000000,9,'I am Here','Text','advik@gmail.com','pankaj@gmail.com','2017-07-27 13:08:12'),(14,7,10000000,15,'I am Doing fine','Text','pankaj@gmail.com','advik@gmail.com','2017-07-27 13:08:40');
/*!40000 ALTER TABLE `usermessage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-29 21:25:19
