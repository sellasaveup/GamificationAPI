-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 10, 2015 at 09:54 PM
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_ma_challenge`
--

INSERT INTO `ss_ma_challenge` (`challenge_id`, `challenge_desc`, `CUSTOMER_ACTION`, `challenge_point`, `subject_type`, `challenge_img_url`, `challenge_occurrence`, `expiry_date`, `GOAL`) VALUES
(5, 'Download Mobile App', 'CUS_MOB_APP', 10, 'Customer', 'banner1.jpg', 1, '2015-09-30', 'Social'),
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_ma_customer`
--

INSERT INTO `ss_ma_customer` (`CUST_ID`, `CUST_NAME`, `CUST_AVATAR`, `TOTAL_POINTS`, `SUBJECT_TYPE`) VALUES
(4, 'Boobathi', NULL, 118, 'Customer'),
(5, 'Kumar', NULL, 200, 'Customer'),
(6, 'Vinay', NULL, 300, 'EMP');

-- --------------------------------------------------------

--
-- Table structure for table `ss_ma_level`
--

CREATE TABLE IF NOT EXISTS `ss_ma_level` (
  `level_id` int(250) NOT NULL,
  `level_desc` varchar(2000) NOT NULL,
  `level_mg_url` varchar(2000) NOT NULL,
  `badge_id` int(250) NOT NULL,
  `reward_id` int(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ss_ma_level_challenge`
--

CREATE TABLE IF NOT EXISTS `ss_ma_level_challenge` (
  `level_challenge_id` int(250) NOT NULL,
  `level_id` int(250) NOT NULL,
  `challenge_id` int(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_tr_customer_badge`
--

INSERT INTO `ss_tr_customer_badge` (`TR_ID`, `CUST_ID`, `BADGE_ID`, `ACTION`, `DATE`) VALUES
(4, 4, 2, 'Mobile Recharge', '2015-08-04 03:48:22'),
(5, 4, 2, 'Mobile Recharge', '2015-08-04 03:50:08'),
(6, 4, 2, 'Mobile Recharge', '2015-08-04 03:50:58');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_tr_customer_point`
--

INSERT INTO `ss_tr_customer_point` (`TR_ID`, `CUST_ID`, `POINT`, `ACTION`, `DATE`) VALUES
(1, 1, 100, 'Log in', '2015-07-28 23:36:46'),
(2, 2, 500, 'TEST', '2015-07-28 23:40:31'),
(3, 3, 20, 'TEST_REDUCE_Negative', '2015-07-28 23:41:22'),
(4, 4, 10, 'CUS_MOB_APP', '2015-08-04 03:40:29');

-- --------------------------------------------------------

--
-- Table structure for table `ss_tr_notification`
--

CREATE TABLE IF NOT EXISTS `ss_tr_notification` (
  `notify_tr_id` int(255) NOT NULL,
  `notify_header_id` int(249) NOT NULL,
  `cust_id` int(255) NOT NULL,
  `status` varchar(1000) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_tr_notification`
--

INSERT INTO `ss_tr_notification` (`notify_tr_id`, `notify_header_id`, `cust_id`, `status`) VALUES
(5, 7, 4, 'UN'),
(6, 7, 5, 'UN'),
(7, 8, 4, 'UN'),
(8, 8, 5, 'UN'),
(9, 8, 6, 'UN'),
(10, 9, 4, 'UN'),
(11, 9, 5, 'UN'),
(12, 9, 6, 'UN');

-- --------------------------------------------------------

--
-- Table structure for table `ss_tr_notification_header`
--

CREATE TABLE IF NOT EXISTS `ss_tr_notification_header` (
  `notify_id` int(255) NOT NULL,
  `notify_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `notify_type` varchar(1000) NOT NULL,
  `target` varchar(1000) NOT NULL,
  `message` varchar(10000) NOT NULL,
  `image` varchar(1000) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_tr_notification_header`
--

INSERT INTO `ss_tr_notification_header` (`notify_id`, `notify_date`, `notify_type`, `target`, `message`, `image`) VALUES
(7, '2015-08-04 03:13:58', 'Info', 'SUBJECT', 'sdfsf', 'dddd'),
(8, '2015-08-04 03:50:06', 'Message', 'ALL', 'afaf', 'afasfa'),
(9, '2015-08-04 03:50:54', 'Message', 'ALL', 'afaf', 'afasfa'),
(10, '2015-08-04 03:51:14', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `ss_tr_reward`
--

CREATE TABLE IF NOT EXISTS `ss_tr_reward` (
  `tr_id` int(100) NOT NULL,
  `reward_id` int(100) NOT NULL,
  `customer_id` int(100) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Indexes for table `ss_ma_level`
--
ALTER TABLE `ss_ma_level`
  ADD PRIMARY KEY (`level_id`);

--
-- Indexes for table `ss_ma_level_challenge`
--
ALTER TABLE `ss_ma_level_challenge`
  ADD PRIMARY KEY (`level_challenge_id`);

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
-- Indexes for table `ss_tr_notification`
--
ALTER TABLE `ss_tr_notification`
  ADD PRIMARY KEY (`notify_tr_id`);

--
-- Indexes for table `ss_tr_notification_header`
--
ALTER TABLE `ss_tr_notification_header`
  ADD PRIMARY KEY (`notify_id`);

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
  MODIFY `BADGE_ID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `ss_ma_challenge`
--
ALTER TABLE `ss_ma_challenge`
  MODIFY `challenge_id` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `ss_ma_customer`
--
ALTER TABLE `ss_ma_customer`
  MODIFY `CUST_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT 'Customer Id',AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `ss_ma_level`
--
ALTER TABLE `ss_ma_level`
  MODIFY `level_id` int(250) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ss_ma_level_challenge`
--
ALTER TABLE `ss_ma_level_challenge`
  MODIFY `level_challenge_id` int(250) NOT NULL AUTO_INCREMENT;
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
  MODIFY `TR_ID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `ss_tr_customer_point`
--
ALTER TABLE `ss_tr_customer_point`
  MODIFY `TR_ID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `ss_tr_notification`
--
ALTER TABLE `ss_tr_notification`
  MODIFY `notify_tr_id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `ss_tr_notification_header`
--
ALTER TABLE `ss_tr_notification_header`
  MODIFY `notify_id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `ss_tr_reward`
--
ALTER TABLE `ss_tr_reward`
  MODIFY `tr_id` int(100) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
