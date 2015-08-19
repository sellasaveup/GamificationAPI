package com.gamification.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gamification.common.ConnectionUtility;


public class BadgeMasterDAO {
	
	/*public List<BadgeMaster> getBadgeList() {
		List<BadgeMaster> badgeMasterList = null; 
		System.out.println("BadgeMasterDAO getBadgeList()");
		String query = "SELECT * FROM ss_ma_badge";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			badgeMasterList = new ArrayList<BadgeMaster>();
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				BadgeMaster badgeMaster = new BadgeMaster();
				badgeMaster.setBadgeId(rs.getInt("BADGE_ID"));
				badgeMaster.setBadgeName(rs.getString("BADGE_NAME"));
				badgeMaster.setImageUrl(rs.getString("BADGE_IMG_URL"));
				badgeMaster.setBadgeCode(rs.getString("BADGE_CODE"));
				badgeMaster.setSubjectType(rs.getString("SUBJECT_TYPE"));
				badgeMaster.setGoal(rs.getString("GOAL"));
				badgeMasterList.add(badgeMaster);
				System.out.println("Got Record");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		
		return badgeMasterList;
	
	}
	
	public String addBadge(BadgeMaster badgeMaster) {
		
		System.out.println("BadgeMasterDAO addBadge()");
		String query = "INSERT INTO ss_ma_badge ( BADGE_NAME, BADGE_IMG_URL, BADGE_CODE, SUBJECT_TYPE, GOAL) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, badgeMaster.getBadgeName());
			preparedStatement.setString(2, badgeMaster.getImageUrl());
			preparedStatement.setString(3, badgeMaster.getBadgeCode());
			preparedStatement.setString(4, badgeMaster.getSubjectType());
			preparedStatement.setString(5, badgeMaster.getGoal());
			preparedStatement.executeUpdate();
			badgeMaster.setBadgeId(getBadgeId());
			returnValue = "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return returnValue;
	}
	
	private int getBadgeId() {
		 
		System.out.println("BadgeMasterDAO getBadgeId()");
		String query = "SELECT MAX(BADGE_ID) FROM ss_ma_badge";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		int badgeId = 0;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				badgeId = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		System.out.println("badgeId-->"+badgeId);
		return badgeId;
	
	}
	public String updateBadge(BadgeMaster badgeMaster) {
		
		System.out.println("BadgeMasterDAO updateBadge()");
		String query = "UPDATE ss_ma_badge SET  BADGE_NAME = ?, BADGE_IMG_URL = ?, BADGE_CODE = ?, SUBJECT_TYPE=?, GOAL=? WHERE BADGE_ID = ?";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, badgeMaster.getBadgeName());
			preparedStatement.setString(2, badgeMaster.getImageUrl());
			preparedStatement.setString(3, badgeMaster.getBadgeCode());
			preparedStatement.setString(4, badgeMaster.getSubjectType());
			preparedStatement.setString(5, badgeMaster.getGoal());
			preparedStatement.setInt(6, badgeMaster.getBadgeId());
			
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
	
	public String deleteBadge(int badgeId) {
		
		System.out.println("BadgeMasterDAO deleteBadge()");
		String query = "DELETE FROM ss_ma_badge WHERE BADGE_ID = ?";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, badgeId);
			preparedStatement.executeUpdate();
			returnValue = "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return returnValue;
	
	}*/
}
