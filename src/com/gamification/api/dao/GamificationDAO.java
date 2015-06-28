package com.gamification.api.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;

public class GamificationDAO {
	
	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/gamification";

	 //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	
	public String getPoint( String custId) { 
		System.out.println("GamificationDAO getPoint()");
		String query = "SELECT TOTAL_POINTS FROM ss_ma_customer where CUST_ID = ?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String points = null;
		Connection connection = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(custId));
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				points = rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement, rs);
		}
		System.out.println("points-->"+points);
		return points;
	}
	
	
	public String putPoint(String custId, String point, String activity) {
		
		System.out.println("GamificationDAO putPoint()");
		String query = "INSERT INTO SS_TR_CUSTOMER_POINT ( CUST_ID, POINT, ACTION) VALUES ( ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(custId));
			preparedStatement.setInt(2, Integer.parseInt(point));
			preparedStatement.setString(3,activity);
			preparedStatement.executeUpdate();
			returnValue = "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement, null);
		}
		return returnValue;
	}
	
	public String reducePoint( String custId, String point, String activity) {
		return putPoint(custId, point, activity+"_Negative");
	}
	
	
	public String getBadge(String custId) {  
		System.out.println("GamificationDAO reducePoint()");
		String query = "SELECT BADGE_ID FROM ss_tr_customer_badge where CUST_ID = ?";
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		StringBuilder badges = null;
		String badgesStr = null;
		Connection connection = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(custId));
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				badges = new StringBuilder();
				badges.append(rs.getString(1)).append("#");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement, rs);
		}
		System.out.println("badges-->"+badges);
		if(badges != null) {
			badgesStr = badges.toString();
		}
		return badgesStr;
	
	}
	
	
	public String awardBadge(String custId, String badgeId, String activity) {
		
		System.out.println("GamificationDAO awardBadge()");
		String query = "INSERT INTO ss_tr_customer_badge ( CUST_ID, BADGE_ID, ACTION) VALUES ( ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String returnValue = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(custId));
			preparedStatement.setInt(2, Integer.parseInt(badgeId));
			preparedStatement.setString(3,activity);
			preparedStatement.executeUpdate();
			returnValue = "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement, null);
		}
		return returnValue;
	}
	
	
	public String removeBadge( String custId, String badgeId, String activity) {
		return awardBadge(custId,badgeId, activity+"_NEGATIVE");
		}
	
	private Connection getConnection() {
		
		 Connection connection = null;
		   try{
		      
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Connecting to database...");
		      connection = DriverManager.getConnection(DB_URL,USER,PASS);
		      System.out.println("Database Connected...");
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }
		   return connection;
	}
	
	private void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
