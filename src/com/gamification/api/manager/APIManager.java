package com.gamification.api.manager;

import java.util.List;

import com.gamification.api.dao.GamificationApiDAO;
import com.gamification.api.view.ChallengeMaster;
import com.gamification.api.view.CustomerMaster;
import com.gamification.api.view.CustomerTransaction;
import com.gamification.common.Result;
import com.gamification.web.view.BadgeMaster;
import com.gamification.web.view.Challenge;
import com.gamification.web.view.Reward;

public class APIManager {
	
	public String getPoint( String custId, String requestType) { 
		System.out.println("custId-->"+custId);
		System.out.println("requestType-->"+requestType);
		GamificationApiDAO gamificationDAO = getGamificationDAO();
		String totalPoint = null;
		if("A".equals(requestType)) {
			totalPoint = gamificationDAO.getMasterPoint(Integer.parseInt(custId));
		} else if("M".equals(requestType)) {
			totalPoint = gamificationDAO.getCurrentMonthMasterPoint(Integer.parseInt(custId));
		}
		return totalPoint;
	}
	
	
	public String putPoint(String custId, String point, String action) {
		
		System.out.println("custId-->"+custId);
		System.out.println("point-->"+point);
		System.out.println("action-->"+action);
		GamificationApiDAO gamificationApiDAO = getGamificationDAO();
		CustomerTransaction customerTransaction = getCustomerTransaction();
		customerTransaction.setCustId(Integer.parseInt(custId));
		customerTransaction.setPoint(Integer.parseInt(point));
		customerTransaction.setAction(action);
		String transactionStatus = gamificationApiDAO.putTransactionPoint(customerTransaction);
		System.out.println("transactionStatus-->"+transactionStatus);
		String returnStatus = "0";
		if(transactionStatus.equals("1")) {
			String currentTotalPoint = getPoint(custId, "A");
			System.out.println("currentTotalPoint-->"+currentTotalPoint);
			if(currentTotalPoint != null) {
				int totalPoint = customerTransaction.getPoint() + Integer.parseInt(currentTotalPoint);
				System.out.println("totalPoint-->"+totalPoint);
				returnStatus = gamificationApiDAO.updateMasterPoint(customerTransaction.getCustId(), totalPoint);
			}
		}
		return returnStatus;
	}
	
	public String reducePoint( String custId, String point) {
		
		System.out.println("custId-->"+custId);
		System.out.println("point-->"+point);
		String returnStatus = "0";
		String currentTotalPointStr = getPoint(custId, "A");
		System.out.println("currentTotalPoint-->"+currentTotalPointStr);
		int currentPoint = Integer.parseInt(currentTotalPointStr);
		int reducePoint = Integer.parseInt(point);
		int finalPoint = 0;
		if(reducePoint<currentPoint) {
			finalPoint = currentPoint - reducePoint;
		}
		System.out.println("finalPoint-->"+finalPoint);
		returnStatus = getGamificationDAO().updateMasterPoint(Integer.parseInt(custId), finalPoint);
		return returnStatus;
	}
	
	
	public List<BadgeMaster> getBadge(String custId) { 
		System.out.println("custId-->"+custId);
		return getGamificationDAO().getBadge(Integer.parseInt(custId));
	}
	
	
	public String awardBadge(String custId, String badgeId, String activity) {
		
		System.out.println("custId-->"+custId);
		System.out.println("badgeId-->"+badgeId);
		System.out.println("activity-->"+activity);
		return getGamificationDAO().awardBadge(custId, badgeId, activity);
	}
	
	
	public String removeBadge( String custId, String badgeId) {
		
		System.out.println("custId-->"+custId);
		System.out.println("badgeId-->"+badgeId);

		return getGamificationDAO().removeBadge(Integer.parseInt(custId), Integer.parseInt(badgeId));
	}
	
	public Result postAction( int custId, String action) {
		System.out.println("custId-->"+custId);
		System.out.println("action-->"+action);
		
		return new ActionProcessor().performAction(custId, action);
	}
	
	public CustomerMaster getProfile( int custId) {
		
		return new ActionProcessor().getProfile(custId);
	}
	
	public String getRank(String custId, String requestType) {
		GamificationApiDAO gamificationApiDAO = getGamificationDAO();
		int customerId = Integer.parseInt(custId);
		String rank = null;
		if(requestType.equals("A")) {
			rank = gamificationApiDAO.getOverAllRank(customerId);
		} else if(requestType.equals("M")) {
			rank = gamificationApiDAO.getCurrentMonthRank(customerId);
		}
		System.out.println("rank-->"+rank);
		return rank;
	}
	
	public List<CustomerMaster> getLeaderBoard(String custId, String requestType) {
		List<CustomerMaster> customerMasterList = null;
		GamificationApiDAO gamificationApiDAO = getGamificationDAO();
		if(requestType.equals("A")) {
			customerMasterList = gamificationApiDAO.getOverAllLeaderBoard(Integer.parseInt(custId));
		} else if(requestType.equals("M")) {
			customerMasterList = gamificationApiDAO.getCurrentMonthLeaderBoard(Integer.parseInt(custId));
		}
		System.out.println("customerMasterList-->"+customerMasterList);
		return customerMasterList;
	}
	
	public List<BadgeMaster> getAllBadge(String custId) {
		return getGamificationDAO().getAllBadge(Integer.parseInt(custId));
	}
	
	public List<Challenge> getChallenges(String custId) {
		return getGamificationDAO().getChallenges(Integer.parseInt(custId));
	}
	
	public List<Reward> getAllReward(String custId) {
		return getGamificationDAO().getAllReward(Integer.parseInt(custId));
	}
	
	public List<Reward> getReward(String custId) {
		return getGamificationDAO().getReward(Integer.parseInt(custId));
	}
	
	private CustomerTransaction getCustomerTransaction() {
		return new CustomerTransaction();
	}
	private GamificationApiDAO getGamificationDAO() {
		return new GamificationApiDAO();
	}
	
	public String redeemPoint(String custId, String rewardId) {
		
		Integer point = getGamificationDAO().getPointForReward(Integer.parseInt(custId), Integer.parseInt(rewardId));
		return reducePoint(custId, point.toString());
	}

}
