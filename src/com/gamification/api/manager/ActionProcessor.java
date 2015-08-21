package com.gamification.api.manager;

import java.util.List;

import org.apache.log4j.Logger;

import com.gamification.api.dao.ActionProcessorDAO;
import com.gamification.api.dao.GamificationApiDAO;
import com.gamification.api.dao.LevelDAO;
import com.gamification.api.view.Challenge;
import com.gamification.api.view.Level;
import com.gamification.api.view.UserAction;
import com.gamification.api.view.UserBadge;
import com.gamification.api.view.UserGoalPoints;
import com.gamification.api.view.UserLevel;
import com.gamification.api.view.UserReward;
import com.gamification.common.RequestStatus;

public class ActionProcessor {
	final static Logger logger = Logger.getLogger(ActionProcessor.class);
	
	public RequestStatus performAction(String userCode, String actionCode) {
		RequestStatus requestStatus = new RequestStatus();
		requestStatus.setIsSuccess("1");
		requestStatus.setCode(userCode);
		requestStatus.setMessage("Post Action Transaction Succesful");
		Challenge challenge = getChallenge(actionCode);
		if(challenge != null) {
			logger.debug("challenge available");
			UserGoalPoints userGoalPoints = getActionProcessorDAO().getUserGoalpoints(userCode, challenge.getGoalCode());
			logger.debug("userGoalPoints-->"+userGoalPoints);
			if(userGoalPoints == null) {
				logger.debug("userGoalPoints zero entry is not available , Going to insert");
				String putUserGoalPointsStatus = putUserGoalPoints(userCode, 0);
				logger.debug("putUserGoalPointsStatus--->"+putUserGoalPointsStatus);
			}
			
			int occurrence = challenge.getOccurrence();
			logger.debug("occurrence-->"+occurrence);
			if(occurrence == 0) {
				logger.debug("No occurrence maintained or 0 occurrence, So performing proper transaction");
				performTransactions(challenge, userCode);
			} else if(occurrence >0 && occurrence != 1){
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
					} else {
						requestStatus.setIsSuccess("1");
						requestStatus.setCode(userCode);
						requestStatus.setMessage("Zero Points Transaction Succesful");
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
			} else {
				logger.debug("No Previous action available but occurrence is one SO perforing transaction");
				requestStatus = performTransactions(challenge, userCode);
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
				if(postUserGoalPointsStatus.equals("1")) {
					
				} else {
					requestStatus = getErrorRequestStatus(userCode, "Post User Goal Points failure");
					logger.debug("**********Post user Goal Points failure************");
				}
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
					
					String rewardCode = challenge.getRewardCode();
					if(rewardCode != null) {
						logger.debug("User Reward Available for this challenge "+challenge.getActionCode());
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
							logger.debug("**********Post user reward failure************");
						}
					}
				} else {
					requestStatus = getErrorRequestStatus(userCode, "Post User Badge failure");
					logger.debug("**********Post user badge  failure************");
				}
			}
		} else {
			requestStatus = getErrorRequestStatus(userCode, "Post User Action failure");
			logger.debug("**********Post user Action  failure************");
		}

		return requestStatus;
	}
	
	private String updateUserGoalPoints(String userCode, String goalCode, int points) {
		String returnStatus = "1";
		UserGoalPoints userGoalPoints = getActionProcessorDAO().getUserGoalpoints(userCode, goalCode);
		if(userGoalPoints != null) {
			logger.debug(userGoalPoints);
			logger.debug("userGoalPoints.getTotalpoints()-->"+userGoalPoints.getTotalpoints());
			logger.debug("Challenge Points-->"+points);
			int totalpoints = userGoalPoints.getTotalpoints() + points;
			logger.debug("totalpoints-->"+totalpoints);
			userGoalPoints.setTotalpoints(totalpoints);
			String updateUserGoalPoints = updateUserGoalPoints(userGoalPoints);
			if(updateUserGoalPoints.equals("1")) {
				logger.debug("Update user Goal Points success, Going to check level promotion");
				List<Level> levelList = getLevelList(goalCode, totalpoints);
				for(Level level : levelList) {
					logger.debug("Putting level transaction for-->"+level.getLevelCode());
					UserLevel userLevel = new UserLevel();
					userLevel.setLevelCode(level.getLevelCode());
					userLevel.setUserCode(userCode);
					userLevel.setGoalCode(goalCode);
					userLevel.setBadgeCode(level.getBadgeCode());
					userLevel.setPriority(level.getPriority());
					logger.debug(userLevel);
					String postUserLevelStatus = postUserLevel(userLevel);
					logger.debug("postUserLevelStatus-->"+postUserLevelStatus);
					if(postUserLevelStatus.equals("1")) {
						if(level.getBadgeCode() != null) {
							logger.debug("Badge available for this level-->"+level.getLevelCode());
							UserBadge userBadge =new UserBadge();
							userBadge.setBadgeCode(level.getBadgeCode());
							userBadge.setGoalCode(goalCode);
							userBadge.setUserCode(userCode);
							userBadge.setStatus("ACTIVE");
							logger.debug(userBadge);
							String postUserBadge = postUserBadge(userBadge);
							logger.debug("postUserBadge for level status-->"+postUserBadge);
							if(postUserBadge.equals("1")) {
								if(level.getRewardCode() != null) {
									logger.debug("reward is available for this level-->"+level.getLevelCode());
									UserReward userReward = new UserReward();
									userReward.setRewardCode(level.getRewardCode());
									userReward.setGoalCode(goalCode);
									userReward.setUserCode(userCode);
									userReward.setRedeemStatus("NO");
									logger.debug(userReward);
									String postUserRewardStatus = postUserReward(userReward);
									logger.debug("postUserRewardLevelStatus-->"+postUserRewardStatus);
									if(postUserRewardStatus.equals("0")) {
										logger.debug("************failed in postUserReward************");
										returnStatus = "0";
									}
								}
							} else {
								logger.debug("***************failed in postUserBadge*************");
								returnStatus = "0";
							}
						}
					} else {
						logger.debug("**************UserLevel Failed for this user-->"+userCode);
						returnStatus = "0";
					}
				}
			} else {
				logger.debug("***************failed in UserGoalPoints");
				returnStatus = "0";
			}
		} else {
			logger.debug("******************UserGoalPoints not available for this user-->"+userCode);
			returnStatus = "0";
		}
		return returnStatus;
	}
	
	
	public String putUserGoalPoints(String userCode, int points) {
		String userGoalPointsInsertionStatus = "0";
		Level level = new LevelDAO().getMinimumLevel();
		if(level != null) {
			List<String> goalCodeList = getGamificationApiDAO().getGoalCodeForUserCode(userCode);
			for(String goalCode : goalCodeList) {
				UserGoalPoints userGoalPoints = new UserGoalPoints();
				userGoalPoints.setUserCode(userCode);
				userGoalPoints.setGoalCode(goalCode);
				userGoalPoints.setTotalpoints(0);
				userGoalPoints.setReedemedPoints(0);
				userGoalPoints.setGlobalBadgeCode(level.getBadgeCode());
				userGoalPointsInsertionStatus = new ActionProcessorDAO().putUserGoalPoints(userGoalPoints);
				logger.debug(goalCode+" insertion of userGoalPointsInsertionStatus--->"+userGoalPointsInsertionStatus);
			}
			
		}
		return userGoalPointsInsertionStatus;
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
	
	private List<Level> getLevelList(String goalCode, int points) {
		return getActionProcessorDAO().getLevelList(goalCode, points);
	}
	
	private String postUserLevel(UserLevel userLevel) {
		return getGamificationApiDAO().postUserLevel(userLevel);
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
