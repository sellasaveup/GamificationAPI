package com.gamification.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gamification.common.ConnectionUtility;
import com.gamification.web.view.Challenge;

public class ChallengeDAO {

	
	public List<Challenge> getChallengeList() {
		List<Challenge> challengeList = null; 
		System.out.println("ChallengeDAO getChallengeList()");
		String query = "SELECT * FROM ss_ma_challenge";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			challengeList = new ArrayList<Challenge>();
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Challenge challenge = new Challenge();
				challenge.setId(rs.getInt("challenge_id"));
				challenge.setDescription(rs.getString("challenge_desc"));
				challenge.setUserAction(rs.getString("CUSTOMER_ACTION"));
				challenge.setPoint(rs.getInt("challenge_point"));
				challenge.setSubjectType(rs.getString("subject_type"));
				challenge.setImageUrl(rs.getString("challenge_img_url"));
				challenge.setOccurrence(rs.getInt("challenge_occurrence"));
				challenge.setExpiryDate(rs.getString("expiry_date"));
				challenge.setGoal(rs.getString("GOAL"));
				challengeList.add(challenge);
				System.out.println("Got Record");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		
		return challengeList;
	
	}
	
	public String addChallenge(Challenge challenge) {
		
		System.out.println("ChallengeDAO addChallenge()");
		String query = "INSERT INTO ss_ma_challenge ( challenge_desc, CUSTOMER_ACTION, challenge_point, subject_type, challenge_img_url, challenge_occurrence, expiry_date, GOAL) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, challenge.getDescription());
			preparedStatement.setString(2, challenge.getUserAction());
			preparedStatement.setInt(3, challenge.getPoint());
			preparedStatement.setString(4, challenge.getSubjectType());
			preparedStatement.setString(5, challenge.getImageUrl());
			preparedStatement.setInt(6, challenge.getOccurrence());
			preparedStatement.setDate(7,connectionUtility.getSqlDate(challenge.getExpiryDate()));
			preparedStatement.setString(8, challenge.getGoal());
			preparedStatement.executeUpdate();
			System.out.println("Added successfully");
			challenge.setId(getChallengeId());
			returnValue = "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return returnValue;
	}
	
	private int getChallengeId() {
		 
		System.out.println("ChallengeDAO getChallengeId()");
		String query = "SELECT MAX(challenge_id) FROM ss_ma_challenge";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		int rewardId = 0;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				rewardId = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		System.out.println("rewardId-->"+rewardId);
		return rewardId;
	
	}
	public String updateChallenge(Challenge challenge) {
		
		System.out.println("ChallengeDAO updateReward()");
		String query = "UPDATE ss_ma_challenge SET  challenge_desc = ?, CUSTOMER_ACTION = ?, challenge_point = ?, subject_type=?, challenge_img_url=?, challenge_occurrence=?, expiry_date=?, GOAL=?  WHERE challenge_id = ?";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, challenge.getDescription());
			preparedStatement.setString(2, challenge.getUserAction());
			preparedStatement.setInt(3, challenge.getPoint());
			preparedStatement.setString(4, challenge.getSubjectType());
			preparedStatement.setString(5, challenge.getImageUrl());
			preparedStatement.setInt(6, challenge.getOccurrence());
			preparedStatement.setDate(7,connectionUtility.getSqlDate(challenge.getExpiryDate()));
			preparedStatement.setString(8, challenge.getGoal());
			preparedStatement.setInt(9, challenge.getId());
			preparedStatement.executeUpdate();
			System.out.println("Updted successfully");
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
	
	public String deleteChallenge(int challengeId) {
		
		System.out.println("ChallengeDAO deleteReward()");
		String query = "DELETE FROM ss_ma_challenge WHERE challenge_id = ?";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, challengeId);
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
