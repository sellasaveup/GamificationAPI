package com.gamification.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gamification.api.view.CustomerMaster;
import com.gamification.common.ConnectionUtility;

public class CustomerMasterDAO {

	
	public List<CustomerMaster> getCustomerList() {
		List<CustomerMaster> customerList = null; 
		System.out.println("CustomerMasterDAO getCustomerList()");
		String query = "SELECT * FROM ss_ma_customer";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
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
	
	public String addCustomer(CustomerMaster customerMaster) {
		
		System.out.println("CustomerMasterDAO addCustomer()");
		String query = "INSERT INTO ss_ma_customer ( CUST_ID, CUST_NAME, CUST_AVATAR, TOTAL_POINTS, SUBJECT_TYPE) VALUES ( ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, customerMaster.getCustId());
			preparedStatement.setString(2, customerMaster.getCustomerName());
			preparedStatement.setString(3, customerMaster.getCustomerAvatar());
			preparedStatement.setInt(4, customerMaster.getPoints());
			preparedStatement.setString(5, customerMaster.getSubjectType());
			preparedStatement.executeUpdate();
			customerMaster.setCustId(getCustomerId());
			returnValue = "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return returnValue;
	}
	
	private int getCustomerId() {
		 
		System.out.println("CustomerMasterDAO getCustomerId()");
		String query = "SELECT MAX(CUST_ID) FROM ss_ma_customer";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		int customerId = 0;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				customerId = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		System.out.println("customerId-->"+customerId);
		return customerId;
	
	}
	public String updateCustomer(CustomerMaster customerMaster) {
		
		System.out.println("CustomerMasterDAO updateCustomer()");
		String query = "UPDATE ss_ma_customer SET  CUST_NAME = ?, CUST_AVATAR = ?, TOTAL_POINTS = ?, SUBJECT_TYPE=? WHERE CUST_ID = ?";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, customerMaster.getCustomerName());
			preparedStatement.setString(2, customerMaster.getCustomerAvatar());
			preparedStatement.setInt(3, customerMaster.getPoints());
			preparedStatement.setString(4, customerMaster.getSubjectType());
			preparedStatement.setInt(5, customerMaster.getCustId());
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
	
	public String deleteCustomer(int customerId) {
		
		System.out.println("CustomerMasterDAO deleteCustomer()");
		String query = "DELETE FROM ss_ma_customer WHERE CUST_ID = ?";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, customerId);
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
