package com.gamification.api.view;

public class UserBadge {
	private String badgeCode;
	private String goalCode;
	private String userCode;
	private String status;
	
	public String getBadgeCode() {
		return badgeCode;
	}
	public void setBadgeCode(String badgeCode) {
		this.badgeCode = badgeCode;
	}
	public String getGoalCode() {
		return goalCode;
	}
	public void setGoalCode(String goalCode) {
		this.goalCode = goalCode;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString() {
		return new StringBuilder("UserBadge--->[").append("badgeCode=").append(badgeCode).append(",goalCode=").append(goalCode)
				.append(",userCode=").append(userCode).append(",status=").append(status).append("]").toString();
	}
	
}
