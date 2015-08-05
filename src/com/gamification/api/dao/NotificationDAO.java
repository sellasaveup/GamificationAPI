package com.gamification.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gamification.api.view.CustomerMaster;
import com.gamification.api.view.Notification;
import com.gamification.common.ConnectionUtility;

public class NotificationDAO {

	public String putNotificationHeader(Notification notification) {

		System.out.println("NotificationDAO putNotificationHeader()");
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
		 
		System.out.println("NotificationDAO getNotificationId()");
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
		System.out.println("notificationId-->"+notificationId);
		return notificationId;
	
	}
	
	public String putNotificationTransaction(int notificationHeaderId, int custId, String transactionStatus) {

		System.out.println("NotificationDAO putNotificationTransaction()");
		String query = "INSERT INTO ss_tr_notification ( notify_header_id, cust_id, status) VALUES ( ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = "0";
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, notificationHeaderId);
			preparedStatement.setInt(2, custId);
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
	
	public List<CustomerMaster> getSubjectBasedCustomerList(String subjectType) {
		List<CustomerMaster> customerList = null; 
		System.out.println("NotificationDAO getSubjectBasedCustomerList()");
		String query = "SELECT * FROM ss_ma_customer where subject_type = ?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, subjectType);
			customerList = new ArrayList<CustomerMaster>();
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
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
	
	private ConnectionUtility getConnectionUtility() {
		return new ConnectionUtility();
	}
}
