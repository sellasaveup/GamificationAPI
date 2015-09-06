-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 06, 2015 at 05:40 PM
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
-- Dumping data for table `ss_ma_badge`
--

INSERT INTO `ss_ma_badge` (`BADGE_ID`, `BADGE_CODE`, `GOAL_CODE`, `NAME`, `IMAGE`, `STORY`, `EXPIRY_DATE`, `DATE`) VALUES
(1, 'HYPE_NEW_BIE', 'HYPE_GOAL', 'Newbie ', 'newbie.jpg', 'Welcome! You have entered Hype Community, Experiencing money as a tool', '2015-09-03', '2015-08-16 13:12:33'),
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
  `STATUS` varchar(250) NOT NULL,
  `BADGE_CODE` varchar(250) DEFAULT NULL,
  `REWARD_CODE` varchar(250) DEFAULT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_ma_challenge`
--

INSERT INTO `ss_ma_challenge` (`CHALLENGE_ID`, `ACTION_CODE`, `GOAL_CODE`, `STORY`, `IMAGE`, `POINTS`, `OCCURRENCE`, `EXPIRY_DATE`, `STATUS`, `BADGE_CODE`, `REWARD_CODE`, `DATE`) VALUES
(1, 'HYPE_APP_DOWLD', 'HYPE_GOAL', 'Download Hype App', 'hype_icon.png', 10, 1, '2015-12-31', 'ACTIVE', 'HYPE_NEW_BIE', NULL, '2015-08-20 10:53:00'),
(2, 'HYPE_CREATE_GOAL', 'HYPE_GOAL', 'You have created a Goal in Hype app', 'challenge.jpg', 10, 0, '2015-12-31', 'ACTIVE', 'HYPE_NEW_BIE', NULL, '2015-08-20 11:35:11'),
(3, 'HYPE_CREATE_GOAL_MILESTONE', 'HYPE_GOAL', 'You have created Milestone for a Goal', 'challenge.jpg', 5, 4, '2015-12-31', 'ACTIVE', 'HYPE_CREATE_GOAL_MILESTONE', NULL, '2015-08-20 11:36:45'),
(4, 'HYPE_GOAL_SAVE_MONEY_25', 'HYPE_GOAL', 'You have saved 25% money for your Hype Goal', 'challenge.jpg', 10, NULL, '2015-12-31', 'ACTIVE', 'HYPE_SAVER', NULL, '2015-08-20 11:43:00'),
(5, 'HYPE_GOAL_SAVE_MONEY_50', 'HYPE_GOAL', 'you have saved 50% money towards your Hype Goal', 'challenge', 10, NULL, '2015-12-31', 'ACTIVE', 'HYPE_SUPER_SAVER', NULL, '2015-08-20 11:45:32'),
(6, 'HYPE_GOAL_SAVE_MONEY_75', 'HYPE_GOAL', 'You have saved 75% money for your Hype Goal', 'challenge.jpg', 10, NULL, '2015-12-31', 'ACTIVE', 'HYPE_SUPER_SMART_SAVER', NULL, '2015-08-20 11:48:21'),
(7, 'HYPE_GOAL_SHARE_BUDDY', 'HYPE_GOAL', 'You have Shared you Goal with your buddy', 'challenge.jpg', 10, 1, '2015-12-31', 'ACTIVE', 'HYPE_GOAL_SHARE_BUDDY', NULL, '2015-08-20 11:50:24'),
(8, 'HYPE_GOAL_LOCK', 'HYPE_GOAL', 'You have locked your Hype Goal', 'challenge.jpg', -30, NULL, '2015-12-31', 'ACTIVE', NULL, NULL, '2015-08-20 11:54:01'),
(9, 'HYPE_GOAL_UNLOCK', 'HYPE_GOAL', 'You have unlocked your Hype Goal', 'challenge.jpg', 30, NULL, '2015-12-31', 'ACTIVE', NULL, NULL, '2015-08-20 11:54:42'),
(10, 'HYPE_RECEIVE_COMMENTS', 'HYPE_GOAL', 'You have received Comments on your Hype goal', NULL, 3, NULL, '2015-12-31', 'ACTIVE', 'HYPE_FELLOW_INFLUENCER', NULL, '2015-08-20 11:55:48'),
(11, 'HYPE_RECEIVE_LIKE', 'HYPE_GOAL', 'You have received like for your Hype Goal ', 'challenge.jpg', 1, NULL, '2015-12-31', 'ACTIVE', 'HYPE_FELLOW_INFLUENCER', NULL, '2015-08-20 11:56:59'),
(12, 'HYPE_CONTRIBUTE_BUDDY', 'HYPE_GOAL', 'You have contributed for your friends Hype Goal', 'challenge.jpg', 10, NULL, '2015-12-31', 'ACTIVE', 'HYPE_STAR_CONTRIBUTOR', NULL, '2015-08-20 11:58:09'),
(13, 'HYPE_COMPLETE_GOAL', 'HYPE_GOAL', 'You have completed your Hype Goal', 'challenge.jpg', 10, NULL, '2016-01-31', 'ACTIVE', 'HYPE_GURU', NULL, '2015-08-20 12:00:08'),
(14, 'HYPE_CANCEL_GOAL', 'HYPE_GOAL', 'You have cancelled your Hype Goal ', 'Challenge.jpg', -20, NULL, '2015-12-31', 'ACTIVE', NULL, NULL, '2015-08-20 12:01:37');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_ma_goal`
--

INSERT INTO `ss_ma_goal` (`GOAL_ID`, `GOAL_CODE`, `NAME`, `STORY`, `EXPIRY_DATE`, `IMAGE`, `USER_TYPE`, `STATUS`, `DATE`) VALUES
(1, 'HYPE_GOAL', 'Hype Goal', 'Create Hype Goals, Share Goal with your Buddy, accomplish your Goal', '2016-01-01', 'hype.jpg', 'CUSTOMER', 'ACTIVE', '2015-08-16 13:05:41'),
(3, 'IB_GOAL', 'Internet Banking Goal', 'Internet Banking Goal', '2015-12-31', NULL, 'CUSTOMER', 'ACTIVE', '2015-09-06 15:04:31');

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
  `START_POINT` int(250) NOT NULL,
  `END_POINT` int(250) NOT NULL,
  `PRIORITY` int(250) NOT NULL,
  `EXPIRY_DATE` date NOT NULL,
  `DATE` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_ma_level`
--

INSERT INTO `ss_ma_level` (`LEVEL_ID`, `LEVEL_CODE`, `GOAL_CODE`, `REWARD_CODE`, `BADGE_CODE`, `NAME`, `IMAGE`, `STORY`, `START_POINT`, `END_POINT`, `PRIORITY`, `EXPIRY_DATE`, `DATE`) VALUES
(1, 'LEVEL1', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'HYPE_BRONZE', 'reached 250 points', 'level.jpg', 'Congrats, you have reached 250 Points in achieving your financial goal using Hype Goal Program', 0, 100, 1, '2015-12-31', '2015-12-20 00:00:00'),
(2, 'LEVEL2', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'HYPE_SILVER', 'reached 500 points ', 'level.jpg', 'Congrats, you have reached 500 points in achieving your financial goal using Hype Goal Program', 101, 500, 2, '2015-12-31', '2015-12-20 00:00:00'),
(3, 'LEVEL3', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'HYPE_GOLD', 'reached 1000 points ', 'level.jpg', 'Congrats, you have reached 1000 points in achieving your financial goal using Hype Goal Program', 501, 1000, 3, '2015-12-31', '2015-12-20 00:00:00'),
(4, 'LEVEL4', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'HYPE_PLATINUM', 'reached 2500 points ', 'level.jpg', 'Congrats, you have reached 2500 points in achieving your financial goal using Hype Goal Program', 1001, 2500, 4, '2015-12-31', '2015-12-20 00:00:00'),
(5, 'LEVEL5', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'HYPE_DIAMOND', 'reached >greater than 5000 points', 'level.jpg', 'Congrats, for reaching more than 5000 points in achieving your financial goals using Hype Goal Program', 2501, 5000, 5, '2015-12-31', '2015-12-20 00:00:00');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_ma_reward`
--

INSERT INTO `ss_ma_reward` (`REWARD_ID`, `REWARD_CODE`, `GOAL_CODE`, `NAME`, `STORY`, `IMAGE`, `EXPIRY_DATE`, `DATE`) VALUES
(1, 'AMAZON_GIFT_VOUCHER', 'HYPE_GOAL', 'Amazon gift voucher', 'Amazon gift voucher worth 10Euro', 'AMAZON_GIFT_VOUCHER.jpg', '2015-12-31', '2015-08-16 14:15:45'),
(4, 'FILPKART_VOUCHER', 'HYPE_GOAL', 'Flipkart Gift Voucher', 'Flipkart Gift Voucher', 'FlipkartReward.jpg', '2015-12-31', '2015-09-06 12:14:58');

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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_ma_user`
--

INSERT INTO `ss_ma_user` (`USER_ID`, `USER_CODE`, `NAME`, `NICK_NAME`, `IMAGE`, `USER_TYPE`, `STATUS`, `DATE`) VALUES
(9, 'GBS03630', 'Ayyasamy B A', 'Bathi', 'Boobathi.jpg', 'CUSTOMER', 'ACTIVE', '2015-09-04 15:52:21'),
(10, 'GBS02663', 'Sujatha Balaji', 'Sujatha', 'sujatha.png', 'CUSTOMER', 'ACTIVE', '2015-09-04 16:06:27'),
(11, 'GBS00123', 'Vishnu  Priya B', 'Vishnu', 'Vishnu.jpg', 'CUSTOMER', 'ACTIVE', '2015-09-04 16:16:47'),
(12, 'GBS00010', 'Vinay Kumar S', 'Vinay', 'Vinay.jpg', 'CUSTOMER', 'ACTIVE', '2015-09-06 11:19:11'),
(16, 'GBS02345', 'Meghala Venu', 'Meghala', 'Meghala.jpg', 'CUSTOMER', 'ACTIVE', '2015-09-06 11:27:31'),
(17, 'GBS03546', 'Ranjith Kumar', 'Ranjith', 'Ranjith.jpg', 'CUSTOMER', 'ACTIVE', '2015-09-06 11:21:39'),
(18, 'GBS06543', 'Gayathri Vasu', 'Gayathri', 'Gayathri.jpg', 'CUSTOMER', 'ACTIVE', '2015-09-06 11:22:02'),
(19, 'GBS00011', 'Raj Kumar SR', '', 'Raj.jpg', 'CUSTOMER', 'ACTIVE', '2015-09-06 18:41:57'),
(20, 'GBS00012', 'Kumar Vishvas', '', 'Kumar.jpg', 'CUSTOMER', 'ACTIVE', '2015-09-06 18:42:21'),
(21, 'GBS00013', 'Arun Vijayan S', '', 'Arun.jpg', 'CUSTOMER', 'ACTIVE', '2015-09-06 18:42:32');

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
-- Dumping data for table `ss_ma_user_type`
--

INSERT INTO `ss_ma_user_type` (`USER_TYPE_ID`, `USER_TYPE_CODE`, `STORY`, `IMAGE`, `STATUS`, `DATE`) VALUES
(1, 'CUSTOMER', 'CUSTOMER OF GBS', 'CUSTOMER.JPG', 'ACTIVE', '2015-08-16 13:02:56'),
(2, 'EMPLOYEE', 'EMPLOYEE OF GBS', 'EMPLOYEE.JPG', 'ACTIVE', '2015-08-16 13:02:56');

-- --------------------------------------------------------

--
-- Table structure for table `ss_tr_notification`
--

CREATE TABLE IF NOT EXISTS `ss_tr_notification` (
  `notify_tr_id` int(255) NOT NULL,
  `notify_header_id` int(249) NOT NULL,
  `USER_CODE` varchar(250) NOT NULL,
  `status` varchar(1000) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_tr_notification`
--

INSERT INTO `ss_tr_notification` (`notify_tr_id`, `notify_header_id`, `USER_CODE`, `status`) VALUES
(14, 13, 'GBS03630', 'INACTIVE'),
(15, 13, 'GBS02663', 'ACTIVE'),
(16, 13, 'GBS00123', 'ACTIVE'),
(17, 14, 'GBS03630', 'INACTIVE'),
(18, 15, 'GBS03630', 'INACTIVE'),
(19, 16, 'GBS03630', 'INACTIVE');

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_tr_notification_header`
--

INSERT INTO `ss_tr_notification_header` (`notify_id`, `notify_date`, `notify_type`, `target`, `message`, `image`) VALUES
(13, '2015-09-04 17:31:26', 'Message', 'ALL', 'Today a new PSA ready', ''),
(14, '2015-09-06 14:36:15', 'Message', 'USER', 'Welcome to Hype Challenges', ''),
(15, '2015-09-06 14:37:39', 'Info', 'USER', 'You have been awarded Hype Guru Badge ', ''),
(16, '2015-09-06 14:38:21', 'Info', 'USER', 'New Challenges are added for Hype', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_tr_user_action`
--

INSERT INTO `ss_tr_user_action` (`TR_ID`, `GOAL_CODE`, `USER_CODE`, `ACTION_CODE`, `POINTS`, `STATUS`, `DATE`) VALUES
(28, 'HYPE_GOAL', 'GBS03630', 'HYPE_APP_DOWLD', 10, 'ACTIVE', '2015-08-26 11:34:31'),
(29, 'HYPE_GOAL', 'GBS02663', 'HYPE_APP_DOWLD', 10, 'ACTIVE', '2015-09-06 11:34:40'),
(30, 'HYPE_GOAL', 'GBS00123', 'HYPE_APP_DOWLD', 10, 'ACTIVE', '2015-09-06 11:34:54'),
(31, 'HYPE_GOAL', 'GBS00010', 'HYPE_APP_DOWLD', 10, 'ACTIVE', '2015-09-06 11:35:01'),
(35, 'HYPE_GOAL', 'GBS02345', 'HYPE_APP_DOWLD', 10, 'ACTIVE', '2015-09-06 11:35:30'),
(36, 'HYPE_GOAL', 'GBS03546', 'HYPE_APP_DOWLD', 10, 'ACTIVE', '2015-09-06 11:35:37'),
(37, 'HYPE_GOAL', 'GBS06543', 'HYPE_APP_DOWLD', 10, 'ACTIVE', '2015-09-06 11:35:44'),
(38, 'HYPE_GOAL', 'GBS03630', 'HYPE_CREATE_GOAL', 10, 'ACTIVE', '2015-09-06 11:35:56'),
(39, 'HYPE_GOAL', 'GBS03630', 'HYPE_CREATE_GOAL_MILESTONE', 0, 'ACTIVE', '2015-07-14 11:36:00'),
(40, 'HYPE_GOAL', 'GBS03630', 'HYPE_GOAL_SAVE_MONEY_25', 10, 'ACTIVE', '2015-09-06 11:36:05'),
(41, 'HYPE_GOAL', 'GBS03630', 'HYPE_GOAL_SAVE_MONEY_50', 10, 'ACTIVE', '2015-09-06 11:36:09'),
(42, 'HYPE_GOAL', 'GBS03630', 'HYPE_GOAL_SAVE_MONEY_75', 10, 'ACTIVE', '2015-06-15 11:36:14'),
(43, 'HYPE_GOAL', 'GBS03630', 'HYPE_GOAL_SHARE_BUDDY', 10, 'ACTIVE', '2015-09-06 11:36:27'),
(44, 'HYPE_GOAL', 'GBS03630', 'HYPE_GOAL_LOCK', -30, 'ACTIVE', '2015-08-10 11:36:32'),
(45, 'HYPE_GOAL', 'GBS03630', 'HYPE_GOAL_UNLOCK', 30, 'ACTIVE', '2015-09-06 11:36:36'),
(46, 'HYPE_GOAL', 'GBS03630', 'HYPE_RECEIVE_COMMENTS', 3, 'ACTIVE', '2015-08-18 11:36:41'),
(47, 'HYPE_GOAL', 'GBS03630', 'HYPE_CONTRIBUTE_BUDDY', 10, 'ACTIVE', '2015-09-06 11:36:46'),
(48, 'HYPE_GOAL', 'GBS03630', 'HYPE_COMPLETE_GOAL', 10, 'ACTIVE', '2015-09-06 11:47:16'),
(49, 'HYPE_GOAL', 'GBS02663', 'HYPE_CREATE_GOAL', 10, 'ACTIVE', '2015-09-06 11:47:45'),
(50, 'HYPE_GOAL', 'GBS02663', 'HYPE_CREATE_GOAL_MILESTONE', 0, 'ACTIVE', '2015-09-06 11:47:52'),
(51, 'HYPE_GOAL', 'GBS02663', 'HYPE_GOAL_SAVE_MONEY_25', 10, 'ACTIVE', '2015-09-06 11:48:00'),
(52, 'HYPE_GOAL', 'GBS02663', 'HYPE_GOAL_SAVE_MONEY_50', 10, 'ACTIVE', '2015-09-06 11:48:04'),
(53, 'HYPE_GOAL', 'GBS02663', 'HYPE_GOAL_SAVE_MONEY_75', 10, 'ACTIVE', '2015-09-06 11:48:09'),
(54, 'HYPE_GOAL', 'GBS02663', 'HYPE_GOAL_SHARE_BUDDY', 10, 'ACTIVE', '2015-09-06 11:48:15'),
(55, 'HYPE_GOAL', 'GBS02663', 'HYPE_GOAL_LOCK', -30, 'ACTIVE', '2015-09-06 11:48:20'),
(56, 'HYPE_GOAL', 'GBS02663', 'HYPE_GOAL_UNLOCK', 30, 'ACTIVE', '2015-09-06 11:48:25'),
(57, 'HYPE_GOAL', 'GBS00123', 'HYPE_CREATE_GOAL', 10, 'ACTIVE', '2015-09-06 11:48:32'),
(58, 'HYPE_GOAL', 'GBS00123', 'HYPE_GOAL_SAVE_MONEY_25', 10, 'ACTIVE', '2015-09-06 11:48:38'),
(59, 'HYPE_GOAL', 'GBS00123', 'HYPE_GOAL_SAVE_MONEY_75', 10, 'ACTIVE', '2015-09-06 11:48:42'),
(60, 'HYPE_GOAL', 'GBS00123', 'HYPE_GOAL_UNLOCK', 30, 'ACTIVE', '2015-09-06 11:48:47'),
(61, 'HYPE_GOAL', 'GBS00010', 'HYPE_CREATE_GOAL', 10, 'ACTIVE', '2015-09-06 11:48:53'),
(65, 'HYPE_GOAL', 'GBS03546', 'HYPE_RECEIVE_LIKE', 1, 'ACTIVE', '2015-09-06 11:49:23'),
(66, 'HYPE_GOAL', 'GBS00011', 'HYPE_APP_DOWLD', 10, 'ACTIVE', '2015-09-06 18:43:36'),
(67, 'HYPE_GOAL', 'GBS00012', 'HYPE_CREATE_GOAL_MILESTONE', 0, 'ACTIVE', '2015-09-06 18:43:43'),
(68, 'HYPE_GOAL', 'GBS00013', 'HYPE_GOAL_UNLOCK', 30, 'ACTIVE', '2015-09-06 18:43:50'),
(69, 'HYPE_GOAL', 'GBS00012', 'HYPE_CREATE_GOAL_MILESTONE', 0, 'ACTIVE', '2015-09-06 18:53:43'),
(70, 'HYPE_GOAL', 'GBS00012', 'HYPE_GOAL_SAVE_MONEY_75', 10, 'ACTIVE', '2015-09-06 18:53:48'),
(71, 'HYPE_GOAL', 'GBS02663', 'HYPE_GOAL_UNLOCK', 30, 'ACTIVE', '2015-09-06 21:08:28');

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
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_tr_user_badge`
--

INSERT INTO `ss_tr_user_badge` (`TR_ID`, `BADGE_CODE`, `GOAL_CODE`, `USER_CODE`, `STATUS`, `DATE`) VALUES
(48, 'HYPE_NEW_BIE', 'HYPE_GOAL', 'GBS03630', 'ACTIVE', '2015-08-19 11:34:31'),
(49, 'HYPE_NEW_BIE', 'HYPE_GOAL', 'GBS02663', 'ACTIVE', '2015-09-06 11:34:40'),
(50, 'HYPE_NEW_BIE', 'HYPE_GOAL', 'GBS00123', 'ACTIVE', '2015-09-06 11:34:54'),
(51, 'HYPE_NEW_BIE', 'HYPE_GOAL', 'GBS00010', 'ACTIVE', '2015-09-06 11:35:01'),
(55, 'HYPE_NEW_BIE', 'HYPE_GOAL', 'GBS02345', 'ACTIVE', '2015-09-06 11:35:30'),
(56, 'HYPE_NEW_BIE', 'HYPE_GOAL', 'GBS03546', 'ACTIVE', '2015-09-06 11:35:37'),
(57, 'HYPE_NEW_BIE', 'HYPE_GOAL', 'GBS06543', 'ACTIVE', '2015-09-06 11:35:44'),
(59, 'HYPE_SAVER', 'HYPE_GOAL', 'GBS03630', 'ACTIVE', '2015-08-18 11:36:05'),
(60, 'HYPE_SUPER_SAVER', 'HYPE_GOAL', 'GBS03630', 'ACTIVE', '2015-09-06 11:36:09'),
(61, 'HYPE_SUPER_SMART_SAVER', 'HYPE_GOAL', 'GBS03630', 'ACTIVE', '2015-07-13 11:36:14'),
(62, 'HYPE_GOAL_SHARE_BUDDY', 'HYPE_GOAL', 'GBS03630', 'ACTIVE', '2015-09-06 11:36:27'),
(63, 'HYPE_FELLOW_INFLUENCER', 'HYPE_GOAL', 'GBS03630', 'ACTIVE', '2015-06-09 11:36:41'),
(64, 'HYPE_STAR_CONTRIBUTOR', 'HYPE_GOAL', 'GBS03630', 'ACTIVE', '2015-05-12 11:36:46'),
(65, 'HYPE_SILVER', 'HYPE_GOAL', 'GBS03630', 'ACTIVE', '2015-07-21 11:47:16'),
(66, 'HYPE_GURU', 'HYPE_GOAL', 'GBS03630', 'ACTIVE', '2015-09-06 11:47:16'),
(67, 'HYPE_BRONZE', 'HYPE_GOAL', 'GBS02663', 'ACTIVE', '2015-09-06 11:47:45'),
(68, 'HYPE_NEW_BIE', 'HYPE_GOAL', 'GBS02663', 'ACTIVE', '2015-09-06 11:47:45'),
(69, 'HYPE_SAVER', 'HYPE_GOAL', 'GBS02663', 'ACTIVE', '2015-09-06 11:48:00'),
(70, 'HYPE_SUPER_SAVER', 'HYPE_GOAL', 'GBS02663', 'ACTIVE', '2015-09-06 11:48:04'),
(71, 'HYPE_SUPER_SMART_SAVER', 'HYPE_GOAL', 'GBS02663', 'ACTIVE', '2015-09-06 11:48:09'),
(72, 'HYPE_GOAL_SHARE_BUDDY', 'HYPE_GOAL', 'GBS02663', 'ACTIVE', '2015-09-06 11:48:15'),
(73, 'HYPE_NEW_BIE', 'HYPE_GOAL', 'GBS00123', 'ACTIVE', '2015-09-06 11:48:32'),
(74, 'HYPE_SAVER', 'HYPE_GOAL', 'GBS00123', 'ACTIVE', '2015-09-06 11:48:38'),
(75, 'HYPE_SUPER_SMART_SAVER', 'HYPE_GOAL', 'GBS00123', 'ACTIVE', '2015-09-06 11:48:42'),
(76, 'HYPE_NEW_BIE', 'HYPE_GOAL', 'GBS00010', 'ACTIVE', '2015-09-06 11:48:53'),
(80, 'HYPE_FELLOW_INFLUENCER', 'HYPE_GOAL', 'GBS03546', 'ACTIVE', '2015-09-06 11:49:24'),
(81, 'HYPE_NEW_BIE', 'HYPE_GOAL', 'GBS00011', 'ACTIVE', '2015-09-06 18:43:36'),
(82, 'HYPE_SUPER_SMART_SAVER', 'HYPE_GOAL', 'GBS00012', 'ACTIVE', '2015-09-06 18:53:48'),
(83, 'HYPE_SILVER', 'HYPE_GOAL', 'GBS02663', 'ACTIVE', '2015-09-06 21:08:28');

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
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_tr_user_goal_points`
--

INSERT INTO `ss_tr_user_goal_points` (`TR_ID`, `USER_CODE`, `GOAL_CODE`, `TOTAL_POINTS`, `REEDEMED_POINTS`, `GLOBAL_BADGE_CODE`, `DATE`) VALUES
(33, 'GBS03630', 'HYPE_GOAL', '113', '0', 'HYPE_BRONZE', '2015-09-06 11:34:31'),
(34, 'GBS02663', 'HYPE_GOAL', '120', '0', 'HYPE_BRONZE', '2015-09-06 11:34:40'),
(35, 'GBS00123', 'HYPE_GOAL', '70', '0', 'HYPE_BRONZE', '2015-09-06 11:34:54'),
(36, 'GBS00010', 'HYPE_GOAL', '20', '0', 'HYPE_BRONZE', '2015-09-06 11:35:01'),
(40, 'GBS02345', 'HYPE_GOAL', '10', '0', 'HYPE_BRONZE', '2015-09-06 11:35:30'),
(41, 'GBS03546', 'HYPE_GOAL', '11', '0', 'HYPE_BRONZE', '2015-09-06 11:35:37'),
(42, 'GBS06543', 'HYPE_GOAL', '10', '0', 'HYPE_BRONZE', '2015-09-06 11:35:44'),
(43, 'GBS00011', 'HYPE_GOAL', '10', '0', 'HYPE_BRONZE', '2015-09-06 18:43:36'),
(45, 'GBS00012', 'HYPE_GOAL', '10', '0', 'HYPE_BRONZE', '2015-09-06 18:43:43'),
(47, 'GBS00013', 'HYPE_GOAL', '30', '0', 'HYPE_BRONZE', '2015-09-06 18:43:50');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_tr_user_level`
--

INSERT INTO `ss_tr_user_level` (`TR_ID`, `LEVEL_CODE`, `USER_CODE`, `GOAL_CODE`, `BADGE_CODE`, `PRIORITY`, `DATE`) VALUES
(2, 'LEVEL2', 'GBS03630', 'HYPE_GOAL', 'HYPE_SILVER', 2, '2015-09-06 11:47:16'),
(4, 'LEVEL1', 'GBS00010', 'HYPE_GOAL', 'HYPE_BRONZE', 1, '2015-09-06 11:58:53'),
(6, 'LEVEL1', 'GBS00123', 'HYPE_GOAL', 'HYPE_BRONZE', 1, '2015-09-06 11:59:25'),
(8, 'LEVEL1', 'GBS02663', 'HYPE_GOAL', 'HYPE_BRONZE', 1, '2015-09-06 11:59:58'),
(9, 'LEVEL2', 'GBS02663', 'HYPE_GOAL', 'HYPE_SILVER', 2, '2015-09-06 21:08:28');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ss_tr_user_reward`
--

INSERT INTO `ss_tr_user_reward` (`TR_ID`, `REWARD_CODE`, `GOAL_CODE`, `USER_CODE`, `REDEEM_STATUS`, `REDEEM_POINTS`, `DATE`) VALUES
(2, 'AMAZON_GIFT_VOUCHER', 'HYPE_GOAL', 'GBS03630', 'NO', 50, '2015-09-06 11:47:16'),
(3, 'FILPKART_VOUCHER', 'HYPE_GOAL', 'GBS03630', 'NO', 100, '2015-09-06 11:47:45'),
(4, 'AMAZON_GIFT_VOUCHER', 'HYPE_GOAL', 'GBS02663', 'NO', 0, '2015-09-06 21:08:28');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ss_ma_badge`
--
ALTER TABLE `ss_ma_badge`
  ADD PRIMARY KEY (`BADGE_ID`),
  ADD UNIQUE KEY `BADGE_CODE` (`BADGE_CODE`),
  ADD KEY `GOAL_CODE` (`GOAL_CODE`);

--
-- Indexes for table `ss_ma_challenge`
--
ALTER TABLE `ss_ma_challenge`
  ADD PRIMARY KEY (`CHALLENGE_ID`),
  ADD UNIQUE KEY `ACTION_CODE` (`ACTION_CODE`),
  ADD KEY `GOAL_CODE` (`GOAL_CODE`),
  ADD KEY `BADGE_CODE` (`BADGE_CODE`),
  ADD KEY `ACTION_CODE_2` (`ACTION_CODE`);

--
-- Indexes for table `ss_ma_goal`
--
ALTER TABLE `ss_ma_goal`
  ADD PRIMARY KEY (`GOAL_ID`),
  ADD UNIQUE KEY `GOAL_CODE` (`GOAL_CODE`),
  ADD KEY `FK_GOAL_USER_TYPE` (`USER_TYPE`);

--
-- Indexes for table `ss_ma_level`
--
ALTER TABLE `ss_ma_level`
  ADD PRIMARY KEY (`LEVEL_ID`),
  ADD UNIQUE KEY `LEVEL_CODE` (`LEVEL_CODE`),
  ADD KEY `GOAL_CODE` (`GOAL_CODE`),
  ADD KEY `REWARD_CODE` (`REWARD_CODE`),
  ADD KEY `BADGE_CODE` (`BADGE_CODE`),
  ADD KEY `PRIORITY` (`PRIORITY`);

--
-- Indexes for table `ss_ma_reward`
--
ALTER TABLE `ss_ma_reward`
  ADD PRIMARY KEY (`REWARD_ID`),
  ADD UNIQUE KEY `REWARD_CODE` (`REWARD_CODE`),
  ADD KEY `GOAL_CODE` (`GOAL_CODE`);

--
-- Indexes for table `ss_ma_user`
--
ALTER TABLE `ss_ma_user`
  ADD PRIMARY KEY (`USER_ID`),
  ADD UNIQUE KEY `USER_CODE` (`USER_CODE`),
  ADD KEY `FK_USER_TYPE` (`USER_TYPE`);

--
-- Indexes for table `ss_ma_user_type`
--
ALTER TABLE `ss_ma_user_type`
  ADD PRIMARY KEY (`USER_TYPE_ID`),
  ADD UNIQUE KEY `USER_TYPE_CODE` (`USER_TYPE_CODE`);

--
-- Indexes for table `ss_tr_notification`
--
ALTER TABLE `ss_tr_notification`
  ADD PRIMARY KEY (`notify_tr_id`),
  ADD KEY `USER_CODE` (`USER_CODE`);

--
-- Indexes for table `ss_tr_notification_header`
--
ALTER TABLE `ss_tr_notification_header`
  ADD PRIMARY KEY (`notify_id`);

--
-- Indexes for table `ss_tr_user_action`
--
ALTER TABLE `ss_tr_user_action`
  ADD PRIMARY KEY (`TR_ID`),
  ADD KEY `GOAL_CODE` (`GOAL_CODE`),
  ADD KEY `USER_CODE` (`USER_CODE`),
  ADD KEY `ACTION_CODE` (`ACTION_CODE`);

--
-- Indexes for table `ss_tr_user_badge`
--
ALTER TABLE `ss_tr_user_badge`
  ADD PRIMARY KEY (`TR_ID`),
  ADD KEY `BADGE_CODE` (`BADGE_CODE`),
  ADD KEY `GOAL_CODE` (`GOAL_CODE`),
  ADD KEY `USER_CODE` (`USER_CODE`);

--
-- Indexes for table `ss_tr_user_goal_points`
--
ALTER TABLE `ss_tr_user_goal_points`
  ADD PRIMARY KEY (`TR_ID`),
  ADD KEY `USER_CODE` (`USER_CODE`),
  ADD KEY `GOAL_CODE` (`GOAL_CODE`),
  ADD KEY `GLOBAL_BADGE_CODE` (`GLOBAL_BADGE_CODE`);

--
-- Indexes for table `ss_tr_user_level`
--
ALTER TABLE `ss_tr_user_level`
  ADD PRIMARY KEY (`TR_ID`),
  ADD KEY `LEVEL_CODE` (`LEVEL_CODE`),
  ADD KEY `USER_CODE` (`USER_CODE`),
  ADD KEY `GOAL_CODE` (`GOAL_CODE`),
  ADD KEY `BADGE_CODE` (`BADGE_CODE`);

--
-- Indexes for table `ss_tr_user_reward`
--
ALTER TABLE `ss_tr_user_reward`
  ADD PRIMARY KEY (`TR_ID`),
  ADD KEY `GOAL_CODE` (`GOAL_CODE`),
  ADD KEY `USER_CODE` (`USER_CODE`),
  ADD KEY `REWARD_CODE` (`REWARD_CODE`);

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
  MODIFY `GOAL_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `ss_ma_level`
--
ALTER TABLE `ss_ma_level`
  MODIFY `LEVEL_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `ss_ma_reward`
--
ALTER TABLE `ss_ma_reward`
  MODIFY `REWARD_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `ss_ma_user`
--
ALTER TABLE `ss_ma_user`
  MODIFY `USER_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `ss_ma_user_type`
--
ALTER TABLE `ss_ma_user_type`
  MODIFY `USER_TYPE_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `ss_tr_notification`
--
ALTER TABLE `ss_tr_notification`
  MODIFY `notify_tr_id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `ss_tr_notification_header`
--
ALTER TABLE `ss_tr_notification_header`
  MODIFY `notify_id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `ss_tr_user_action`
--
ALTER TABLE `ss_tr_user_action`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=72;
--
-- AUTO_INCREMENT for table `ss_tr_user_badge`
--
ALTER TABLE `ss_tr_user_badge`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=84;
--
-- AUTO_INCREMENT for table `ss_tr_user_goal_points`
--
ALTER TABLE `ss_tr_user_goal_points`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=49;
--
-- AUTO_INCREMENT for table `ss_tr_user_level`
--
ALTER TABLE `ss_tr_user_level`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `ss_tr_user_reward`
--
ALTER TABLE `ss_tr_user_reward`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
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
-- Constraints for table `ss_tr_notification`
--
ALTER TABLE `ss_tr_notification`
  ADD CONSTRAINT `FK_NOTIFY_USER_CODE` FOREIGN KEY (`USER_CODE`) REFERENCES `ss_ma_user` (`USER_CODE`);

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
