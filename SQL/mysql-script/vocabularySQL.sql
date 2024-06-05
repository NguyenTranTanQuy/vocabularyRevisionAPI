CREATE DATABASE  IF NOT EXISTS `vocabulary_revision` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `vocabulary_revision`;
-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: localhost    Database: vocabulary_revision
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `detailed_level`
--

DROP TABLE IF EXISTS `detailed_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detailed_level` (
  `created_at` datetime(6) DEFAULT NULL,
  `level_levelid` bigint NOT NULL,
  `user_username` varchar(255) NOT NULL,
  PRIMARY KEY (`level_levelid`,`user_username`),
  KEY `FKneokmojae6ulf5hnqfui8ibtn` (`user_username`),
  CONSTRAINT `FKneokmojae6ulf5hnqfui8ibtn` FOREIGN KEY (`user_username`) REFERENCES `user` (`username`),
  CONSTRAINT `FKrvejiw3f1tl2ci659cgdua40m` FOREIGN KEY (`level_levelid`) REFERENCES `level` (`levelid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailed_level`
--

LOCK TABLES `detailed_level` WRITE;
/*!40000 ALTER TABLE `detailed_level` DISABLE KEYS */;
INSERT INTO `detailed_level` VALUES ('2024-06-04 12:11:18.640000',1,'tanquy0401'),('2024-06-04 12:11:43.008000',2,'tanquy0401'),('2024-06-04 13:58:33.740000',3,'tanquy0401'),('2024-06-04 14:00:22.346000',4,'tanquy0401');
/*!40000 ALTER TABLE `detailed_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `folder`
--

DROP TABLE IF EXISTS `folder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `folder` (
  `folderid` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `folder_name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`folderid`),
  KEY `FK7e3tp86jlv3pgynlnbsd4ggrn` (`username`),
  CONSTRAINT `FK7e3tp86jlv3pgynlnbsd4ggrn` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `folder`
--

LOCK TABLES `folder` WRITE;
/*!40000 ALTER TABLE `folder` DISABLE KEYS */;
INSERT INTO `folder` VALUES (1,'A','ABCD','tanquy0401');
/*!40000 ALTER TABLE `folder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level`
--

DROP TABLE IF EXISTS `level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `level` (
  `experience` int NOT NULL,
  `levelid` bigint NOT NULL AUTO_INCREMENT,
  `level_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`levelid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level`
--

LOCK TABLES `level` WRITE;
/*!40000 ALTER TABLE `level` DISABLE KEYS */;
INSERT INTO `level` VALUES (0,1,'Cấp 0'),(100,2,'Cấp 1'),(200,3,'Cấp 2'),(300,4,'Cấp 3'),(400,5,'Cấp 4'),(500,6,'Cấp 5');
/*!40000 ALTER TABLE `level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `created_at` datetime(6) DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `experience` bigint DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('2024-06-04 12:11:18.603000','2002-01-04 07:00:00.000000',310,'quyglpk12@gmail.com','Nguyen Tran Tan','Quy 111','123456','tanquy0401');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_progress`
--

DROP TABLE IF EXISTS `user_progress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_progress` (
  `correct_attempts` int NOT NULL,
  `incorrect_attempts` int NOT NULL,
  `last_attempt_date` datetime(6) DEFAULT NULL,
  `vocabulary_vocabularyid` bigint NOT NULL,
  `user_username` varchar(255) NOT NULL,
  PRIMARY KEY (`vocabulary_vocabularyid`,`user_username`),
  KEY `FKae9aj0otfoeldenl0kmkemfhs` (`user_username`),
  CONSTRAINT `FKae9aj0otfoeldenl0kmkemfhs` FOREIGN KEY (`user_username`) REFERENCES `user` (`username`),
  CONSTRAINT `FKw28fyrl8i0qwsj6pcj12vxy9` FOREIGN KEY (`vocabulary_vocabularyid`) REFERENCES `vocabulary` (`vocabularyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_progress`
--

LOCK TABLES `user_progress` WRITE;
/*!40000 ALTER TABLE `user_progress` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_progress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vocabulary`
--

DROP TABLE IF EXISTS `vocabulary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vocabulary` (
  `vocabulary_listid` bigint DEFAULT NULL,
  `vocabularyid` bigint NOT NULL AUTO_INCREMENT,
  `definition` varchar(255) DEFAULT NULL,
  `word` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vocabularyid`),
  KEY `FK2uyoq6jlldfyx5hmhfmrfpfwy` (`vocabulary_listid`),
  CONSTRAINT `FK2uyoq6jlldfyx5hmhfmrfpfwy` FOREIGN KEY (`vocabulary_listid`) REFERENCES `vocabulary_lists` (`vocabulary_listid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vocabulary`
--

LOCK TABLES `vocabulary` WRITE;
/*!40000 ALTER TABLE `vocabulary` DISABLE KEYS */;
INSERT INTO `vocabulary` VALUES (4,1,'A','A'),(4,2,'B','B');
/*!40000 ALTER TABLE `vocabulary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vocabulary_lists`
--

DROP TABLE IF EXISTS `vocabulary_lists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vocabulary_lists` (
  `folderid` bigint DEFAULT NULL,
  `vocabulary_listid` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `list_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vocabulary_listid`),
  KEY `FK1f0unrfvvovgkfat6n1a2hk9t` (`folderid`),
  CONSTRAINT `FK1f0unrfvvovgkfat6n1a2hk9t` FOREIGN KEY (`folderid`) REFERENCES `folder` (`folderid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vocabulary_lists`
--

LOCK TABLES `vocabulary_lists` WRITE;
/*!40000 ALTER TABLE `vocabulary_lists` DISABLE KEYS */;
INSERT INTO `vocabulary_lists` VALUES (1,3,'100 từ vựng về nhà cửa','Bài 1'),(1,4,'100 từ vựng về nhà cửa','Bài 1');
/*!40000 ALTER TABLE `vocabulary_lists` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-04 21:43:14
