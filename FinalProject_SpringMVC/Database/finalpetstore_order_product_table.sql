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
-- Table structure for table `order_product_table`
--

DROP TABLE IF EXISTS `order_product_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_product_table` (
  `order_Id` int(11) NOT NULL,
  `CREATION_DATE` datetime DEFAULT NULL,
  `OFFER_ID` int(11) DEFAULT NULL,
  `PRICE` int(11) DEFAULT NULL,
  `PROD_DESC` varchar(255) DEFAULT NULL,
  `PROD_NAME` varchar(255) DEFAULT NULL,
  KEY `FK5E64354D8B87E160` (`order_Id`),
  CONSTRAINT `FK5E64354D8B87E160` FOREIGN KEY (`order_Id`) REFERENCES `order_table` (`order_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_product_table`
--

LOCK TABLES `order_product_table` WRITE;
/*!40000 ALTER TABLE `order_product_table` DISABLE KEYS */;
INSERT INTO `order_product_table` VALUES (1,'2016-04-23 21:30:28',2,78,'NA',NULL),(2,'2016-04-23 21:40:33',3,78,'NA',NULL),(2,'2016-04-23 21:40:33',2,78,'NA',NULL),(3,'2016-04-23 21:43:16',2,78,'NA',NULL),(3,'2016-04-23 21:43:16',2,78,'NA',NULL),(4,'2016-04-23 21:49:55',2,78,'NA',NULL),(5,'2016-04-23 21:57:10',2,78,'NA',NULL),(6,'2016-04-23 22:00:27',2,78,'NA',NULL),(7,'2016-04-23 22:01:02',2,78,'NA',NULL),(7,'2016-04-23 22:01:02',4,78,'gh',NULL),(8,'2016-04-23 22:33:04',2,78,'NA','d3'),(9,'2016-04-23 22:44:37',2,78,'NA','d3'),(9,'2016-04-23 22:44:37',7,12,'Food','Pedigree'),(10,'2016-04-23 22:54:53',7,12,'Food','Pedigree'),(11,'2016-04-23 23:00:01',7,12,'Food','Pedigree'),(12,'2016-04-23 23:01:13',7,12,'Food','Pedigree'),(13,'2016-04-23 23:13:34',9,16,'Biscuits for cats','catBiscuits'),(14,'2016-04-23 23:16:15',8,13,'Cat Food','Porkar'),(15,'2016-04-23 23:19:03',8,13,'Cat Food','Porkar'),(16,'2016-04-23 23:22:07',10,14,'Food','cat Nuts'),(17,'2016-04-23 23:24:15',7,12,'Food','Pedigree'),(18,'2016-04-23 23:46:20',9,16,'Biscuits for cats','catBiscuits'),(19,'2016-04-23 23:53:15',8,13,'Cat Food','Porkar'),(20,'2016-04-24 00:25:54',10,14,'Food','cat Nuts'),(21,'2016-04-24 10:40:50',7,12,'Food','Pedigree'),(22,'2016-04-24 11:24:29',8,13,'Cat Food','Porkar'),(23,'2016-04-24 22:54:46',7,12,'Food','Pedigree'),(24,'2016-04-24 22:55:18',7,12,'Food','Pedigree'),(24,'2016-04-24 22:55:18',7,12,'Food','Pedigree'),(25,'2016-04-25 09:33:15',7,12,'Food','Pedigree'),(25,'2016-04-25 09:33:15',13,17,'Accessories','Fashion Belt'),(26,'2016-04-25 11:29:50',14,12,'Food for pets','Friskies'),(27,'2016-04-25 15:44:01',7,12,'Food','Pedigree'),(28,'2016-04-25 16:23:01',11,14,'Food for pets','Health Food'),(29,'2016-04-25 20:51:48',7,12,'Food','Pedigree'),(29,'2016-04-25 20:51:48',11,14,'Food for pets','Health Food'),(29,'2016-04-25 20:51:48',13,17,'Accessories','Fashion Belt'),(30,'2016-04-25 20:52:30',7,12,'Food','Pedigree'),(30,'2016-04-25 20:52:30',11,14,'Food for pets','Health Food'),(30,'2016-04-25 20:52:30',13,17,'Accessories','Fashion Belt'),(30,'2016-04-25 20:52:30',13,17,'Accessories','Fashion Belt'),(31,'2016-04-25 20:56:55',10,14,'Food','cat Nuts'),(32,'2016-04-25 20:57:51',10,14,'Food','cat Nuts'),(32,'2016-04-25 20:57:51',11,14,'Food for pets','Health Food'),(33,'2016-04-25 21:00:38',7,12,'Food','Pedigree'),(34,'2016-04-25 23:38:31',7,12,'Food','Pedigree');
/*!40000 ALTER TABLE `order_product_table` ENABLE KEYS */;
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
