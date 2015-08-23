package com.gamification.api.manager;

import java.util.Collection;

import org.apache.log4j.Logger;

import com.gamification.api.dao.GamificationApiDAO;
import com.gamification.api.dao.RequestValidatorDAO;
import com.gamification.api.view.ChallengeView;
import com.gamification.api.view.CustomerTransaction;
import com.gamification.api.view.LevelView;
import com.gamification.api.view.User;
import com.gamification.api.view.UserProfile;
import com.gamification.common.RequestStatus;


public class APIManager {
	final static Logger logger = Logger.getLogger(APIManager.class);
	
	public RequestStatus onboardUser( User user) {
		logger.debug("Inside APIManager.onboardUser()");
		RequestStatus requestStatus = null;
		user.setStatus("ACTIVE");
		logger.debug("user--->"+user);
		
		requestStatus = new APIRequestValidator().doValidateOnboardUser(user);
		
		if(requestStatus == null) {
			logger.debug("Validation Success Going to presist in DB");
			requestStatus = new RequestStatus();
			String onBoardStatus = getGamificationDAO().putUser(user);
			
			if(onBoardStatus.equals("1")) {
				String putUserGoalPointsSTatus = new ActionProcessor().putUserGoalPoints(user.getUserCode(),0);
				logger.debug("*************putUserGoalPointsSTatus-->"+putUserGoalPointsSTatus);
				requestStatus.setIsSuccess("1");
				requestStatus.setCode(user.getUserCode());
				requestStatus.setMessage("Onboarded Successfully");
			} else {
				requestStatus.setIsSuccess("0");
				requestStatus.setCode(user.getUserCode());
				requestStatus.setMessage("Techinical Error");
			}
		}
		logger.debug("requestStatus--->"+requestStatus);
		return requestStatus;
	}
	
	
	public UserProfile getProfile( String userCode, String goalCode) {
		
		UserProfile userProfile = null;
		if(new RequestValidatorDAO().getUserCode(userCode) != null) {
			logger.debug("userCode available in DB Going to Fetch Profile");
			userProfile = getGamificationDAO().getUserProfile(userCode, goalCode);
		}
		return userProfile;
	}
	
	public RequestStatus postAction( String userCode, String actionCode) {
		logger.debug("userCode--->"+userCode);
		logger.debug("actionCode--->"+actionCode);
		RequestStatus requestStatus = new APIRequestValidator().dovalidatePostAction(userCode, actionCode);
		if(requestStatus == null) {
			
			requestStatus = new ActionProcessor().performAction(userCode, actionCode);
		}
		
		return requestStatus;
	}
	
	private CustomerTransaction getCustomerTransaction() {
		return new CustomerTransaction();
	}
	private GamificationApiDAO getGamificationDAO() {
		return new GamificationApiDAO();
	}
	
	public Collection<ChallengeView> retrieveChallengesByGoalCode(ChallengeView challengeView) {
		logger.debug("retrieveChallengesByGoalCode challenge"+ challengeView);
		return getGamificationDAO().getChalByGoal(challengeView);
	}
	public Collection<LevelView> retrieveLevelsByGoalCode(LevelView levelView) {
		logger.debug("retrieveLevelsByGoalCode level"+ levelView);
		return getGamificationDAO().getLevelsByGoal(levelView);
	}

}
