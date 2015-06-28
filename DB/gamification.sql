-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 28, 2015 at 08:22 PM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `gamification`
--

-- --------------------------------------------------------

--
-- Table structure for table `ss_ma_badge`
--

CREATE TABLE IF NOT EXISTS `ss_ma_badge` (
  `BADGE_ID` int(10) NOT NULL,
  `BADGE_NAME` varchar(1000) DEFAULT NULL,
  `BADGE` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_ma_badge`
--

INSERT INTO `ss_ma_badge` (`BADGE_ID`, `BADGE_NAME`, `BADGE`) VALUES
(1, 'Well Done', '');

-- --------------------------------------------------------

--
-- Table structure for table `ss_ma_customer`
--

CREATE TABLE IF NOT EXISTS `ss_ma_customer` (
  `CUST_ID` int(10) NOT NULL,
  `CUST_NAME` varchar(1000) DEFAULT NULL,
  `CUST_AVATAR` blob,
  `TOTAL_POINTS` int(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_ma_customer`
--

INSERT INTO `ss_ma_customer` (`CUST_ID`, `CUST_NAME`, `CUST_AVATAR`, `TOTAL_POINTS`) VALUES
(1, 'Boobathi', NULL, 100);

-- --------------------------------------------------------

--
-- Table structure for table `ss_tr_customer_badge`
--

CREATE TABLE IF NOT EXISTS `ss_tr_customer_badge` (
  `TR_ID` int(10) NOT NULL,
  `CUST_ID` int(10) NOT NULL,
  `BADGE_ID` int(10) NOT NULL,
  `ACTION` varchar(10000) DEFAULT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_tr_customer_badge`
--

INSERT INTO `ss_tr_customer_badge` (`TR_ID`, `CUST_ID`, `BADGE_ID`, `ACTION`, `DATE`) VALUES
(1, 1, 1, 'sss', '2015-06-28 23:24:24'),
(2, 1, 1, 'TEST_BADGE', '2015-06-28 23:44:02'),
(3, 1, 1, 'TEST_BADGE_NEGATIVE', '2015-06-28 23:47:57');

-- --------------------------------------------------------

--
-- Table structure for table `ss_tr_customer_point`
--

CREATE TABLE IF NOT EXISTS `ss_tr_customer_point` (
  `TR_ID` int(10) NOT NULL,
  `CUST_ID` int(10) NOT NULL,
  `POINT` int(100) NOT NULL,
  `ACTION` varchar(1000) DEFAULT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_tr_customer_point`
--

INSERT INTO `ss_tr_customer_point` (`TR_ID`, `CUST_ID`, `POINT`, `ACTION`, `DATE`) VALUES
(1, 1, 100, 'Log in', '2015-06-28 23:36:46'),
(2, 1, 100, 'TEST', '2015-06-28 23:40:31'),
(3, 1, 20, 'TEST_REDUCE_Negative', '2015-06-28 23:41:22');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ss_ma_badge`
--
ALTER TABLE `ss_ma_badge`
  ADD PRIMARY KEY (`BADGE_ID`);

--
-- Indexes for table `ss_ma_customer`
--
ALTER TABLE `ss_ma_customer`
  ADD PRIMARY KEY (`CUST_ID`);

--
-- Indexes for table `ss_tr_customer_badge`
--
ALTER TABLE `ss_tr_customer_badge`
  ADD PRIMARY KEY (`TR_ID`);

--
-- Indexes for table `ss_tr_customer_point`
--
ALTER TABLE `ss_tr_customer_point`
  ADD PRIMARY KEY (`TR_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ss_ma_customer`
--
ALTER TABLE `ss_ma_customer`
  MODIFY `CUST_ID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `ss_tr_customer_badge`
--
ALTER TABLE `ss_tr_customer_badge`
  MODIFY `TR_ID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `ss_tr_customer_point`
--
ALTER TABLE `ss_tr_customer_point`
  MODIFY `TR_ID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
