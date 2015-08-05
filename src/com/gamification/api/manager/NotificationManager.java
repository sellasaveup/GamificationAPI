package com.gamification.api.manager;

import java.util.List;

import com.gamification.api.dao.NotificationDAO;
import com.gamification.api.view.CustomerMaster;
import com.gamification.api.view.Notification;
import com.gamification.common.Result;
import com.gamification.web.dao.CustomerMasterDAO;

public class NotificationManager {

	public Result pushNotification(Notification notification) {
		System.out.println("Inside NotificationManager pushNotification()");
		Result result = null;
		NotificationDAO notificationDAO = new NotificationDAO();
		List<CustomerMaster> customerMasterList = null;
		System.out.println("notification.getTarget()-->" + notification.getTarget());
		String status = notificationDAO.putNotificationHeader(notification);
		int notificationId = notification.getNotificationId();
		System.out.println("notificationId-->" + notificationId);
		if ("1".equals(status)) {
			if (notification.getTarget().equals("ALL")) {
				System.out.println("Notification is Targetting ALL the customers");
				customerMasterList = new CustomerMasterDAO().getCustomerList();
				if (customerMasterList != null) {
					for (CustomerMaster customerMaster : customerMasterList) {
						System.out.println("Putting ALL CUSTOMER based Notification for " + customerMaster.getCustId());
						notificationDAO.putNotificationTransaction(notificationId, customerMaster.getCustId(), "UN");
						result = new Result(1, notification.getCustId(), "All Customer Based Notification Pushed");
					}
				}

			} else if (notification.getTarget().equals("SUBJECT")) {
				System.out.println("Notification is Targetting SUBJECT the customers");
				customerMasterList = notificationDAO.getSubjectBasedCustomerList(notification.getSubjectType());
				if(customerMasterList != null) {
					for (CustomerMaster customerMaster : customerMasterList) {
						System.out.println("Putting SUBJECT Notification for " + customerMaster.getCustId());
						notificationDAO.putNotificationTransaction(notificationId, customerMaster.getCustId(), "UN");
						result = new Result(1, notification.getCustId(), "Subject Type Based Notification Pushed");
					}
				}

			} else if (notification.getTarget().equals("CUST")) {
				System.out.println("Putting CUST based Notification for " + notification.getCustId());
				if(notification.getCustId() != -1) {
					notificationDAO.putNotificationTransaction(notificationId, notification.getCustId(), "UN");
					result = new Result(1, notification.getCustId(), "Customer Based Notification Pushed");
				} else {
					result = new Result(0, notification.getCustId(), "Customer id required for CUST based Notification");
				}
				
			} else {
				result = new Result(0, notification.getCustId(), "Invalid Target");
			}
		}

		return result;
	}
}
