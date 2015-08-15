package com.gamification.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gamification.common.ConnectionUtility;
import com.gamification.web.view.Level;

public class LevelDAO {

	public List<Level> getLevelList() {
		List<Level> levelList = null; 
		String query = "SELECT * FROM SS_MA_LEVEL";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			levelList = new ArrayList<Level>();
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Level level = new Level();
				level.setLevelId(rs.getLong("LEVEL_ID"));
				level.setLevelDesc(rs.getString("LEVEL_DESC"));
				level.setImageUrl(rs.getString("LEVEL_IMG_URL"));
				level.setBadgeId(rs.getLong("BADGE_ID"));
				level.setRewardId(rs.getLong("REWARD_ID"));
				levelList.add(level);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		return levelList;

	}

	public String addLevel(Level level) {

		String query = "INSERT INTO SS_MA_LEVEL ( LEVEL_DESC, LEVEL_IMG_URL, BADGE_ID, REWARD_ID) VALUES ( ?, ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, level.getLevelDesc());
			preparedStatement.setString(2, level.getImageUrl());
			preparedStatement.setLong(3, level.getBadgeId());
			preparedStatement.setLong(4, level.getRewardId());
			preparedStatement.executeUpdate();
			level.setLevelId(getLevelId());
			returnValue = "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return returnValue;
	}

	private Long getLevelId() {

		String query = "SELECT MAX(LEVEL_ID) FROM SS_MA_LEVEL";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Long levelId = 0l;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				levelId = rs.getLong(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		return levelId;

	}
	public String updateLevel(Level level) {

		String query = "UPDATE SS_MA_LEVEL SET  LEVEL_DESC = ?, LEVEL_IMG_URL = ?, BADGE_ID = ?, REWARD_ID = ? WHERE LEVEL_ID = ?";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, level.getLevelDesc());
			preparedStatement.setString(2, level.getImageUrl());
			preparedStatement.setLong(3, level.getBadgeId());
			preparedStatement.setLong(4, level.getRewardId());
			preparedStatement.setLong(5, level.getLevelId());
			preparedStatement.executeUpdate();
			returnValue = "SUCCESS";
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

	public String deleteLevel(Long levelId) {

		String query = "DELETE FROM SS_MA_LEVEL WHERE LEVEL_ID = ?";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, levelId);
			preparedStatement.executeUpdate();
			returnValue = "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return returnValue;

	}

}
