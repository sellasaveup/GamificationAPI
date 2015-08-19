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
	
	public RequestStatus dovalidatePostAction(String userCode, String actionCode) {
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
	
	
	private RequestStatus getRequestStatus() {
		return new RequestStatus();
	}
	private RequestValidatorDAO getRequestValidatorDAO() {
		return new RequestValidatorDAO();
	}
}
