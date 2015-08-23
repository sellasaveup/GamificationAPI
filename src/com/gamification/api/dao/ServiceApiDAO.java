package com.gamification.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.gamification.common.ConnectionUtility;

public class ServiceApiDAO {
	final static Logger logger = Logger.getLogger(ServiceApiDAO.class);
	
	public String getPerformedActivities() {
		logger.debug("getAllTimePoints()");
		String query = "select count(*) from ss_tr_user_action where status='ACTIVE'";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String performedActivitiesCount = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				logger.debug("Got performedActivitiesCount");
				performedActivitiesCount = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("performedActivitiesCount-->"+performedActivitiesCount);
		return performedActivitiesCount;
	
	}
	
	public String getUnlockedBadgeCount() {
		logger.debug("getUnlockedBadgeCount()");
		String query = "select count(*) from ss_tr_user_badge where status='ACTIVE'";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String unlockedBadgeCount = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				logger.debug("Got unlockedBadgeCount");
				unlockedBadgeCount = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("unlockedBadgeCount-->"+unlockedBadgeCount);
		return unlockedBadgeCount;
	
	}
	
	
	public String getEngagedUserCount() {
		logger.debug("getEngagedUserCount()");
		String query = "select count(*) from ss_ma_user where status='ACTIVE'";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String engagedUserCount = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				logger.debug("Got engagedUserCount");
				engagedUserCount = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("engagedUserCount-->"+engagedUserCount);
		return engagedUserCount;
	
	}
	public String getLatestAction() {
		logger.debug("getLatestAction()");
		String query = "select US.name,ua.points,ch.story,go.name goal,us.image from ss_tr_user_action UA,ss_ma_user US, ss_ma_challenge ch,ss_ma_goal go where UA.user_code=US.USER_CODE and ua.action_code=ch.action_code and  ua.goal_code =go.goal_code and ua.status='ACTIVE' order by ua.date desc limit 1";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String name = "";
		String points = "";
		String action = "";
		String goal = "";
		String image = "";
		StringBuilder finalActivityString = new StringBuilder("");
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				logger.debug("Got getLatestAction");
				name = rs.getString("NAME");
				points = rs.getString("POINTS");
				action = rs.getString("STORY");
				goal = rs.getString("GOAL");
				image = rs.getString("IMAGE");
				finalActivityString.append(name).append(" earned on ").append(goal).append("...").append(points).
				append(" Points(s)").append(" for ").append(action).append("#").append(image);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("finalActivityString-->"+finalActivityString);
		return finalActivityString.toString();
	
	}
	
	public String getLatestBadgeActivity() {
		logger.debug("getLatestBadgeActivity()");
		String query = "select um.name,bm.name badge, gm.story goal, um.image from ss_ma_user um,ss_ma_badge bm, ss_ma_goal gm, ss_tr_user_badge ub where ub.badge_code = bm.badge_code and ub.goal_code = gm.goal_code and ub.user_code=um.user_code and ub.status='ACTIVE' order by ub.date desc limit 1";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String name = "";
		String badge = "";
		String goal = "";
		String image = "";
		StringBuilder finalBadgeActivityString = new StringBuilder("");
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				logger.debug("Got LatestBadgeActivity");
				name = rs.getString("NAME");
				badge = rs.getString("BADGE");
				goal = rs.getString("GOAL");
				image = rs.getString("IMAGE");
				finalBadgeActivityString.append(name).append(" unlocked a Badge....").append(badge).append(" on ").append(goal).append("#").append(image);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("finalBadgeActivityString-->"+finalBadgeActivityString);
		return finalBadgeActivityString.toString();
	
	}
	
	public String getLatestReedemActivity() {
		logger.debug("getLatestReedemActivity()");
		String query = "select um.name,gm.story goal,rm.name,ur.REDEEM_POINTS reward,um.image from ss_ma_user um, ss_ma_goal gm, ss_ma_reward rm, ss_tr_user_reward ur where ur.user_code = um.user_code and ur.goal_code = gm.goal_code and ur.reward_code = rm.reward_code and ur.redeem_status='YES' order by ur.date desc limit 1";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String name = "";
		String reward = "";
		String goal = "";
		String image = "";
		StringBuilder finalRedeemActivityString = new StringBuilder("");
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				logger.debug("Got getLatestReedemActivity");
				name = rs.getString("NAME");
				reward = rs.getString("REWARD");
				goal = rs.getString("GOAL");
				image = rs.getString("IMAGE");
				finalRedeemActivityString.append(name).append(" Redeemed on ").append(goal).append("...").append(reward).append(" points(s)#").append(image);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("finalRedeemActivityString-->"+finalRedeemActivityString);
		return finalRedeemActivityString.toString();
	
	}
	
	public String getLatestRewardActivity() {
		logger.debug("getLatestRewardActivity()");
		String query = "select um.name,gm.story goal,rm.name,ur.REDEEM_POINTS reward,um.image from ss_ma_user um, ss_ma_goal gm, ss_ma_reward rm, ss_tr_user_reward ur where ur.user_code = um.user_code and ur.goal_code = gm.goal_code and ur.reward_code = rm.reward_code and ur.redeem_status='NO' order by ur.date desc limit 1";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String name = "";
		String reward = "";
		String goal = "";
		String image = "";
		StringBuilder finalRewardActivityString = new StringBuilder("");
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				logger.debug("Got getLatestRewardActivity");
				name = rs.getString("NAME");
				reward = rs.getString("REWARD");
				goal = rs.getString("GOAL");
				image = rs.getString("IMAGE");
				finalRewardActivityString.append(name).append(" Redeemed on ").append(goal).append("...").append(reward).append(" points(s)#").append(image);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("finalRedeemActivityString-->"+finalRewardActivityString);
		return finalRewardActivityString.toString();
	
	}
	
	public String getLatestLevelActivity() {
		logger.debug("getLatestLevelActivity()");
		String query = "select um.name,lm.name level,lm.end_point point,gm.story goal, um.image from ss_ma_user um, ss_ma_level lm, ss_ma_goal gm, ss_tr_user_level ul where um.user_code = ul.user_code and lm.level_code = ul.level_code and gm.goal_code = ul.goal_code order by ul.date desc limit 1";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String name = "";
		String level = "";
		String point = "";
		String goal = "";
		String image = "";
		StringBuilder finallevelActivityString = new StringBuilder("");
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				logger.debug("Got finallevelActivityString");
				name = rs.getString("NAME");
				level = rs.getString("LEVEL");
				point = rs.getString("POINT");
				goal = rs.getString("GOAL");
				image = rs.getString("IMAGE");
				finallevelActivityString.append(name).append(" Reached ").append(level).append("...")
				.append(point).append(" points(s) on ").append(goal).append("#").append(image);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("finallevelActivityString-->"+finallevelActivityString);
		return finallevelActivityString.toString();
	
	}
	
	public String getLatestUserActivity() {
		logger.debug("getLatestUserActivity()");
		String query = "select um.name,um.nick_name,utm.story type,um.status ,um.image from ss_ma_user um,ss_ma_user_type utm where um.user_type=utm.USER_TYPE_CODE order by um.date limit 1";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String name = "";
		String nickName = "";
		String type = "";
		String status = "";
		String image = "";
		StringBuilder finalUserActivityString = new StringBuilder("");
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				logger.debug("Got finallevelActivityString");
				name = rs.getString("NAME");
				nickName = rs.getString("NICK_NAME");
				type = rs.getString("TYPE");
				status = rs.getString("STATUS");
				image = rs.getString("IMAGE");
				finalUserActivityString.append(name).append("/").append(nickName).append(" joined ")
				.append(type).append(" community to score on a goal…").append(status).append("#").append(image);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("finalUserActivityString-->"+finalUserActivityString);
		return finalUserActivityString.toString();
	
	}
	
	
	
	
	private ConnectionUtility getConnectionUtility() {
		return new ConnectionUtility();
	}
}
