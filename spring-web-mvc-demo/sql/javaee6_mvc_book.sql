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
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor`
--

LOCK TABLES `actor` WRITE;
/*!40000 ALTER TABLE `actor` DISABLE KEYS */;
INSERT INTO `actor` VALUES (4,'Leonardo','Decaprio','2024-09-21 19:47:12',0,'2024-09-21 19:47:12','2024-09-21 19:47:12'),(5,'Actor ','Four ','2024-09-21 19:47:12',0,'2024-09-21 19:47:12','2024-09-21 19:47:12'),(6,'Actor','Six','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(7,'Actor','6','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(8,'Actor','7','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(9,'Actor','8','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(10,'Actor','9','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(11,'Actor','10','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(12,'Actor','11','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(13,'Actor','12','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(14,'Actor','13','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(15,'Actor','14','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(16,'Actor','15','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(17,'Actor','16','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(18,'Actor','17','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(19,'Actor','18','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(20,'Actor','19','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(21,'Actor','20','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(22,'Actor','21','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(23,'Actor','22','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(24,'Actor','23','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(25,'Actor','24','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(26,'Actor','25','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(27,'Actor','26','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(28,'Actor','27','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(29,'Actor','28','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(30,'Actor','29','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(31,'Actor','30','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(32,'Actor','31','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(33,'Actor','32','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(34,'Actor','33','1974-11-11 00:00:00',0,'2024-09-28 19:51:42','2024-09-28 19:51:42'),(36,'Actor','Another','2024-10-08 23:26:13',NULL,'2024-10-08 23:26:13','2024-10-08 23:26:13'),(37,'Actor ','Four ','2024-10-08 23:26:13',NULL,'2024-10-08 23:26:13','2024-10-08 23:26:13');
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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor_in_movie`
--

LOCK TABLES `actor_in_movie` WRITE;
/*!40000 ALTER TABLE `actor_in_movie` DISABLE KEYS */;
INSERT INTO `actor_in_movie` VALUES (12,2,4),(13,2,5),(17,25,4),(19,25,5),(30,27,7),(31,27,8),(32,7,9),(33,7,10),(34,7,11),(35,2,36),(36,2,37),(37,2,11),(38,2,10),(39,28,4),(40,28,5);
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
INSERT INTO `comment` VALUES (21,2,'Comment 2','2024-09-21 20:15:54','2024-09-21 20:15:54'),(22,2,'Comment 3','2024-09-21 20:15:54','2024-09-21 20:15:54'),(25,NULL,'Comment 5','2024-09-21 20:20:06','2024-09-21 20:20:06'),(26,NULL,'Comment 6','2024-09-21 20:20:06','2024-09-21 20:20:06');
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
INSERT INTO `director` VALUES (3,'Director','Three','2024-09-22 18:44:56',0,'2024-09-22 18:44:56','2024-09-22 18:44:56'),(4,'Director','Four','2015-02-20 00:00:00',0,'2024-09-22 18:44:56','2024-09-22 18:44:56');
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
INSERT INTO `director_in_movie` VALUES (16,2,3),(17,2,4);
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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (2,'Movie 2',2015,'Drama','2024-09-21 19:05:31','2024-09-21 19:05:31'),(4,'New Movie 3',2020,'Sci-Fi','2024-09-21 20:19:14','2024-09-21 20:19:14'),(7,'MovieTitle 7',2010,'Drama','2024-09-28 20:23:20',NULL),(25,'Movie 8',2010,'Sci-Fi','2024-10-08 20:52:38','2024-10-08 20:52:38'),(27,'Movie 10',2010,'Sci-Fi','2024-10-08 20:52:50','2024-10-08 20:52:50'),(28,'Movie 11',2010,'Sci-Fi','2024-10-12 19:15:45','2024-10-12 19:15:45');
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_details`
--

LOCK TABLES `movie_details` WRITE;
/*!40000 ALTER TABLE `movie_details` DISABLE KEYS */;
INSERT INTO `movie_details` VALUES (2,2,'Movie 2 Details','2024-09-21 19:05:31','2024-09-21 19:05:31'),(9,NULL,'Movie 2 Details','2024-10-05 20:15:56','2024-10-05 20:15:56'),(10,18,'Test movie details 10','2024-10-05 20:18:39','2024-10-05 20:18:39'),(11,17,'Test movie details 10','2024-10-05 20:18:39','2024-10-05 20:18:39'),(13,22,'Test movie details 11','2024-10-08 19:32:55','2024-10-08 19:32:55'),(14,21,'Test movie details 11','2024-10-08 19:32:55','2024-10-08 19:32:55'),(15,23,'Test movie details 11','2024-10-08 19:39:23','2024-10-08 19:39:23'),(17,25,'Test movie details 8','2024-10-08 20:52:38','2024-10-08 20:52:38'),(19,27,'Test movie details 10','2024-10-08 20:52:50','2024-10-08 20:52:50'),(20,28,'Test movie details 11','2024-10-12 19:15:45','2024-10-12 19:15:45');
/*!40000 ALTER TABLE `movie_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` varchar(45) DEFAULT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN','1'),(2,'ROLE_USER','2');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$10$Xp62NxqP6qCfTXfBN0GAheN1kfywSEsyz5ltNCoedNZL03kl.ykrC'),(2,'user','$2a$10$hBq1QvzgAjfqp.6mBMzniOd2qpuhvYNCPfECZkqXZiHwGJiK2U1sW');
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

-- Dump completed on 2024-10-19 20:33:30
