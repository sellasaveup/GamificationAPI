package com.gamification.api.manager;

import com.gamification.api.dao.GamificationDAO;

public class APIManager {
	
	public String getPoint( String custId) { 
		System.out.println("custId-->"+custId);
		return getGamificationDAO().getPoint(custId);
	}
	
	
	public String putPoint(String custId, String point, String activity) {
		
		System.out.println("custId-->"+custId);
		System.out.println("point-->"+point);
		System.out.println("activity-->"+activity);
		return getGamificationDAO().putPoint(custId, point, activity);
	}
	
	public String reducePoint( String custId, String point, String activity) {
		
		System.out.println("custId-->"+custId);
		System.out.println("point-->"+point);
		System.out.println("activity-->"+activity);
		return getGamificationDAO().reducePoint(custId, point, activity);
	}
	
	
	public String getBadge(String custId) { 
		System.out.println("custId-->"+custId);
		return getGamificationDAO().getBadge(custId);
	}
	
	
	public String awardBadge(String custId, String badgeId, String activity) {
		
		System.out.println("custId-->"+custId);
		System.out.println("badgeId-->"+badgeId);
		System.out.println("activity-->"+activity);
		return getGamificationDAO().awardBadge(custId, badgeId, activity);
	}
	
	
	public String removeBadge( String custId, String badgeId, String activity) {
		
		System.out.println("custId-->"+custId);
		System.out.println("badgeId-->"+badgeId);
		System.out.println("activity-->"+activity);
		return getGamificationDAO().removeBadge(custId, badgeId, activity);
	}
	
	private GamificationDAO getGamificationDAO() {
		return new GamificationDAO();
	}

}
