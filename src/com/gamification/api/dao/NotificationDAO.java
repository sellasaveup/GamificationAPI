package com.gamification.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gamification.api.view.CustomerMaster;
import com.gamification.api.view.Notification;
import com.gamification.common.ConnectionUtility;

public class NotificationDAO {
	final static Logger logger = Logger.getLogger(NotificationDAO.class);
	
	public List<String> getUserCodeList(String goalCode) {
		List<String> userCodeList = null; 
		logger.debug("NotificationDAO getSubjectBasedCustomerList()");
		String query = "select USER_CODE from ss_ma_user where user_type in (select user_type from ss_ma_goal where goal_code=?)";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, goalCode);
			userCodeList = new ArrayList<String>();
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				userCodeList.add(rs.getString("USER_CODE"));
				logger.debug("Got Record");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("userCodeList-->"+userCodeList);
		return userCodeList;
	
	}
	public String putNotificationHeader(Notification notification) {

		logger.debug("NotificationDAO putNotificationHeader()");
		String query = "INSERT INTO ss_tr_notification_header ( notify_type, target, message, image) VALUES ( ?, ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = "0";
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, notification.getNotificationType());
			preparedStatement.setString(2, notification.getTarget());
			preparedStatement.setString(3, notification.getMessage());
			preparedStatement.setString(4, notification.getImageUrl());
			preparedStatement.executeUpdate();
			notification.setNotificationId(getNotificationId());
			returnValue = "1";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return returnValue;
	}
	
	private int getNotificationId() {
		 
		logger.debug("NotificationDAO getNotificationId()");
		String query = "SELECT MAX(notify_id) FROM ss_tr_notification_header";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		int notificationId = 0;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				notificationId = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("notificationId-->"+notificationId);
		return notificationId;
	
	}
	
	public String putNotificationTransaction(int notificationHeaderId, String userCode, String transactionStatus) {

		logger.debug("NotificationDAO putNotificationTransaction()");
		String query = "INSERT INTO ss_tr_notification ( notify_header_id, user_code, status) VALUES ( ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = "0";
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, notificationHeaderId);
			preparedStatement.setString(2, userCode);
			preparedStatement.setString(3, transactionStatus);
			preparedStatement.executeUpdate();
			returnValue = "1";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return returnValue;
	}
	
	public List<String> getUserTypeBasedCustomerList(String userType) {
		List<String> userCodeList = null; 
		logger.debug("NotificationDAO getUserTypeBasedCustomerList()");
		String query = "SELECT user_code FROM ss_ma_user where user_type = ?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userType);
			userCodeList = new ArrayList<String>();
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				userCodeList.add(rs.getString("USER_CODE"));
				logger.debug("Got Record");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		logger.debug("userCodeList-->"+userCodeList);
		return userCodeList;
	
	}
	
	private ConnectionUtility getConnectionUtility() {
		return new ConnectionUtility();
	}
}
