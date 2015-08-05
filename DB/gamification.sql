-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 26, 2015 at 12:47 PM
-- Server version: 5.6.24
-- PHP Version: 5.5.24

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
  `BADGE_IMG_URL` varchar(10000) NOT NULL,
  `BADGE_CODE` varchar(1000) NOT NULL,
  `SUBJECT_TYPE` varchar(1000) NOT NULL,
  `GOAL` varchar(1000) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_ma_badge`
--

INSERT INTO `ss_ma_badge` (`BADGE_ID`, `BADGE_NAME`, `BADGE_IMG_URL`, `BADGE_CODE`, `SUBJECT_TYPE`, `GOAL`) VALUES
(1, 'Well Done', '', '', 'EMP', ''),
(2, 'Mobile Gem', '', 'MOB_GEM', 'EMP', 'SOCIAL');

-- --------------------------------------------------------

--
-- Table structure for table `ss_ma_challenge`
--

CREATE TABLE IF NOT EXISTS `ss_ma_challenge` (
  `challenge_id` int(100) NOT NULL,
  `challenge_desc` varchar(1000) NOT NULL,
  `CUSTOMER_ACTION` varchar(1000) NOT NULL,
  `challenge_point` int(100) NOT NULL,
  `subject_type` varchar(1000) NOT NULL,
  `challenge_img_url` varchar(20000) NOT NULL,
  `challenge_occurrence` int(100) NOT NULL,
  `expiry_date` date DEFAULT NULL,
  `GOAL` varchar(1000) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_ma_challenge`
--

INSERT INTO `ss_ma_challenge` (`challenge_id`, `challenge_desc`, `CUSTOMER_ACTION`, `challenge_point`, `subject_type`, `challenge_img_url`, `challenge_occurrence`, `expiry_date`, `GOAL`) VALUES
(5, 'Download Mobile App', 'CUS_MOB_APP', 10, 'Customer', 'banner1.jpg', 1, '2014-09-30', 'Social'),
(6, 'Make first mobile payment', 'CUS_MOB_FIRST_PAY', 10, 'Customer', 'banner1.jpg', 1, '2015-09-30', 'Business'),
(7, 'Make 3 transactions with mobile app this month', 'CUS_MOB_THREE_TRAN', 20, 'Customer', 'banner1.jpg', 3, '2015-08-31', ''),
(8, 'Send money with Hype Account to your friends', 'CUS_HYPE_TRAN', 50, 'Customer', ' banner1.jpg', 1, '2015-09-30', ''),
(9, 'Fill in/update your contact information', 'CUST_KYC', 10, 'Customer', 'Customerprofilereview.jpg', 1, '2015-09-30', ''),
(10, 'Pay for utilities online', 'CUST_PAY_UTIL', 50, 'Customer', 'RechargeThreeTimes.jpg', 1, '2015-09-30', ''),
(11, 'Make at least 3 online payments with Credit Card this Month', 'CUS_CC_TRAN', 100, 'Customer', 'RechargeThreeTimes.jpg', 3, '2015-09-30', '');

-- --------------------------------------------------------

--
-- Table structure for table `ss_ma_customer`
--

CREATE TABLE IF NOT EXISTS `ss_ma_customer` (
  `CUST_ID` int(10) NOT NULL COMMENT 'Customer Id',
  `CUST_NAME` varchar(1000) DEFAULT NULL,
  `CUST_AVATAR` varchar(10000) DEFAULT NULL,
  `TOTAL_POINTS` int(100) NOT NULL,
  `SUBJECT_TYPE` varchar(1000) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_ma_customer`
--

INSERT INTO `ss_ma_customer` (`CUST_ID`, `CUST_NAME`, `CUST_AVATAR`, `TOTAL_POINTS`, `SUBJECT_TYPE`) VALUES
(1, 'Boobathi', '', 100, 'EMP'),
(2, 'Sujatha', '', 200, 'EMP'),
(3, 'Kumar', '', 300, 'Customer');

-- --------------------------------------------------------

--
-- Table structure for table `ss_ma_reward`
--

CREATE TABLE IF NOT EXISTS `ss_ma_reward` (
  `REWARD_ID` int(100) NOT NULL,
  `REWARD_DESC` varchar(1000) NOT NULL,
  `REWARD_POINT` int(100) NOT NULL,
  `REWARD_CODE` varchar(100) NOT NULL,
  `REWARD_IMG_URL` varchar(2000) NOT NULL,
  `SUBJECT_TYPE` varchar(1000) NOT NULL,
  `GOAL` varchar(1000) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_ma_reward`
--

INSERT INTO `ss_ma_reward` (`REWARD_ID`, `REWARD_DESC`, `REWARD_POINT`, `REWARD_CODE`, `REWARD_IMG_URL`, `SUBJECT_TYPE`, `GOAL`) VALUES
(1, 'Avail Flipkart Coupon', 100, 'FLIP_KART_OFFER', '', '', ''),
(3, 'Reedem your points from Amazon', 300, 'AMAZ_300', '', '', ''),
(6, 'Avail discount offer - Nuova Campagna, MUTUI Banca Sella', 1000, 'TEST', 'test http', 'EMP', 'Social');

-- --------------------------------------------------------

--
-- Table structure for table `ss_tr_challenge`
--

CREATE TABLE IF NOT EXISTS `ss_tr_challenge` (
  `tr_id` int(100) NOT NULL,
  `challenge_id` int(100) NOT NULL,
  `customer_id` int(100) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(2, 1, 2, 'TEST_BADGE', '2015-06-28 23:44:02');

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

-- --------------------------------------------------------

--
-- Table structure for table `ss_tr_reward`
--

CREATE TABLE IF NOT EXISTS `ss_tr_reward` (
  `tr_id` int(100) NOT NULL,
  `reward_id` int(100) NOT NULL,
  `customer_id` int(100) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_tr_reward`
--

INSERT INTO `ss_tr_reward` (`tr_id`, `reward_id`, `customer_id`, `date`) VALUES
(1, 1, 1, '2015-07-26 15:58:57');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ss_ma_badge`
--
ALTER TABLE `ss_ma_badge`
  ADD PRIMARY KEY (`BADGE_ID`);

--
-- Indexes for table `ss_ma_challenge`
--
ALTER TABLE `ss_ma_challenge`
  ADD PRIMARY KEY (`challenge_id`);

--
-- Indexes for table `ss_ma_customer`
--
ALTER TABLE `ss_ma_customer`
  ADD PRIMARY KEY (`CUST_ID`);

--
-- Indexes for table `ss_ma_reward`
--
ALTER TABLE `ss_ma_reward`
  ADD PRIMARY KEY (`REWARD_ID`);

--
-- Indexes for table `ss_tr_challenge`
--
ALTER TABLE `ss_tr_challenge`
  ADD PRIMARY KEY (`tr_id`);

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
-- Indexes for table `ss_tr_reward`
--
ALTER TABLE `ss_tr_reward`
  ADD PRIMARY KEY (`tr_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ss_ma_badge`
--
ALTER TABLE `ss_ma_badge`
  MODIFY `BADGE_ID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `ss_ma_challenge`
--
ALTER TABLE `ss_ma_challenge`
  MODIFY `challenge_id` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `ss_ma_customer`
--
ALTER TABLE `ss_ma_customer`
  MODIFY `CUST_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT 'Customer Id',AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `ss_ma_reward`
--
ALTER TABLE `ss_ma_reward`
  MODIFY `REWARD_ID` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `ss_tr_challenge`
--
ALTER TABLE `ss_tr_challenge`
  MODIFY `tr_id` int(100) NOT NULL AUTO_INCREMENT;
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
--
-- AUTO_INCREMENT for table `ss_tr_reward`
--
ALTER TABLE `ss_tr_reward`
  MODIFY `tr_id` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
