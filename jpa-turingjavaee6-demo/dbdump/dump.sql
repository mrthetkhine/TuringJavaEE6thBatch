-- MySQL dump 10.13  Distrib 8.0.38, for macos14 (x86_64)
--
-- Host: localhost    Database: javaee6th_batch
-- ------------------------------------------------------
-- Server version	9.0.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actor`
--

DROP TABLE IF EXISTS `actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(128) DEFAULT NULL,
  `last_name` varchar(128) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `gender` smallint DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor`
--

LOCK TABLES `actor` WRITE;
/*!40000 ALTER TABLE `actor` DISABLE KEYS */;
INSERT INTO `actor` VALUES (1,'Leonardo','Dicapario','1974-11-11 00:00:00',0,'2024-09-15 19:59:22','2024-09-15 19:59:22'),(2,'Actor ','One ','2024-09-21 19:45:10',NULL,'2024-09-21 19:45:10','2024-09-21 19:45:10'),(3,'Actor ','Two ','2024-09-21 19:45:10',NULL,'2024-09-21 19:45:10','2024-09-21 19:45:10'),(4,'Actor ','Three ','2024-09-21 19:47:12',NULL,'2024-09-21 19:47:12','2024-09-21 19:47:12'),(5,'Actor ','Four ','2024-09-21 19:47:12',NULL,'2024-09-21 19:47:12','2024-09-21 19:47:12'),(6,'Actor','Six','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(7,'Actor','6','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(8,'Actor','7','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(9,'Actor','8','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(10,'Actor','9','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(11,'Actor','10','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(12,'Actor','11','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(13,'Actor','12','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(14,'Actor','13','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(15,'Actor','14','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(16,'Actor','15','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(17,'Actor','16','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(18,'Actor','17','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(19,'Actor','18','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(20,'Actor','19','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(21,'Actor','20','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(22,'Actor','21','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(23,'Actor','22','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(24,'Actor','23','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(25,'Actor','24','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(26,'Actor','25','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(27,'Actor','26','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(28,'Actor','27','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(29,'Actor','28','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(30,'Actor','29','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(31,'Actor','30','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(32,'Actor','31','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(33,'Actor','32','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(34,'Actor','33','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42');
/*!40000 ALTER TABLE `actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actor_in_movie`
--

DROP TABLE IF EXISTS `actor_in_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actor_in_movie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `movie_id` int DEFAULT NULL,
  `actor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor_in_movie`
--

LOCK TABLES `actor_in_movie` WRITE;
/*!40000 ALTER TABLE `actor_in_movie` DISABLE KEYS */;
INSERT INTO `actor_in_movie` VALUES (10,1,2),(11,1,3),(12,2,4),(13,2,5);
/*!40000 ALTER TABLE `actor_in_movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank_account`
--

DROP TABLE IF EXISTS `bank_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank_account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_name` varchar(255) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_account`
--

LOCK TABLES `bank_account` WRITE;
/*!40000 ALTER TABLE `bank_account` DISABLE KEYS */;
INSERT INTO `bank_account` VALUES (1,'Account A',1500,'2024-09-29 18:47:04','2024-09-29 19:06:01'),(2,'Account B',500,'2024-09-29 18:47:04','2024-09-29 18:54:41');
/*!40000 ALTER TABLE `bank_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `year` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Title 1','Description 1','Author 1',2010),(2,'Title 2','Description 2','Author 1',2020),(3,'Title 3 update','Author 3 update','Author 3 update',2015);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `movie_id` int DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (19,1,'Comment 1','2024-09-21 20:14:41','2024-09-21 20:14:41'),(20,1,'Comment 2','2024-09-21 20:14:41','2024-09-21 20:14:41'),(21,2,'Comment 2','2024-09-21 20:15:54','2024-09-21 20:15:54'),(22,2,'Comment 3','2024-09-21 20:15:54','2024-09-21 20:15:54'),(25,NULL,'Comment 5','2024-09-21 20:20:06','2024-09-21 20:20:06'),(26,NULL,'Comment 6','2024-09-21 20:20:06','2024-09-21 20:20:06');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `director`
--

DROP TABLE IF EXISTS `director`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `director` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(128) DEFAULT NULL,
  `last_name` varchar(128) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `gender` smallint DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `director`
--

LOCK TABLES `director` WRITE;
/*!40000 ALTER TABLE `director` DISABLE KEYS */;
INSERT INTO `director` VALUES (1,'Director','One','2024-09-22 18:40:03',0,'2024-09-22 18:40:03','2024-09-22 18:40:03'),(2,'Director','Two','1980-08-15 00:00:00',0,'2024-09-22 18:40:03','2024-09-22 18:40:03'),(3,'Director','Three','2024-09-22 18:44:56',0,'2024-09-22 18:44:56','2024-09-22 18:44:56'),(4,'Director','Four','2015-02-20 00:00:00',0,'2024-09-22 18:44:56','2024-09-22 18:44:56');
/*!40000 ALTER TABLE `director` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `director_in_movie`
--

DROP TABLE IF EXISTS `director_in_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `director_in_movie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `movie_id` int DEFAULT NULL,
  `director_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `director_in_movie`
--

LOCK TABLES `director_in_movie` WRITE;
/*!40000 ALTER TABLE `director_in_movie` DISABLE KEYS */;
INSERT INTO `director_in_movie` VALUES (14,1,1),(15,1,2),(16,2,3),(17,2,4);
/*!40000 ALTER TABLE `director_in_movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `genre` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Movie 1',2010,'Drama','2024-09-21 19:04:58','2024-09-21 19:04:58'),(2,'Movie 2',2015,'Drama','2024-09-21 19:05:31','2024-09-21 19:05:31'),(4,'New Movie 3',2020,'Sci-Fi','2024-09-21 20:19:14','2024-09-21 20:19:14'),(7,'MovieTitle1',2010,NULL,'2024-09-28 20:23:20',NULL),(8,'MovieTitle1',2010,NULL,'2024-09-28 20:23:20',NULL);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_details`
--

DROP TABLE IF EXISTS `movie_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `movie_id` int DEFAULT NULL,
  `details` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_details`
--

LOCK TABLES `movie_details` WRITE;
/*!40000 ALTER TABLE `movie_details` DISABLE KEYS */;
INSERT INTO `movie_details` VALUES (1,1,'Movie 1 Details','2024-09-21 19:04:58','2024-09-21 19:04:58'),(2,2,'Movie 2 Details','2024-09-21 19:05:31','2024-09-21 19:05:31');
/*!40000 ALTER TABLE `movie_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-29 20:20:35
