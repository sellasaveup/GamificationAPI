package com.gamification.api.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gamification.api.dao.GamificationApiDAO;
import com.gamification.api.dao.RequestValidatorDAO;
import com.gamification.api.view.BadgeView;
import com.gamification.api.view.ChallengeView;
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
			GamificationApiDAO gamificationDAO = getGamificationDAO();
			userProfile = gamificationDAO.getUserProfile(userCode, goalCode);
			if(userProfile != null) {
				String badgeCode = userProfile.getGlobalBadgeCode();
				if(badgeCode != null) {
					logger.debug("badgeCode-->"+badgeCode);
					BadgeView badgeView = gamificationDAO.getBadge(badgeCode);
					if(badgeView != null) {
						userProfile.setBadgeView(badgeView);
					}
				}
			}
			logger.debug(userProfile);
			
		}
		return userProfile;
	}
	
	public RequestStatus postAction( String userCode, String actionCode) {
		logger.debug("userCode--->"+userCode);
		logger.debug("actionCode--->"+actionCode);
		RequestStatus requestStatus = new APIRequestValidator().doValidatePostAction(userCode, actionCode);
		if(requestStatus == null) {
			
			requestStatus = new ActionProcessor().performAction(userCode, actionCode);
		}
		
		return requestStatus;
	}
	
	public Map<String, Object> getAllTimePoints( String userCode, String goalCode)  {
		logger.debug("Inside getAllTimePoints()");
		logger.debug("userCode--->"+userCode);
		logger.debug("goalCode--->"+goalCode);
		
			Map<String, Object> pointsRequestMap = new HashMap<String, Object>();
			String points = null;
			RequestStatus requestStatus = new APIRequestValidator().doGetPointsRequest(userCode, goalCode);
			if(requestStatus == null) {
				requestStatus = new RequestStatus();
				requestStatus.setIsSuccess("1");
				requestStatus.setCode(userCode);
				requestStatus.setMessage("Points Available for All Time");
				points = getGamificationDAO().getAllTimePoints(userCode, goalCode);
				pointsRequestMap.put("Points", points);
			}
			pointsRequestMap.put("Response", requestStatus);
			return pointsRequestMap;
		}


		public Map<String, Object> getCurrentMonthPoints( String userCode, String goalCode)  {
		logger.debug("Inside getCurrentMonthPoints()");
		logger.debug("userCode--->"+userCode);
		logger.debug("goalCode--->"+goalCode);
		
			Map<String, Object> pointsRequestMap = new HashMap<String, Object>();
			String points = null;
			RequestStatus requestStatus = new APIRequestValidator().doGetPointsRequest(userCode, goalCode);
			if(requestStatus == null) {
				requestStatus = new RequestStatus();
				requestStatus.setIsSuccess("1");
				requestStatus.setCode(userCode);
				requestStatus.setMessage("Points Available for Current Month");
				points = getGamificationDAO().getCurrentMonthPoints(userCode, goalCode);
				pointsRequestMap.put("Points", points);
			}
			pointsRequestMap.put("Response", requestStatus);
			return pointsRequestMap;
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
