-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.62 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for cloudstorage
CREATE DATABASE IF NOT EXISTS `cloudstorage` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cloudstorage`;

-- Dumping structure for table cloudstorage.filedetails
CREATE TABLE IF NOT EXISTS `filedetails` (
  `fname` varchar(50) NOT NULL,
  `ftype` varchar(50) NOT NULL,
  `fsize` int(11) NOT NULL DEFAULT '0',
  `frequency` int(11) NOT NULL DEFAULT '0',
  `rank` int(11) NOT NULL DEFAULT '0',
  `storage` varchar(50) NOT NULL DEFAULT '0',
  `lastaccess` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table cloudstorage.filedetails: ~3 rows (approximately)
DELETE FROM `filedetails`;
/*!40000 ALTER TABLE `filedetails` DISABLE KEYS */;
INSERT INTO `filedetails` (`fname`, `ftype`, `fsize`, `frequency`, `rank`, `storage`, `lastaccess`) VALUES
	('phishing url.txt', 'txt', 1910, 2, 2, 'STORAGE1', '18-07-2021 11:00:18'),
	('alphanum.java', 'java', 651, 3, 1, 'STORAGE2', '24-03-2022 19:13:29'),
	('checknum.java', 'java', 759, 3, 1, 'STORAGE3', '24-03-2022 19:21:40');
/*!40000 ALTER TABLE `filedetails` ENABLE KEYS */;

-- Dumping structure for table cloudstorage.sharedetails
CREATE TABLE IF NOT EXISTS `sharedetails` (
  `uname` varchar(50) DEFAULT NULL,
  `fname` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table cloudstorage.sharedetails: ~5 rows (approximately)
DELETE FROM `sharedetails`;
/*!40000 ALTER TABLE `sharedetails` DISABLE KEYS */;
INSERT INTO `sharedetails` (`uname`, `fname`) VALUES
	('aaa', 'phishing url.txt'),
	('aaa', 'alphanum.java'),
	('bbb', 'checknum.java'),
	('bbb', 'alphanum.java'),
	('xyz', 'checknum.java');
/*!40000 ALTER TABLE `sharedetails` ENABLE KEYS */;

-- Dumping structure for table cloudstorage.user
CREATE TABLE IF NOT EXISTS `user` (
  `uname` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table cloudstorage.user: ~4 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`uname`, `pass`, `email`) VALUES
	('aaa', 'aaa', 'codebigtechnologies@gmail.com'),
	('bbb', 'bbb', 'codebigtechnologies@gmail.com'),
	('ccc', 'ccc', 'codebigtechnologies@gmail.com'),
	('xyz', 'xyzxyz', 'xyz@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
