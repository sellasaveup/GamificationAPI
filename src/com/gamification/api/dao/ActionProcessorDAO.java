package com.gamification.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gamification.api.view.Challenge;
import com.gamification.api.view.CustomerMaster;
import com.gamification.api.view.CustomerTransaction;
import com.gamification.api.view.Level;
import com.gamification.api.view.UserGoalPoints;
import com.gamification.common.ConnectionUtility;

public class ActionProcessorDAO {
	final static Logger logger = Logger.getLogger(ActionProcessorDAO.class);
	public String putUserGoalPoints(UserGoalPoints userGoalPoints) {
		logger.debug("putUserGoalPoints()");
		String query = "INSERT INTO SS_TR_USER_GOAL_POINTS (USER_CODE, GOAL_CODE, TOTAL_POINTS, REEDEMED_POINTS, GLOBAL_BADGE_CODE) VALUES (?, ?, ?, ?, ?)";
		String postStatus = "0";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userGoalPoints.getUserCode());
			preparedStatement.setString(2, userGoalPoints.getGoalCode());
			preparedStatement.setInt(3, userGoalPoints.getTotalpoints());
			preparedStatement.setInt(4, userGoalPoints.getReedemedPoints());
			preparedStatement.setString(5, userGoalPoints.getGlobalBadgeCode());
			preparedStatement.executeUpdate();
			logger.debug("USER Goal Points Inserted Succesfully");
			postStatus = "1";
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return postStatus;
	
	}
	
	public UserGoalPoints getUserGoalpoints(String userCode, String goalCode) {
		logger.debug("getUserGoalpoints()");
		String query = "SELECT * FROM SS_TR_USER_GOAL_POINTS WHERE USER_CODE =? AND GOAL_CODE=?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		UserGoalPoints userGoalPoints = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			preparedStatement.setString(2, goalCode);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				userGoalPoints =new UserGoalPoints();
				userGoalPoints.setUserCode(rs.getString("USER_CODE"));
				userGoalPoints.setGoalCode(rs.getString("GOAL_CODE"));
				userGoalPoints.setTotalpoints(rs.getInt("TOTAL_POINTS"));
				userGoalPoints.setReedemedPoints(rs.getInt("REEDEMED_POINTS"));
				userGoalPoints.setGlobalBadgeCode(rs.getString("GLOBAL_BADGE_CODE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug(userGoalPoints);
		return userGoalPoints;

	
		
	}
	
	public List<Level> getLevelList(String goalCode, int points) {
		
		logger.debug("getLevelList()");
		logger.debug("goalCode-->"+goalCode);
		logger.debug("points-->"+points);
		
		List<Level> levelList = new ArrayList<Level>();
		String query = "SELECT * FROM SS_MA_LEVEL WHERE GOAL_CODE=? AND POINTS <= ? AND LEVEL_CODE NOT IN (SELECT LEVEL_CODE FROM SS_TR_USER_LEVEL) AND EXPIRY_DATE >=  DATE_FORMAT(CURRENT_DATE , '%Y-%m-%d')";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, goalCode);
			preparedStatement.setInt(2, points);
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Level level = new Level();
				level.setLevelCode(rs.getString("LEVEL_CODE"));
				level.setGoalCode(rs.getString("GOAL_CODE"));
				level.setRewardCode(rs.getString("REWARD_CODE"));
				level.setBadgeCode(rs.getString("BADGE_CODE"));
				level.setName(rs.getString("NAME"));
				level.setImage(rs.getString("IMAGE"));
				level.setStory(rs.getString("STORY"));
				level.setPoints(rs.getInt("POINTS"));
				level.setPriority(rs.getInt("PRIORITY"));
				logger.debug("level.getLevelCode()-->"+level.getLevelCode());
				levelList.add(level);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug(levelList);
		return levelList;
	}
	
	private ConnectionUtility getConnectionUtility() {
		return new ConnectionUtility();
	}

}
