package com.gamification.api.manager;

import com.gamification.api.view.ChallengeMaster;
import com.gamification.api.view.CustomerMaster;
import com.gamification.api.view.CustomerTransaction;

import java.util.List;

import com.gamification.api.dao.ActionProcessorDAO;
import com.gamification.api.dao.GamificationApiDAO;
import com.gamification.common.Result;

public class ActionProcessor {
	public Result performAction(int custId, String action) {
		
		Result result = new Result();
		ActionProcessorDAO actionProcessorDAO = getActionProcessorDAO();
		GamificationApiDAO gamificationApiDAO = getGamificationApiDAO();
		CustomerMaster customerMaster = actionProcessorDAO.getCustomer(custId);
		if(customerMaster == null) {
			result.setCustomerId(custId);
			result.setStatus(0);
			result.setStatusReport("Customer Not Available");
			
		} else {
			ChallengeMaster challengeMaster = actionProcessorDAO.getChallenge(action, customerMaster.getSubjectType());
			CustomerTransaction customerTransaction = new CustomerTransaction();
			if(challengeMaster != null) {
				List<CustomerTransaction> customerTransactionList = actionProcessorDAO.getCustomerTransaction(custId, action);
				if(customerTransactionList.size() == (challengeMaster.getOccurrence()-1)) {
					System.out.println("Action matching to the challenge");
					customerTransaction.setCustId(custId);
					customerTransaction.setPoint(challengeMaster.getPoint());
					customerTransaction.setAction(action);
					
					
					String transactionStatus = gamificationApiDAO.putTransactionPoint(customerTransaction);
					System.out.println("transactionStatus-->"+transactionStatus);
					
					if(transactionStatus.equals("1")) {
						String currentTotalPoint = gamificationApiDAO.getMasterPoint(custId);
						System.out.println("currentTotalPoint-->"+currentTotalPoint);
						if(currentTotalPoint != null) {
							int totalPoint = customerTransaction.getPoint() + Integer.parseInt(currentTotalPoint);
							System.out.println("totalPoint-->"+totalPoint);
							gamificationApiDAO.updateMasterPoint(customerTransaction.getCustId(), totalPoint);
						}
					}
					
					result.setCustomerId(custId);
					result.setStatus(1);
					result.setStatusReport("Need More action to Achiev Challenge");
					
				} else if(customerTransactionList.size() < challengeMaster.getOccurrence()) {
					System.out.println("Action lesser so need to post 0 points");
					customerTransaction.setCustId(custId);
					customerTransaction.setPoint(0);
					customerTransaction.setAction(action);
					String transactionStatus = gamificationApiDAO.putTransactionPoint(customerTransaction);
					System.out.println("transactionStatus-->"+transactionStatus);
					
					if(transactionStatus.equals("1")) {
						String currentTotalPoint = gamificationApiDAO.getMasterPoint(custId);
						System.out.println("currentTotalPoint-->"+currentTotalPoint);
						if(currentTotalPoint != null) {
							int totalPoint = customerTransaction.getPoint() + Integer.parseInt(currentTotalPoint);
							System.out.println("totalPoint-->"+totalPoint);
							gamificationApiDAO.updateMasterPoint(customerTransaction.getCustId(), totalPoint);
						}
					}
					
					result.setCustomerId(custId);
					result.setStatus(1);
					result.setStatusReport("Challenge Completed");
				}
			} else {
				result.setCustomerId(custId);
				result.setStatus(0);
				result.setStatusReport("Challenge Not Available");
			}
		}
		return result;
	}
	
	public CustomerMaster getProfile(int custId) {
		CustomerMaster customerMaster = getActionProcessorDAO().getCustomer(custId);
		return customerMaster;
	}
	
	private GamificationApiDAO getGamificationApiDAO() {
		return new GamificationApiDAO();
	}
	
	private ActionProcessorDAO getActionProcessorDAO() {
		return new ActionProcessorDAO();
	}
}
