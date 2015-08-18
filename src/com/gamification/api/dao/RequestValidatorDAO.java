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
	
	private ConnectionUtility getConnectionUtility() {
		return new ConnectionUtility();
	}
}
