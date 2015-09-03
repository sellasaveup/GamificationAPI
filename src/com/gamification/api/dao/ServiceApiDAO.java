package com.gamification.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gamification.api.view.BadgeView;
import com.gamification.api.view.ChallengeView;
import com.gamification.api.view.Notification;
import com.gamification.api.view.User;
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
				append(" Points(s)\n").append(" for, ").append(action).append("#").append(image);
				
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
		String query = "select um.name,bm.name badge, gm.name goal, um.image from ss_ma_user um,ss_ma_badge bm, ss_ma_goal gm, ss_tr_user_badge ub where ub.badge_code = bm.badge_code and ub.goal_code = gm.goal_code and ub.user_code=um.user_code and ub.status='ACTIVE' order by ub.date desc limit 1";
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
		String query = "select um.name,gm.name GOAL,rm.name,ur.REDEEM_POINTS reward,um.image from ss_ma_user um, ss_ma_goal gm, ss_ma_reward rm, ss_tr_user_reward ur where ur.user_code = um.user_code and ur.goal_code = gm.goal_code and ur.reward_code = rm.reward_code and ur.redeem_status='YES' order by ur.date desc limit 1";
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
		String query = "select um.name,gm.name goal,rm.name rewardName,ur.REDEEM_POINTS reward,um.image from ss_ma_user um, ss_ma_goal gm, ss_ma_reward rm, ss_tr_user_reward ur where ur.user_code = um.user_code and ur.goal_code = gm.goal_code and ur.reward_code = rm.reward_code and ur.redeem_status='NO' order by ur.date desc limit 1";
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
				reward = rs.getString("rewardName");
				goal = rs.getString("GOAL");
				image = rs.getString("IMAGE");
				finalRewardActivityString.append(name).append(" received a reward on ").append(goal).append("...").append(reward).append(" #").append(image);
				
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
		String query = "select um.name,lm.level_code level,lm.end_point point,gm.name goal, um.image, b.name badgeName from ss_ma_user um, ss_ma_level lm, ss_ma_goal gm, ss_tr_user_level ul, ss_ma_badge b where um.user_code = ul.user_code and lm.level_code = ul.level_code and gm.goal_code = ul.goal_code and b.BADGE_CODE = ul.BADGE_CODE and b.GOAL_CODE= ul.GOAL_CODE order by ul.date desc limit 1";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String name = "";
		String badgeName = "";
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
				badgeName = rs.getString("badgeName");
				level = rs.getString("LEVEL");
				point = rs.getString("POINT");
				goal = rs.getString("GOAL");
				image = rs.getString("IMAGE");
				finallevelActivityString.append(name).append(" reached ").append(badgeName).append("...")
				.append(" on ").append(goal).append("#").append(image);
				
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
				finalUserActivityString.append(name).append(" joined ")
				.append(type).append(" community to score on a goal ").append("#").append(image);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("finalUserActivityString-->"+finalUserActivityString);
		return finalUserActivityString.toString();
	
	}
	
	public String postUserBadge(String userCode, String badgeCode, String goalCode) {
		
		logger.debug("postUserBadge()");
		String query = "INSERT INTO ss_tr_user_badge (BADGE_CODE, GOAL_CODE, USER_CODE, STATUS) VALUES (?, ?, ?, 'ACTIVE');";
		String postStatus = "0";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, badgeCode);
			preparedStatement.setString(2, goalCode);
			preparedStatement.setString(3, userCode);
			preparedStatement.executeUpdate();
			postStatus = "1";
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		logger.debug("postStatus-->"+postStatus);
		return postStatus;
	
	}
	
	public List<User> getUser(String code, String query) {

		logger.debug("getUser()");
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, code);
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUserCode(rs.getString("USER_CODE"));
				user.setName(rs.getString("NAME"));
				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("userList-->"+userList);
		return userList;
	
	}
	
	public List<ChallengeView> getChallenge(String userCode) {

		logger.debug("getUser()");
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<ChallengeView> challengeList = new ArrayList<ChallengeView>();
		String query = "select ACTION_CODE, STORY from ss_ma_challenge where goal_code in (select goal_code from ss_ma_goal where goal_code in (select goal_code from ss_ma_user_type where user_type_code in (select user_type from ss_ma_user where user_code = ?)))";
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				ChallengeView challenge = new ChallengeView();
				challenge.setActionCode(rs.getString("ACTION_CODE"));
				challenge.setStory(rs.getString("STORY"));
				challengeList.add(challenge);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("challengeList-->"+challengeList);
		return challengeList;
	
	}
	
	public List<BadgeView> getBadge(String userCode) {

		logger.debug("getBadge()");
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<BadgeView> badgeList = new ArrayList<BadgeView>();
		String query = "select BADGE_CODE, NAME from ss_ma_badge where goal_code in (select goal_code from ss_ma_goal where goal_code in (select goal_code from ss_ma_user_type where user_type_code in (select user_type from ss_ma_user where user_code = ?)))";
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				BadgeView badge = new BadgeView();
				badge.setBadgeCode(rs.getString("BADGE_CODE"));
				badge.setName(rs.getString("NAME"));
				badgeList.add(badge);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("badgeList-->"+badgeList);
		return badgeList;
	
	}
	
	public String getUserType(String userCode) {

		logger.debug("getUserType()");
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String userType = null;
		String query = "select user_type from ss_ma_user where user_code=?";
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				userType = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("userType-->"+userType);
		return userType;
	
	}
	
	public List<Notification> getNotification(String userCode) {

		logger.debug("getNotification()");
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Notification> notificationList = new ArrayList<Notification>();
		String query = "select nt.user_code,nh.notify_type,nh.message,nh.image from ss_tr_notification_header nh, ss_tr_notification nt where nh.notify_id = nt.notify_header_id and user_code = ? and status='ACTIVE'";
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Notification notification = new Notification();
				notification.setUserCode(rs.getString("USER_CODE"));
				notification.setNotificationType(rs.getString("NOTIFY_TYPE"));
				notification.setMessage(rs.getString("MESSAGE"));
				notification.setImageUrl(rs.getString("IMAGE"));
				notificationList.add(notification);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("notificationList-->"+notificationList);
		return notificationList;
	
	}
	
	public void updateNotification(String userCode) {
		logger.debug("updateNotification()");
		
		PreparedStatement preparedStatement = null;
		String query = "update ss_tr_notification set status='INACTIVE' where user_code=?";
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
	}
	
	private ConnectionUtility getConnectionUtility() {
		return new ConnectionUtility();
	}
}
