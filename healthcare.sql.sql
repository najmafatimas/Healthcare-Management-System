-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: healthcaremangement
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `Did` int(11) NOT NULL,
  `Dname` varchar(45) NOT NULL,
  `Gender` varchar(45) NOT NULL,
  `Specialist` varchar(45) NOT NULL,
  `Timing` varchar(45) NOT NULL,
  `Qualification` varchar(45) NOT NULL,
  `RoomNo` int(11) NOT NULL,
  PRIMARY KEY (`Did`,`Dname`,`Gender`,`Specialist`,`Timing`,`Qualification`,`RoomNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'Dr.Vikram','Male','Artho','10-7','MBBS,Md',17),(2,'Dr.Rekha','Female','Child','10-5','MBBS,Md',12),(3,'Dr.Pramod','Male','Artho','10-5','BDM ,MD',8);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility`
--

DROP TABLE IF EXISTS `facility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facility` (
  `Facility_Name` varchar(25) NOT NULL,
  PRIMARY KEY (`Facility_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility`
--

LOCK TABLES `facility` WRITE;
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
INSERT INTO `facility` VALUES ('Ambulance'),('Canteen'),('Free Camp');
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab`
--

DROP TABLE IF EXISTS `lab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lab` (
  `Test_Name` varchar(25) NOT NULL,
  `Test_Cost` int(11) NOT NULL,
  PRIMARY KEY (`Test_Name`,`Test_Cost`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab`
--

LOCK TABLES `lab` WRITE;
/*!40000 ALTER TABLE `lab` DISABLE KEYS */;
INSERT INTO `lab` VALUES ('Blood Bank',1000),('CT Scan',1200),('OR SCAN',500),('X-ray',1000);
/*!40000 ALTER TABLE `lab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical`
--

DROP TABLE IF EXISTS `medical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical` (
  `Med_Name` varchar(25) NOT NULL,
  `Med_comp` varchar(45) NOT NULL,
  `Exp_date` varchar(45) NOT NULL,
  `Med_cost` int(11) NOT NULL,
  `Count` int(11) NOT NULL,
  PRIMARY KEY (`Med_Name`,`Med_comp`,`Exp_date`,`Med_cost`,`Count`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical`
--

LOCK TABLES `medical` WRITE;
/*!40000 ALTER TABLE `medical` DISABLE KEYS */;
INSERT INTO `medical` VALUES ('Brufa','Reckitt pvt','09-10-2025',150,20),('Corex','Cino pvt','08-08-2025',55,8),('Metolar','Cipla pvt','12-2-2022',150,22),('Nytra','Ace pvt','01-11-2025',105,10);
/*!40000 ALTER TABLE `medical` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `Pid` int(11) NOT NULL,
  `PName` varchar(45) NOT NULL,
  `Disease` varchar(45) NOT NULL,
  `Gender` varchar(45) NOT NULL,
  `Admit_status` varchar(45) NOT NULL,
  `Age` int(11) NOT NULL,
  PRIMARY KEY (`Pid`,`PName`,`Disease`,`Gender`,`Admit_status`,`Age`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (10,'Pankaj','Cancer','Male','Y',30),(11,'Gaurav','Cold','Male','Y',22),(12,'Ravi','Sugar','Male','Y',25),(14,'Raju','Cancer','Male','y',25),(15,'Rani','Sugar','Female','Y',29);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `register` (
  `Username` varchar(25) NOT NULL,
  `Passwordl` varchar(45) NOT NULL,
  `Gender` varchar(25) NOT NULL,
  `PhoneNumber` varchar(25) NOT NULL,
  `DOB` varchar(25) NOT NULL,
  PRIMARY KEY (`Username`,`Passwordl`,`Gender`,`PhoneNumber`,`DOB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
INSERT INTO `register` VALUES ('Fatima','fatima','female','1234567890',''),('Najma','najma','Female','90365460116','08-08-1997'),('Salman','salman','Male','9141481310','09-09-1997'),('Sharukh','srk','male','12345678901','12-08-2000');
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `Sid` int(11) NOT NULL,
  `Sname` varchar(45) NOT NULL,
  `Designation` varchar(45) NOT NULL,
  `Gender` varchar(45) NOT NULL,
  `Salary` int(11) NOT NULL,
  PRIMARY KEY (`Sid`,`Sname`,`Designation`,`Gender`,`Salary`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (10,'Ravi','Worker','Male',10000),(11,'Komal','Nurse','Female',8000),(12,'Raju','Worker','Male',4000),(13,'Gaurav','Worker','Male',2000);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-27 15:26:29
