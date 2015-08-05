package com.gamification.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gamification.api.view.ChallengeMaster;
import com.gamification.api.view.CustomerMaster;
import com.gamification.api.view.CustomerTransaction;
import com.gamification.common.ConnectionUtility;
import com.gamification.web.view.Challenge;

public class ActionProcessorDAO {
	
	public CustomerMaster getCustomer(int custId) {  
		System.out.println("ActionProcessorDAO getCustomer()");
		String query = "SELECT * FROM ss_ma_customer where CUST_ID = ?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		CustomerMaster customerMaster = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,custId);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				customerMaster = new CustomerMaster();
				customerMaster.setCustId(rs.getInt("CUST_ID"));
				customerMaster.setCustomerName(rs.getString("CUST_NAME"));
				customerMaster.setCustomerAvatar(rs.getString("CUST_AVATAR"));
				customerMaster.setPoints(rs.getInt("TOTAL_POINTS"));
				customerMaster.setSubjectType(rs.getString("SUBJECT_TYPE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getConnectionUtility().closeConnection(connection, preparedStatement, rs);
		}
		return customerMaster;
	
	}
	
	public ChallengeMaster getChallenge(String action, String subjectType) {

		ChallengeMaster challenge = null;
		System.out.println("ActionProcessorDAO getChallengeList()");
		String query = "SELECT * FROM ss_ma_challenge where expiry_date >=  DATE_FORMAT(CURRENT_DATE , '%Y-%m-%d') and CUSTOMER_ACTION = ? and subject_type = ?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, action);
			preparedStatement.setString(2, subjectType);
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				challenge = new ChallengeMaster();
				challenge.setId(rs.getInt("challenge_id"));
				challenge.setDescription(rs.getString("challenge_desc"));
				challenge.setUserAction(rs.getString("CUSTOMER_ACTION"));
				challenge.setPoint(rs.getInt("challenge_point"));
				challenge.setSubjectType(rs.getString("subject_type"));
				challenge.setImageUrl(rs.getString("challenge_img_url"));
				challenge.setOccurrence(rs.getInt("challenge_occurrence"));
				System.out.println("Challenge available for "+action);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		
		return challenge;
	
	
	}
	
	public List<CustomerTransaction> getCustomerTransaction(int custId, String action) {
		List<CustomerTransaction> customerTransactionList = new ArrayList<CustomerTransaction>();
		
		System.out.println("ActionProcessorDAO getCustomerTransaction()");
		String query = "SELECT * FROM ss_tr_customer_point where CUST_ID = ? and ACTION = ?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, custId);
			preparedStatement.setString(2, action);
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				CustomerTransaction customerTransaction = new CustomerTransaction();
				customerTransaction.setTransactionId(rs.getInt("TR_ID"));
				customerTransaction.setCustId(rs.getInt("CUST_ID"));
				customerTransaction.setPoint(rs.getInt("POINT"));
				customerTransaction.setAction(rs.getString("ACTION"));
				customerTransactionList.add(customerTransaction);
				System.out.println("Got Record");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		System.out.println("customerTransactionList.size()-->"+customerTransactionList.size());
		return customerTransactionList;
	}
	
	
	private ConnectionUtility getConnectionUtility() {
		return new ConnectionUtility();
	}

}
