package com.gamification.api.manager;

import org.apache.log4j.Logger;

import com.gamification.api.dao.RequestValidatorDAO;
import com.gamification.api.view.User;
import com.gamification.common.RequestStatus;

public class APIRequestValidator {
	final static Logger logger = Logger.getLogger(APIRequestValidator.class);
   
	public RequestStatus doValidateOnboardUser(User user) {
		RequestValidatorDAO requestValidatorDAO = getRequestValidatorDAO();
		
		RequestStatus requestStatus = null;
		if(user.getUserCode() == null || user.getUserCode().equals("")) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setMessage("User Code cannot be Empty");
		} else if(user.getName() == null || user.getName().equals("")) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(user.getUserCode());
			requestStatus.setMessage("Name cannot be Empty");
		} else if(user.getUserType() == null || user.getUserType().equals("")) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(user.getUserCode());
			requestStatus.setMessage("User Type cannot be Empty");
		} else if(requestValidatorDAO.getUserCode(user.getUserCode()) != null) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(user.getUserCode());
			requestStatus.setMessage("User Already Exists");
		} else if(requestValidatorDAO.getUserType(user.getUserType()) == null) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(user.getUserCode());
			requestStatus.setMessage("User Type does not Exists");
		}
		
		return requestStatus;
	}
	
	public RequestStatus doValidatePostAction(String userCode, String actionCode) {
		
		RequestValidatorDAO requestValidatorDAO = getRequestValidatorDAO();
		
		RequestStatus requestStatus = null;
		if(userCode == null || userCode.equals("")) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setMessage("User Code cannot be Empty");
		} else if(actionCode == null || actionCode.equals("")) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(userCode);
			requestStatus.setMessage("Action Code cannot be Empty");
		} else if(requestValidatorDAO.getUserCode(userCode) == null) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(userCode);
			requestStatus.setMessage("User Not Onboarded");
		} else if(requestValidatorDAO.getActionCode(actionCode) == null) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(userCode);
			requestStatus.setMessage("Action Code does not Exists");
		}
		return requestStatus;
	}
	
	public RequestStatus doGetPointsRequest(String userCode, String goalCode) {
		
		RequestValidatorDAO requestValidatorDAO = getRequestValidatorDAO();
		
		RequestStatus requestStatus = null;
		if(userCode == null || userCode.equals("")) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setMessage("User Code cannot be Empty");
		} else if(goalCode == null || goalCode.equals("")) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(userCode);
			requestStatus.setMessage("Goal Code cannot be Empty");
		} else if(requestValidatorDAO.getUserCode(userCode) == null) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(userCode);
			requestStatus.setMessage("User Not Onboarded");
		} else if(requestValidatorDAO.getGoalCode(goalCode) == null) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(userCode);
			requestStatus.setMessage("Goal Code does not Exists");
		}
		return requestStatus;
	}
	
	public RequestStatus doValidateAwardBadge(String userCode, String badgeCode, String goalCode) {
		RequestValidatorDAO requestValidatorDAO = getRequestValidatorDAO();
		
		RequestStatus requestStatus = null;
		if(userCode == null || userCode.equals("")) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setMessage("User Code cannot be Empty");
		} else if(goalCode == null || goalCode.equals("")) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(userCode);
			requestStatus.setMessage("Goal Code cannot be Empty");
		} else if(badgeCode == null || badgeCode.equals("")) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(userCode);
			requestStatus.setMessage("Badge Code cannot be Empty");
		}
		else if(requestValidatorDAO.getUserCode(userCode) == null) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(userCode);
			requestStatus.setMessage("User Not Onboarded");
		} else if(requestValidatorDAO.getBadgeCode(badgeCode,goalCode) == null) {
			requestStatus = getRequestStatus();
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(userCode);
			requestStatus.setMessage("Badge does not Exists for selected goal");
		}
		return requestStatus;
		
	}
	
	private RequestStatus getRequestStatus() {
		return new RequestStatus();
	}
	private RequestValidatorDAO getRequestValidatorDAO() {
		return new RequestValidatorDAO();
	}
}
