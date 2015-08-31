package com.gamification.api.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gamification.api.dao.GamificationApiDAO;
import com.gamification.api.dao.GraphDAO;
import com.gamification.api.dao.RequestValidatorDAO;
import com.gamification.api.dao.ServiceApiDAO;
import com.gamification.api.view.BadgeView;
import com.gamification.api.view.ChallengeView;
import com.gamification.api.view.GoalView;
import com.gamification.api.view.LeaderBoardPageView;
import com.gamification.api.view.LevelView;
import com.gamification.api.view.PointsLineChart;
import com.gamification.api.view.RewardView;
import com.gamification.api.view.User;
import com.gamification.api.view.UserBadge;
import com.gamification.api.view.UserPointsPageView;
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
			
	public String getPerformedActivities() {
		logger.debug("getPerformedActivities()");
			return getServiceApiDAO().getPerformedActivities();
	}
	
	public String getUnlockedBadgeCount() {
		logger.debug("getUnlockedBadgeCount()");
			return getServiceApiDAO().getUnlockedBadgeCount();
	}
	
	public String getEngagedUserCount() {
		logger.debug("getEngagedUserCount()");
			return getServiceApiDAO().getEngagedUserCount();
	}
	
	public String getLatestAction() {
		logger.debug("getLatestAction()");
			return getServiceApiDAO().getLatestAction();
	}
	public String getLatestBadgeActivity() {
		logger.debug("getLatestBadgeActivity()");
			return getServiceApiDAO().getLatestBadgeActivity();
	}
	
	public String getLatestReedemActivity() {
		logger.debug("getLatestReedemActivity()");
			return getServiceApiDAO().getLatestReedemActivity();
	}
	
	public String getLatestRewardActivity() {
		logger.debug("getLatestRewardActivity()");
			return getServiceApiDAO().getLatestRewardActivity();
	}
	
	public String getLatestLevelActivity() {
		logger.debug("getLatestLevelActivity()");
			return getServiceApiDAO().getLatestLevelActivity();
	}
	
	public String getLatestUserActivity() {
		logger.debug("getLatestUserActivity()");
			return getServiceApiDAO().getLatestUserActivity();
	}
	
	public RequestStatus awardBadge(String userCode, String badgeCode, String goalCode) {
		logger.debug("getLatestLevelActivity()");
		logger.debug("userCode-->"+userCode);
		logger.debug("badgeCode-->"+badgeCode);
		logger.debug("goalCode-->"+goalCode);
		
		RequestStatus requestStatus = new APIRequestValidator().doGetPointsRequest(userCode, goalCode);
		if(requestStatus == null) {
			String postStatus = getServiceApiDAO().postUserBadge(userCode, badgeCode, goalCode);
			if(postStatus.equals("1")) {
				requestStatus = new RequestStatus();
				requestStatus.setIsSuccess("1");
				requestStatus.setCode(userCode);
				requestStatus.setMessage("Badge Awarded Succesfully");
			} else {
				requestStatus = new RequestStatus();
				requestStatus.setIsSuccess("1");
				requestStatus.setCode(userCode);
				requestStatus.setMessage("Badge Award Failed");
			}
		}
		
		return requestStatus;
	}
	
	public Collection<ChallengeView> retrieveChallengesByGoalCode(ChallengeView challengeView) {
		logger.debug("retrieveChallengesByGoalCode challenge"+ challengeView);
		return getGamificationDAO().getChalByGoal(challengeView);
	}
	public Collection<LevelView> retrieveLevelsByGoalCode(LevelView levelView) {
		logger.debug("retrieveLevelsByGoalCode level"+ levelView);
		return getGamificationDAO().getLevelsByGoal(levelView);
	}
	
	public List<LeaderBoardPageView> getLeaderBoard(String goalCode, String requestType) {
		List<LeaderBoardPageView> customerMasterList = null;
		GamificationApiDAO gamificationApiDAO = getGamificationDAO();
		if(requestType.equals("A")) {
			customerMasterList = gamificationApiDAO.getOverAllLeaderBoard( goalCode);
		} else if(requestType.equals("M")) {
			customerMasterList = gamificationApiDAO.getCurrentMonthLeaderBoard(goalCode);
		}
		System.out.println("customerMasterList-->"+customerMasterList);
		return customerMasterList;
	}
	
	
	public List<BadgeView> getMyBadgeList( String userCode, String goalCode) {
		logger.debug(" getMyBadgeList list userCode--->"+userCode);
		logger.debug("actionCode--->"+goalCode);
			
		List<BadgeView> list = getGamificationDAO().getMyBadgeList(userCode, goalCode);
		
		return list;
	}
	
	public List<BadgeView> getMyLockedBadgeList( String userCode, String goalCode) {
		logger.debug(" getMyLockedBadgeList list userCode--->"+userCode);
		logger.debug("actionCode--->"+goalCode);
			
		List<BadgeView> list = getGamificationDAO().getMyLockedBadgeList(userCode, goalCode);
		
		return list;
	}
	
	
	public List<UserBadge> getAllMyBadgeList( String userCode, String goalCode) {
		logger.debug(" badge list userCode--->"+userCode);
		logger.debug("actionCode--->"+goalCode);
			
		List<UserBadge> list = getGamificationDAO().getAllMyBadgeList(userCode, goalCode);
		
		return list;
	}
	
	public List<GoalView> getAllMyGoalList( String userCode) {
		logger.debug(" getAllMyGoalList list userCode--->"+userCode);
			
		List<GoalView> list = getGamificationDAO().getAllMyGoalList(userCode);
		
		return list;
	}
	
	public List<UserPointsPageView> getAllPointsDetails( String userCode, String goalCode) {
		logger.debug("points detail poiuserCode--->"+userCode);
		logger.debug("actionCode--->"+goalCode);
			
		List<UserPointsPageView> list = getGamificationDAO().getAllPointsInfo(userCode, goalCode);
		return list;
	}
	
	public List<RewardView> getMyRewardList( String userCode, String goalCode) {
		logger.debug(" badge list userCode--->"+userCode);
		logger.debug("actionCode--->"+goalCode);
			
		List<RewardView> list = getGamificationDAO().getMyRewardList(userCode, goalCode);
		
		return list;
	}	
	private GamificationApiDAO getGamificationDAO() {
		return new GamificationApiDAO();
	}
	
	private ServiceApiDAO getServiceApiDAO() {
		return new ServiceApiDAO();
	}
	
	public String getAllTimeRank( String userCode, String goalCode)  {
		logger.debug("Inside getAllTimeRank()");
		logger.debug("userCode--->"+userCode);
		logger.debug("goalCode--->"+goalCode);
		return getGamificationDAO().getAllTimeRank(userCode, goalCode);
	}


	public String getCurrentMonthRank( String userCode, String goalCode)  {
		logger.debug("Inside getCurrentMonthRank()");
		logger.debug("userCode--->"+userCode);
		logger.debug("goalCode--->"+goalCode);
	
		return getGamificationDAO().getCurrentMonthRank(userCode, goalCode);
	}
	
	public List<User> getUser( String code, String requestType) {
		logger.debug("code--->"+code);
		logger.debug("requestType--->"+requestType);
			
		List<User> userList = null;
		String query = null;
		
		if(requestType != null && requestType.equals("GOAL")) {
			logger.debug("Hype goal");
			query = "select * from ss_ma_user where user_type in (select user_type  from ss_ma_goal where  goal_code =?)";
		} else {
			query = "select * from ss_ma_user where user_type in (select user_type_code  from ss_ma_user_type where  user_type_code =?)";
		}
		logger.debug("code--->"+code);
		logger.debug("query--->"+query);
		
		userList = getServiceApiDAO().getUser(code, query);		
				
		return userList;
	}
	public PointsLineChart getMyPointsLineChart( String userCode, String goalCode) {
		logger.debug(" badge list userCode--->"+userCode);
		logger.debug("actionCode--->"+goalCode);
			
		PointsLineChart chart = getGraphDAO().getMyPointsLineChart(userCode, goalCode);
		
		return chart;
	}	
	private GraphDAO getGraphDAO() {
		return new GraphDAO();
	}

}
