package com.gamification.api.manager;

import java.util.List;

import org.apache.log4j.Logger;

import com.gamification.api.dao.ActionProcessorDAO;
import com.gamification.api.dao.GamificationApiDAO;
import com.gamification.api.dao.LevelDAO;
import com.gamification.api.dao.RequestValidatorDAO;
import com.gamification.api.view.CustomerTransaction;
import com.gamification.api.view.Level;
import com.gamification.api.view.User;
import com.gamification.api.view.UserGoalPoints;
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
			Level level = new LevelDAO().getMinimumLevel();
			if(level != null) {
				List<String> goalCodeList = getGamificationDAO().getGoalCodeForUserCode(user.getUserCode());
				for(String goalCode : goalCodeList) {
					UserGoalPoints userGoalPoints = new UserGoalPoints();
					userGoalPoints.setUserCode(user.getUserCode());
					userGoalPoints.setGoalCode(goalCode);
					userGoalPoints.setTotalpoints("0");
					userGoalPoints.setReedemedPoints("0");
					userGoalPoints.setGlobalBadgeCode(level.getBadgeCode());
					String userGoalPointsInsertionStatus = new ActionProcessorDAO().putUserGoalPoints(userGoalPoints);
					logger.debug(goalCode+" insertion of userGoalPointsInsertionStatus--->"+userGoalPointsInsertionStatus);
				}
				
			}
			if(onBoardStatus.equals("1")) {
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
	
	

}
