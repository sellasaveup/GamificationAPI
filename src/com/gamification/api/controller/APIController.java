package com.gamification.api.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.gamification.api.manager.APIManager;

@Path("/api")
public class APIController {
	@GET
	@Path("/GET_POINT")
	public Response getPoint(@QueryParam("custId") String custId) {
		if (custId != null) {
			return Response.status(200).entity(getAPIManager().getPoint(custId)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}

	}

	@GET
	@Path("/PUT_POINT")
	public Response putPoint(@QueryParam("custId") String custId, @QueryParam("point") String point,
			@QueryParam("activity") String activity) {
		if (custId != null && point != null) {
			return Response.status(200).entity(getAPIManager().putPoint(custId, point, activity)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}
	}

	@GET
	@Path("/REDUCE_POINT")
	public Response reducePoint(@QueryParam("custId") String custId, @QueryParam("point") String point,
			@QueryParam("activity") String activity) {
		if (custId != null && point != null) {
			return Response.status(200).entity(getAPIManager().reducePoint(custId, point, activity)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}
	}

	@GET
	@Path("/GET_BADGE")
	public Response getBadge(@QueryParam("custId") String custId) {
		if (custId != null) {
		return Response.status(200).entity(getAPIManager().getBadge(custId)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}
	}

	@GET
	@Path("/AWARD_BADGE")
	public Response awardBadge(@QueryParam("custId") String custId, @QueryParam("badgeId") String badgeId,
			@QueryParam("activity") String activity) {
		if (custId != null && badgeId != null) {
			return Response.status(200).entity(getAPIManager().awardBadge(custId, badgeId, activity)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}
	}

	@GET
	@Path("/REMOVE_BADGE")
	public Response removeBadge(@QueryParam("custId") String custId, @QueryParam("badgeId") String badgeId,
			@QueryParam("activity") String activity) {
		if (custId != null && badgeId != null) {
			return Response.status(200).entity(getAPIManager().removeBadge(custId, badgeId, activity)).build();
		} else {
			return Response.status(503).entity("Invalid Request").build();
		}
	}

	private APIManager getAPIManager() {
		return new APIManager();
	}
}
