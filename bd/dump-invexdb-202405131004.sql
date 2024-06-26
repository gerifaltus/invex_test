-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: invexdb
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.21-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `au_employee`
--

DROP TABLE IF EXISTS `au_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `au_employee` (
  `id` int(11) NOT NULL,
  `REV` int(11) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `first_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mothers_last_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `second_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `id_gender` int(11) DEFAULT NULL,
  `id_position` int(11) DEFAULT NULL,
  PRIMARY KEY (`REV`,`id`),
  CONSTRAINT `FKpafo4m3kto4uxdhstf2mh7h97` FOREIGN KEY (`REV`) REFERENCES `revinfo` (`REV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `au_employee`
--

LOCK TABLES `au_employee` WRITE;
/*!40000 ALTER TABLE `au_employee` DISABLE KEYS */;
INSERT INTO `au_employee` VALUES (5,1,0,_binary '',21,'2023-05-11','ricardo auditoria','corazón','de leon','',1,3),(5,2,1,_binary '',50,'2023-05-11','ricardo auditoria 2','corazón','de leon','',1,4),(12,6,0,_binary '',21,'2022-05-11','ricardo2','corazón','de leon','',1,3),(13,6,0,_binary '',22,'2021-04-11','leonardo2','corazón','de dragón','',1,4),(14,6,0,_binary '',23,'2020-02-11','chaplin2','mekensy','segundo','',2,5),(5,7,1,_binary '',22,'2022-05-11','ricardo update','corazón','de leon','',1,3),(5,8,1,_binary '\0',22,'2022-05-11','ricardo update','corazón','de leon','',1,3);
/*!40000 ALTER TABLE `au_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalog_item`
--

DROP TABLE IF EXISTS `catalog_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalog_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name_item` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `id_catalog_main` int(11) NOT NULL,
  `description` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `catalog_item_id_catalog_main_catalog_main_id_FK` (`id_catalog_main`),
  CONSTRAINT `catalog_item_id_catalog_main_catalog_main_id_FK` FOREIGN KEY (`id_catalog_main`) REFERENCES `catalog_main` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog_item`
--

LOCK TABLES `catalog_item` WRITE;
/*!40000 ALTER TABLE `catalog_item` DISABLE KEYS */;
INSERT INTO `catalog_item` VALUES (1,'M','Masculino',1,'Genero Masculino',1,NULL),(2,'F','Femenino',1,'Genero Femenino',1,NULL),(3,'P001','Director General',2,'Director General de la empresa',1,NULL),(4,'P002','Gerente de Finanzas',2,NULL,1,NULL),(5,'P003','Gerente de TI',2,NULL,1,NULL),(6,'P004','Jefe de Departamento de Softwa',2,NULL,1,NULL),(7,'P005','Lider Técnico',2,NULL,1,NULL),(8,'P006','Desarrollador Sr',2,NULL,1,NULL),(9,'P007','Desarrollador Jr',2,NULL,1,NULL);
/*!40000 ALTER TABLE `catalog_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalog_item_aud`
--

DROP TABLE IF EXISTS `catalog_item_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalog_item_aud` (
  `id` int(11) NOT NULL,
  `REV` int(11) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name_item` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `id_catalog_main` int(11) DEFAULT NULL,
  PRIMARY KEY (`REV`,`id`),
  CONSTRAINT `FKbfgydnccq60raremwctqmtvkk` FOREIGN KEY (`REV`) REFERENCES `revinfo` (`REV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog_item_aud`
--

LOCK TABLES `catalog_item_aud` WRITE;
/*!40000 ALTER TABLE `catalog_item_aud` DISABLE KEYS */;
INSERT INTO `catalog_item_aud` VALUES (1,1,1,_binary '','M','Genero Masculino','Masculino',1),(1,3,1,_binary '','M','Genero Masculino','Masculino',1),(2,3,1,_binary '','F','Genero Femenino','Femenino',1),(1,4,1,_binary '','M','Genero Masculino','Masculino',1),(2,4,1,_binary '','F','Genero Femenino','Femenino',1),(1,6,1,_binary '','M','Genero Masculino','Masculino',1),(2,6,1,_binary '','F','Genero Femenino','Femenino',1);
/*!40000 ALTER TABLE `catalog_item_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalog_main`
--

DROP TABLE IF EXISTS `catalog_main`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalog_main` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name_catalog` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `name_item` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog_main`
--

LOCK TABLES `catalog_main` WRITE;
/*!40000 ALTER TABLE `catalog_main` DISABLE KEYS */;
INSERT INTO `catalog_main` VALUES (1,'GEN','GENDER','Genero de las personas',1,NULL),(2,'POS','POSITION','Puesto de cada persona',1,NULL);
/*!40000 ALTER TABLE `catalog_main` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `second_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mothers_last_name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `id_gender` int(11) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `id_position` int(11) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_id_gender_catalog_item_id_FK` (`id_gender`),
  KEY `employee_id_position_catalog_item_id_FK` (`id_position`),
  CONSTRAINT `employee_id_gender_catalog_item_id_FK` FOREIGN KEY (`id_gender`) REFERENCES `catalog_item` (`id`),
  CONSTRAINT `employee_id_position_catalog_item_id_FK` FOREIGN KEY (`id_position`) REFERENCES `catalog_item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (5,'ricardo update','','corazón','de leon',22,1,'2022-05-11',3,0,4),(12,'ricardo2','','corazón','de leon',21,1,'2022-05-11',3,1,0),(13,'leonardo2','','corazón','de dragón',22,1,'2021-04-11',4,1,0),(14,'chaplin2','','mekensy','segundo',23,2,'2020-02-11',5,1,0);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revinfo`
--

DROP TABLE IF EXISTS `revinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `revinfo` (
  `REV` int(11) NOT NULL AUTO_INCREMENT,
  `REVTSTMP` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`REV`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revinfo`
--

LOCK TABLES `revinfo` WRITE;
/*!40000 ALTER TABLE `revinfo` DISABLE KEYS */;
INSERT INTO `revinfo` VALUES (1,1715594495329),(2,1715594579487),(3,1715614483059),(4,1715614684296),(5,1715614738150),(6,1715615479319),(7,1715615504277),(8,1715615526915);
/*!40000 ALTER TABLE `revinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'invexdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-13 10:04:16
