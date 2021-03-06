-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema kamal
--

CREATE DATABASE IF NOT EXISTS kamal;
USE kamal;

--
-- Definition of table `projecttable`
--

DROP TABLE IF EXISTS `projecttable`;
CREATE TABLE `projecttable` (
  `Serial` int(10) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `Mobile` varchar(45) NOT NULL,
  `Category` varchar(45) NOT NULL,
  `Performance` varchar(45) NOT NULL,
  `Model` varchar(45) NOT NULL,
  PRIMARY KEY  (`Serial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `projecttable`
--

/*!40000 ALTER TABLE `projecttable` DISABLE KEYS */;
/*!40000 ALTER TABLE `projecttable` ENABLE KEYS */;


--
-- Definition of table `usertable`
--

DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable` (
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Verified Code` varchar(45) NOT NULL,
  PRIMARY KEY  (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usertable`
--

/*!40000 ALTER TABLE `usertable` DISABLE KEYS */;
/*!40000 ALTER TABLE `usertable` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
