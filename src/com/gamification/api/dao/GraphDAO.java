package com.gamification.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.gamification.api.view.PointsLineChart;
import com.gamification.api.view.User;
import com.gamification.common.ConnectionUtility;

public class GraphDAO {

	final static Logger logger = Logger.getLogger(GraphDAO.class);

	public PointsLineChart getMyPointsLineChart(String userCode, String goalCode) {

		logger.debug("GraphDAO getMyPointsLineChart()");
		String query = "SELECT sum(ua.POINTS) as totalpoints, monthname(ua.DATE) monthna FROM ss_tr_user_action ua where ua.STATUS='Active' and ua.USER_CODE=? and ua.GOAL_CODE = ? group by ua.USER_CODE, month(ua.DATE)";
		
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		PointsLineChart pointsLineChart = new PointsLineChart();
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userCode);
			preparedStatement.setString(2, goalCode);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()){
			    String monthName = rs.getString("monthna");
			    String points = rs.getString("totalpoints");
			    
			    if (monthName.equals("January")){
			    	pointsLineChart.getyAxis()[0] = points;
			    }else if (monthName.equals("February")){    
			    	pointsLineChart.getyAxis()[1] = points;
			    }else if (monthName.equals("March")){    
			    	pointsLineChart.getyAxis()[2] = points;			    
			    }else if (monthName.equals("April")){    
			    	pointsLineChart.getyAxis()[3] = points;			    
			    }else if (monthName.equals("May")){    
			    	pointsLineChart.getyAxis()[4] = points;			    
			    }else if (monthName.equals("June")){    
			    	pointsLineChart.getyAxis()[5] = points;			    
			    }else if (monthName.equals("July")){    
			    	pointsLineChart.getyAxis()[6] = points;			    
			    }else if (monthName.equals("August")){    
			    	pointsLineChart.getyAxis()[7] = points;			    
			    }else if (monthName.equals("September")){    
			    	pointsLineChart.getyAxis()[8] = points;			    
			    }else if (monthName.equals("October")){    
			    	pointsLineChart.getyAxis()[9] = points;			    
			    }else if (monthName.equals("November")){    
			    	pointsLineChart.getyAxis()[10] = points;			    
			    }else if (monthName.equals("December")){    
			    	pointsLineChart.getyAxis()[11] = points;			    			    	
			    }			    
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
		return pointsLineChart;
		
	}
	private ConnectionUtility getConnectionUtility() {
		return new ConnectionUtility();
	}

}
