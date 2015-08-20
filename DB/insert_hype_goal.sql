INSERT INTO `ss_ma_user` (`USER_ID`, `USER_CODE`, `NAME`, `NICK_NAME`, `IMAGE`, `USER_TYPE`, `STATUS`, `DATE`) VALUES
(1, 'GBS03146', 'Sujatha Balaji', 'Sujatha', 'sujatha.jpg', 'EMPLOYEE', 'ACTIVE', '2015-08-16 13:01:26');

INSERT INTO `ss_ma_user_type` (`USER_TYPE_ID`, `USER_TYPE_CODE`, `STORY`, `IMAGE`, `STATUS`, `DATE`) VALUES
(1, 'CUSTOMER', 'CUSTOMER OF GBS', 'CUSTOMER.JPG', 'ACTIVE', '2015-08-16 13:02:56'),
(2, 'EMPLOYEE', 'EMPLOYEE OF GBS', 'EMPLOYEE.JPG', 'ACTIVE', '2015-08-16 13:02:56');


INSERT INTO `ss_ma_goal` (`GOAL_ID`, `GOAL_CODE`, `NAME`, `STORY`, `EXPIRY_DATE`, `IMAGE`, `USER_TYPE`, `STATUS`, `DATE`) VALUES
(1, 'HYPE_GOAL', 'Hype Goal', 'Create Hype Goals, Share Goal with your Buddy, accomplish your Goal', '2016-01-01', 'hype.jpg', 'EMPLOYEE', 'ACTIVE', '2015-08-16 13:05:41');


INSERT INTO `ss_ma_badge` (`BADGE_ID`, `BADGE_CODE`, `GOAL_CODE`, `NAME`, `IMAGE`, `STORY`, `EXPIRY_DATE`, `DATE`) VALUES
(1, 'HYPE_NEW_BIE', 'HYPE_GOAL', 'Newbie ', 'newbie.jpg', 'Welcome! You have entered Hype Community, Experiencing money as a tool', '2015-12-31', '2015-08-16 13:12:33'),
(2, 'HYPE_SAVER', 'HYPE_GOAL', 'You have saved money for a goal by 25%', 'SAVER.JPG', 'You have saved 25% money for a goal ', '2015-12-31', '2015-08-16 13:17:30'),
(3, 'HYPE_SUPER_SAVER', 'HYPE_GOAL', 'Hype Super Saver', 'HYPE_SUPER_SAVER.JPG', 'You have saved 50% of Money for a goal', '2015-12-31', '2015-08-16 13:45:09'),
(4, 'HYPE_SUPER_SMART_SAVER', 'HYPE_GOAL', 'You are Super Smart Saver', 'HYPE_SUPER_SMART_SAVER.JPG', 'You have saved 75% for a goal', '2015-12-31', '2015-08-16 13:47:50'),
(5, 'HYPE_GOAL_SHARE_BUDDY', 'HYPE_GOAL', 'SOCIALIZER', 'SOCIALIZER.JPG', 'You have shared your Goal with a buddy\n', '2015-12-31', '2015-08-16 13:49:50'),
(6, 'HYPE_FELLOW_INFLUENCER', 'HYPE_GOAL', 'Received Comments and like', 'HYPE_FELLOW_INFLUENCER.JPG', 'You have received Comments and like from your buddy', '2015-12-31', '2015-08-16 13:55:41'),
(7, 'HYPE_GURU', 'HYPE GOAL', 'Complete a Goal', 'HYPE_GURU.jpg', 'You have completed a Goal', '2015-12-31', '2015-08-16 14:00:38'),
(8, 'HYPE_STAR_CONTRIBUTOR', 'HYPE_GOAL', 'Star Contributor', 'badge.jpg', 'Star Contributor', '2015-10-31', '2015-08-20 11:17:51');


INSERT INTO `ss_ma_reward` (`REWARD_ID`, `REWARD_CODE`, `GOAL_CODE`, `NAME`, `STORY`, `IMAGE`, `EXPIRY_DATE`, `DATE`) VALUES
(1, 'AMAZON_GIFT_VOUCHER', 'HYPE_GOAL', 'Amazon gift voucher', 'Amazon gift voucher worth 10Euro', 'AMAZON_GIFT_VOUCHER.jpg', '2015-12-31', '2015-08-16 14:15:45');

INSERT INTO `ss_ma_challenge` (`CHALLENGE_ID`, `ACTION_CODE`, `GOAL_CODE`, `STORY`, `IMAGE`, `POINTS`, `OCCURANCE`, `EXPIRY_DATE`, `BADGE_CODE`, `REWARD_CODE`, `DATE`) VALUES
(1, 'HYPE_APP_DOWLD', 'HYPE_GOAL', 'Download Hype App', 'hype_icon.png', 10, NULL, '2015-12-31', 'HYPE_NEW_BIE', NULL, '2015-08-20 10:53:00'),
(2, 'HYPE_CREATE_GOAL', 'HYPE_GOAL', 'You have created a Goal in Hype app', 'challenge.jpg', 10, NULL, '2015-12-31', 'HYPE_NEW_BIE', NULL, '2015-08-20 11:35:11'),
(3, 'HYPE_CREATE_GOAL_MILESTONE', 'HYPE_GOAL', 'You have created Milestone for a Goal', 'challenge.jpg', 5, NULL, '2015-12-31', 'HYPE_CREATE_GOAL_MILESTONE', NULL, '2015-08-20 11:36:45'),
(4, 'HYPE_GOAL_SAVE_MONEY_25', 'HYPE_GOAL', 'You have saved 25% money for your Hype Goal', 'challenge.jpg', 10, NULL, '2015-12-31', 'HYPE_SAVER', NULL, '2015-08-20 11:43:00'),
(5, 'HYPE_GOAL_SAVE_MONEY_50', 'HYPE_GOAL', 'you have saved 50% money towards your Hype Goal', 'challenge', 10, NULL, '2015-12-31', 'HYPE_SUPER_SAVER', NULL, '2015-08-20 11:45:32'),
(6, 'HYPE_GOAL_SAVE_MONEY_75', 'HYPE_GOAL', 'You have saved 75% money for your Hype Goal', 'challenge.jpg', 10, NULL, '2015-12-31', 'HYPE_SUPER_SMART_SAVER', NULL, '2015-08-20 11:48:21'),
(7, 'HYPE_GOAL_SHARE_BUDDY', 'HYPE_GOAL', 'You have Shared you Goal with your buddy', 'challenge.jpg', 10, NULL, '2015-12-31', 'HYPE_GOAL_SHARE_BUDDY', NULL, '2015-08-20 11:50:24'),
(8, 'HYPE_GOAL_LOCK', 'HYPE_GOAL', 'You have locked your Hype Goal', 'challenge.jpg', -30, NULL, '2015-12-31', NULL, NULL, '2015-08-20 11:54:01'),
(9, 'HYPE_GOAL_UNLOCK', 'HYPE_GOAL', 'You have unlocked your Hype Goal', 'challenge.jpg', 30, NULL, '2015-12-31', NULL, NULL, '2015-08-20 11:54:42'),
(10, 'HYPE_RECEIVE_COMMENTS', 'HYPE_GOAL', 'You have received Comments on your Hype goal', NULL, 3, NULL, '2015-12-31', 'HYPE_FELLOW_INFLUENCER', NULL, '2015-08-20 11:55:48'),
(11, 'HYPE_RECEIVE_LIKE', 'HYPE_GOAL', 'You have received like for your Hype Goal ', 'challenge.jpg', 1, NULL, '2015-12-31', 'HYPE_FELLOW_INFLUENCER', NULL, '2015-08-20 11:56:59'),
(12, 'HYPE_CONTRIBUTE_BUDDY', '', 'You have contributed for your friends Hype Goal', 'challenge.jpg', 10, NULL, '2015-12-31', 'HYPE_STAR_CONTRIBUTOR', NULL, '2015-08-20 11:58:09'),
(13, 'HYPE_COMPLETE_GOAL', 'HYPE_GOAL', 'You have completed your Hype Goal', 'challenge.jpg', 10, NULL, '2016-01-31', 'HYPE_GURU', NULL, '2015-08-20 12:00:08'),
(14, 'HYPE_CANCEL_GOAL', 'HYPE_GOAL', 'You have cancelled your Hype Goal ', 'Challenge.jpg', -20, NULL, '2015-12-31', NULL, NULL, '2015-08-20 12:01:37');

INSERT INTO `ss_ma_level` (`LEVEL_ID`, `LEVEL_CODE`, `GOAL_CODE`, `REWARD_CODE`, `BADGE_CODE`, `NAME`, `IMAGE`, `STORY`, `POINTS`, `PRIORITY`, `DATE`) VALUES
(1, 'LEVEL1', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'BRONZE', 'reached 250 points', NULL, 'Congrats, you have reached 250 Points in achieving your financial goal using Hype Goal Program', 250, 1, '2015-08-20 00:00:00'),
(2, 'LEVEL2', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'SILVER', 'reached 500 points ', 'level.jpg', 'Congrats, you have reached 500 points in achieving your financial goal using Hype Goal Program', 500, 2, '2015-08-20 00:00:00'),
(3, 'LEVEL3', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'GOLD', 'reached 1000 points ', 'level.jpg', 'Congrats, you have reached 1000 points in achieving your financial goal using Hype Goal Program', 1000, 3, '2015-08-20 00:00:00'),
(4, 'LEVEL4', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'PLATINUM', 'reached 2500 points ', 'level.jpg', 'Congrats, you have reached 2500 points in achieving your financial goal using Hype Goal Program', 2500, 4, '2015-08-20 00:00:00'),
(5, 'LEVEL5', 'HYPE_GOAL', 'AMAZON_GIFT_VOUCHER', 'DIAMOND', 'reached >greater than 5000 points', 'level.jpg', 'Congrats, for reaching more than 5000 points in achieving your financial goals using Hype Goal Program', 5000, 5, '2015-08-20 00:00:00');


