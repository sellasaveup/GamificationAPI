package com.gamification.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.gamification.api.view.LevelView;
import com.gamification.common.ConnectionUtility;

public class LevelDAO {
	final static Logger logger = Logger.getLogger(LevelDAO.class);
	
	public LevelView getMinimumLevel() {
		logger.debug("getMinimumLevel()");
		String query = "SELECT MIN(PRIORITY),LEVEL_CODE,GOAL_CODE, REWARD_CODE, BADGE_CODE, NAME, IMAGE, STORY, START_POINT, END_POINT, PRIORITY FROM SS_MA_LEVEL";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		LevelView level = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				logger.debug("Level Available");
				level = new LevelView();
				level.setLevelCode(rs.getString("LEVEL_CODE"));
				level.setGoalCode(rs.getString("LEVEL_CODE"));
				level.setRewardCode(rs.getString("REWARD_CODE"));
				level.setBadgeCode(rs.getString("BADGE_CODE"));
				level.setName(rs.getString("NAME"));
				level.setImage(rs.getString("IMAGE"));
				level.setStory(rs.getString("STORY"));
				level.setStartPoint(rs.getInt("START_POINT"));
				level.setEndPoint(rs.getInt("END_POINT"));
				level.setPriority(rs.getInt("PRIORITY"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		logger.debug(level);
		return level;
	
	}
	private ConnectionUtility getConnectionUtility() {
		return new ConnectionUtility();
	}
}
