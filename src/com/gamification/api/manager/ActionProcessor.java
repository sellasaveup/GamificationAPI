package com.gamification.api.manager;

import java.util.List;

import org.apache.log4j.Logger;

import com.gamification.api.dao.ActionProcessorDAO;
import com.gamification.api.dao.GamificationApiDAO;
import com.gamification.api.view.Challenge;
import com.gamification.api.view.UserAction;
import com.gamification.api.view.UserBadge;
import com.gamification.api.view.UserGoalPoints;
import com.gamification.api.view.UserReward;
import com.gamification.common.RequestStatus;

public class ActionProcessor {
	final static Logger logger = Logger.getLogger(ActionProcessor.class);
	
	public RequestStatus performAction(String userCode, String actionCode) {
		RequestStatus requestStatus = new RequestStatus();
		Challenge challenge = getChallenge(actionCode);
		if(challenge != null) {
			logger.debug("challenge available");
			int occurrence = challenge.getOccurrence();
			logger.debug("occurrence-->"+occurrence);
			if(occurrence == 0) {
				logger.debug("No occurrence maintained or 0 occurrence, So performing proper transaction");
				performTransactions(challenge, userCode);
			} else if(occurrence >0){
				List<UserAction> userActionList = getUserAction(userCode,actionCode);
				logger.debug("userActionList Size-->"+userActionList.size());
				if(userActionList.isEmpty()) {
					logger.debug("No Previous occurrence in DB preforming 0 Transaction");
					UserAction userAction = new UserAction();
					userAction.setGoalCode(challenge.getGoalCode());
					userAction.setUserCode(userCode);
					userAction.setActionCode(actionCode);
					userAction.setPoints(0);
					userAction.setStatus("ACTIVE");
					String postStatus = postUserAction(userAction);
					if(postStatus.equals("0")) {
						requestStatus.setIsSuccess("0");
						requestStatus.setCode(userCode);
						requestStatus.setMessage("UserAction transaction failed");
					}
				} else if(userActionList.size() < (occurrence-1)) {
					logger.debug("No Previous occurrences lesser than challenge occurrence so 0 transaction");
					UserAction userAction = new UserAction();
					userAction.setGoalCode(challenge.getGoalCode());
					userAction.setUserCode(userCode);
					userAction.setActionCode(actionCode);
					userAction.setPoints(0);
					userAction.setStatus("ACTIVE");
					String postStatus = postUserAction(userAction);
					if(postStatus.equals("0")) {
						requestStatus.setIsSuccess("0");
						requestStatus.setCode(userCode);
						requestStatus.setMessage("UserAction transaction failed");
					}
				} else if(userActionList.size() == (occurrence-1)) {
					logger.debug("Previous occurrences equal to challenge occurrence so performing non 0 transaction");
					requestStatus = performTransactions(challenge, userCode);
				}
			}
			
			if(requestStatus.getIsSuccess().equals("1")) {
				logger.debug("All the transactions are succesful and So performing user Goal Points");
				//UserGoalPoints userGoalPoints = getUserGoalPoints(userCode,goalCode);
			}
		} else {
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(userCode);
			requestStatus.setMessage("Challenge Not Available");
		}
		
		
		return requestStatus;
	}
	
	private RequestStatus performTransactions(Challenge challenge, String userCode) {
		logger.debug("performTransactions()");
		RequestStatus requestStatus = new RequestStatus();
		requestStatus.setIsSuccess("1");
		requestStatus.setCode(userCode);
		requestStatus.setMessage("Transactions Performed Succesfully");
		UserAction userAction = new UserAction();
		userAction.setGoalCode(challenge.getGoalCode());
		userAction.setUserCode(userCode);
		userAction.setActionCode(challenge.getActionCode());
		userAction.setPoints(challenge.getPoints());
		userAction.setStatus("ACTIVE");
		logger.debug(userAction);
		String postUserStatus = postUserAction(userAction);
		logger.debug("postUserStatus-->"+postUserStatus);
		if(postUserStatus.equals("1")) {
			
			if(challenge.getPoints() > 0) {
				logger.debug("User action succesful going to put UserGoalPoints");
				String postUserGoalPointsStatus = updateUserGoalPoints(userCode, challenge.getGoalCode(), challenge.getPoints());
				logger.debug("postUserGoalPointsStatus-->"+postUserGoalPointsStatus);
			}
			
			logger.debug("postUserStatus success going to put badge transaction");
			String badgeCode = challenge.getBadgeCode();
			if(badgeCode != null) {
				logger.debug("Badge available for this challenge "+challenge.getActionCode());
				UserBadge userBadge = new UserBadge();
				userBadge.setBadgeCode(badgeCode);
				userBadge.setGoalCode(challenge.getGoalCode());
				userBadge.setUserCode(userCode);
				userBadge.setStatus("ACTIVE");
				logger.debug(userBadge);
				String postUserBadgeStatus = postUserBadge(userBadge);
				logger.debug("postUserBadgeStatus-->"+postUserBadgeStatus);
				if(postUserBadgeStatus.equals("1")) {
					logger.debug("User Reward Available for this challenge "+challenge.getActionCode());
					String rewardCode = challenge.getRewardCode();
					if(rewardCode != null) {
						UserReward userReward = new UserReward();
						userReward.setRewardCode(rewardCode);
						userReward.setGoalCode(challenge.getGoalCode());
						userReward.setUserCode(userCode);
						userReward.setRedeemPoints(0);
						userReward.setRedeemStatus("NO");
						logger.debug(userReward);
						String postUserRewardStatus = postUserReward(userReward);
						logger.debug("postUserRewardStatus-->"+postUserRewardStatus);
						if(postUserRewardStatus.equals("0")) {
							logger.debug("User Reward post failed");
							requestStatus = getErrorRequestStatus(userCode, "Post User Reward failure");
						}
					}
				} else {
					requestStatus = getErrorRequestStatus(userCode, "Post User Badge failure");
				}
			}
		} else {
			requestStatus = getErrorRequestStatus(userCode, "Post User Action failure");
		}

		return requestStatus;
	}
	
	private String updateUserGoalPoints(String userCode, String goalCode, int points) {
		UserGoalPoints userGoalPoints = getActionProcessorDAO().getUserGoalpoints(userCode, goalCode);
		if(userGoalPoints != null) {
			logger.debug("userGoalPoints.getTotalpoints()-->"+userGoalPoints.getTotalpoints());
			logger.debug("Challenge Points-->"+userGoalPoints.getTotalpoints());
			int totalpoints = userGoalPoints.getTotalpoints() + points;
			logger.debug("totalpoints-->"+totalpoints);
			userGoalPoints.setTotalpoints(totalpoints);
			String updateUserGoalPoints = updateUserGoalPoints(userGoalPoints);
			if(updateUserGoalPoints.equals("1")) {
				logger.debug("Update user Goal Points success, Going to check level promotion");
			}
		}
		return null;
	}
	private Challenge getChallenge(String actionCode) {
		return getGamificationApiDAO().getChallenge(actionCode);
	}
	
	private List<UserAction> getUserAction(String userCode, String actionCode) {
		return getGamificationApiDAO().getUserAction(userCode, actionCode);
	}
	
	private String postUserAction(UserAction userAction) {
		return getGamificationApiDAO().postUserAction(userAction);
	}
	
	private String postUserBadge(UserBadge userBadge) {
		return getGamificationApiDAO().postUserBadge(userBadge);
	}
	
	private String postUserReward(UserReward userReward) {
		return getGamificationApiDAO().postUserReward(userReward);
	}
	
	private String updateUserGoalPoints(UserGoalPoints userGoalPoints) {
		return getGamificationApiDAO().updateUserGoalPoints(userGoalPoints);
	}
	private RequestStatus getErrorRequestStatus(String code, String message) {
		RequestStatus requestStatus = new RequestStatus();
		requestStatus.setIsSuccess("0");
		requestStatus.setCode(code);
		requestStatus.setMessage(message);
		return requestStatus;
	}
	private GamificationApiDAO getGamificationApiDAO() {
		return new GamificationApiDAO();
	}
	
	private ActionProcessorDAO getActionProcessorDAO() {
		return new ActionProcessorDAO();
	}
}
