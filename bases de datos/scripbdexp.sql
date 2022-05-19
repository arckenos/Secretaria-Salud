-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: expediente
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `citas`
--

DROP TABLE IF EXISTS `citas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citas` (
  `id_citas` int NOT NULL AUTO_INCREMENT,
  `id_trabajador_salud` int NOT NULL,
  `id_paciente` int NOT NULL,
  PRIMARY KEY (`id_citas`),
  KEY `id_trabajador_salud_idx` (`id_trabajador_salud`),
  KEY `id_cita_paciente_idx` (`id_paciente`),
  CONSTRAINT `id_cita_paciente` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`id_paciente`),
  CONSTRAINT `id_cita_trabajador_salud` FOREIGN KEY (`id_trabajador_salud`) REFERENCES `trabajador_salud` (`id_trabajador_salud`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citas`
--

LOCK TABLES `citas` WRITE;
/*!40000 ALTER TABLE `citas` DISABLE KEYS */;
INSERT INTO `citas` VALUES (0,2,0),(1,1,0),(2,3,0);
/*!40000 ALTER TABLE `citas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expedientes`
--

DROP TABLE IF EXISTS `expedientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expedientes` (
  `id_expediente` int NOT NULL AUTO_INCREMENT,
  `id_paciente` int NOT NULL,
  `nombre_documento` varchar(45) NOT NULL,
  `tipo_documento` varchar(45) NOT NULL,
  `fecha_documento` datetime NOT NULL,
  `archivo_documento` blob NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `comentarios` varchar(45) NOT NULL,
  `es_accesible` tinyint NOT NULL,
  PRIMARY KEY (`id_expediente`),
  KEY `id_expediente_paciente_idx` (`id_paciente`),
  CONSTRAINT `id_expediente_paciente` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`id_paciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expedientes`
--

LOCK TABLES `expedientes` WRITE;
/*!40000 ALTER TABLE `expedientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `expedientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pacientes` (
  `id_paciente` int NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(45) NOT NULL,
  `fecha_nacimiento` varchar(45) NOT NULL,
  `curp_paciente` varchar(18) NOT NULL,
  `contrasenia` varchar(15) NOT NULL,
  `tutor_paciente` int DEFAULT NULL,
  PRIMARY KEY (`id_paciente`),
  KEY `id_tutor_paciente_idx` (`tutor_paciente`),
  CONSTRAINT `id_tutor_paciente` FOREIGN KEY (`tutor_paciente`) REFERENCES `pacientes` (`id_paciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacientes`
--

LOCK TABLES `pacientes` WRITE;
/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
INSERT INTO `pacientes` VALUES (0,'Rafael Gutierrez','2001-10-30','GUNR011','123456',NULL);
/*!40000 ALTER TABLE `pacientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajador_salud`
--

DROP TABLE IF EXISTS `trabajador_salud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trabajador_salud` (
  `id_trabajador_salud` int NOT NULL AUTO_INCREMENT,
  `cedula_profesional` varchar(8) NOT NULL,
  `contrasenia` varchar(15) NOT NULL,
  `nombre_trabajador_salud` varchar(45) NOT NULL,
  PRIMARY KEY (`id_trabajador_salud`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajador_salud`
--

LOCK TABLES `trabajador_salud` WRITE;
/*!40000 ALTER TABLE `trabajador_salud` DISABLE KEYS */;
INSERT INTO `trabajador_salud` VALUES (1,'CDP12345','123456','Roberto Martin Gomez'),(2,'CDP23456','123456','Eduardo Joel Lopez'),(3,'CDP34567','123456','Martin Adrian Macias');
/*!40000 ALTER TABLE `trabajador_salud` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-18 22:22:19
