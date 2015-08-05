package com.gamification.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gamification.common.ConnectionUtility;
import com.gamification.web.view.Reward;

public class RewardDAO {
	
	public List<Reward> getRewardList() {
		List<Reward> rewardList = null; 
		System.out.println("RewardDAO getRewardList()");
		String query = "SELECT * FROM SS_MA_REWARD";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rewardList = new ArrayList<Reward>();
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Reward reward = new Reward();
				reward.setRewardId(rs.getInt("REWARD_ID"));
				reward.setRewardDesc(rs.getString("REWARD_DESC"));
				reward.setRewardPoint(rs.getInt("REWARD_POINT"));
				reward.setRewardCode(rs.getString("REWARD_CODE"));
				reward.setImageUrl(rs.getString("REWARD_IMG_URL"));
				reward.setSubjectType(rs.getString("SUBJECT_TYPE"));
				reward.setGoal(rs.getString("GOAL"));
				rewardList.add(reward);
				System.out.println("Got Record");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, rs);
		}
		
		return rewardList;
	
	}
	
	public String addReward(Reward reward) {
		
		System.out.println("RewardDAO addReward()");
		String query = "INSERT INTO SS_MA_REWARD ( REWARD_DESC, REWARD_POINT, REWARD_CODE, REWARD_IMG_URL, SUBJECT_TYPE, GOAL) VALUES ( ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, reward.getRewardDesc());
			preparedStatement.setInt(2, reward.getRewardPoint());
			preparedStatement.setString(3, reward.getRewardCode());
			preparedStatement.setString(4, reward.getImageUrl());
			preparedStatement.setString(5, reward.getSubjectType());
			preparedStatement.setString(6, reward.getGoal());
			preparedStatement.executeUpdate();
			reward.setRewardId(getRewardId());
			returnValue = "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return returnValue;
	}
	
	private int getRewardId() {
		 
		System.out.println("RewardDAO getRewardId()");
		String query = "SELECT MAX(REWARD_ID) FROM SS_MA_REWARD";
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
	public String updateReward(Reward reward) {
		
		System.out.println("RewardDAO updateReward()");
		String query = "UPDATE SS_MA_REWARD SET  REWARD_DESC = ?, REWARD_POINT = ?, REWARD_CODE = ?, REWARD_IMG_URL=?, SUBJECT_TYPE=?, GOAL=? WHERE REWARD_ID = ?";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, reward.getRewardDesc());
			preparedStatement.setInt(2, reward.getRewardPoint());
			preparedStatement.setString(3, reward.getRewardCode());
			preparedStatement.setString(4, reward.getImageUrl());
			preparedStatement.setString(5, reward.getSubjectType());
			preparedStatement.setString(6, reward.getGoal());
			preparedStatement.setInt(7, reward.getRewardId());
			
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
	
	public String deleteReward(int rewardId) {
		
		System.out.println("RewardDAO deleteReward()");
		String query = "DELETE FROM SS_MA_REWARD WHERE REWARD_ID = ?";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, rewardId);
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
