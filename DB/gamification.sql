-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 22, 2015 at 12:16 AM
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
-- Table structure for table `SS_MA_BADGE`
--

CREATE TABLE IF NOT EXISTS `SS_MA_BADGE` (
  `BADGE_ID` int(250) NOT NULL,
  `BADGE_CODE` varchar(250) NOT NULL,
  `GOAL_CODE` varchar(250) NOT NULL,
  `NAME` varchar(2000) NOT NULL,
  `IMAGE` varchar(2000) DEFAULT NULL,
  `STORY` varchar(5000) DEFAULT NULL,
  `EXPIRY_DATE` date NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SS_MA_BADGE`
--

INSERT INTO `SS_MA_BADGE` (`BADGE_ID`, `BADGE_CODE`, `GOAL_CODE`, `NAME`, `IMAGE`, `STORY`, `EXPIRY_DATE`, `DATE`) VALUES
(2, 'HYPE_NEW_BIE', 'HYPE_GOAL', 'Newbie ', 'newbie.jpg', 'Welcome! You have entered Hype Community, Experiencing money as a tool', '2015-12-31', '2015-08-22 01:08:49'),
(3, 'HYPE_SAVER', 'HYPE_GOAL', 'You have saved money for a goal by 25%', 'SAVER.JPG', 'You have saved 25% money for a goal ', '2015-12-31', '2015-08-22 01:08:49'),
(4, 'HYPE_SUPER_SAVER', 'HYPE_GOAL', 'Hype Super Saver', 'HYPE_SUPER_SAVER.JPG', 'You have saved 50% of Money for a goal', '2015-12-31', '2015-08-22 01:08:49'),
(5, 'HYPE_SUPER_SMART_SAVER', 'HYPE_GOAL', 'You are Super Smart Saver', 'HYPE_SUPER_SMART_SAVER.JPG', 'You have saved 75% for a goal', '2015-12-31', '2015-08-22 01:08:49'),
(6, 'HYPE_GOAL_SHARE_BUDDY', 'HYPE_GOAL', 'SOCIALIZER', 'SOCIALIZER.JPG', 'You have shared your Goal with a buddy\n', '2015-12-31', '2015-08-22 01:08:49'),
(7, 'HYPE_FELLOW_INFLUENCER', 'HYPE_GOAL', 'Received Comments and like', 'HYPE_FELLOW_INFLUENCER.JPG', 'You have received Comments and like from your buddy', '2015-12-31', '2015-08-22 01:08:49'),
(8, 'HYPE_GURU', 'HYPE GOAL', 'Complete a Goal', 'HYPE_GURU.jpg', 'You have completed a Goal', '2015-12-31', '2015-08-22 01:08:49'),
(9, 'HYPE_STAR_CONTRIBUTOR', 'HYPE_GOAL', 'Star Contributor', 'badge.jpg', 'Star Contributor', '2015-10-31', '2015-08-22 01:08:49');

-- --------------------------------------------------------

--
-- Table structure for table `SS_MA_CHALLENGE`
--

CREATE TABLE IF NOT EXISTS `SS_MA_CHALLENGE` (
  `CHALLENGE_ID` int(250) NOT NULL,
  `ACTION_CODE` varchar(250) NOT NULL,
  `GOAL_CODE` varchar(250) NOT NULL,
  `STORY` varchar(5000) DEFAULT NULL,
  `IMAGE` varchar(2000) DEFAULT NULL,
  `POINTS` int(250) NOT NULL,
  `OCCURRENCE` int(250) DEFAULT NULL,
  `EXPIRY_DATE` date NOT NULL,
  `BADGE_CODE` varchar(250) DEFAULT NULL,
  `REWARD_CODE` varchar(250) DEFAULT NULL,
  `STATUS` varchar(250) NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SS_MA_CHALLENGE`
--

INSERT INTO `SS_MA_CHALLENGE` (`CHALLENGE_ID`, `ACTION_CODE`, `GOAL_CODE`, `STORY`, `IMAGE`, `POINTS`, `OCCURRENCE`, `EXPIRY_DATE`, `BADGE_CODE`, `REWARD_CODE`, `STATUS`, `DATE`) VALUES
(2, 'HYPE_APP_DOWLD', 'HYPE_GOAL', 'Download Hype App', 'hype_icon.png', 10, 1, '2015-12-31', 'HYPE_NEW_BIE', NULL, 'ACTIVE', '2015-08-22 01:15:15'),
(3, 'HYPE_CREATE_GOAL', 'HYPE_GOAL', 'You have created a Goal in Hype app', 'challenge.jpg', 10, NULL, '2015-12-31', 'HYPE_NEW_BIE', 'AMAZON_GIFT_VOUCHER', 'ACTIVE', '2015-08-22 01:15:15'),
(4, 'HYPE_CREATE_GOAL_MILESTONE', 'HYPE_GOAL', 'You have created Milestone for a Goal', 'challenge.jpg', 5, NULL, '2015-12-31', 'HYPE_CREATE_GOAL_MILESTONE', NULL, 'ACTIVE', '2015-08-22 01:15:15'),
(5, 'HYPE_GOAL_SAVE_MONEY_25', 'HYPE_GOAL', 'You have saved 25% money for your Hype Goal', 'challenge.jpg', 10, NULL, '2015-12-31', 'HYPE_SAVER', NULL, 'ACTIVE', '2015-08-22 01:15:15'),
(6, 'HYPE_GOAL_SAVE_MONEY_50', 'HYPE_GOAL', 'you have saved 50% money towards your Hype Goal', 'challenge', 10, NULL, '2015-12-31', 'HYPE_SUPER_SAVER', NULL, 'ACTIVE', '2015-08-22 01:15:15'),
(7, 'HYPE_GOAL_SAVE_MONEY_75', 'HYPE_GOAL', 'You have saved 75% money for your Hype Goal', 'challenge.jpg', 10, NULL, '2015-12-31', 'HYPE_SUPER_SMART_SAVER', NULL, 'ACTIVE', '2015-08-22 01:15:15'),
(8, 'HYPE_GOAL_SHARE_BUDDY', 'HYPE_GOAL', 'You have Shared you Goal with your buddy', 'challenge.jpg', 10, NULL, '2015-12-31', 'HYPE_GOAL_SHARE_BUDDY', NULL, 'ACTIVE', '2015-08-22 01:15:15'),
(9, 'HYPE_GOAL_LOCK', 'HYPE_GOAL', 'You have locked your Hype Goal', 'challenge.jpg', -30, NULL, '2015-12-31', NULL, NULL, 'ACTIVE', '2015-08-22 01:15:15'),
(10, 'HYPE_GOAL_UNLOCK', 'HYPE_GOAL', 'You have unlocked your Hype Goal', 'challenge.jpg', 30, NULL, '2015-12-31', NULL, NULL, 'ACTIVE', '2015-08-22 01:15:15'),
(11, 'HYPE_RECEIVE_COMMENTS', 'HYPE_GOAL', 'You have received Comments on your Hype goal', NULL, 3, NULL, '2015-12-31', 'HYPE_FELLOW_INFLUENCER', NULL, 'ACTIVE', '2015-08-22 01:15:15'),
(12, 'HYPE_RECEIVE_LIKE', 'HYPE_GOAL', 'You have received like for your Hype Goal ', 'challenge.jpg', 1, NULL, '2015-12-31', 'HYPE_FELLOW_INFLUENCER', NULL, 'ACTIVE', '2015-08-22 01:15:15'),
(13, 'HYPE_CONTRIBUTE_BUDDY', '', 'You have contributed for your friends Hype Goal', 'challenge.jpg', 10, NULL, '2015-12-31', 'HYPE_STAR_CONTRIBUTOR', NULL, 'ACTIVE', '2015-08-22 01:15:15'),
(14, 'HYPE_COMPLETE_GOAL', 'HYPE_GOAL', 'You have completed your Hype Goal', 'challenge.jpg', 10, NULL, '2016-01-31', 'HYPE_GURU', NULL, 'ACTIVE', '2015-08-22 01:15:15'),
(15, 'HYPE_CANCEL_GOAL', 'HYPE_GOAL', 'You have cancelled your Hype Goal ', 'Challenge.jpg', -20, NULL, '2015-12-31', NULL, NULL, 'ACTIVE', '2015-08-22 01:15:15');

-- --------------------------------------------------------

--
-- Table structure for table `SS_MA_GOAL`
--

CREATE TABLE IF NOT EXISTS `SS_MA_GOAL` (
  `GOAL_ID` int(250) NOT NULL,
  `GOAL_CODE` varchar(250) NOT NULL,
  `NAME` varchar(2000) NOT NULL,
  `STORY` varchar(5000) DEFAULT NULL,
  `EXPIRY_DATE` date NOT NULL,
  `IMAGE` varchar(2000) DEFAULT NULL,
  `USER_TYPE` varchar(250) NOT NULL,
  `STATUS` varchar(250) NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SS_MA_GOAL`
--

INSERT INTO `SS_MA_GOAL` (`GOAL_ID`, `GOAL_CODE`, `NAME`, `STORY`, `EXPIRY_DATE`, `IMAGE`, `USER_TYPE`, `STATUS`, `DATE`) VALUES
(3, 'HYPE_GOAL', 'Hype Goal', 'Create Hype Goals, Share Goal with your Buddy, accomplish your Goal', '2016-01-01', 'hype.jpg', 'CUSTOMER', 'ACTIVE', '2015-08-22 01:06:41');

-- --------------------------------------------------------

--
-- Table structure for table `SS_MA_LEVEL`
--

CREATE TABLE IF NOT EXISTS `SS_MA_LEVEL` (
  `LEVEL_ID` int(250) NOT NULL,
  `LEVEL_CODE` varchar(250) NOT NULL,
  `GOAL_CODE` varchar(250) DEFAULT NULL,
  `REWARD_CODE` varchar(250) DEFAULT NULL,
  `BADGE_CODE` varchar(250) DEFAULT NULL,
  `NAME` varchar(2000) NOT NULL,
  `IMAGE` varchar(2000) DEFAULT NULL,
  `STORY` varchar(5000) DEFAULT NULL,
  `POINTS` int(250) NOT NULL,
  `PRIORITY` int(250) NOT NULL,
  `EXPIRY_DATE` date NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SS_MA_LEVEL`
--

INSERT INTO `SS_MA_LEVEL` (`LEVEL_ID`, `LEVEL_CODE`, `GOAL_CODE`, `REWARD_CODE`, `BADGE_CODE`, `NAME`, `IMAGE`, `STORY`, `POINTS`, `PRIORITY`, `EXPIRY_DATE`, `DATE`) VALUES
(3, 'LEVEL1', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'BRONZE', 'reached 250 points', NULL, 'Congrats, you have reached 250 Points in achieving your financial goal using Hype Goal Program', 250, 1, '2015-08-31', '0000-00-00 00:00:00'),
(4, 'LEVEL2', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'SILVER', 'reached 500 points ', 'level.jpg', 'Congrats, you have reached 500 points in achieving your financial goal using Hype Goal Program', 500, 2, '2015-08-31', '0000-00-00 00:00:00'),
(5, 'LEVEL3', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'GOLD', 'reached 1000 points ', 'level.jpg', 'Congrats, you have reached 1000 points in achieving your financial goal using Hype Goal Program', 1000, 3, '2015-08-31', '0000-00-00 00:00:00'),
(6, 'LEVEL4', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'PLATINUM', 'reached 2500 points ', 'level.jpg', 'Congrats, you have reached 2500 points in achieving your financial goal using Hype Goal Program', 2500, 4, '2015-08-31', '0000-00-00 00:00:00'),
(7, 'LEVEL5', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'DIAMOND', 'reached >greater than 5000 points', 'level.jpg', 'Congrats, for reaching more than 5000 points in achieving your financial goals using Hype Goal Program', 5000, 5, '2015-08-31', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `SS_MA_REWARD`
--

CREATE TABLE IF NOT EXISTS `SS_MA_REWARD` (
  `REWARD_ID` int(250) NOT NULL,
  `REWARD_CODE` varchar(250) NOT NULL,
  `GOAL_CODE` varchar(250) NOT NULL,
  `NAME` varchar(2000) NOT NULL,
  `STORY` varchar(5000) DEFAULT NULL,
  `IMAGE` varchar(2000) DEFAULT NULL,
  `EXPIRY_DATE` date NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SS_MA_REWARD`
--

INSERT INTO `SS_MA_REWARD` (`REWARD_ID`, `REWARD_CODE`, `GOAL_CODE`, `NAME`, `STORY`, `IMAGE`, `EXPIRY_DATE`, `DATE`) VALUES
(2, 'AMAZON_GIFT_VOUCHER', 'HYPE_GOAL', 'Amazon gift voucher', 'Amazon gift voucher worth 10Euro', 'AMAZON_GIFT_VOUCHER.jpg', '2015-12-31', '2015-08-22 01:09:37');

-- --------------------------------------------------------

--
-- Table structure for table `SS_MA_USER`
--

CREATE TABLE IF NOT EXISTS `SS_MA_USER` (
  `USER_ID` int(250) NOT NULL,
  `USER_CODE` varchar(250) NOT NULL,
  `NAME` varchar(2000) NOT NULL,
  `NICK_NAME` varchar(2000) DEFAULT NULL,
  `IMAGE` varchar(2000) DEFAULT NULL,
  `USER_TYPE` varchar(250) NOT NULL,
  `STATUS` varchar(250) NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SS_MA_USER`
--

INSERT INTO `SS_MA_USER` (`USER_ID`, `USER_CODE`, `NAME`, `NICK_NAME`, `IMAGE`, `USER_TYPE`, `STATUS`, `DATE`) VALUES
(13, 'GBS03146', 'Sujatha Balaji', 'Sujatha', 'sujatha.jpg', 'EMPLOYEE', 'ACTIVE', '2015-08-22 01:20:40');

-- --------------------------------------------------------

--
-- Table structure for table `SS_MA_USER_TYPE`
--

CREATE TABLE IF NOT EXISTS `SS_MA_USER_TYPE` (
  `USER_TYPE_ID` int(250) NOT NULL,
  `USER_TYPE_CODE` varchar(250) NOT NULL,
  `STORY` varchar(5000) DEFAULT NULL,
  `IMAGE` varchar(2000) DEFAULT NULL,
  `STATUS` varchar(250) NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SS_MA_USER_TYPE`
--

INSERT INTO `SS_MA_USER_TYPE` (`USER_TYPE_ID`, `USER_TYPE_CODE`, `STORY`, `IMAGE`, `STATUS`, `DATE`) VALUES
(2, 'CUSTOMER', 'CUSTOMER OF GBS', 'CUSTOMER.JPG', 'ACTIVE', '2015-08-22 01:03:28'),
(3, 'EMPLOYEE', 'EMPLOYEE OF GBS', 'EMPLOYEE.JPG', 'ACTIVE', '2015-08-22 01:03:28');

-- --------------------------------------------------------

--
-- Table structure for table `SS_TR_USER_ACTION`
--

CREATE TABLE IF NOT EXISTS `SS_TR_USER_ACTION` (
  `TR_ID` int(250) NOT NULL,
  `GOAL_CODE` varchar(250) NOT NULL,
  `USER_CODE` varchar(250) NOT NULL,
  `ACTION_CODE` varchar(250) NOT NULL,
  `POINTS` int(250) NOT NULL,
  `STATUS` varchar(250) NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `SS_TR_USER_BADGE`
--

CREATE TABLE IF NOT EXISTS `SS_TR_USER_BADGE` (
  `TR_ID` int(250) NOT NULL,
  `BADGE_CODE` varchar(250) NOT NULL,
  `GOAL_CODE` varchar(250) NOT NULL,
  `USER_CODE` varchar(250) NOT NULL,
  `STATUS` varchar(250) NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `SS_TR_USER_GOAL_POINTS`
--

CREATE TABLE IF NOT EXISTS `SS_TR_USER_GOAL_POINTS` (
  `TR_ID` int(250) NOT NULL,
  `USER_CODE` varchar(250) NOT NULL,
  `GOAL_CODE` varchar(250) NOT NULL,
  `TOTAL_POINTS` varchar(250) NOT NULL,
  `REEDEMED_POINTS` varchar(250) NOT NULL,
  `GLOBAL_BADGE_CODE` varchar(250) DEFAULT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `SS_TR_USER_LEVEL`
--

CREATE TABLE IF NOT EXISTS `SS_TR_USER_LEVEL` (
  `TR_ID` int(250) NOT NULL,
  `LEVEL_CODE` varchar(250) NOT NULL,
  `USER_CODE` varchar(250) NOT NULL,
  `GOAL_CODE` varchar(250) NOT NULL,
  `BADGE_CODE` varchar(250) NOT NULL,
  `PRIORITY` int(250) NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `SS_TR_USER_REWARD`
--

CREATE TABLE IF NOT EXISTS `SS_TR_USER_REWARD` (
  `TR_ID` int(250) NOT NULL,
  `REWARD_CODE` varchar(250) NOT NULL,
  `GOAL_CODE` varchar(250) NOT NULL,
  `USER_CODE` varchar(250) NOT NULL,
  `REDEEM_STATUS` varchar(250) NOT NULL,
  `REDEEM_POINTS` int(250) NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `SS_MA_BADGE`
--
ALTER TABLE `SS_MA_BADGE`
  ADD PRIMARY KEY (`BADGE_ID`),
  ADD UNIQUE KEY `BADGE_CODE` (`BADGE_CODE`);

--
-- Indexes for table `SS_MA_CHALLENGE`
--
ALTER TABLE `SS_MA_CHALLENGE`
  ADD PRIMARY KEY (`CHALLENGE_ID`),
  ADD UNIQUE KEY `ACTION_CODE` (`ACTION_CODE`);

--
-- Indexes for table `SS_MA_GOAL`
--
ALTER TABLE `SS_MA_GOAL`
  ADD PRIMARY KEY (`GOAL_ID`),
  ADD UNIQUE KEY `GOAL_CODE` (`GOAL_CODE`),
  ADD KEY `FK_GOAL_USER_TYPE` (`USER_TYPE`);

--
-- Indexes for table `SS_MA_LEVEL`
--
ALTER TABLE `SS_MA_LEVEL`
  ADD PRIMARY KEY (`LEVEL_ID`),
  ADD UNIQUE KEY `LEVEL_CODE` (`LEVEL_CODE`);

--
-- Indexes for table `SS_MA_REWARD`
--
ALTER TABLE `SS_MA_REWARD`
  ADD PRIMARY KEY (`REWARD_ID`),
  ADD UNIQUE KEY `REWARD_CODE` (`REWARD_CODE`);

--
-- Indexes for table `SS_MA_USER`
--
ALTER TABLE `SS_MA_USER`
  ADD PRIMARY KEY (`USER_ID`),
  ADD UNIQUE KEY `USER_CODE` (`USER_CODE`),
  ADD KEY `FK_USER_TYPE` (`USER_TYPE`);

--
-- Indexes for table `SS_MA_USER_TYPE`
--
ALTER TABLE `SS_MA_USER_TYPE`
  ADD PRIMARY KEY (`USER_TYPE_ID`),
  ADD UNIQUE KEY `USER_TYPE_CODE` (`USER_TYPE_CODE`);

--
-- Indexes for table `SS_TR_USER_ACTION`
--
ALTER TABLE `SS_TR_USER_ACTION`
  ADD PRIMARY KEY (`TR_ID`);

--
-- Indexes for table `SS_TR_USER_BADGE`
--
ALTER TABLE `SS_TR_USER_BADGE`
  ADD PRIMARY KEY (`TR_ID`);

--
-- Indexes for table `SS_TR_USER_GOAL_POINTS`
--
ALTER TABLE `SS_TR_USER_GOAL_POINTS`
  ADD PRIMARY KEY (`TR_ID`);

--
-- Indexes for table `SS_TR_USER_LEVEL`
--
ALTER TABLE `SS_TR_USER_LEVEL`
  ADD PRIMARY KEY (`TR_ID`);

--
-- Indexes for table `SS_TR_USER_REWARD`
--
ALTER TABLE `SS_TR_USER_REWARD`
  ADD PRIMARY KEY (`TR_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `SS_MA_BADGE`
--
ALTER TABLE `SS_MA_BADGE`
  MODIFY `BADGE_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `SS_MA_CHALLENGE`
--
ALTER TABLE `SS_MA_CHALLENGE`
  MODIFY `CHALLENGE_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `SS_MA_GOAL`
--
ALTER TABLE `SS_MA_GOAL`
  MODIFY `GOAL_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `SS_MA_LEVEL`
--
ALTER TABLE `SS_MA_LEVEL`
  MODIFY `LEVEL_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `SS_MA_REWARD`
--
ALTER TABLE `SS_MA_REWARD`
  MODIFY `REWARD_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `SS_MA_USER`
--
ALTER TABLE `SS_MA_USER`
  MODIFY `USER_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `SS_MA_USER_TYPE`
--
ALTER TABLE `SS_MA_USER_TYPE`
  MODIFY `USER_TYPE_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `SS_TR_USER_ACTION`
--
ALTER TABLE `SS_TR_USER_ACTION`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `SS_TR_USER_BADGE`
--
ALTER TABLE `SS_TR_USER_BADGE`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `SS_TR_USER_GOAL_POINTS`
--
ALTER TABLE `SS_TR_USER_GOAL_POINTS`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `SS_TR_USER_LEVEL`
--
ALTER TABLE `SS_TR_USER_LEVEL`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `SS_TR_USER_REWARD`
--
ALTER TABLE `SS_TR_USER_REWARD`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `SS_MA_GOAL`
--
ALTER TABLE `SS_MA_GOAL`
  ADD CONSTRAINT `FK_GOAL_USER_TYPE` FOREIGN KEY (`USER_TYPE`) REFERENCES `SS_MA_USER_TYPE` (`USER_TYPE_CODE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `SS_MA_USER`
--
ALTER TABLE `SS_MA_USER`
  ADD CONSTRAINT `FK_USER_TYPE` FOREIGN KEY (`USER_TYPE`) REFERENCES `SS_MA_USER_TYPE` (`USER_TYPE_CODE`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
