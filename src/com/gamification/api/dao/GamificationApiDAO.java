package com.gamification.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gamification.api.manager.APIManager;
import com.gamification.api.view.Challenge;
import com.gamification.api.view.CustomerMaster;
import com.gamification.api.view.CustomerTransaction;
import com.gamification.api.view.User;
import com.gamification.api.view.UserAction;
import com.gamification.api.view.UserBadge;
import com.gamification.api.view.UserGoalPoints;
import com.gamification.api.view.UserLevel;
import com.gamification.api.view.UserProfile;
import com.gamification.api.view.UserReward;
import com.gamification.common.ConnectionUtility;

import java.sql.ResultSet;

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
	
	public Challenge getChallenge(String actionCode) {
		Challenge challenge = null;
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
				challenge = new Challenge();
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
		String query = "select* from SS_TR_USER_ACTION WHERE USER_CODE=? AND ACTION_CODE=?";
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
	
	/*
	public String getMasterPoint(int custId) {
		System.out.println("GamificationDAO getPoint()");
		String query = "SELECT TOTAL_POINTS FROM ss_ma_customer where CUST_ID = ?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String points = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, custId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				points = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		System.out.println("points-->" + points);
		return points;
	}

	public String getCurrentMonthMasterPoint(int custId) {
		System.out.println("GamificationDAO getPoint()");
		String query = "SELECT sum(point) FROM ss_tr_customer_point WHERE cust_id=? and month(date) = EXTRACT(month FROM (NOW()))";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String points = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, custId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				points = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		System.out.println("current month points-->" + points);
		return points;
	}

	public String updateMasterPoint(int custId, int point) {

		System.out.println("GamificationDAO updateMasterPoint()");
		String query = "UPDATE ss_ma_customer SET  TOTAL_POINTS = ? WHERE CUST_ID = ?";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = "0";
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, point);
			preparedStatement.setInt(2, custId);
			preparedStatement.executeUpdate();
			returnValue = "1";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return returnValue;
	}

	public String putTransactionPoint(CustomerTransaction customerTransaction) {

		System.out.println("GamificationDAO putPoint()");
		String query = "INSERT INTO SS_TR_CUSTOMER_POINT ( CUST_ID, POINT, ACTION) VALUES ( ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = "0";
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, customerTransaction.getCustId());
			preparedStatement.setInt(2, customerTransaction.getPoint());
			preparedStatement.setString(3, customerTransaction.getAction());
			preparedStatement.executeUpdate();
			returnValue = "1";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return returnValue;
	}

	public List<BadgeMaster> getBadge(int custId) {
		System.out.println("GamificationDAO reducePoint()");
		List<BadgeMaster> badgeMasterList = null;
		System.out.println("BadgeMasterDAO getBadgeList()");
		String query = "select * from ss_ma_badge where BADGE_ID in (select BADGE_ID from ss_tr_customer_badge where CUST_ID =?)";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, custId);
			rs = preparedStatement.executeQuery();
			badgeMasterList = new ArrayList<BadgeMaster>();

			while (rs.next()) {
				BadgeMaster badgeMaster = new BadgeMaster();
				badgeMaster.setBadgeId(rs.getInt("BADGE_ID"));
				badgeMaster.setBadgeName(rs.getString("BADGE_NAME"));
				badgeMaster.setImageUrl(rs.getString("BADGE_IMG_URL"));
				badgeMaster.setBadgeCode(rs.getString("BADGE_CODE"));
				badgeMaster.setSubjectType(rs.getString("SUBJECT_TYPE"));
				badgeMaster.setGoal(rs.getString("GOAL"));
				badgeMasterList.add(badgeMaster);
				System.out.println("Got Record");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}

		return badgeMasterList;
	}

	public List<BadgeMaster> getAllBadge(int custId) {
		List<BadgeMaster> badgeMasterList = null;
		System.out.println("BadgeMasterDAO getBadgeList()");
		String query = "SELECT * FROM ss_ma_badge where SUBJECT_TYPE = (select SUBJECT_TYPE from ss_ma_customer where cust_id = ?)";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			badgeMasterList = new ArrayList<BadgeMaster>();
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, custId);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				BadgeMaster badgeMaster = new BadgeMaster();
				badgeMaster.setBadgeId(rs.getInt("BADGE_ID"));
				badgeMaster.setBadgeName(rs.getString("BADGE_NAME"));
				badgeMaster.setImageUrl(rs.getString("BADGE_IMG_URL"));
				badgeMaster.setBadgeCode(rs.getString("BADGE_CODE"));
				badgeMasterList.add(badgeMaster);
				System.out.println("Got Record");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}

		return badgeMasterList;

	}

	public String awardBadge(String custId, String badgeId, String activity) {

		System.out.println("GamificationDAO awardBadge()");
		String query = "INSERT INTO ss_tr_customer_badge ( CUST_ID, BADGE_ID, ACTION) VALUES ( ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = "0";
		ConnectionUtility connectionUtility = getConnectionUtility();

		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(custId));
			preparedStatement.setInt(2, Integer.parseInt(badgeId));
			preparedStatement.setString(3, activity);
			preparedStatement.executeUpdate();
			returnValue = "1";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return returnValue;
	}

	public String getOverAllRank(int custId) {

		System.out.println("GamificationDAO getOverAllRank()");
		String query = "select customer_master_outer.cust_id ,( select count(TOTAL_POINTS) from ss_ma_customer customer_master_inner where customer_master_inner.TOTAL_POINTS >= customer_master_outer.TOTAL_POINTS ) as RANK from ss_ma_customer customer_master_outer where cust_id = ?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String rank = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, custId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				rank = rs.getString("RANK");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		System.out.println("rank-->" + rank);
		return rank;

	}

	public String getCurrentMonthRank(int custId) {

		System.out.println("GamificationDAO getPoint()");
		String query = "select customer_master_outer.cust_id ,( select count(TOTAL_POINTS) from ss_ma_customer customer_master_inner where customer_master_inner.TOTAL_POINTS >= customer_master_outer.TOTAL_POINTS ) as RANK from ss_ma_customer customer_master_outer where cust_id = ?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String rank = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, custId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				rank = rs.getString("RANK");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		System.out.println("rank-->" + rank);
		return rank;

	}

	public List<CustomerMaster> getOverAllLeaderBoard(int custId) {

		List<CustomerMaster> customerList = null;
		System.out.println("GamificationDAO getOverAllLeaderBoard()");
		String query = "SELECT * FROM ss_ma_customer where SUBJECT_TYPE = (select SUBJECT_TYPE from ss_ma_customer where CUST_ID = ?) order by TOTAL_POINTS desc";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			customerList = new ArrayList<CustomerMaster>();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, custId);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				CustomerMaster customerMaster = new CustomerMaster();
				customerMaster.setCustId(rs.getInt("CUST_ID"));
				customerMaster.setCustomerName(rs.getString("CUST_NAME"));
				customerMaster.setCustomerAvatar(rs.getString("CUST_AVATAR"));
				customerMaster.setPoints(rs.getInt("TOTAL_POINTS"));
				customerMaster.setSubjectType(rs.getString("SUBJECT_TYPE"));
				customerList.add(customerMaster);
				System.out.println("Got Record");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}

		return customerList;

	}

	public List<CustomerMaster> getCurrentMonthLeaderBoard(int custId) {

		List<CustomerMaster> customerList = null;
		System.out.println("GamificationDAO getCurrentMonthLeaderBoard()");
		String query = "SELECT * FROM ss_ma_customer where SUBJECT_TYPE = (select SUBJECT_TYPE from ss_ma_customer where CUST_ID = ?) order by TOTAL_POINTS desc";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			customerList = new ArrayList<CustomerMaster>();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, custId);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				CustomerMaster customerMaster = new CustomerMaster();
				customerMaster.setCustId(rs.getInt("CUST_ID"));
				customerMaster.setCustomerName(rs.getString("CUST_NAME"));
				customerMaster.setCustomerAvatar(rs.getString("CUST_AVATAR"));
				customerMaster.setPoints(rs.getInt("TOTAL_POINTS"));
				customerMaster.setSubjectType(rs.getString("SUBJECT_TYPE"));
				customerList.add(customerMaster);
				System.out.println("Got Record");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}

		return customerList;

	}

	

	public List<Reward> getAllReward(int custId) {
		List<Reward> rewardList = null;
		System.out.println("GamificationDAO getAllReward()");
		String query = "SELECT * FROM SS_MA_REWARD where SUBJECT_TYPE = (select SUBJECT_TYPE from ss_ma_customer where CUST_ID = ?)";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			rewardList = new ArrayList<Reward>();
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, custId);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Reward reward = new Reward();
				reward.setRewardId(rs.getInt("REWARD_ID"));
				reward.setRewardDesc(rs.getString("REWARD_DESC"));
				reward.setRewardPoint(rs.getInt("REWARD_POINT"));
				reward.setRewardCode(rs.getString("REWARD_CODE"));
				reward.setImageUrl(rs.getString("REWARD_IMG_URL"));
				reward.setSubjectType(rs.getString("SUBJECT_TYPE"));
				reward.setGoal(rs.getString("GOAL"));
				rewardList.add(reward);
				System.out.println("Got Record");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}

		return rewardList;

	}

	public List<Reward> getReward(int custId) {
		List<Reward> rewardList = null;
		System.out.println("GamificationDAO getReward()");
		String query = "SELECT * FROM SS_MA_REWARD where reward_id in (select reward_id from SS_tr_REWARD where customer_id = ?)";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			rewardList = new ArrayList<Reward>();
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, custId);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Reward reward = new Reward();
				reward.setRewardId(rs.getInt("REWARD_ID"));
				reward.setRewardDesc(rs.getString("REWARD_DESC"));
				reward.setRewardPoint(rs.getInt("REWARD_POINT"));
				reward.setRewardCode(rs.getString("REWARD_CODE"));
				reward.setImageUrl(rs.getString("REWARD_IMG_URL"));
				reward.setSubjectType(rs.getString("SUBJECT_TYPE"));
				reward.setGoal(rs.getString("GOAL"));
				rewardList.add(reward);
				System.out.println("Got Record");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}

		return rewardList;

	}

	public Integer getPointForReward(int custId, int rewardId) {
		System.out.println("GamificationDAO getReward()");
		String query = "SELECT REWARD_POINT FROM SS_MA_REWARD where reward_id in (select reward_id from SS_tr_REWARD where customer_id = ?)";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Integer point = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, custId);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				point = rs.getInt("REWARD_POINT");
				System.out.println("Got point Record");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}

		return point;

	}

	public String removeBadge(int custId, int badgeId) {

		System.out.println("BadgeMasterDAO deleteBadge()");
		String query = "DELETE FROM ss_tr_customer_badge WHERE CUST_ID = ? and BADGE_ID = ?";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = "0";
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, custId);
			preparedStatement.setInt(2, badgeId);
			preparedStatement.executeUpdate();
			returnValue = "1";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return returnValue;

	}

	*/
	private ConnectionUtility getConnectionUtility() {
		return new ConnectionUtility();
	}
}
