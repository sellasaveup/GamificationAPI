-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 16, 2015 at 09:14 AM
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `OCCURANCE` int(250) DEFAULT NULL,
  `EXPIRY_DATE` date NOT NULL,
  `BADGE_CODE` varchar(250) DEFAULT NULL,
  `REWARD_CODE` varchar(250) DEFAULT NULL,
  `DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `DATE` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `SS_MA_BADGE`
--
ALTER TABLE `SS_MA_BADGE`
  ADD PRIMARY KEY (`BADGE_ID`);

--
-- Indexes for table `SS_MA_CHALLENGE`
--
ALTER TABLE `SS_MA_CHALLENGE`
  ADD PRIMARY KEY (`CHALLENGE_ID`);

--
-- Indexes for table `SS_MA_GOAL`
--
ALTER TABLE `SS_MA_GOAL`
  ADD PRIMARY KEY (`GOAL_ID`);

--
-- Indexes for table `SS_MA_LEVEL`
--
ALTER TABLE `SS_MA_LEVEL`
  ADD PRIMARY KEY (`LEVEL_ID`);

--
-- Indexes for table `SS_MA_USER`
--
ALTER TABLE `SS_MA_USER`
  ADD PRIMARY KEY (`USER_ID`);

--
-- Indexes for table `SS_MA_USER_TYPE`
--
ALTER TABLE `SS_MA_USER_TYPE`
  ADD PRIMARY KEY (`USER_TYPE_ID`);

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
  MODIFY `BADGE_ID` int(250) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `SS_MA_CHALLENGE`
--
ALTER TABLE `SS_MA_CHALLENGE`
  MODIFY `CHALLENGE_ID` int(250) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `SS_MA_GOAL`
--
ALTER TABLE `SS_MA_GOAL`
  MODIFY `GOAL_ID` int(250) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `SS_MA_LEVEL`
--
ALTER TABLE `SS_MA_LEVEL`
  MODIFY `LEVEL_ID` int(250) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `SS_MA_USER`
--
ALTER TABLE `SS_MA_USER`
  MODIFY `USER_ID` int(250) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `SS_MA_USER_TYPE`
--
ALTER TABLE `SS_MA_USER_TYPE`
  MODIFY `USER_TYPE_ID` int(250) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `SS_TR_USER_ACTION`
--
ALTER TABLE `SS_TR_USER_ACTION`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `SS_TR_USER_BADGE`
--
ALTER TABLE `SS_TR_USER_BADGE`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `SS_TR_USER_GOAL_POINTS`
--
ALTER TABLE `SS_TR_USER_GOAL_POINTS`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `SS_TR_USER_LEVEL`
--
ALTER TABLE `SS_TR_USER_LEVEL`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `SS_TR_USER_REWARD`
--
ALTER TABLE `SS_TR_USER_REWARD`
  MODIFY `TR_ID` int(250) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
