package com.gamification.api.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.gamification.api.manager.APIManager;
import com.gamification.api.manager.NotificationManager;
import com.gamification.api.view.ChallengeView;
import com.gamification.api.view.CustomerMaster;
import com.gamification.api.view.LevelView;
import com.gamification.api.view.Notification;
import com.gamification.api.view.User;
import com.gamification.api.view.UserProfile;
import com.gamification.common.JsonGenerator;
import com.gamification.common.RequestStatus;
import com.gamification.common.Result;


@Path("/api")
public class APIController {
	final static Logger logger = Logger.getLogger(APIController.class);
	
	@GET
	@Path("/ONBOARD_USER")
	@Produces(MediaType.APPLICATION_JSON)
	public Response onboardUser(@QueryParam("userCode") String userCode, @QueryParam("name") String name, @QueryParam("nickName") String nickName,
							    @QueryParam("image") String image, @QueryParam("userType") String userType) {
		logger.debug("Inside ONBOARD_USER Service");
		User user = new User();
		HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		user.setUserCode(userCode);
		user.setName(name);
		user.setNickName(nickName);
		user.setImage(image);
		user.setUserType(userType);
		RequestStatus requestStatus = getAPIManager().onboardUser(user);
		jsonRoot.put("Response", requestStatus);
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
		

	}
	
	
	@GET
	@Path("/GET_PROFILE")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProfile(@QueryParam("userCode") String userCode, @QueryParam("goalCode") String goalCode) {
		logger.debug("*Inside GET_PROFILE Service");
		
		    HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		    UserProfile userProfile = getAPIManager().getProfile(userCode, goalCode);
			if(userProfile != null) {
				jsonRoot.put("Response", userProfile);
			}
			else {
				RequestStatus requestStatus = new RequestStatus();
				requestStatus.setIsSuccess("0");
				requestStatus.setCode(userCode);
				requestStatus.setMessage("Profile Not Available");
				jsonRoot.put("Response", requestStatus);
			}
			
			return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
	}
	
	@GET
	@Path("/POST_ACTION")
	@Produces(MediaType.APPLICATION_JSON)
	public Response postAction(@QueryParam("userCode") String userCode, @QueryParam("actionCode") String actionCode) {
		logger.debug("Inside POST_ACTION Service");
		
		    HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		    RequestStatus requestStatus = getAPIManager().postAction(userCode, actionCode);
		    jsonRoot.put("Response", requestStatus);
			return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
	}
	
	
	@GET
	@Path("/GET_ALL_POINTS")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTimePoints(@QueryParam("userCode") String userCode, @QueryParam("goalCode") String goalCode) {
		logger.debug("Inside GET_POINTS Service");
		Map<String, Object> jsonRoot = getAPIManager().getAllTimePoints(userCode, goalCode);
		logger.debug("jsonRoot2-->"+jsonRoot);
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
	}
	
	@GET
	@Path("/GET_MONTH_POINTS")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCurrentMonthPoints(@QueryParam("userCode") String userCode, @QueryParam("goalCode") String goalCode) {
		logger.debug("Inside GET_MONTH_POINTS Service");
		Map<String, Object> jsonRoot = getAPIManager().getAllTimePoints(userCode, goalCode);
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
	}
	
	
	@GET
	@Path("/GET_PERFORMED_ACTIVITIES_COUNT")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPerformedActivities() {
		logger.debug("GET_PERFORMED_ACTIVITIES_COUNT");
		Map<String, Object> jsonRoot = new HashMap<String, Object>();
		String performedActivitiesCount = getAPIManager().getPerformedActivities();
		if(performedActivitiesCount == null) {
			performedActivitiesCount = "0";
		}
		performedActivitiesCount = "500";
		jsonRoot.put("performedActivitiesCount", performedActivitiesCount);
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
	}
	
	@GET
	@Path("/GET_UNLOCKED_BADGE_COUNT")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUnlockedBadgeCount() {
		logger.debug("GET_UNLOCKED_BADGE_COUNT");
		Map<String, Object> jsonRoot = new HashMap<String, Object>();
		String unlockedBadgeCount = getAPIManager().getUnlockedBadgeCount();
		if(unlockedBadgeCount == null) {
			unlockedBadgeCount = "0";
		}
		unlockedBadgeCount = "50";
		jsonRoot.put("unlockedBadgeCount", unlockedBadgeCount);
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
	}
	
	@GET
	@Path("/GET_ENGAGED_USER_COUNT")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEngagedUserCount() {
		logger.debug("GET_ENGAGED_USER_COUNT");
		Map<String, Object> jsonRoot = new HashMap<String, Object>();
		String engagedUserCount = getAPIManager().getEngagedUserCount();
		if(engagedUserCount == null) {
			engagedUserCount = "0";
		}
		engagedUserCount = "200";
		jsonRoot.put("engagedUserCount", engagedUserCount);
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
	}
	
	@GET
	@Path("/GET_LATEST_ACTION")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLatestAction() {
		logger.debug("GET_LATEST_ACTION");
		Map<String, Object> jsonRoot = new HashMap<String, Object>();
		String latestAction = getAPIManager().getLatestAction();
		if(latestAction == null) {
			latestAction = "#";
		}
		jsonRoot.put("latestAction", latestAction);
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
	  } 
	
	@GET
	@Path("/GET_LATEST_BADGE")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLatestBadgeActivity() {
		logger.debug("GET_LATEST_BADGE");
		Map<String, Object> jsonRoot = new HashMap<String, Object>();
		String latestBadgeAction = getAPIManager().getLatestBadgeActivity();
		if(latestBadgeAction == null) {
			latestBadgeAction = "#";
		}
		jsonRoot.put("latestBadgeAction", latestBadgeAction);
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
	  } 
	
	@GET
	@Path("/GET_LATEST_REDEEM")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLatestReedemActivity() {
		logger.debug("GET_LATEST_REDEEM");
		Map<String, Object> jsonRoot = new HashMap<String, Object>();
		String latestRedeemAction = getAPIManager().getLatestReedemActivity();
		if(latestRedeemAction == null) {
			latestRedeemAction = "#";
		}
		jsonRoot.put("latestRedeemAction", latestRedeemAction);
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
	  } 
	
	@GET
	@Path("/GET_LATEST_REWARD")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLatestRewardActivity() {
		logger.debug("GET_LATEST_REWARD");
		Map<String, Object> jsonRoot = new HashMap<String, Object>();
		String latestRewardAction = getAPIManager().getLatestRewardActivity();
		if(latestRewardAction == null) {
			latestRewardAction = "#";
		}
		jsonRoot.put("latestRewardAction", latestRewardAction);
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
	  } 
	
	@GET
	@Path("/GET_LATEST_LEVEL")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLatestLevelActivity() {
		logger.debug("GET_LATEST_LEVEL");
		Map<String, Object> jsonRoot = new HashMap<String, Object>();
		String latestlevelAction = getAPIManager().getLatestLevelActivity();
		if(latestlevelAction == null) {
			latestlevelAction = "#";
		}
		jsonRoot.put("latestlevelAction", latestlevelAction);
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
	  } 
	
	@GET
	@Path("/GET_LATEST_USER")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLatestUserActivity() {
		logger.debug("GET_LATEST_USER");
		Map<String, Object> jsonRoot = new HashMap<String, Object>();
		String latestUserAction = getAPIManager().getLatestUserActivity();
		if(latestUserAction == null) {
			latestUserAction = "#";
		}
		jsonRoot.put("latestUserAction", latestUserAction);
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
	  } 
	
	
	@GET
	@Path("/REDUCE_USER_POINT")
	@Produces(MediaType.APPLICATION_JSON)
	public Response redeemPoint(@QueryParam("custId") String custId, @QueryParam("rewardId") String rewardId) {
		 HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		if (custId != null && !custId.equals("") && rewardId != null && !rewardId.equals("")) {
			String status = null;//getAPIManager().redeemPoint(custId, rewardId);
			jsonRoot.put("status", status);
			jsonRoot.put("custId", custId);
			return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}
	}
	
	
	
	@GET
	@Path("/GET_BADGE")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBadge(@QueryParam("custId") String custId) {
		HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		if (custId != null && !custId.equals("")) {
			//List<BadgeMaster> badgeMasterList = getAPIManager().getBadge(custId);
			
			if(null != null) {
				jsonRoot.put("Result", null);
			}
			else {
				
				jsonRoot.put("Result", new Result(0, Integer.parseInt(custId), "Customer Not Available"));
			}
			
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}
	}

	@GET
	@Path("/AWARD_BADGE")
	@Produces(MediaType.APPLICATION_JSON)
	public Response awardBadge(@QueryParam("custId") String custId, @QueryParam("badgeId") String badgeId,
			@QueryParam("activity") String activity) {
		HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		if (custId != null && !custId.equals("") && badgeId != null && !badgeId.equals("")) {
			String status = null;//getAPIManager().awardBadge(custId, badgeId, activity);
			jsonRoot.put("status", status);
			jsonRoot.put("custId", custId);
			return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
		} else {
			jsonRoot.put("status", "0");
			return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
		}
	}

	@GET
	@Path("/REMOVE_BADGE")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeBadge(@QueryParam("custId") String custId, @QueryParam("badgeId") String badgeId) {
		HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		if (custId != null && !custId.equals("") && badgeId != null && !badgeId.equals("")) {
			String status = null;//getAPIManager().removeBadge(custId, badgeId);
			jsonRoot.put("status", status);
			jsonRoot.put("custId", custId);
			return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}
	}
	
	@GET
	@Path("/GET_RANK")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRank(@QueryParam("custId") String custId, @QueryParam("requestType") String requestType) {
		System.out.println("Inside getRank");
		    HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		    if(custId != null && !custId.equals("") && requestType != null) {
		    	String rank = null;//getAPIManager().getRank(custId, requestType);
				if(rank != null) {
					jsonRoot.put("status", "1");
					jsonRoot.put("rank", rank);
					jsonRoot.put("custId", custId);
				} else {
					jsonRoot.put("status", "0");
					jsonRoot.put("custId", custId);
				}
		    } else {
		    	jsonRoot.put("status", "0");
		    }
			
			return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
	}
	
	
	@GET
	@Path("/GET_LEADERBOARD")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLeaderBoard(@QueryParam("custId") String custId, @QueryParam("requestType") String requestType) {
		HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		if (custId != null && !custId.equals("") && requestType != null) {
			List<CustomerMaster> customerMasterList = null;// getAPIManager().getLeaderBoard(custId, requestType);
			
			if(!customerMasterList.isEmpty()) {
				jsonRoot.put("Result", customerMasterList);
			}
			else {
				
				jsonRoot.put("Result", new Result(0, Integer.parseInt(custId), "Leader Board Not Available"));
			}
			
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}
	}
	
	@GET
	@Path("/GET_ALL_BADGE")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBadge(@QueryParam("custId") String custId) {
		HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		if (custId != null && !custId.equals("")) {
			 //List<BadgeMaster> badgeMasterList = getAPIManager().getAllBadge(custId);

			
			
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}
	}
	
	@GET
	@Path("/GET_CHALLENGES")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getChallenges(@QueryParam("custId") String custId) {
		HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		if (custId != null && !custId.equals("")) {
			 
			
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}
	}
	
	@GET
	@Path("/GET_ALL_REWARD")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllReward(@QueryParam("custId") String custId) {
		HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		if (custId != null && !custId.equals("")) {
			
			
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}
	}
	
	@GET
	@Path("/GET_REWARD")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReward(@QueryParam("custId") String custId) {
		HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		if (custId != null && !custId.equals("")) {
			
			
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}
	}
	
	@GET
	@Path("/PUSH_NOTIFICATION")
	@Produces(MediaType.APPLICATION_JSON)
	public Response pushNotification(@QueryParam("notificationType") String notificationType, @QueryParam("target") String target,
									 @QueryParam("message") String message, @QueryParam("imageUrl") String imageUrl,
									 @QueryParam("userCode") String userCode, @QueryParam("userType") String userType,
									 @QueryParam("goalCode") String goalCode) {
		logger.debug("Inside PUSH_NOTIFICATION Service");
		Map<String, Object> jsonRoot = new HashMap<String, Object>();
		
			Notification notification = new Notification();
			notification.setNotificationType(notificationType);
			notification.setTarget(target);
			notification.setMessage(message);
			notification.setImageUrl(imageUrl);
			notification.setUserType(userType);
			notification.setUserCode(userCode);
			notification.setGoalCode(goalCode);
			RequestStatus requestStatus = new NotificationManager().pushNotification(notification);
			jsonRoot.put("Response", requestStatus);
			return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
		
	}
	

	
	private APIManager getAPIManager() {
		return new APIManager();
	}
	
	private JsonGenerator getJsonGenerator() {
		return new JsonGenerator();
	}
	
	@GET
	@Path("/GETCHALLENGESBYGOAL")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getChallengesByGoal(@QueryParam("goalCode") String goalCode) {
		logger.debug("Inside getChallenges by Goal Code");
		
	    HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
	    ChallengeView challengeView = new ChallengeView();
	    challengeView.setGoalCode(goalCode);
	    Collection<ChallengeView> challengeViewColl = getAPIManager().retrieveChallengesByGoalCode(challengeView);
		if(challengeViewColl != null) {
			jsonRoot.put("Response", challengeViewColl);
		} else {
			RequestStatus requestStatus = new RequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(goalCode);
			requestStatus.setMessage("No Challenges Found");
			jsonRoot.put("Response", requestStatus);
		}
		
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
	}
	
	@GET
	@Path("/GETLEVELBYGOAL")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLevelByGoal(@QueryParam("goalCode") String goalCode) {
		logger.debug("Inside getLevel by Goal Code");
		
	    HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
	    LevelView levelView = new LevelView();
	    levelView.setGoalCode(goalCode);
	    Collection<LevelView> levelViewColl = getAPIManager().retrieveLevelsByGoalCode(levelView);
		if(levelViewColl != null) {
			jsonRoot.put("Response", levelViewColl);
		} else {
			RequestStatus requestStatus = new RequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(goalCode);
			requestStatus.setMessage("No Levels found");
			jsonRoot.put("Response", requestStatus);
		}
		
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
	}
	
}
