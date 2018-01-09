-- --------------------------------------------------------
-- Host:                         chaiontime.cihlbki1pfev.us-east-2.rds.amazonaws.com
-- Server version:               5.7.17-log - MySQL Community Server (GPL)
-- Server OS:                    Linux
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for chaiontime
DROP DATABASE IF EXISTS `chaiontime`;
CREATE DATABASE IF NOT EXISTS `chaiontime` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `chaiontime`;

-- Dumping structure for table chaiontime.ADMIN
DROP TABLE IF EXISTS `ADMIN`;
CREATE TABLE IF NOT EXISTS `ADMIN` (
  `ADMIN_NAME` varchar(40) NOT NULL,
  `ADMIN_ID` varchar(10) NOT NULL,
  `ADMIN_PASSWORD` char(32) NOT NULL,
  `ACCESS_RIGHT` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table chaiontime.ADMIN: ~0 rows (approximately)
/*!40000 ALTER TABLE `ADMIN` DISABLE KEYS */;
/*!40000 ALTER TABLE `ADMIN` ENABLE KEYS */;

-- Dumping structure for table chaiontime.ATTACHMENT
DROP TABLE IF EXISTS `ATTACHMENT`;
CREATE TABLE IF NOT EXISTS `ATTACHMENT` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `ATTACHMENT` longblob,
  `ATTACHMENT_NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ATTACHMENT_NAME` (`ATTACHMENT_NAME`),
  UNIQUE KEY `ATTACHMENT_NAME_2` (`ATTACHMENT_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;

-- Dumping data for table chaiontime.ATTACHMENT: ~46 rows (approximately)


-- Dumping structure for table chaiontime.CATALOGUE
DROP TABLE IF EXISTS `CATALOGUE`;
CREATE TABLE IF NOT EXISTS `CATALOGUE` (
  `CATALOGUE_ID` int(10) NOT NULL AUTO_INCREMENT,
  `CATALOGUE_NAME` varchar(50) NOT NULL,
  `ACTIVE` tinyint(1) DEFAULT '1',
  `PARENT` varchar(50) DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `IMAGE_ID` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CATALOGUE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

-- Dumping data for table chaiontime.CATALOGUE: ~4 rows (approximately)
/*!40000 ALTER TABLE `CATALOGUE` DISABLE KEYS */;
INSERT IGNORE INTO `CATALOGUE` (`CATALOGUE_ID`, `CATALOGUE_NAME`, `ACTIVE`, `PARENT`, `DESCRIPTION`, `IMAGE_ID`) VALUES
	(32, 'coffe', 1, NULL, NULL, NULL),
	(33, 'Tea', 1, NULL, NULL, NULL),
	(34, 'Tea', 1, NULL, NULL, NULL),
	(35, 'Soft Drinks', 1, NULL, NULL, NULL);
/*!40000 ALTER TABLE `CATALOGUE` ENABLE KEYS */;

-- Dumping structure for table chaiontime.DELIVERY_BOY
DROP TABLE IF EXISTS `DELIVERY_BOY`;
CREATE TABLE IF NOT EXISTS `DELIVERY_BOY` (
  `DELIVERYBOY_ID` int(10) NOT NULL AUTO_INCREMENT,
  `DELIVERYBOY_NAME` varchar(45) NOT NULL,
  `DELIVERYBOY_ACTIVE` tinyint(1) NOT NULL,
  `NATIONAL_ID_TYPE` varchar(20) DEFAULT NULL,
  `NATIONAL_ID` varchar(50) DEFAULT NULL,
  `IMAGE_ID` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`DELIVERYBOY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dumping data for table chaiontime.DELIVERY_BOY: ~7 rows (approximately)
/*!40000 ALTER TABLE `DELIVERY_BOY` DISABLE KEYS */;
INSERT IGNORE INTO `DELIVERY_BOY` (`DELIVERYBOY_ID`, `DELIVERYBOY_NAME`, `DELIVERYBOY_ACTIVE`, `NATIONAL_ID_TYPE`, `NATIONAL_ID`, `IMAGE_ID`) VALUES
	(1, 'aa', 0, 'HOME_MUM', 'MUM', 'service.png'),
	(2, 'Sayan', 1, 'NCR_NODAL_XYZ', 'NCR', 'home-1.png'),
	(3, 'Vivek', 1, 'ALL NODAL', '1', 'V8FX93.png'),
	(4, 'Ayan', 1, 'Adhar', '1234567', 'T590S0.jpg'),
	(5, 'kunal', 0, 'kln-88', 'kln', 'VVW1AV.jpg'),
	(6, 'binni', 0, 'b4545', 'binni0909', '27FJ4Z.jpg'),
	(7, 'kumar', 1, 'public', 'k-all', 'YGLPYQ.jpg');
/*!40000 ALTER TABLE `DELIVERY_BOY` ENABLE KEYS */;

-- Dumping structure for table chaiontime.FAQ
DROP TABLE IF EXISTS `FAQ`;
CREATE TABLE IF NOT EXISTS `FAQ` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `QUESTION` varchar(200) NOT NULL,
  `ANSWER` varchar(200) NOT NULL,
  `ACTIVE` int(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table chaiontime.FAQ: ~2 rows (approximately)
/*!40000 ALTER TABLE `FAQ` DISABLE KEYS */;
INSERT IGNORE INTO `FAQ` (`ID`, `QUESTION`, `ANSWER`, `ACTIVE`) VALUES
	(1, '1+1?', '2', 0),
	(2, '2+1?', '3', 0),
	(3, 'How long will it tale to deliver Order?', 'Approximately 1-2 Hours.', 1);
/*!40000 ALTER TABLE `FAQ` ENABLE KEYS */;

-- Dumping structure for table chaiontime.FEEDBACK
DROP TABLE IF EXISTS `FEEDBACK`;
CREATE TABLE IF NOT EXISTS `FEEDBACK` (
  `USER_ID` varchar(10) NOT NULL,
  `FEEDBACK_DESC` varchar(100) DEFAULT NULL,
  `ORDER_ID` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table chaiontime.FEEDBACK: ~0 rows (approximately)
/*!40000 ALTER TABLE `FEEDBACK` DISABLE KEYS */;
INSERT IGNORE INTO `FEEDBACK` (`USER_ID`, `FEEDBACK_DESC`, `ORDER_ID`) VALUES
	('AYAN', 'Excellent tea', '1');
/*!40000 ALTER TABLE `FEEDBACK` ENABLE KEYS */;

-- Dumping structure for table chaiontime.ORDER_DETAILS
DROP TABLE IF EXISTS `ORDER_DETAILS`;
CREATE TABLE IF NOT EXISTS `ORDER_DETAILS` (
  `ORDER_DETAILS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ORDER_ID` int(11) NOT NULL,
  `PRODUCT_ID` int(11) NOT NULL,
  `QUANTITY` int(11) NOT NULL,
  `TOTAL_PRICE` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ORDER_DETAILS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

-- Dumping data for table chaiontime.ORDER_DETAILS: ~32 rows (approximately)
/*!40000 ALTER TABLE `ORDER_DETAILS` DISABLE KEYS */;
INSERT IGNORE INTO `ORDER_DETAILS` (`ORDER_DETAILS_ID`, `ORDER_ID`, `PRODUCT_ID`, `QUANTITY`, `TOTAL_PRICE`) VALUES
	(2, 1, 37, 1, 50.00),
	(3, 1, 38, 4, 50.00),
	(5, 1, 37, 1, 50.00),
	(6, 1, 38, 4, 50.00),
	(8, 1, 37, 1, 50.00),
	(9, 1, 38, 4, 50.00),
	(11, 1, 37, 1, 50.00),
	(12, 1, 38, 4, 50.00),
	(14, 1, 37, 1, 50.00),
	(15, 1, 38, 4, 50.00),
	(17, 1, 37, 1, 50.00),
	(18, 1, 38, 4, 50.00),
	(20, 1, 37, 1, 50.00),
	(21, 1, 38, 4, 50.00),
	(22, 1, 36, 1, 50.00),
	(23, 1, 37, 1, 50.00),
	(24, 1, 38, 4, 50.00),
	(26, 1, 37, 1, 50.00),
	(27, 1, 38, 4, 50.00),
	(29, 1, 37, 1, 50.00),
	(30, 1, 38, 4, 50.00),
	(31, 17, 45, 1, 200.00),
	(32, 18, 45, 1, 200.00),
	(33, 19, 45, 1, 200.00),
	(34, 20, 45, 2, 400.00),
	(35, 20, 47, 2, 400.00),
	(40, 25, 45, 2, 400.00),
	(41, 25, 48, 2, 100.00),
	(42, 30, 64, 1, 40.00),
	(43, 31, 64, 1, 40.00),
	(44, 32, 64, 1, 40.00),
	(45, 33, 64, 1, 40.00);
/*!40000 ALTER TABLE `ORDER_DETAILS` ENABLE KEYS */;

-- Dumping structure for table chaiontime.ORDER_HEADER
DROP TABLE IF EXISTS `ORDER_HEADER`;
CREATE TABLE IF NOT EXISTS `ORDER_HEADER` (
  `ORDER_ID` int(10) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(50) NOT NULL,
  `ORDER_TOTALPRICE` decimal(10,2) NOT NULL,
  `USER_ADDRESS_ID` int(10) NOT NULL,
  `VENDOR_ID` int(10) DEFAULT NULL,
  `DELIVERYBOY_ID` int(10) DEFAULT NULL,
  `STATUS` varchar(20) NOT NULL,
  `IS_PAID` tinyint(1) DEFAULT NULL,
  `DELIVERY_CHARGES` decimal(10,2) DEFAULT NULL,
  `TOTAL_ITEMS` int(11) DEFAULT NULL,
  `NOTES` varchar(100) DEFAULT NULL,
  `ORDER_DATE` date NOT NULL,
  `DEIVERY_DATE` date DEFAULT NULL,
  `POS_ID` int(10) NOT NULL,
  `OTP` int(4) DEFAULT NULL,
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

-- Dumping data for table chaiontime.ORDER_HEADER: ~4 rows (approximately)
/*!40000 ALTER TABLE `ORDER_HEADER` DISABLE KEYS */;
INSERT IGNORE INTO `ORDER_HEADER` (`ORDER_ID`, `USER_ID`, `ORDER_TOTALPRICE`, `USER_ADDRESS_ID`, `VENDOR_ID`, `DELIVERYBOY_ID`, `STATUS`, `IS_PAID`, `DELIVERY_CHARGES`, `TOTAL_ITEMS`, `NOTES`, `ORDER_DATE`, `DEIVERY_DATE`, `POS_ID`, `OTP`) VALUES
	(30, 'SAYAN', 40.00, 1, NULL, NULL, 'RECEIVED', 0, 100.00, 1, NULL, '2018-01-06', NULL, 1, NULL),
	(31, 'SAYAN', 40.00, 1, NULL, NULL, 'RECEIVED', 0, 100.00, 1, NULL, '2018-01-06', NULL, 1, NULL),
	(32, 'SAYAN', 40.00, 1, NULL, NULL, 'RECEIVED', 0, 100.00, 1, NULL, '2018-01-06', NULL, 1, NULL),
	(33, 'SAYAN', 40.00, 1, NULL, NULL, 'RECEIVED', 0, 100.00, 1, NULL, '2018-01-06', NULL, 1, NULL);
/*!40000 ALTER TABLE `ORDER_HEADER` ENABLE KEYS */;

-- Dumping structure for table chaiontime.OTP
DROP TABLE IF EXISTS `OTP`;
CREATE TABLE IF NOT EXISTS `OTP` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `ENTITY` varchar(50) NOT NULL,
  `OTP` int(4) NOT NULL,
  `TIMESTAMP` datetime NOT NULL,
  `ENTITY_TYPE` varchar(50) NOT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `PHONE` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

-- Dumping data for table chaiontime.OTP: ~17 rows (approximately)
/*!40000 ALTER TABLE `OTP` DISABLE KEYS */;
INSERT IGNORE INTO `OTP` (`ID`, `ENTITY`, `OTP`, `TIMESTAMP`, `ENTITY_TYPE`, `EMAIL`, `PHONE`) VALUES
	(1, '4', 5681, '2017-11-26 00:49:59', 'ORDER', 'Vivek.sharma@live.com', '1234567890'),
	(2, '5', 5686, '2017-11-29 22:14:37', 'ORDER', 'ayan.sen@live.com', '1234567890'),
	(4, '7', 9410, '2017-12-08 10:05:46', 'ORDER', 'ayan.sen@live.com', '1234567890'),
	(5, '8', 5538, '2018-01-02 14:53:33', 'ORDER', 'ayan.sen@live.com', '1234567890'),
	(6, '9', 6913, '2018-01-02 17:21:28', 'ORDER', 'ayan.sen@live.com', '1234567890'),
	(7, '10', 1521, '2018-01-02 17:23:28', 'ORDER', 'ayan.sen@live.com', '1234567890'),
	(8, '11', 8755, '2018-01-02 17:35:09', 'ORDER', 'ayan.sen@live.com', '1234567890'),
	(9, '12', 7110, '2018-01-02 18:28:02', 'ORDER', 'ayan.sen@live.com', '1234567890'),
	(10, '17', 5259, '2018-01-05 00:53:55', 'ORDER', 'sayanr_87@yahoo.co.in', '9836949843'),
	(11, '18', 4645, '2018-01-04 19:56:52', 'ORDER', 'sayanr_87@yahoo.co.in', '9836949843'),
	(12, '19', 3941, '2018-01-04 19:58:09', 'ORDER', 'sayanr_87@yahoo.co.in', '9836949843'),
	(13, '20', 6513, '2018-01-04 20:01:27', 'ORDER', 'sayanr_87@yahoo.co.in', '9836949843'),
	(14, '25', 2828, '2018-01-05 01:37:29', 'ORDER', 'sayanr_87@yahoo.co.in', '9836949843'),
	(15, '30', 2432, '2018-01-06 10:12:09', 'ORDER', 'sayanr_87@yahoo.co.in', '9836949843'),
	(16, '31', 6918, '2018-01-06 10:30:21', 'ORDER', 'sayanr_87@yahoo.co.in', '9836949843'),
	(17, '32', 2394, '2018-01-06 10:38:36', 'ORDER', 'sayanr_87@yahoo.co.in', '9836949843'),
	(18, '33', 5726, '2018-01-06 10:47:51', 'ORDER', 'sayanr_87@yahoo.co.in', '9836949843');
/*!40000 ALTER TABLE `OTP` ENABLE KEYS */;

-- Dumping structure for table chaiontime.PAYMENT
DROP TABLE IF EXISTS `PAYMENT`;
CREATE TABLE IF NOT EXISTS `PAYMENT` (
  `PAYMENT_ID` int(10) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(50) NOT NULL,
  `PAYMENT_MODE` varchar(20) NOT NULL,
  `PAYMENT_DATE_TIME` datetime NOT NULL,
  `PAYMENT_AMOUNT` decimal(10,2) NOT NULL,
  `ORDER_ID` int(10) DEFAULT NULL,
  `SOURCE_PAYMENT_ID` varchar(30) DEFAULT NULL,
  `SOURCE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`PAYMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table chaiontime.PAYMENT: ~0 rows (approximately)
/*!40000 ALTER TABLE `PAYMENT` DISABLE KEYS */;
/*!40000 ALTER TABLE `PAYMENT` ENABLE KEYS */;

-- Dumping structure for table chaiontime.POS
DROP TABLE IF EXISTS `POS`;
CREATE TABLE IF NOT EXISTS `POS` (
  `POS_ID` int(10) NOT NULL AUTO_INCREMENT,
  `POS_ACTIVE` tinyint(1) NOT NULL,
  `POS_AREA` varchar(40) NOT NULL,
  `POS_OWNER_NAME` varchar(45) NOT NULL,
  `POS_OWNER_MAIL` varchar(100) CHARACTER SET utf8 NOT NULL,
  `POS_LAT` varchar(50) DEFAULT NULL,
  `POS_LONG` varchar(50) DEFAULT NULL,
  `POS_ADDRESS` varchar(200) DEFAULT NULL,
  `VENDOR_ID` int(10) NOT NULL,
  PRIMARY KEY (`POS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

-- Dumping data for table chaiontime.POS: ~18 rows (approximately)
/*!40000 ALTER TABLE `POS` DISABLE KEYS */;
INSERT IGNORE INTO `POS` (`POS_ID`, `POS_ACTIVE`, `POS_AREA`, `POS_OWNER_NAME`, `POS_OWNER_MAIL`, `POS_LAT`, `POS_LONG`, `POS_ADDRESS`, `VENDOR_ID`) VALUES
	(1, 1, 'Mumbai Marine', 'Ayan sen', 'ayan@gmail.com', '22.471954507739223', '88.35205078125', NULL, 1),
	(2, 0, 'Dumdum', 'ayan', 'ayan@gmail.com', NULL, NULL, NULL, 1),
	(3, 0, 'test', 'Test', 'test@test.com', NULL, NULL, NULL, 1),
	(4, 0, 'adj', 'asg', 'asd@ssad', NULL, NULL, NULL, 0),
	(5, 0, 'data address', 'TEst data', 'as@ssd', NULL, NULL, NULL, 0),
	(6, 0, 'aasfaf', 'fafsadfaf', 'as@asf', NULL, NULL, NULL, 0),
	(7, 0, 'dumdum', 'ayan', 'ayan@gmail.com', NULL, NULL, NULL, 0),
	(8, 0, 'dumdum', 'ayan', 'ayan@gmail.com', NULL, NULL, NULL, 0),
	(9, 0, 'dumdum', 'ayan', 'ayan@gmail.com', NULL, NULL, NULL, 0),
	(10, 0, 'dumdum', 'ayan', 'ayan@gmail.com', NULL, NULL, NULL, 0),
	(11, 0, 'testd', 'Test', 'sda@af', NULL, NULL, NULL, 0),
	(12, 0, 'sdad', 'Testd', 'ac@asd', NULL, NULL, NULL, 0),
	(13, 0, 'ad', 'test', 'ssd@aa', NULL, NULL, NULL, 0),
	(14, 0, 'asdad', 'dad', 'as@asd', NULL, NULL, NULL, 0),
	(15, 1, 'Mumbai Marine', 'ayan sen', 'ayan@gmail.com', NULL, NULL, NULL, 9),
	(16, 1, 'Dumdum', 'ayan', 'ayan@gmail.com', NULL, NULL, NULL, 9),
	(17, 1, 'Lake Town', 'Sayan', 'xyz@gmail.com', '0', '0', NULL, 1),
	(18, 1, 'Test', 'Test', 'test@gmail.com', '0', '0', NULL, 3);
/*!40000 ALTER TABLE `POS` ENABLE KEYS */;

-- Dumping structure for table chaiontime.PRODUCT
DROP TABLE IF EXISTS `PRODUCT`;
CREATE TABLE IF NOT EXISTS `PRODUCT` (
  `PRODUCT_ID` int(10) NOT NULL AUTO_INCREMENT,
  `CATALOGUE_ID` varchar(10) NOT NULL,
  `PRODUCT_NAME` varchar(50) NOT NULL,
  `PRODUCT_DESC` varchar(100) DEFAULT NULL,
  `ACTIVE` tinyint(1) DEFAULT '1',
  `IMAGE_ID` varchar(20) DEFAULT NULL,
  `PRODUCT_SIZE` varchar(45) DEFAULT NULL,
  `PRODUCT_BUYPRICE` decimal(10,2) DEFAULT NULL,
  `PRODUCT_DISCA` tinyint(1) DEFAULT NULL,
  `PRODUCT_DISCPER` decimal(10,2) DEFAULT NULL,
  `PRODUCT_DISCSTARTDTE` datetime DEFAULT NULL,
  `PRODUCT_DISCENDDTE` datetime DEFAULT NULL,
  `PRODUCT_FINALBUYPRICE` decimal(10,2) DEFAULT NULL,
  `UNIT` int(10) DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=latin1;

-- Dumping data for table chaiontime.PRODUCT: ~3 rows (approximately)
/*!40000 ALTER TABLE `PRODUCT` DISABLE KEYS */;
INSERT IGNORE INTO `PRODUCT` (`PRODUCT_ID`, `CATALOGUE_ID`, `PRODUCT_NAME`, `PRODUCT_DESC`, `ACTIVE`, `IMAGE_ID`, `PRODUCT_SIZE`, `PRODUCT_BUYPRICE`, `PRODUCT_DISCA`, `PRODUCT_DISCPER`, `PRODUCT_DISCSTARTDTE`, `PRODUCT_DISCENDDTE`, `PRODUCT_FINALBUYPRICE`, `UNIT`) VALUES
	(64, '32', 'kerala coffe', 'kerala coffe', 1, NULL, 'cup', 40.00, NULL, NULL, NULL, NULL, 40.00, NULL),
	(65, '33', 'Masala Tea', 'Masala Tea', 1, NULL, 'cup', 20.00, NULL, NULL, NULL, NULL, 20.00, NULL),
	(66, '33', 'Cardamom Tea', 'Cardamom Tea', 1, NULL, 'cup', 15.00, NULL, NULL, NULL, NULL, 15.00, NULL);
/*!40000 ALTER TABLE `PRODUCT` ENABLE KEYS */;

-- Dumping structure for table chaiontime.STOCK
DROP TABLE IF EXISTS `STOCK`;
CREATE TABLE IF NOT EXISTS `STOCK` (
  `PRODUCT_ID` int(10) NOT NULL,
  `UNIT_VALUE` decimal(10,2) NOT NULL,
  `UNIT` int(10) NOT NULL,
  `UNIT_NAME` varchar(20) NOT NULL,
  `STOCK_ID` int(10) NOT NULL,
  PRIMARY KEY (`STOCK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table chaiontime.STOCK: ~2 rows (approximately)
/*!40000 ALTER TABLE `STOCK` DISABLE KEYS */;
INSERT IGNORE INTO `STOCK` (`PRODUCT_ID`, `UNIT_VALUE`, `UNIT`, `UNIT_NAME`, `STOCK_ID`) VALUES
	(36, 10.00, 100, '200 ml', 1),
	(36, 20.00, 50, '400 ml', 2);
/*!40000 ALTER TABLE `STOCK` ENABLE KEYS */;

-- Dumping structure for table chaiontime.TERMS_AND_CONDITION
DROP TABLE IF EXISTS `TERMS_AND_CONDITION`;
CREATE TABLE IF NOT EXISTS `TERMS_AND_CONDITION` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `TERMS` varchar(500) NOT NULL,
  `ACTIVE` int(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table chaiontime.TERMS_AND_CONDITION: ~4 rows (approximately)
/*!40000 ALTER TABLE `TERMS_AND_CONDITION` DISABLE KEYS */;
INSERT IGNORE INTO `TERMS_AND_CONDITION` (`ID`, `TERMS`, `ACTIVE`) VALUES
	(1, 'terms 1', 0),
	(2, 'terms 1', 0),
	(3, 'All orders are subjected to Mumbai jurisdiction', 1),
	(4, 'All deliveries to be made by 8:pm', 1);
/*!40000 ALTER TABLE `TERMS_AND_CONDITION` ENABLE KEYS */;

-- Dumping structure for table chaiontime.USER
DROP TABLE IF EXISTS `USER`;
CREATE TABLE IF NOT EXISTS `USER` (
  `USER_ID` varchar(50) COLLATE latin1_general_cs NOT NULL,
  `USER_PASSWORD` char(100) COLLATE latin1_general_cs NOT NULL,
  `USER_NAME` varchar(100) CHARACTER SET latin1 NOT NULL,
  `USER_EMAIL` varchar(100) COLLATE latin1_general_cs NOT NULL,
  `USER_PHONE` bigint(20) NOT NULL,
  `USER_WALLETAMT` decimal(10,2) DEFAULT NULL,
  `USER_ACTIVE` tinyint(1) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

-- Dumping data for table chaiontime.USER: ~6 rows (approximately)
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT IGNORE INTO `USER` (`USER_ID`, `USER_PASSWORD`, `USER_NAME`, `USER_EMAIL`, `USER_PHONE`, `USER_WALLETAMT`, `USER_ACTIVE`) VALUES
	('AYAN', '$2a$10$lobgiNsLKLYYAyXQ/0errem7KHsJAFf9NL5WOrONCxiPqHlsx0L7.', 'AYAN SEN', 'AYAN.SEN@live.com', 8585858585, 0.00, 0),
	('nikhil', '$2a$10$IN29zRU5zVnAjEgtMNEIRuqKvXvXeMXXoirCo0Ud0cnvnpiSBENv.', 'nikhil Roy', 'nikhil.Roy@live.com', 1234567890, 0.00, 1),
	('nikhil1', '$2a$10$2v/1Bv6T/7Ir7x8x0.uWjuCgK8xaawZq9SSlfukrFSF8y1Z7L2QkO', 'nikhil Roy', 'nikhil.Roy@live.com', 1234567890, 0.00, 1),
	('SAYAN', '$2a$10$rdbDIgTXotb21qjespyreO6XtDtyS/CeNwjBZR9r0b.X77DFhInUS', 'Sayan Roy', 'sayanr_87@yahoo.co.in', 8013642341, NULL, 1),
	('samir', '$2a$10$RHb/i0DREY09W5Fz91RyxOD5/fygCZF0sTtyf/f198yj07/GFZ.QK', 'Samir Roy', 'samir.Roy@live.com', 1234567890, 0.00, 1),
	('vivek', '$2a$10$7c1YallGGQpATS711sHk5O3Kec8BM/axnA830sUTo1rxIeGycbAky', 'Vivek koshik', 'ayan.sen@live.com', 1234567890, 0.00, 0);
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;

-- Dumping structure for table chaiontime.USER_ADDRESS
DROP TABLE IF EXISTS `USER_ADDRESS`;
CREATE TABLE IF NOT EXISTS `USER_ADDRESS` (
  `USER_ADDRESS_ID` int(10) NOT NULL AUTO_INCREMENT,
  `USER_ADDRESSLINE` varchar(200) COLLATE latin1_general_cs NOT NULL,
  `USER_CITY` varchar(50) COLLATE latin1_general_cs DEFAULT NULL,
  `USER_STATE` varchar(50) COLLATE latin1_general_cs DEFAULT NULL,
  `USER_POSTALCODE` varchar(10) COLLATE latin1_general_cs DEFAULT NULL,
  `USER_COUNTRY` varchar(10) COLLATE latin1_general_cs DEFAULT NULL,
  `USER_LAT` varchar(50) COLLATE latin1_general_cs DEFAULT NULL,
  `USER_LONG` varchar(50) COLLATE latin1_general_cs DEFAULT NULL,
  `USER_ID` varchar(50) COLLATE latin1_general_cs NOT NULL,
  `ADDRESS_TYPE` varchar(50) COLLATE latin1_general_cs DEFAULT NULL,
  PRIMARY KEY (`USER_ADDRESS_ID`,`USER_ID`),
  UNIQUE KEY `USER_ADDRESS_ID` (`USER_ADDRESS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

-- Dumping data for table chaiontime.USER_ADDRESS: ~4 rows (approximately)
/*!40000 ALTER TABLE `USER_ADDRESS` DISABLE KEYS */;
INSERT IGNORE INTO `USER_ADDRESS` (`USER_ADDRESS_ID`, `USER_ADDRESSLINE`, `USER_CITY`, `USER_STATE`, `USER_POSTALCODE`, `USER_COUNTRY`, `USER_LAT`, `USER_LONG`, `USER_ID`, `ADDRESS_TYPE`) VALUES
	(1, 'Nager Bazar', 'KOL', 'WB', '700028', 'INDIA', '123456', '12123', 'SAYAN', NULL),
	(2, 'DUM DUM', 'KOLKATA', 'WB', '700028', 'INDIA', '2333', '1232', 'samir', NULL),
	(3, 'DUM DUM', 'KOLKATA', 'WB', '700090', 'INDIA', '2333', '1232', 'nikhil', 'home'),
	(4, 'DUM DUM', 'KOLKATA', 'WB', '700028', 'INDIA', '2333', '1232', 'nikhil1', 'home'),
	(11, 'DUM DUM', 'KOLKATA', 'WB', '700028', 'INDIA', '2333', '1232', 'nikhil1', 'home'),
	(12, 'DUM DUM', 'KOLKATA', 'WB', '700028', 'INDIA', '2333', '1232', 'nikhil1', 'home');
/*!40000 ALTER TABLE `USER_ADDRESS` ENABLE KEYS */;

-- Dumping structure for table chaiontime.USER_ROLES
DROP TABLE IF EXISTS `USER_ROLES`;
CREATE TABLE IF NOT EXISTS `USER_ROLES` (
  `USER_ROLE_ID` int(10) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(50) COLLATE latin1_general_cs DEFAULT NULL,
  `ROLE` varchar(45) COLLATE latin1_general_cs NOT NULL,
  PRIMARY KEY (`USER_ROLE_ID`),
  UNIQUE KEY `UNI_USERID_ROLE` (`ROLE`,`USER_ID`),
  KEY `FK_USERID_IDS` (`USER_ID`),
  CONSTRAINT `FK_USER_ROLES_USER` FOREIGN KEY (`USER_ID`) REFERENCES `USER` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

-- Dumping data for table chaiontime.USER_ROLES: ~11 rows (approximately)
/*!40000 ALTER TABLE `USER_ROLES` DISABLE KEYS */;
INSERT IGNORE INTO `USER_ROLES` (`USER_ROLE_ID`, `USER_ID`, `ROLE`) VALUES
	(14, 'AYAN', 'ROLE_ADMIN'),
	(21, 'nikhil', 'ROLE_ADMIN'),
	(23, 'nikhil1', 'ROLE_ADMIN'),
	(18, 'SAYAN', 'ROLE_ADMIN'),
	(19, 'samir', 'ROLE_ADMIN'),
	(16, 'vivek', 'ROLE_ADMIN'),
	(15, 'AYAN', 'ROLE_USER'),
	(22, 'nikhil', 'ROLE_USER'),
	(24, 'nikhil1', 'ROLE_USER'),
	(20, 'samir', 'ROLE_USER'),
	(17, 'vivek', 'ROLE_USER');
/*!40000 ALTER TABLE `USER_ROLES` ENABLE KEYS */;

-- Dumping structure for table chaiontime.VENDOR
DROP TABLE IF EXISTS `VENDOR`;
CREATE TABLE IF NOT EXISTS `VENDOR` (
  `VENDOR_ID` int(10) NOT NULL AUTO_INCREMENT,
  `VENDOR_NAME` varchar(45) NOT NULL,
  `VENDOR_ACTIVE` tinyint(1) NOT NULL,
  `VENDOR_ADDRESS` varchar(150) NOT NULL,
  PRIMARY KEY (`VENDOR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping data for table chaiontime.VENDOR: ~8 rows (approximately)
/*!40000 ALTER TABLE `VENDOR` DISABLE KEYS */;
INSERT IGNORE INTO `VENDOR` (`VENDOR_ID`, `VENDOR_NAME`, `VENDOR_ACTIVE`, `VENDOR_ADDRESS`) VALUES
	(1, 'BIRIANI HOUSE', 1, 'Central Kolkata'),
	(2, 'MOGLAI HOUSE', 0, 'KOL'),
	(3, 'Indian Coffee House', 1, 'College Street kolkata'),
	(4, 'Indian Coffee House', 0, 'College Street'),
	(5, 'Indian Coffee House', 0, 'College Street'),
	(6, 'Sweet Corn', 1, 'Lake Town, kolkata'),
	(9, 'ARSALAN', 1, 'KOL'),
	(10, 'Pizza Hut', 1, 'Chain_Store');
/*!40000 ALTER TABLE `VENDOR` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
