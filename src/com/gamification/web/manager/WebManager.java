package com.gamification.web.manager;

import java.util.List;

import com.gamification.api.view.CustomerMaster;
import com.gamification.web.dao.BadgeMasterDAO;
import com.gamification.web.dao.ChallengeDAO;
import com.gamification.web.dao.CustomerMasterDAO;
import com.gamification.web.dao.RewardDAO;
import com.gamification.web.view.BadgeMaster;
import com.gamification.web.view.Challenge;
import com.gamification.web.view.Reward;

public class WebManager {
	//final static Logger logger = Logger.getLogger(WebManager.class);
	public List<Reward>  getRewardList() {
		//logger.debug("Inside Manager");
		return new RewardDAO().getRewardList();
	}
	
	public String addReward(Reward reward) {
		return new RewardDAO().addReward(reward);
	}
	
	public String updateReward(Reward reward) {
		return new RewardDAO().updateReward(reward);
	}
	
	public String deleteReward(int rewardId) {
		return new RewardDAO().deleteReward(rewardId);
	}
	
	public List<Challenge>  getChallengeList() {
		return new ChallengeDAO().getChallengeList();
	}
	
	public String addChallenge(Challenge challenge) {
		return new ChallengeDAO().addChallenge(challenge);
	}
	
	public String updateChallenge(Challenge challenge) {
		return new ChallengeDAO().updateChallenge(challenge);
	}
	
	public String deleteChallenge(int challengrId) {
		return new ChallengeDAO().deleteChallenge(challengrId);
	}
	
	public List<CustomerMaster>  getCustomerList() {
		return new CustomerMasterDAO().getCustomerList();
	}
	
	public String addCustomer(CustomerMaster customerMaster) {
		return new CustomerMasterDAO().addCustomer(customerMaster);
	}
	
	public String updateCustomer(CustomerMaster customerMaster) {
		return new CustomerMasterDAO().updateCustomer(customerMaster);
	}
	
	public String deleteCustomer(int custId) {
		return new CustomerMasterDAO().deleteCustomer(custId);
	}
	
	public List<BadgeMaster>  getBadgeList() {
		return new BadgeMasterDAO().getBadgeList();
	}
	
	public String addBadge(BadgeMaster badgeMaster) {
		return new BadgeMasterDAO().addBadge(badgeMaster);
	}
	
	public String updateBadge(BadgeMaster badgeMaster) {
		return new BadgeMasterDAO().updateBadge(badgeMaster);
	}
	
	public String deleteBadge(int badgeId) {
		return new BadgeMasterDAO().deleteBadge(badgeId);
	}
}
