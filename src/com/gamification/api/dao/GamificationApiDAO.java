package com.gamification.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gamification.api.manager.APIManager;
import com.gamification.api.view.CustomerMaster;
import com.gamification.api.view.CustomerTransaction;
import com.gamification.api.view.User;
import com.gamification.api.view.UserProfile;
import com.gamification.common.ConnectionUtility;
import com.gamification.web.view.BadgeMaster;
import com.gamification.web.view.Challenge;
import com.gamification.web.view.Reward;

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
    
	public UserProfile getUserProfile(String userCode) {


		logger.debug("getUserProfile()");
		String query = "SELECT USER.USER_CODE, USER.NAME, USER.NICK_NAME, USER.IMAGE, USER.USER_TYPE, USER.STATUS,GOAL_POINT.TOTAL_POINTS,GOAL_POINT.REEDEMED_POINTS,(GOAL_POINT.TOTAL_POINTS -GOAL_POINT.REEDEMED_POINTS) REDEEMABLE_POINT,GOAL_POINT.GLOBAL_BADGE_CODE FROM SS_MA_USER USER,SS_TR_USER_GOAL_POINTS GOAL_POINT WHERE USER.USER_CODE = GOAL_POINT.USER_CODE AND USER.USER_CODE=?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		UserProfile userProfile = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
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
	
	public String getGoalCodeForUserCode(String userCode) {
		logger.debug("getGoalCodeForUserCode()");
		String query = "SELECT GOAL_CODE FROM SS_MA_GOAL WHERE USER_TYPE=(SELECT USER_TYPE FROM SS_MA_USER WHERE USER_CODE=?)";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String goalCode = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				goalCode = rs.getString("GOAL_CODE");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("goalCode-->"+goalCode);
		return goalCode;

	
		
	}
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

	public List<Challenge> getChallenges(int custId) {
		List<Challenge> challengeList = null;
		System.out.println("GamificationDAO getChallenges()");
		String query = "SELECT * FROM ss_ma_challenge where SUBJECT_TYPE = (select SUBJECT_TYPE from ss_ma_customer where CUST_ID = ?) and expiry_date >=  DATE_FORMAT(CURRENT_DATE , '%Y-%m-%d')";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			challengeList = new ArrayList<Challenge>();
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, custId);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Challenge challenge = new Challenge();
				challenge.setId(rs.getInt("challenge_id"));
				challenge.setDescription(rs.getString("challenge_desc"));
				challenge.setUserAction(rs.getString("CUSTOMER_ACTION"));
				challenge.setPoint(rs.getInt("challenge_point"));
				challenge.setSubjectType(rs.getString("subject_type"));
				challenge.setImageUrl(rs.getString("challenge_img_url"));
				challenge.setOccurrence(rs.getInt("challenge_occurrence"));
				challenge.setExpiryDate(rs.getString("expiry_date"));
				challengeList.add(challenge);
				System.out.println("Got Record");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}

		return challengeList;

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

	private ConnectionUtility getConnectionUtility() {
		return new ConnectionUtility();
	}
}
