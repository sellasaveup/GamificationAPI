package com.gamification.api.manager;

import org.apache.log4j.Logger;

import com.gamification.api.dao.ActionProcessorDAO;
import com.gamification.api.dao.GamificationApiDAO;
import com.gamification.api.view.Challenge;
import com.gamification.common.RequestStatus;

public class ActionProcessor {
	final static Logger logger = Logger.getLogger(ActionProcessor.class);
	
	public RequestStatus performAction(String userCode, String actionCode) {
		RequestStatus requestStatus = new RequestStatus();
		Challenge challenge = getChallenge(actionCode);
		if(challenge != null) {
			logger.debug("challenge available");
			requestStatus.setIsSuccess("1");
			requestStatus.setCode(userCode);
			requestStatus.setMessage("Post Action Successful");
		} else {
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(userCode);
			requestStatus.setMessage("Challenge Not Available");
		}
		return requestStatus;
	}
	
	private Challenge getChallenge(String actionCode) {
		return getGamificationApiDAO().getChallenge(actionCode);
	}
	
	private GamificationApiDAO getGamificationApiDAO() {
		return new GamificationApiDAO();
	}
	
	private ActionProcessorDAO getActionProcessorDAO() {
		return new ActionProcessorDAO();
	}
}
