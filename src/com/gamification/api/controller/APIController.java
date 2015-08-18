package com.gamification.api.controller;

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
import com.gamification.api.manager.APIRequestValidator;
import com.gamification.api.manager.NotificationManager;
import com.gamification.api.view.CustomerMaster;
import com.gamification.api.view.Notification;
import com.gamification.api.view.User;
import com.gamification.api.view.UserProfile;
import com.gamification.common.JsonGenerator;
import com.gamification.common.RequestStatus;
import com.gamification.common.Result;
import com.gamification.web.view.BadgeMaster;
import com.gamification.web.view.Challenge;
import com.gamification.web.view.Reward;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	public Response getProfile(@QueryParam("userCode") String userCode) {
		logger.debug("Inside GET_PROFILE Service");
		
		    HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		    UserProfile userProfile = getAPIManager().getProfile(userCode);
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
	@Path("/GET_POINT")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPoint(@QueryParam("custId") String custId, @QueryParam("requestType") String requestType) {
		if (custId != null && !custId.equals("") && requestType != null) {
			String point = getAPIManager().getPoint(custId,requestType);
			 HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
			if(point != null) {
				jsonRoot.put("status", "1");
				jsonRoot.put("point", point);
				jsonRoot.put("custId", custId);
			} else {
				jsonRoot.put("status", "0");
				jsonRoot.put("custId", custId);
			}
			return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}

	}

	@GET
	@Path("/PUT_POINT")
	@Produces(MediaType.APPLICATION_JSON)
	public Response putPoint(@QueryParam("custId") String custId, @QueryParam("point") String point,
			@QueryParam("activity") String activity) {
		 HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		if (custId != null && !custId.equals("") && point != null && !point.equals("")) {
			String status = getAPIManager().putPoint(custId, point, activity);
			jsonRoot.put("status", status);
			jsonRoot.put("custId", custId);
			return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}
	}

	@GET
	@Path("/REDUCE_POINT")
	@Produces(MediaType.APPLICATION_JSON)
	public Response reducePoint(@QueryParam("custId") String custId, @QueryParam("point") String point,
			@QueryParam("activity") String activity) {
		 HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		if (custId != null && !custId.equals("") && point != null && !point.equals("")) {
			String status = getAPIManager().reducePoint(custId, point);
			jsonRoot.put("status", status);
			jsonRoot.put("custId", custId);
			return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}
	}

	@GET
	@Path("/REDUCE_USER_POINT")
	@Produces(MediaType.APPLICATION_JSON)
	public Response redeemPoint(@QueryParam("custId") String custId, @QueryParam("rewardId") String rewardId) {
		 HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		if (custId != null && !custId.equals("") && rewardId != null && !rewardId.equals("")) {
			String status = getAPIManager().redeemPoint(custId, rewardId);
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
			List<BadgeMaster> badgeMasterList = getAPIManager().getBadge(custId);
			
			if(badgeMasterList != null) {
				jsonRoot.put("Result", badgeMasterList);
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
			String status = getAPIManager().awardBadge(custId, badgeId, activity);
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
			String status = getAPIManager().removeBadge(custId, badgeId);
			jsonRoot.put("status", status);
			jsonRoot.put("custId", custId);
			return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}
	}
	
	@GET
	@Path("/POST_ACTIONE")
	@Produces(MediaType.APPLICATION_JSON)

	public Response postAction(@QueryParam("custId") String custId, @QueryParam("action") String action) {
		System.out.println("Inside POST_ACTIONE");
		    HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
		    Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Result result = getAPIManager().postAction(Integer.parseInt(custId), action);
			JSONROOT.put("Result", result);
			String jsonArray = gson.toJson(JSONROOT);
			return Response.status(200).entity(jsonArray).build();
	}
	
	
	
	
	@GET
	@Path("/GET_RANK")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRank(@QueryParam("custId") String custId, @QueryParam("requestType") String requestType) {
		System.out.println("Inside getRank");
		    HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		    if(custId != null && !custId.equals("") && requestType != null) {
		    	String rank = getAPIManager().getRank(custId, requestType);
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
			List<CustomerMaster> customerMasterList = getAPIManager().getLeaderBoard(custId, requestType);
			
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
			 List<BadgeMaster> badgeMasterList = getAPIManager().getAllBadge(custId);

			if(!badgeMasterList.isEmpty()) {
				jsonRoot.put("Result", badgeMasterList);
			}
			else {
				
				jsonRoot.put("Result", new Result(0, Integer.parseInt(custId), "Badges Not Available"));
			}
			
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
			 List<Challenge> badgeMasterList = getAPIManager().getChallenges(custId);

			if(!badgeMasterList.isEmpty()) {
				jsonRoot.put("Result", badgeMasterList);
			}
			else {
				
				jsonRoot.put("Result", new Result(0, Integer.parseInt(custId), "Challenges Not Available"));
			}
			
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
			List<Reward> rewardList = getAPIManager().getAllReward(custId);

			if(!rewardList.isEmpty()) {
				jsonRoot.put("Result", rewardList);
			}
			else {
				
				jsonRoot.put("Result", new Result(0, Integer.parseInt(custId), "Rewards Not Available"));
			}
			
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
			List<Reward> rewardList = getAPIManager().getReward(custId);

			if(!rewardList.isEmpty()) {
				jsonRoot.put("Result", rewardList);
			}
			else {
				
				jsonRoot.put("Result", new Result(0, Integer.parseInt(custId), "Rewards Not Available"));
			}
			
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
									 @QueryParam("custId") String custId, @QueryParam("subjectType") String subjectType) {
		
		HashMap<String, Object> jsonRoot = new HashMap<String, Object>();
		if (notificationType != null && target != null && message != null) {
			Notification notification = new Notification();
			notification.setNotificationType(notificationType);
			notification.setTarget(target);
			notification.setMessage(message);
			notification.setImageUrl(imageUrl);
			if(custId != null && !custId.equals("")) {
				notification.setCustId(Integer.parseInt(custId));
			} else {
				notification.setCustId(-1);
			}
			notification.setSubjectType(subjectType);
			Result result = new NotificationManager().pushNotification(notification);
			jsonRoot.put("Result", result);
		return Response.status(200).entity(getJsonGenerator().getJson(jsonRoot)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}
	}
	

	
	private APIManager getAPIManager() {
		return new APIManager();
	}
	
	private JsonGenerator getJsonGenerator() {
		return new JsonGenerator();
	}
}
