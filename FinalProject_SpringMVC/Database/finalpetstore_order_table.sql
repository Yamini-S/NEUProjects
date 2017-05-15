-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: finalpetstore
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `order_table`
--

DROP TABLE IF EXISTS `order_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_table` (
  `order_Id` int(11) NOT NULL AUTO_INCREMENT,
  `creation_date` datetime DEFAULT NULL,
  `order_desc` varchar(255) DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_table`
--

LOCK TABLES `order_table` WRITE;
/*!40000 ALTER TABLE `order_table` DISABLE KEYS */;
INSERT INTO `order_table` VALUES (1,'2016-04-23 21:30:28','order is placed by 2','Confirmed',2),(2,'2016-04-23 21:40:33','order is placed by 2','Confirmed',2),(3,'2016-04-23 21:43:16','order is placed by 2','Confirmed',2),(4,'2016-04-23 21:49:55','order is placed by 2','Confirmed',2),(5,'2016-04-23 21:57:10','order is placed by 2','Confirmed',2),(6,'2016-04-23 22:00:27','order is placed by 2','Confirmed',2),(7,'2016-04-23 22:01:02','order is placed by 2','Confirmed',2),(8,'2016-04-23 22:33:04','order is placed by 2','Confirmed',2),(9,'2016-04-23 22:44:37','order is placed by 2','Confirmed',2),(10,'2016-04-23 22:54:53','order is placed by 2','Confirmed',2),(11,'2016-04-23 23:00:01','order is placed by 2','Confirmed',2),(12,'2016-04-23 23:01:13','order is placed by 2','Confirmed',2),(13,'2016-04-23 23:13:34','order is placed by 2','Confirmed',2),(14,'2016-04-23 23:16:15','order is placed by 2','Confirmed',2),(15,'2016-04-23 23:19:03','order is placed by 2','Confirmed',2),(16,'2016-04-23 23:22:07','order is placed by 2','Confirmed',2),(17,'2016-04-23 23:24:15','order is placed by 2','Confirmed',2),(18,'2016-04-23 23:46:20','order is placed by 2','Confirmed',2),(19,'2016-04-23 23:53:15','order is placed by 2','Confirmed',2),(20,'2016-04-24 00:25:54','order is placed by 2','Confirmed',2),(21,'2016-04-24 10:40:50','order is placed by 2','Confirmed',2),(22,'2016-04-24 11:24:29','order is placed by 2','Confirmed',2),(23,'2016-04-24 22:54:46','order is placed by 2','Confirmed',2),(24,'2016-04-24 22:55:18','order is placed by 2','Confirmed',2),(25,'2016-04-25 09:33:15','order is placed by 2','Confirmed',2),(26,'2016-04-25 11:29:50','order is placed by 4','Confirmed',4),(27,'2016-04-25 15:44:01','order is placed by 4','Confirmed',4),(28,'2016-04-25 16:23:01','order is placed by 4','Confirmed',4),(29,'2016-04-25 20:51:48','order is placed by 4','Proceed To Confirm',4),(30,'2016-04-25 20:52:30','order is placed by 4','Proceed To Confirm',4),(31,'2016-04-25 20:56:55','order is placed by 4','Proceed To Confirm',4),(32,'2016-04-25 20:57:51','order is placed by 4','Proceed To Confirm',4),(33,'2016-04-25 21:00:38','order is placed by 4','Proceed To Confirm',4),(34,'2016-04-25 23:38:31','order is placed by 2','Proceed To Confirm',2);
/*!40000 ALTER TABLE `order_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-26  8:15:52
