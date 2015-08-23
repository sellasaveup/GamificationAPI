package com.gamification.api.manager;

import java.util.List;

import org.apache.log4j.Logger;

import com.gamification.api.dao.NotificationDAO;
import com.gamification.api.view.Notification;
import com.gamification.common.RequestStatus;
import com.gamification.common.Result;

public class NotificationManager {
	final static Logger logger = Logger.getLogger(NotificationManager.class);
	public RequestStatus pushNotification(Notification notification) {
		logger.debug("Inside NotificationManager pushNotification()");
		RequestStatus requestStatus = new RequestStatus();
		requestStatus.setIsSuccess("1");
		requestStatus.setCode(notification.getGoalCode());
		requestStatus.setMessage("Push Notification Succesful");
		NotificationDAO notificationDAO = new NotificationDAO();
		List<String> userCodeList = null;
		logger.debug("notification.getTarget()-->" + notification.getTarget());
		String status = notificationDAO.putNotificationHeader(notification);
		int notificationId = notification.getNotificationId();
		logger.debug("notificationId-->" + notificationId);
		if ("1".equals(status)) {
			if (notification.getTarget().equals("ALL")) {
				logger.debug("Notification is Targetting ALL the customers");
				userCodeList = notificationDAO.getUserCodeList(notification.getGoalCode());
				
				if (userCodeList != null) {
					for (String userCode : userCodeList) {
						logger.debug("Putting ALL User and Goal based Notification for " + userCode);
						notificationDAO.putNotificationTransaction(notificationId, userCode, "ACTIVE");
					}
				} else {
					logger.debug("User not available for mentioned goal");
					requestStatus.setIsSuccess("0");
					requestStatus.setCode(notification.getGoalCode());
					requestStatus.setMessage("User not available for mentioned goal");
				}

			} else if (notification.getTarget().equals("USER_TYPE")) {
				logger.debug("Notification is Targetting SUBJECT the customers");
				userCodeList = notificationDAO.getUserTypeBasedCustomerList(notification.getUserType());
				if(userCodeList != null) {
					for (String userCode : userCodeList) {
						logger.debug("Putting USER_TYPE Notification for " + userCode);
						notificationDAO.putNotificationTransaction(notificationId, userCode, "ACTIVE");
					}
				} else {
					logger.debug("User not available for mentioned user type");
					requestStatus.setIsSuccess("0");
					requestStatus.setCode(notification.getGoalCode());
					requestStatus.setMessage("User not available for mentioned user type");
				}

			} else if (notification.getTarget().equals("USER")) {
				logger.debug("Putting USER based Notification for " + notification.getUserCode());
				if(notification.getUserCode() != null) {
					notificationDAO.putNotificationTransaction(notificationId, notification.getUserCode(), "ACTIVE");
				} else {
					logger.debug("User not available for mentioned user code");
					requestStatus.setIsSuccess("0");
					requestStatus.setCode(notification.getGoalCode());
					requestStatus.setMessage("User not available for mentioned user code");
				}
				
			} else {
				logger.debug("No valid Target");
				requestStatus.setIsSuccess("0");
				requestStatus.setCode(notification.getGoalCode());
				requestStatus.setMessage("No Valid Target Provided");
			}
		} else {
			requestStatus.setIsSuccess("0");
			requestStatus.setCode(notification.getGoalCode());
			requestStatus.setMessage("Push Notification HeaderFailed");
		}

		return requestStatus;
	}
}
