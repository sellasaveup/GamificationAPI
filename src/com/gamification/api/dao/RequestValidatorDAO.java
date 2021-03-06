package com.gamification.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.gamification.api.manager.APIRequestValidator;
import com.gamification.common.ConnectionUtility;
	
public class RequestValidatorDAO {
	final static Logger logger = Logger.getLogger(APIRequestValidator.class);
	
	public String getUserCode(String userCode) {

		logger.debug("getUserCode()");
		String query = "SELECT USER_CODE FROM SS_MA_USER WHERE USER_CODE = ?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String dbUserCode = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			logger.debug("connection-->"+connection);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				dbUserCode = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("dbUserCode-->"+dbUserCode);
		return dbUserCode;
	
	}
	
	public String getUserType(String userType) {

		logger.debug("getUserType()");
		String query = "SELECT USER_TYPE_CODE FROM SS_MA_USER_TYPE WHERE USER_TYPE_CODE = ? AND STATUS='ACTIVE'";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String dbuserType = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userType);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				dbuserType = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("dbuserType-->"+dbuserType);
		return dbuserType;
	
	}
	
	public String getActionCode(String actionCode) {

		logger.debug("getActionCode()");
		String query = "SELECT ACTION_CODE FROM SS_MA_CHALLENGE WHERE ACTION_CODE = ? AND STATUS='ACTIVE' AND EXPIRY_DATE >=  DATE_FORMAT(CURRENT_DATE , '%Y-%m-%d')";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String dbActionCode = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, actionCode);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				dbActionCode = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("dbActionCode-->"+dbActionCode);
		return dbActionCode;
	
	}
	
	public String getGoalCode(String goalCode) {

		logger.debug("getGoalCode()");
		String query = "SELECT GOAL_CODE FROM SS_MA_GOAL WHERE GOAL_CODE = ? AND STATUS='ACTIVE' AND EXPIRY_DATE >=  DATE_FORMAT(CURRENT_DATE , '%Y-%m-%d')";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String dbGoalCode = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, goalCode);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				dbGoalCode = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("dbGoalCode-->"+dbGoalCode);
		return dbGoalCode;
	
	}
	
	public String getBadgeCode(String badgeCode, String goalCode) {

		logger.debug("getBadgeCode()");
		String query = "select badge_code from ss_ma_badge where badge_code=? and goal_Code = ?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String dbBadgeCode = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, badgeCode);
			preparedStatement.setString(2, goalCode);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				dbBadgeCode = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("dbBadgeCode-->"+dbBadgeCode);
		return dbBadgeCode;
	
	}
	
	private ConnectionUtility getConnectionUtility() {
		return new ConnectionUtility();
	}
}
