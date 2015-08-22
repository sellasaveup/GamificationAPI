-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 22, 2015 at 10:27 AM
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
  `BADGE_ID` int(250) NOT NULL,
  `BADGE_CODE` varchar(250) NOT NULL,
  `GOAL_CODE` varchar(250) NOT NULL,
  `NAME` varchar(2000) NOT NULL,
  `IMAGE` varchar(2000) DEFAULT NULL,
  `STORY` varchar(5000) DEFAULT NULL,
  `EXPIRY_DATE` date NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `ss_ma_badge`:
--   `GOAL_CODE`
--       `ss_ma_goal` -> `GOAL_CODE`
--

--
-- Dumping data for table `ss_ma_badge`
--

INSERT INTO `ss_ma_badge` (`BADGE_ID`, `BADGE_CODE`, `GOAL_CODE`, `NAME`, `IMAGE`, `STORY`, `EXPIRY_DATE`, `DATE`) VALUES
(1, 'HYPE_NEW_BIE', 'HYPE_GOAL', 'Newbie ', 'newbie.jpg', 'Welcome! You have entered Hype Community, Experiencing money as a tool', '2015-07-31', '2015-08-16 13:12:33'),
(2, 'HYPE_SAVER', 'HYPE_GOAL', 'You have saved money for a goal by 25%', 'SAVER.JPG', 'You have saved 25% money for a goal ', '2015-12-31', '2015-08-16 13:17:30'),
(3, 'HYPE_SUPER_SAVER', 'HYPE_GOAL', 'Hype Super Saver', 'HYPE_SUPER_SAVER.JPG', 'You have saved 50% of Money for a goal', '2015-12-31', '2015-08-16 13:45:09'),
(4, 'HYPE_SUPER_SMART_SAVER', 'HYPE_GOAL', 'You are Super Smart Saver', 'HYPE_SUPER_SMART_SAVER.JPG', 'You have saved 75% for a goal', '2015-12-31', '2015-08-16 13:47:50'),
(5, 'HYPE_GOAL_SHARE_BUDDY', 'HYPE_GOAL', 'SOCIALIZER', 'SOCIALIZER.JPG', 'You have shared your Goal with a buddy', '2015-12-31', '2015-08-16 13:49:50'),
(6, 'HYPE_FELLOW_INFLUENCER', 'HYPE_GOAL', 'Received Comments and like', 'HYPE_FELLOW_INFLUENCER.JPG', 'You have received Comments and like from your buddy', '2015-12-31', '2015-08-16 13:55:41'),
(7, 'HYPE_GURU', 'HYPE_GOAL', 'Complete a Goal', 'HYPE_GURU.jpg', 'You have completed a Goal', '2015-12-31', '2015-08-16 14:00:38'),
(8, 'HYPE_STAR_CONTRIBUTOR', 'HYPE_GOAL', 'Star Contributor', 'badge.jpg', 'Star Contributor', '2015-10-31', '2015-08-20 11:17:51'),
(9, 'HYPE_BRONZE', 'HYPE_GOAL', 'Bronze status', 'bronze.jpg', 'You have reached Bronze status', '2015-12-31', '2015-08-22 13:08:59'),
(10, 'HYPE_SILVER', 'HYPE_GOAL', 'Silver status', 'silver.jpg', 'You have reached Silver status', '2015-12-31', '2015-08-22 13:09:24'),
(11, 'HYPE_GOLD', 'HYPE_GOAL', 'Gold status', 'gold.jpg', 'You have reached Gold status', '2015-12-31', '2015-08-22 13:09:54'),
(12, 'HYPE_PLATINUM', 'HYPE_GOAL', 'Platinum status', 'platinum.jpg', 'You have reached Platinum status', '2015-12-31', '2015-08-22 13:10:21'),
(13, 'HYPE_DIAMOND', 'HYPE_GOAL', 'Diamond status', 'diamond.jpg', 'You have reached Diamond status', '2015-12-31', '2015-08-22 13:10:48');

-- --------------------------------------------------------

--
-- Table structure for table `ss_ma_challenge`
--

CREATE TABLE IF NOT EXISTS `ss_ma_challenge` (
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
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `ss_ma_challenge`:
--   `GOAL_CODE`
--       `ss_ma_goal` -> `GOAL_CODE`
--

--
-- Dumping data for table `ss_ma_challenge`
--

INSERT INTO `ss_ma_challenge` (`CHALLENGE_ID`, `ACTION_CODE`, `GOAL_CODE`, `STORY`, `IMAGE`, `POINTS`, `OCCURRENCE`, `EXPIRY_DATE`, `BADGE_CODE`, `REWARD_CODE`, `DATE`) VALUES
(1, 'HYPE_APP_DOWLD', 'HYPE_GOAL', 'Download Hype App', 'hype_icon.png', 10, NULL, '2015-12-31', 'HYPE_NEW_BIE', NULL, '2015-08-20 10:53:00'),
(2, 'HYPE_CREATE_GOAL', 'HYPE_GOAL', 'You have created a Goal in Hype app\r\n', 'challenge.jpg', 10, NULL, '2015-12-31', 'HYPE_NEW_BIE', NULL, '2015-08-20 11:35:11'),
(3, 'HYPE_CREATE_GOAL_MILESTONE', 'HYPE_GOAL', 'You have created Milestone for a Goal\r\n', 'challenge.jpg', 5, NULL, '2015-12-31', 'HYPE_CREATE_GOAL_MILESTONE', NULL, '2015-08-20 11:36:45'),
(4, 'HYPE_GOAL_SAVE_MONEY_25', 'HYPE_GOAL', 'You have saved 25% money for your Hype Goal', 'challenge.jpg', 10, NULL, '2015-12-31', 'HYPE_SAVER', NULL, '2015-08-20 11:43:00'),
(5, 'HYPE_GOAL_SAVE_MONEY_50', 'HYPE_GOAL', 'you have saved 50% money towards your Hype Goal', 'challenge', 10, NULL, '2015-12-31', 'HYPE_SUPER_SAVER', NULL, '2015-08-20 11:45:32'),
(6, 'HYPE_GOAL_SAVE_MONEY_75', 'HYPE_GOAL', 'You have saved 75% money for your Hype Goal\r\n', 'challenge.jpg', 10, NULL, '2015-12-31', 'HYPE_SUPER_SMART_SAVER', NULL, '2015-08-20 11:48:21'),
(7, 'HYPE_GOAL_SHARE_BUDDY', 'HYPE_GOAL', 'You have Shared you Goal with your buddy', 'challenge.jpg', 10, NULL, '2015-12-31', 'HYPE_GOAL_SHARE_BUDDY', NULL, '2015-08-20 11:50:24'),
(8, 'HYPE_GOAL_LOCK', 'HYPE_GOAL', 'You have locked your Hype Goal', 'challenge.jpg', -30, NULL, '2015-12-31', NULL, NULL, '2015-08-20 11:54:01'),
(9, 'HYPE_GOAL_UNLOCK', 'HYPE_GOAL', 'You have unlocked your Hype Goal', 'challenge.jpg', 30, NULL, '2015-12-31', NULL, NULL, '2015-08-20 11:54:42'),
(10, 'HYPE_RECEIVE_COMMENTS', 'HYPE_GOAL', 'You have received Comments on your Hype goal\r\n', NULL, 3, NULL, '2015-12-31', 'HYPE_FELLOW_INFLUENCER', NULL, '2015-08-20 11:55:48'),
(11, 'HYPE_RECEIVE_LIKE', 'HYPE_GOAL', 'You have received like for your Hype Goal ', 'challenge.jpg', 1, NULL, '2015-12-31', 'HYPE_FELLOW_INFLUENCER\r\n', NULL, '2015-08-20 11:56:59'),
(12, 'HYPE_CONTRIBUTE_BUDDY', 'HYPE_GOAL', 'You have contributed for your friends Hype Goal', 'challenge.jpg', 10, NULL, '2015-12-31', 'HYPE_STAR_CONTRIBUTOR\r\n', NULL, '2015-08-20 11:58:09'),
(13, 'HYPE_COMPLETE_GOAL', 'HYPE_GOAL', 'You have completed your Hype Goal', 'challenge.jpg', 10, NULL, '2016-01-31', 'HYPE_GURU', NULL, '2015-08-20 12:00:08'),
(14, 'HYPE_CANCEL_GOAL', 'HYPE_GOAL', 'You have cancelled your Hype Goal ', 'Challenge.jpg', -20, NULL, '2015-12-31', NULL, NULL, '2015-08-20 12:01:37');

-- --------------------------------------------------------

--
-- Table structure for table `ss_ma_goal`
--

CREATE TABLE IF NOT EXISTS `ss_ma_goal` (
  `GOAL_ID` int(250) NOT NULL,
  `GOAL_CODE` varchar(250) NOT NULL,
  `NAME` varchar(2000) NOT NULL,
  `STORY` varchar(5000) DEFAULT NULL,
  `EXPIRY_DATE` date NOT NULL,
  `IMAGE` varchar(2000) DEFAULT NULL,
  `USER_TYPE` varchar(250) NOT NULL,
  `STATUS` varchar(250) NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `ss_ma_goal`:
--   `USER_TYPE`
--       `ss_ma_user_type` -> `USER_TYPE_CODE`
--

--
-- Dumping data for table `ss_ma_goal`
--

INSERT INTO `ss_ma_goal` (`GOAL_ID`, `GOAL_CODE`, `NAME`, `STORY`, `EXPIRY_DATE`, `IMAGE`, `USER_TYPE`, `STATUS`, `DATE`) VALUES
(1, 'HYPE_GOAL', 'Hype Goal', 'Create Hype Goals, Share Goal with your Buddy, accomplish your Goal', '2016-01-01', 'hype.jpg', 'EMPLOYEE', 'ACTIVE', '2015-08-16 13:05:41');

-- --------------------------------------------------------

--
-- Table structure for table `ss_ma_level`
--

CREATE TABLE IF NOT EXISTS `ss_ma_level` (
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
  `DATE` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `ss_ma_level`:
--   `GOAL_CODE`
--       `ss_ma_goal` -> `GOAL_CODE`
--

--
-- Dumping data for table `ss_ma_level`
--

INSERT INTO `ss_ma_level` (`LEVEL_ID`, `LEVEL_CODE`, `GOAL_CODE`, `REWARD_CODE`, `BADGE_CODE`, `NAME`, `IMAGE`, `STORY`, `POINTS`, `PRIORITY`, `DATE`) VALUES
(1, 'LEVEL1', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'HYPE_BRONZE', 'reached 250 points', 'level.jpg', 'Congrats, you have reached 250 Points in achieving your financial goal using Hype Goal Program', 250, 1, '2015-08-20 00:00:00'),
(2, 'LEVEL2', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'HYPE_SILVER', 'reached 500 points ', 'level.jpg', 'Congrats, you have reached 500 points in achieving your financial goal using Hype Goal Program', 500, 2, '2015-08-20 00:00:00'),
(3, 'LEVEL3', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'HYPE_GOLD', 'reached 1000 points ', 'level.jpg', 'Congrats, you have reached 1000 points in achieving your financial goal using Hype Goal Program', 1000, 3, '2015-08-20 00:00:00'),
(4, 'LEVEL4', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'HYPE_PLATINUM', 'reached 2500 points ', 'level.jpg', 'Congrats, you have reached 2500 points in achieving your financial goal using Hype Goal Program', 2500, 4, '2015-08-20 00:00:00'),
(5, 'LEVEL5', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'HYPE_DIAMOND', 'reached >greater than 5000 points', 'level.jpg', 'Congrats, for reaching more than 5000 points in achieving your financial goals using Hype Goal Program', 5000, 5, '2015-08-20 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `ss_ma_reward`
--

CREATE TABLE IF NOT EXISTS `ss_ma_reward` (
  `REWARD_ID` int(250) NOT NULL,
  `REWARD_CODE` varchar(250) NOT NULL,
  `GOAL_CODE` varchar(250) NOT NULL,
  `NAME` varchar(2000) NOT NULL,
  `STORY` varchar(5000) DEFAULT NULL,
  `IMAGE` varchar(2000) DEFAULT NULL,
  `EXPIRY_DATE` date NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `ss_ma_reward`:
--   `GOAL_CODE`
--       `ss_ma_goal` -> `GOAL_CODE`
--

--
-- Dumping data for table `ss_ma_reward`
--

INSERT INTO `ss_ma_reward` (`REWARD_ID`, `REWARD_CODE`, `GOAL_CODE`, `NAME`, `STORY`, `IMAGE`, `EXPIRY_DATE`, `DATE`) VALUES
(1, 'AMAZON_GIFT_VOUCHER', 'HYPE_GOAL', 'Amazon gift voucher', 'Amazon gift voucher worth 10Euro', 'AMAZON_GIFT_VOUCHER.jpg', '2015-12-31', '2015-08-16 14:15:45');

-- --------------------------------------------------------

--
-- Table structure for table `ss_ma_user`
--

CREATE TABLE IF NOT EXISTS `ss_ma_user` (
  `USER_ID` int(250) NOT NULL,
  `USER_CODE` varchar(250) NOT NULL,
  `NAME` varchar(2000) NOT NULL,
  `NICK_NAME` varchar(2000) DEFAULT NULL,
  `IMAGE` varchar(2000) DEFAULT NULL,
  `USER_TYPE` varchar(250) NOT NULL,
  `STATUS` varchar(250) NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `ss_ma_user`:
--   `USER_TYPE`
--       `ss_ma_user_type` -> `USER_TYPE_CODE`
--

--
-- Dumping data for table `ss_ma_user`
--

INSERT INTO `ss_ma_user` (`USER_ID`, `USER_CODE`, `NAME`, `NICK_NAME`, `IMAGE`, `USER_TYPE`, `STATUS`, `DATE`) VALUES
(1, 'GBS03146', 'Sujatha Balaji', 'Sujatha', 'sujatha.jpg', 'EMPLOYEE', 'ACTIVE', '2015-08-16 13:01:26');

-- --------------------------------------------------------

--
-- Table structure for table `ss_ma_user_type`
--

CREATE TABLE IF NOT EXISTS `ss_ma_user_type` (
  `USER_TYPE_ID` int(250) NOT NULL,
  `USER_TYPE_CODE` varchar(250) NOT NULL,
  `STORY` varchar(5000) DEFAULT NULL,
  `IMAGE` varchar(2000) DEFAULT NULL,
  `STATUS` varchar(250) NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `ss_ma_user_type`:
--

--
-- Dumping data for table `ss_ma_user_type`
--

INSERT INTO `ss_ma_user_type` (`USER_TYPE_ID`, `USER_TYPE_CODE`, `STORY`, `IMAGE`, `STATUS`, `DATE`) VALUES
(1, 'CUSTOMER', 'CUSTOMER OF GBS', 'CUSTOMER.JPG', 'ACTIVE', '2015-08-16 13:02:56'),
(2, 'EMPLOYEE', 'EMPLOYEE OF GBS', 'EMPLOYEE.JPG', 'ACTIVE', '2015-08-16 13:02:56');

-- --------------------------------------------------------

--
-- Table structure for table `ss_tr_user_action`
--

CREATE TABLE IF NOT EXISTS `ss_tr_user_action` (
  `TR_ID` int(250) NOT NULL,
  `GOAL_CODE` varchar(250) NOT NULL,
  `USER_CODE` varchar(250) NOT NULL,
  `ACTION_CODE` varchar(250) NOT NULL,
  `POINTS` int(250) NOT NULL,
  `STATUS` varchar(250) NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `ss_tr_user_action`:
--   `ACTION_CODE`
--       `ss_ma_challenge` -> `ACTION_CODE`
--   `GOAL_CODE`
--       `ss_ma_goal` -> `GOAL_CODE`
--   `USER_CODE`
--       `ss_ma_user` -> `USER_CODE`
--

--
-- Dumping data for table `ss_tr_user_action`
--

INSERT INTO `ss_tr_user_action` (`TR_ID`, `GOAL_CODE`, `USER_CODE`, `ACTION_CODE`, `POINTS`, `STATUS`, `DATE`) VALUES
(1, 'HYPE_GOAL', 'GBS03146', 'HYPE_APP_DOWLD', 10, 'Active', '2015-07-30 15:37:22'),
(2, 'HYPE_GOAL', 'GBS03146', 'HYPE_CREATE_GOAL', 10, 'Active', '2015-08-20 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `ss_tr_user_badge`
--

CREATE TABLE IF NOT EXISTS `ss_tr_user_badge` (
  `TR_ID` int(250) NOT NULL,
  `BADGE_CODE` varchar(250) NOT NULL,
  `GOAL_CODE` varchar(250) NOT NULL,
  `USER_CODE` varchar(250) NOT NULL,
  `STATUS` varchar(250) NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `ss_tr_user_badge`:
--   `BADGE_CODE`
--       `ss_ma_badge` -> `BADGE_CODE`
--   `GOAL_CODE`
--       `ss_ma_goal` -> `GOAL_CODE`
--   `USER_CODE`
--       `ss_ma_user` -> `USER_CODE`
--

--
-- Dumping data for table `ss_tr_user_badge`
--

INSERT INTO `ss_tr_user_badge` (`TR_ID`, `BADGE_CODE`, `GOAL_CODE`, `USER_CODE`, `STATUS`, `DATE`) VALUES
(4, 'HYPE_BRONZE', 'HYPE_GOAL', 'GBS03146', 'ACT', '2015-08-22 13:55:30');

-- --------------------------------------------------------

--
-- Table structure for table `ss_tr_user_goal_points`
--

CREATE TABLE IF NOT EXISTS `ss_tr_user_goal_points` (
  `TR_ID` int(250) NOT NULL,
  `USER_CODE` varchar(250) NOT NULL,
  `GOAL_CODE` varchar(250) NOT NULL,
  `TOTAL_POINTS` varchar(250) NOT NULL,
  `REEDEMED_POINTS` varchar(250) NOT NULL,
  `GLOBAL_BADGE_CODE` varchar(250) DEFAULT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `ss_tr_user_goal_points`:
--   `GLOBAL_BADGE_CODE`
--       `ss_ma_badge` -> `BADGE_CODE`
--   `GOAL_CODE`
--       `ss_ma_goal` -> `GOAL_CODE`
--   `USER_CODE`
--       `ss_ma_user` -> `USER_CODE`
--

--
-- Dumping data for table `ss_tr_user_goal_points`
--

INSERT INTO `ss_tr_user_goal_points` (`TR_ID`, `USER_CODE`, `GOAL_CODE`, `TOTAL_POINTS`, `REEDEMED_POINTS`, `GLOBAL_BADGE_CODE`, `DATE`) VALUES
(2, 'GBS03146', 'HYPE_GOAL', '10', '10', 'HYPE_BRONZE', '2015-08-22 13:55:51');

-- --------------------------------------------------------

--
-- Table structure for table `ss_tr_user_level`
--

CREATE TABLE IF NOT EXISTS `ss_tr_user_level` (
  `TR_ID` int(250) NOT NULL,
  `LEVEL_CODE` varchar(250) NOT NULL,
  `USER_CODE` varchar(250) NOT NULL,
  `GOAL_CODE` varchar(250) NOT NULL,
  `BADGE_CODE` varchar(250) NOT NULL,
  `PRIORITY` int(250) NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `ss_tr_user_level`:
--   `BADGE_CODE`
--       `ss_ma_badge` -> `BADGE_CODE`
--   `GOAL_CODE`
--       `ss_ma_goal` -> `GOAL_CODE`
--   `LEVEL_CODE`
--       `ss_ma_level` -> `LEVEL_CODE`
--   `USER_CODE`
--       `ss_ma_user` -> `USER_CODE`
--

--
-- Dumping data for table `ss_tr_user_level`
--

INSERT INTO `ss_tr_user_level` (`TR_ID`, `LEVEL_CODE`, `USER_CODE`, `GOAL_CODE`, `BADGE_CODE`, `PRIORITY`, `DATE`) VALUES
(2, 'LEVEL1', 'GBS03146', 'HYPE_GOAL', 'HYPE_BRONZE', 1, '2015-08-22 13:56:06');

-- --------------------------------------------------------

--
-- Table structure for table `ss_tr_user_reward`
--

CREATE TABLE IF NOT EXISTS `ss_tr_user_reward` (
  `TR_ID` int(250) NOT NULL,
  `REWARD_CODE` varchar(250) NOT NULL,
  `GOAL_CODE` varchar(250) NOT NULL,
  `USER_CODE` varchar(250) NOT NULL,
  `REDEEM_STATUS` varchar(250) NOT NULL,
  `REDEEM_POINTS` int(250) NOT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `ss_tr_user_reward`:
--   `GOAL_CODE`
--       `ss_ma_goal` -> `GOAL_CODE`
--   `REWARD_CODE`
--       `ss_ma_reward` -> `REWARD_CODE`
--   `USER_CODE`
--       `ss_ma_user` -> `USER_CODE`
--

--
-- Dumping data for table `ss_tr_user_reward`
--

INSERT INTO `ss_tr_user_reward` (`TR_ID`, `REWARD_CODE`, `GOAL_CODE`, `USER_CODE`, `REDEEM_STATUS`, `REDEEM_POINTS`, `DATE`) VALUES
(1, 'AMAZON_GIFT_VOUCHER', 'HYPE_GOAL', 'GBS03146', 'YES', 10, '2015-08-22 13:28:43');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ss_ma_badge`
--
ALTER TABLE `ss_ma_badge`
  ADD PRIMARY KEY (`BADGE_ID`), ADD UNIQUE KEY `BADGE_CODE` (`BADGE_CODE`), ADD KEY `GOAL_CODE` (`GOAL_CODE`);

--
-- Indexes for table `ss_ma_challenge`
--
ALTER TABLE `ss_ma_challenge`
  ADD PRIMARY KEY (`CHALLENGE_ID`), ADD UNIQUE KEY `ACTION_CODE` (`ACTION_CODE`), ADD KEY `GOAL_CODE` (`GOAL_CODE`), ADD KEY `BADGE_CODE` (`BADGE_CODE`);

--
-- Indexes for table `ss_ma_goal`
--
ALTER TABLE `ss_ma_goal`
  ADD PRIMARY KEY (`GOAL_ID`), ADD UNIQUE KEY `GOAL_CODE` (`GOAL_CODE`), ADD KEY `FK_GOAL_USER_TYPE` (`USER_TYPE`);

--
-- Indexes for table `ss_ma_level`
--
ALTER TABLE `ss_ma_level`
  ADD PRIMARY KEY (`LEVEL_ID`), ADD UNIQUE KEY `LEVEL_CODE` (`LEVEL_CODE`), ADD KEY `GOAL_CODE` (`GOAL_CODE`), ADD KEY `REWARD_CODE` (`REWARD_CODE`), ADD KEY `BADGE_CODE` (`BADGE_CODE`), ADD KEY `PRIORITY` (`PRIORITY`);

--
-- Indexes for table `ss_ma_reward`
--
ALTER TABLE `ss_ma_reward`
  ADD PRIMARY KEY (`REWARD_ID`), ADD UNIQUE KEY `REWARD_CODE` (`REWARD_CODE`), ADD KEY `GOAL_CODE` (`GOAL_CODE`);

--
-- Indexes for table `ss_ma_user`
--
ALTER TABLE `ss_ma_user`
  ADD PRIMARY KEY (`USER_ID`), ADD UNIQUE KEY `USER_CODE` (`USER_CODE`), ADD KEY `FK_USER_TYPE` (`USER_TYPE`);

--
-- Indexes for table `ss_ma_user_type`
--
ALTER TABLE `ss_ma_user_type`
  ADD PRIMARY KEY (`USER_TYPE_ID`), ADD UNIQUE KEY `USER_TYPE_CODE` (`USER_TYPE_CODE`);

--
-- Indexes for table `ss_tr_user_action`
--
ALTER TABLE `ss_tr_user_action`
  ADD PRIMARY KEY (`TR_ID`), ADD KEY `GOAL_CODE` (`GOAL_CODE`), ADD KEY `USER_CODE` (`USER_CODE`), ADD KEY `ACTION_CODE` (`ACTION_CODE`);

--
-- Indexes for table `ss_tr_user_badge`
--
ALTER TABLE `ss_tr_user_badge`
  ADD PRIMARY KEY (`TR_ID`), ADD KEY `BADGE_CODE` (`BADGE_CODE`), ADD KEY `GOAL_CODE` (`GOAL_CODE`), ADD KEY `USER_CODE` (`USER_CODE`);

--
-- Indexes for table `ss_tr_user_goal_points`
--
ALTER TABLE `ss_tr_user_goal_points`
  ADD PRIMARY KEY (`TR_ID`), ADD KEY `USER_CODE` (`USER_CODE`), ADD KEY `GOAL_CODE` (`GOAL_CODE`), ADD KEY `GLOBAL_BADGE_CODE` (`GLOBAL_BADGE_CODE`);

--
-- Indexes for table `ss_tr_user_level`
--
ALTER TABLE `ss_tr_user_level`
  ADD PRIMARY KEY (`TR_ID`), ADD KEY `LEVEL_CODE` (`LEVEL_CODE`), ADD KEY `USER_CODE` (`USER_CODE`), ADD KEY `GOAL_CODE` (`GOAL_CODE`), ADD KEY `BADGE_CODE` (`BADGE_CODE`);

--
-- Indexes for table `ss_tr_user_reward`
--
ALTER TABLE `ss_tr_user_reward`
  ADD PRIMARY KEY (`TR_ID`), ADD KEY `GOAL_CODE` (`GOAL_CODE`), ADD KEY `USER_CODE` (`USER_CODE`), ADD KEY `REWARD_CODE` (`REWARD_CODE`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ss_ma_badge`
--
ALTER TABLE `ss_ma_badge`
  MODIFY `BADGE_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `ss_ma_challenge`
--
ALTER TABLE `ss_ma_challenge`
  MODIFY `CHALLENGE_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `ss_ma_goal`
--
ALTER TABLE `ss_ma_goal`
  MODIFY `GOAL_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `ss_ma_level`
--
ALTER TABLE `ss_ma_level`
  MODIFY `LEVEL_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `ss_ma_reward`
--
ALTER TABLE `ss_ma_reward`
  MODIFY `REWARD_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `ss_ma_user`
--
ALTER TABLE `ss_ma_user`
  MODIFY `USER_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `ss_ma_user_type`
--
ALTER TABLE `ss_ma_user_type`
  MODIFY `USER_TYPE_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `ss_tr_user_action`
--
ALTER TABLE `ss_tr_user_action`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `ss_tr_user_badge`
--
ALTER TABLE `ss_tr_user_badge`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `ss_tr_user_goal_points`
--
ALTER TABLE `ss_tr_user_goal_points`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `ss_tr_user_level`
--
ALTER TABLE `ss_tr_user_level`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `ss_tr_user_reward`
--
ALTER TABLE `ss_tr_user_reward`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `ss_ma_badge`
--
ALTER TABLE `ss_ma_badge`
ADD CONSTRAINT `FK_BADGE_GOAL_CODE` FOREIGN KEY (`GOAL_CODE`) REFERENCES `ss_ma_goal` (`GOAL_CODE`);

--
-- Constraints for table `ss_ma_challenge`
--
ALTER TABLE `ss_ma_challenge`
ADD CONSTRAINT `FK_CHALLENGE_GOAL_CODE` FOREIGN KEY (`GOAL_CODE`) REFERENCES `ss_ma_goal` (`GOAL_CODE`);

--
-- Constraints for table `ss_ma_goal`
--
ALTER TABLE `ss_ma_goal`
ADD CONSTRAINT `FK_GOAL_USER_TYPE` FOREIGN KEY (`USER_TYPE`) REFERENCES `ss_ma_user_type` (`USER_TYPE_CODE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ss_ma_level`
--
ALTER TABLE `ss_ma_level`
ADD CONSTRAINT `FK_LEVEL_GOAL_CODE` FOREIGN KEY (`GOAL_CODE`) REFERENCES `ss_ma_goal` (`GOAL_CODE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ss_ma_reward`
--
ALTER TABLE `ss_ma_reward`
ADD CONSTRAINT `FK_REWARD_GOAL_CODE` FOREIGN KEY (`GOAL_CODE`) REFERENCES `ss_ma_goal` (`GOAL_CODE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ss_ma_user`
--
ALTER TABLE `ss_ma_user`
ADD CONSTRAINT `FK_USER_TYPE` FOREIGN KEY (`USER_TYPE`) REFERENCES `ss_ma_user_type` (`USER_TYPE_CODE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ss_tr_user_action`
--
ALTER TABLE `ss_tr_user_action`
ADD CONSTRAINT `FK_USER_ACTION_ACTION_CODE` FOREIGN KEY (`ACTION_CODE`) REFERENCES `ss_ma_challenge` (`ACTION_CODE`),
ADD CONSTRAINT `FK_USER_ACTION_GOAL_CODE` FOREIGN KEY (`GOAL_CODE`) REFERENCES `ss_ma_goal` (`GOAL_CODE`),
ADD CONSTRAINT `FK_USER_ACTION_USER_CODE` FOREIGN KEY (`USER_CODE`) REFERENCES `ss_ma_user` (`USER_CODE`);

--
-- Constraints for table `ss_tr_user_badge`
--
ALTER TABLE `ss_tr_user_badge`
ADD CONSTRAINT `FK_USER_BADGE_BADGE_CODE` FOREIGN KEY (`BADGE_CODE`) REFERENCES `ss_ma_badge` (`BADGE_CODE`),
ADD CONSTRAINT `FK_USER_BADGE_GOAL_CODE` FOREIGN KEY (`GOAL_CODE`) REFERENCES `ss_ma_goal` (`GOAL_CODE`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `FK_USER_BADGE_USER_CODE` FOREIGN KEY (`USER_CODE`) REFERENCES `ss_ma_user` (`USER_CODE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ss_tr_user_goal_points`
--
ALTER TABLE `ss_tr_user_goal_points`
ADD CONSTRAINT `FK_USER_GP_BADGE_CODE` FOREIGN KEY (`GLOBAL_BADGE_CODE`) REFERENCES `ss_ma_badge` (`BADGE_CODE`),
ADD CONSTRAINT `FK_USER_GP_GOAL_CODE` FOREIGN KEY (`GOAL_CODE`) REFERENCES `ss_ma_goal` (`GOAL_CODE`),
ADD CONSTRAINT `FK_USER_GP_USER_CODE` FOREIGN KEY (`USER_CODE`) REFERENCES `ss_ma_user` (`USER_CODE`);

--
-- Constraints for table `ss_tr_user_level`
--
ALTER TABLE `ss_tr_user_level`
ADD CONSTRAINT `FK_USER_LEVEL_BADGE_CODE` FOREIGN KEY (`BADGE_CODE`) REFERENCES `ss_ma_badge` (`BADGE_CODE`),
ADD CONSTRAINT `FK_USER_LEVEL_GOAL_CODE` FOREIGN KEY (`GOAL_CODE`) REFERENCES `ss_ma_goal` (`GOAL_CODE`),
ADD CONSTRAINT `FK_USER_LEVEL_LEVEL_CODE` FOREIGN KEY (`LEVEL_CODE`) REFERENCES `ss_ma_level` (`LEVEL_CODE`),
ADD CONSTRAINT `FK_USER_LEVEL_USER_CODE` FOREIGN KEY (`USER_CODE`) REFERENCES `ss_ma_user` (`USER_CODE`);

--
-- Constraints for table `ss_tr_user_reward`
--
ALTER TABLE `ss_tr_user_reward`
ADD CONSTRAINT `FK_USER_REWARD_GOAL_CODE` FOREIGN KEY (`GOAL_CODE`) REFERENCES `ss_ma_goal` (`GOAL_CODE`),
ADD CONSTRAINT `FK_USER_REWARD_RWD_CODE` FOREIGN KEY (`REWARD_CODE`) REFERENCES `ss_ma_reward` (`REWARD_CODE`),
ADD CONSTRAINT `FK_USER_REWARD_USER_CODE` FOREIGN KEY (`USER_CODE`) REFERENCES `ss_ma_user` (`USER_CODE`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
