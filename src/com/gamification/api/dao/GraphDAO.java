package com.gamification.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gamification.api.view.PointsLineChart;
import com.gamification.api.view.User;
import com.gamification.common.ConnectionUtility;

public class GraphDAO {

	final static Logger logger = Logger.getLogger(GraphDAO.class);

	public PointsLineChart getMyPointsLineChart(String userCode, String goalCode) {

		logger.debug("GraphDAO getMyPointsLineChart()");
		String query = "SELECT sum(ua.POINTS) as totalpoints, monthname(ua.DATE) monthna FROM ss_tr_user_action ua where ua.STATUS='ACTIVE' and ua.USER_CODE=? and ua.GOAL_CODE = ? group by ua.USER_CODE, month(ua.DATE)";
		
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

	public List<PointsLineChart> getGoalTrend() {

		logger.debug("GraphDAO getMyPointsLineChart()");
		String query = "select ua.goal_code, sum(ua.POINTS) totalpoints, monthname(ua.date) monthna from ss_tr_user_action ua where ua.STATUS='ACTIVE' group by ua.GOAL_CODE, MONTH(ua.DATE) order by ua.GOAL_CODE";
		
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ConnectionUtility connectionUtility = getConnectionUtility();
		
		try {
			connection = connectionUtility.getConnection();
			preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			String goal = "";
			List<PointsLineChart> goalList = new ArrayList<PointsLineChart>();
			PointsLineChart pointsLineChart = null;
			while (rs.next()){
				if (!goal.equals(rs.getString("GOAL_CODE"))){
					goal = rs.getString("GOAL_CODE");
				   pointsLineChart = new PointsLineChart();
				   pointsLineChart.setDataSet(goal);
					goalList.add(pointsLineChart);
				}
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
			return goalList;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			connectionUtility.closeConnection(connection, preparedStatement, null);
		}
	
	return null;
	}
}
