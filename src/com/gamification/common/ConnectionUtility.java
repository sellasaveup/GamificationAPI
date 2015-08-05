package com.gamification.common;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConnectionUtility {
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/gamification";

	 //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";

	   
	public Connection getConnection() {
		
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
	
	public void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
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
	
	public java.sql.Date getSqlDate(String date) {
		System.out.println("date---->"+date);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date parsed = null;
		try {
			parsed = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("parsed---->"+parsed);
	    java.sql.Date sql = new java.sql.Date(parsed.getTime());
	    System.out.println("sql---->"+sql);
	    return sql;
	}
	
}
