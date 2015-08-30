package com.gamification.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import com.gamification.api.view.BadgeView;
import com.gamification.api.view.ChallengeView;
import com.gamification.api.view.GoalView;
import com.gamification.api.view.LeaderBoardPageView;
import com.gamification.api.view.LevelView;
import com.gamification.api.view.RewardView;
import com.gamification.api.view.User;
import com.gamification.api.view.UserAction;
import com.gamification.api.view.UserBadge;
import com.gamification.api.view.UserGoalPoints;
import com.gamification.api.view.UserLevel;
import com.gamification.api.view.UserPointsPageView;
import com.gamification.api.view.UserProfile;
import com.gamification.api.view.UserReward;
import com.gamification.common.ConnectionUtility;

public class GamificationApiDAO {
	
	final static Logger logger = Logger.getLogger(GamificationApiDAO.class);

	public String putUser(User user) {

		logger.debug("GamificationDAO putPoint()");
		String query = "INSERT INTO SS_MA_USER (USER_CODE, NAME, NICK_NAME, IMAGE, USER_TYPE, STATUS) VALUES (?, ?, ?, ?, ?, ?)";
		String postStatus = "0";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUserCode());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getNickName());
			preparedStatement.setString(4, user.getImage());
			preparedStatement.setString(5, user.getUserType());
			preparedStatement.setString(6, user.getStatus());
			preparedStatement.executeUpdate();
			logger.debug(user.getName()+" Succesfully Onboarded");
			postStatus = "1";
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return postStatus;
	}
    
	public UserProfile getUserProfile(String userCode, String goalCode) {
		
		logger.debug("getUserProfile()");
		logger.debug("userCode-->"+userCode);
		logger.debug("goalCode-->"+goalCode);
		
		String query = "SELECT USER.USER_CODE, USER.NAME, USER.NICK_NAME, USER.IMAGE, USER.USER_TYPE, USER.STATUS,GOAL_POINT.TOTAL_POINTS,GOAL_POINT.REEDEMED_POINTS,(GOAL_POINT.TOTAL_POINTS -GOAL_POINT.REEDEMED_POINTS) REDEEMABLE_POINT,GOAL_POINT.GLOBAL_BADGE_CODE FROM SS_MA_USER USER,SS_TR_USER_GOAL_POINTS GOAL_POINT WHERE USER.USER_CODE = GOAL_POINT.USER_CODE AND USER.USER_CODE=? AND GOAL_POINT.GOAL_CODE=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		UserProfile userProfile = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			preparedStatement.setString(2, goalCode);
			
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				logger.debug("Profile Available");
				userProfile = new UserProfile();
				userProfile.setUserCode(rs.getString("USER_CODE"));
				userProfile.setName(rs.getString("NAME"));
				userProfile.setNickName(rs.getString("NICK_NAME"));
				userProfile.setImage(rs.getString("IMAGE"));
				userProfile.setUserType(rs.getString("USER_TYPE"));
				userProfile.setStatus(rs.getString("STATUS"));
				userProfile.setTotalPoints(rs.getString("TOTAL_POINTS"));
				userProfile.setReedemedPoints(rs.getString("REEDEMED_POINTS"));
				userProfile.setRedeemablePoints(rs.getString("REDEEMABLE_POINT"));
				userProfile.setGlobalBadgeCode(rs.getString("GLOBAL_BADGE_CODE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		logger.debug(userProfile);
		return userProfile;
	
	}
	
	public BadgeView getBadge(String badgeCode) {
		logger.debug("getBadge()");
		String query = "SELECT * FROM SS_MA_BADGE WHERE BADGE_CODE = ?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		BadgeView badgeView = null;
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, badgeCode);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				badgeView = new BadgeView();
				badgeView.setBadgeCode(rs.getString("BADGE_CODE"));
				badgeView.setGoalCode(rs.getString("GOAL_CODE"));
				badgeView.setName(rs.getString("NAME"));
				badgeView.setImage(rs.getString("IMAGE"));
				badgeView.setStory(rs.getString("STORY"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}

		return badgeView;		
	}
	
	public List<String> getGoalCodeForUserCode(String userCode) {
		logger.debug("getGoalCodeForUserCode()");
		String query = "SELECT GOAL_CODE FROM SS_MA_GOAL WHERE USER_TYPE=(SELECT USER_TYPE FROM SS_MA_USER WHERE USER_CODE=?) AND STATUS='ACTIVE'";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<String> goalCodeList = new ArrayList<String>();
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				goalCodeList.add(rs.getString("GOAL_CODE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("goalCodeList-->"+goalCodeList);
		return goalCodeList;

	
		
	}
	
	public ChallengeView getChallenge(String actionCode) {
		ChallengeView challenge = null;
		logger.debug("getChallenge()");
		String query = "SELECT * FROM SS_MA_CHALLENGE WHERE ACTION_CODE=? AND STATUS='ACTIVE' AND EXPIRY_DATE >=  DATE_FORMAT(CURRENT_DATE , '%Y-%m-%d')";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, actionCode);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				logger.debug("Got Challenge");
				challenge = new ChallengeView();
				challenge.setActionCode(rs.getString("ACTION_CODE"));
				challenge.setGoalCode(rs.getString("GOAL_CODE"));
				challenge.setStory(rs.getString("STORY"));
				challenge.setImage(rs.getString("IMAGE"));
				challenge.setPoints(rs.getInt("POINTS"));
				challenge.setOccurrence(rs.getInt("OCCURRENCE"));
				challenge.setExpiryDate(rs.getString("EXPIRY_DATE"));
				challenge.setBadgeCode(rs.getString("BADGE_CODE"));
				challenge.setRewardCode(rs.getString("REWARD_CODE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug(challenge);
		return challenge;

	}
	
	public List<UserAction> getUserAction(String userCode, String actionCode) {
		List<UserAction> userActionList = new ArrayList<UserAction>();
		UserAction userAction = null;
		logger.debug("getUserAction()");
		String query = "select * from SS_TR_USER_ACTION WHERE USER_CODE=? AND ACTION_CODE=?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			preparedStatement.setString(2, actionCode);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				logger.debug("Got UserAction");
				userAction = new UserAction();
				userAction.setGoalCode(rs.getString("GOAL_CODE"));
				userAction.setUserCode(rs.getString("USER_CODE"));
				userAction.setActionCode(rs.getString("ACTION_CODE"));
				userAction.setPoints(rs.getInt("POINTS"));
				userAction.setStatus(rs.getString("STATUS"));
				userAction.setDate(rs.getString("DATE"));
				userActionList.add(userAction);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug(userActionList);
		return userActionList;

	}
	
	public String postUserAction(UserAction userAction) {

		logger.debug("postUserAction()");
		String query = "INSERT INTO SS_TR_USER_ACTION (GOAL_CODE,USER_CODE,ACTION_CODE,POINTS,STATUS) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String postActionStatus = "0";
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userAction.getGoalCode());
			preparedStatement.setString(2, userAction.getUserCode());
			preparedStatement.setString(3, userAction.getActionCode());
			preparedStatement.setInt(4, userAction.getPoints());
			preparedStatement.setString(5, userAction.getStatus());
			preparedStatement.executeUpdate();
			logger.debug("postUserAction Insertion Success");
			postActionStatus = "1";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		logger.debug("postActionStatus-->"+postActionStatus);
		return postActionStatus;
	}
	
	public String postUserBadge(UserBadge userBadge) {

		logger.debug("postUserBadge()");
		
		String query = "INSERT INTO SS_TR_USER_BADGE (BADGE_CODE, GOAL_CODE, USER_CODE, STATUS) VALUES (?, ?, ?,?)";
		String postStatus = "0";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userBadge.getBadgeCode());
			preparedStatement.setString(2, userBadge.getGoalCode());
			preparedStatement.setString(3, userBadge.getUserCode());
			preparedStatement.setString(4, userBadge.getStatus());
			preparedStatement.executeUpdate();
			logger.debug(userBadge.getBadgeCode()+" Succesfully Allocated");
			postStatus = "1";
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return postStatus;
	}
	
	public String postUserReward(UserReward userReward) {

		logger.debug("postUserReward()");
		String query = "INSERT INTO SS_TR_USER_REWARD (REWARD_CODE, GOAL_CODE, USER_CODE, REDEEM_STATUS, REDEEM_POINTS) VALUES (?, ?, ?, ?,?)";
		String postStatus = "0";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userReward.getRewardCode());
			preparedStatement.setString(2, userReward.getGoalCode());
			preparedStatement.setString(3, userReward.getUserCode());
			preparedStatement.setString(4, userReward.getRedeemStatus());
			preparedStatement.setInt(5, userReward.getRedeemPoints());
			preparedStatement.executeUpdate();
			logger.debug(userReward.getRewardCode()+" Succesfully Allocated");
			postStatus = "1";
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return postStatus;
	}
	
			
	public String updateUserGoalPoints(UserGoalPoints userGoalPoints) {

		logger.debug("updateUserGoalPoints()");
		logger.debug(userGoalPoints);
		String query = "UPDATE SS_TR_USER_GOAL_POINTS SET USER_CODE=?, GOAL_CODE=?, TOTAL_POINTS=?, REEDEMED_POINTS = ? WHERE USER_CODE=? AND GOAL_CODE=?";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String updateUserGoalPointsStatus = "0";
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			logger.debug("userGoalPoints.getUserCode()--->"+userGoalPoints.getUserCode());
			logger.debug("userGoalPoints.getTotalpoints()--->"+userGoalPoints.getTotalpoints());
			preparedStatement.setString(1, userGoalPoints.getUserCode());
			preparedStatement.setString(2, userGoalPoints.getGoalCode());
			preparedStatement.setInt(3, userGoalPoints.getTotalpoints());
			preparedStatement.setInt(4, userGoalPoints.getReedemedPoints());
			preparedStatement.setString(5, userGoalPoints.getUserCode());
			preparedStatement.setString(6, userGoalPoints.getGoalCode());
			preparedStatement.executeUpdate();
			updateUserGoalPointsStatus = "1";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		logger.debug("updateUserGoalPointsStatus-->"+updateUserGoalPointsStatus);
		return updateUserGoalPointsStatus;
	}
	
	public String postUserLevel(UserLevel userLevel) {
		logger.debug("postUserLevel()");
		String query = "INSERT INTO SS_TR_USER_LEVEL (LEVEL_CODE, USER_CODE, GOAL_CODE, BADGE_CODE, PRIORITY) VALUES (?, ?, ?, ?, ?);";
		String postStatus = "0";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userLevel.getLevelCode());
			preparedStatement.setString(2, userLevel.getUserCode());
			preparedStatement.setString(3, userLevel.getGoalCode());
			preparedStatement.setString(4, userLevel.getBadgeCode());
			preparedStatement.setInt(5, userLevel.getPriority());
			preparedStatement.executeUpdate();
			logger.debug(userLevel.getLevelCode()+" Succesfully Allocated");
			postStatus = "1";
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return postStatus;
	}
	
	public String getAllTimePoints(String userCode, String goalCode) {

		logger.debug("getAllTimePoints()");
		String query = "select sum(ua.POINTS) from ss_tr_user_action ua, ss_ma_challenge ch where ch.ACTION_CODE=ua.ACTION_CODE and ua.USER_CODE=? and ua.GOAL_CODE=? and ua.STATUS='ACTIVE' ";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String allTimePoints = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			preparedStatement.setString(2, goalCode);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				logger.debug("Got AllTimePoints");
				allTimePoints = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("allTimePoints-->"+allTimePoints);
		return allTimePoints;
	}
	
	public String getCurrentMonthPoints(String userCode, String goalCode) {

		logger.debug("getCurrentMonthPoints()");
		String query = "SELECT sum(ua.POINTS) as points, month(ua.date), ua.USER_CODE  FROM ss_tr_user_action ua  where extract(year_month from ua.date)= ? and ua.STATUS='ACTIVE' AND ua.USER_CODE= ? and ua.GOAL_CODE=?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String currentMonthPoints = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			String currentMonthYear = getCurrentMonthYear();
			preparedStatement.setString(1, currentMonthYear);
			preparedStatement.setString(2, userCode);
			preparedStatement.setString(3, goalCode);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				logger.debug("Got getCurrentMonthPoints");
				currentMonthPoints = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("currentMonthPoints-->"+currentMonthPoints);
		return currentMonthPoints;
	}
	
	private ConnectionUtility getConnectionUtility() {
		return new ConnectionUtility();
	}
	
	
	public Collection<ChallengeView> getChalByGoal(ChallengeView challengeView) {
		return getChallengesByGoal(challengeView);
	}
	
	public Collection<LevelView> getLevelsByGoal(LevelView levelView) {
		return getLevelsByGoalList(levelView);
	}
	
	public Collection<LevelView> getLevelsByGoalList(final LevelView levelView)  {
		
		List<LevelView> levelList = new ArrayList<LevelView>();
		logger.debug("getLevel()");
		String query = "  select l.image as levelImage, l.story as levelstory, r.story as rewardstory, b.image as badgeImage from ss_ma_level l , ss_ma_reward r , ss_ma_badge b where l.REWARD_CODE = r.REWARD_CODE and b.BADGE_CODE = l.BADGE_CODE and l.GOAL_CODE=? order by l.priority desc";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, levelView.getGoalCode());
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				logger.debug("Got Challenge");
				LevelView level = new LevelView();
				level.setStory(rs.getString("levelstory"));
				level.setImage(rs.getString("levelImage"));
				level.setBadgeCode(rs.getString("badgeImage"));
				level.setRewardCode(rs.getString("rewardstory"));
				levelList.add(level);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug(levelList.size());
		return levelList;
		
	}
	
	public Collection<ChallengeView> getChallengesByGoal(final ChallengeView challengeView)  {
		
		List<ChallengeView> challengeList = new ArrayList<ChallengeView>();
		logger.debug("getChallenge()");
		String query = "SELECT * FROM SS_MA_CHALLENGE WHERE GOAL_CODE=? AND EXPIRY_DATE >=  DATE_FORMAT(CURRENT_DATE , '%Y-%m-%d') order by expiry_date desc";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, challengeView.getGoalCode());
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				logger.debug("Got Challenge");
				ChallengeView challenge = new ChallengeView();
				challenge.setActionCode(rs.getString("ACTION_CODE"));
				challenge.setGoalCode(rs.getString("GOAL_CODE"));
				challenge.setStory(rs.getString("STORY"));
				challenge.setImage(rs.getString("IMAGE"));
				challenge.setPoints(rs.getInt("POINTS"));
				challenge.setOccurrence(rs.getInt("OCCURRENCE"));
				challenge.setExpiryDate(rs.getString("EXPIRY_DATE"));
				challenge.setBadgeCode(rs.getString("BADGE_CODE"));
				challenge.setRewardCode(rs.getString("REWARD_CODE"));
				challengeList.add(challenge);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug(challengeList.size());
		return challengeList;
		
	}
	
	public List<LeaderBoardPageView> getOverAllLeaderBoard(String goalCode) {

		List<LeaderBoardPageView> customerList = null;
		System.out.println("GamificationDAO getOverAllLeaderBoard()");
		String query = "select @curRank := @curRank + 1 AS rank, inQuery.*  from (SELECT sum(ua.POINTS) as totalPoints, ua.USER_CODE, u.NAME, u.IMAGE  FROM ss_tr_user_action ua,ss_ma_user u group by ua.USER_CODE order by totalPoints desc limit 10) as inQuery, (SELECT @curRank := 0) r";

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			customerList = new ArrayList<LeaderBoardPageView>();
			preparedStatement = connection.prepareStatement(query);
			//preparedStatement.setInt(1, goalCode); TODO to be asked for goalCode required or not
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				LeaderBoardPageView leaderBoardPageView = new LeaderBoardPageView();
				leaderBoardPageView.setUserCode(rs.getString("USER_CODE"));
				leaderBoardPageView.setUserAvatar(rs.getString("IMAGE"));
				leaderBoardPageView.setName(rs.getString("NAME"));
				leaderBoardPageView.setPoints(rs.getLong("TOTALPOINTS"));
				leaderBoardPageView.setRank(rs.getLong("RANK"));
				customerList.add(leaderBoardPageView);
				System.out.println("Got Record");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}

		return customerList;

	}

	public List<LeaderBoardPageView> getCurrentMonthLeaderBoard(String goalCode) {

		List<LeaderBoardPageView> leaderBoardList = new ArrayList<LeaderBoardPageView>();
		System.out.println("GamificationDAO getCurrentMonthLeaderBoard()");
		String query = "select @curRank := @curRank + 1 AS rank, inQuery.*  from (SELECT sum(ua.POINTS) as totalpoints, month(ua.DATE), ua.USER_CODE, u.image, u.name FROM ss_tr_user_action ua, ss_ma_user u where u.user_code = ua.user_code and extract(year_month from ua.DATE)= ? group by ua.USER_CODE, month(ua.DATE)  order by totalpoints desc limit 10) as inQuery, (SELECT @curRank := 0) r";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			String currentMonthYear = getCurrentMonthYear();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, currentMonthYear);
			//preparedStatement.setInt(1, goalCode); TODO to be asked for goalCode required or not
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				LeaderBoardPageView leaderBoardPageView = new LeaderBoardPageView();
				leaderBoardPageView.setUserCode(rs.getString("USER_CODE"));
				leaderBoardPageView.setUserAvatar(rs.getString("IMAGE"));
				leaderBoardPageView.setPoints(rs.getLong("TOTALPOINTS"));
				leaderBoardPageView.setName(rs.getString("NAME"));
				leaderBoardPageView.setRank(rs.getLong("RANK"));
				leaderBoardList.add(leaderBoardPageView);
				System.out.println("Got Record");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}

		return leaderBoardList;

	}
	
	private String getCurrentMonthYear() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		DecimalFormat mFormat= new DecimalFormat("00");
		String monthStr = mFormat.format(Double.valueOf(month));
		return String.valueOf(year)+monthStr;
	}
	
	public List<UserPointsPageView> getAllPointsInfo(String userCode, String goalCode) {

		List<UserPointsPageView> userPointsList = new ArrayList<UserPointsPageView>();
		System.out.println("GamificationDAO getAllPointsInfo userCode:" + userCode + "goalCode:" + goalCode);
		String query = "select ua.ACTION_CODE, ch.STORY, ua.POINTS, ua.DATE from ss_tr_user_action ua, ss_ma_challenge ch where ch.ACTION_CODE=ua.ACTION_CODE and ua.USER_CODE=? and ua.GOAL_CODE=? and ua.STATUS='Active' order by ua.date desc";

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			preparedStatement.setString(2, goalCode);
			
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				UserPointsPageView userPointsView = new UserPointsPageView();
				userPointsView.setStory(rs.getString("STORY"));
				userPointsView.setPoints(rs.getString("POINTS"));
				userPointsView.setReceivedDate(rs.getString("DATE"));
				userPointsList.add(userPointsView);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}

		return userPointsList;

	}
	
	
	public List<BadgeView> getMyBadgeList(String userCode, String goalCode) {

		List<BadgeView> userBadgeList = null;
		System.out.println("GamificationDAO getMyBadgeList()");
		String query = "select b.NAME, b.IMAGE, b.STORY from ss_ma_badge b where b.BADGE_CODE in (SELECT ub.BADGE_CODE FROM ss_tr_user_badge ub WHERE ub.USER_CODE=? AND ub.GOAL_CODE=?) and b.GOAL_CODE=? and b.EXPIRY_DATE>sysdate()";

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			userBadgeList = new ArrayList<BadgeView>();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			preparedStatement.setString(2, goalCode);
			preparedStatement.setString(3, goalCode);
			
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				BadgeView badge = new BadgeView();
				badge.setStory(rs.getString("STORY"));
				badge.setImage(rs.getString("IMAGE"));
				badge.setName(rs.getString("NAME"));
				userBadgeList.add(badge);
				System.out.println("Got Record");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}

		return userBadgeList;

	}
	
	
	public List<BadgeView> getMyLockedBadgeList(String userCode, String goalCode) {

		List<BadgeView> userBadgeList = null;
		System.out.println("GamificationDAO getMyLockedBadgeList()");
		String query = " select b.NAME, b.IMAGE, b.STORY from ss_ma_badge b where b.BADGE_CODE not in (SELECT ub.BADGE_CODE FROM ss_tr_user_badge ub WHERE ub.USER_CODE=? AND ub.GOAL_CODE=?) and b.GOAL_CODE=? and b.EXPIRY_DATE>sysdate()";

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			userBadgeList = new ArrayList<BadgeView>();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			preparedStatement.setString(2, goalCode);
			preparedStatement.setString(3, goalCode);
			
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				BadgeView badge = new BadgeView();
				badge.setStory(rs.getString("STORY"));
				badge.setImage(rs.getString("IMAGE"));
				badge.setName(rs.getString("NAME"));
				userBadgeList.add(badge);
				System.out.println("Got Record");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}

		return userBadgeList;

	}
	
	
	public List<UserBadge> getAllMyBadgeList(String userCode, String goalCode) {

		List<UserBadge> userBadgeList = null;
		System.out.println("GamificationDAO getAllMyBadgeList()");
		String query = " SELECT * FROM ss_tr_user_badge ub WHERE ub.USER_CODE=? AND ub.GOAL_CODE=?";

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			userBadgeList = new ArrayList<UserBadge>();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			preparedStatement.setString(2, goalCode);
			
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				UserBadge badge = new UserBadge();
				badge.setBadgeCode(rs.getString("BADGE_CODE"));
				userBadgeList.add(badge);
				System.out.println("Got Record");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		return userBadgeList;
	}
	
	public List<GoalView> getAllMyGoalList(String userCode) {

		List<GoalView>  goalViewList = new ArrayList<GoalView>();
		System.out.println("GamificationDAO getAllMyBadgeList()");
		String query = " select * from ss_ma_goal where status ='ACTIVE' and USER_TYPE IN (select user_type from ss_ma_user where user_code = ? ) and EXPIRY_DATE>sysdate()";

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				GoalView goalView = new GoalView();
				goalView.setName(rs.getString("NAME"));
				goalView.setStory(rs.getString("STORY"));
				goalView.setImage(rs.getString("IMAGE"));
				goalView.setGoalCode(rs.getString("GOAL_CODE"));
				goalViewList.add(goalView);
				System.out.println("Got Record");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		return goalViewList;
	}
	public List<RewardView> getMyRewardList(String userCode, String goalCode) {

		List<RewardView> userRewardList = null;
		System.out.println("GamificationDAO getMyRewardList() : user:" + userCode + "Goal" + goalCode);
		String query = "SELECT ur.REWARD_CODE, r.NAME, r.IMAGE, r.STORY, ur.DATE, ur.REDEEM_POINTS FROM ss_tr_user_reward ur, ss_ma_reward r WHERE ur.USER_CODE=? AND ur.GOAL_CODE=? and ur.GOAL_CODE= r.GOAL_CODE and r.REWARD_CODE=ur.REWARD_CODE order by ur.DATE desc";

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			userRewardList = new ArrayList<RewardView>();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			preparedStatement.setString(2, goalCode);
			
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				RewardView reward = new RewardView();
				reward.setStory(rs.getString("STORY"));
				reward.setImage(rs.getString("IMAGE"));
				reward.setName(rs.getString("NAME"));
				reward.setReedemPoints(rs.getInt("REDEEM_POINTS"));
				userRewardList.add(reward);
				System.out.println("Got reward" + reward.getStory() + " name " + reward.getName() + " image " + reward.getImage());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}

		return userRewardList;

	}	
	
	public String getAllTimeRank(String userCode, String goalCode) {

		logger.debug("getAllTimeRank()");
		String query = "select * from (select @curRank := @curRank + 1 AS rank, inQuery.*  from (SELECT sum(ua.points) as totalPoints,  u.user_code FROM ss_tr_user_action ua,ss_ma_user u group by ua.USER_CODE order by totalPoints desc) as inQuery, (SELECT @curRank := 0) r ) outerQry where outerQry.user_code=?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String allTimeRank = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			preparedStatement.setString(2, goalCode);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				logger.debug("Got getAllTimeRank");
				allTimeRank = rs.getString("rank");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("getAllTimeRank-->"+allTimeRank);
		return allTimeRank;
	}
	
	public String getCurrentMonthRank(String userCode, String goalCode) {

		logger.debug("getCurrentMonthRank()");
		String query = "select * from (select @curRank := @curRank + 1 AS rank, inQuery.*  from (SELECT sum(ua.points) as totalPoints, month(ua.date), u.user_code FROM ss_tr_user_action ua,ss_ma_user u where extract(year_month from ua.date)= ?  group by ua.USER_CODE, month(ua.date)  order by totalPoints desc) as inQuery, (SELECT @curRank := 0) r ) outerQry where outerQry.user_code=?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String currentMonthRank = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			String currentMonthYear = getCurrentMonthYear();
			preparedStatement.setString(1, currentMonthYear);
			preparedStatement.setString(2, userCode);
			preparedStatement.setString(3, goalCode);
			
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				logger.debug("Got getCurrentMonthRank");
				currentMonthRank = rs.getString("rank");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("getCurrentMonthRank-->"+currentMonthRank);
		return currentMonthRank;
	}
	
}
