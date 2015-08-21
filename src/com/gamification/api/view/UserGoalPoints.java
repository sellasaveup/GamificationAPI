package com.gamification.api.view;

public class UserGoalPoints {
 
	 private String userCode;
	 private String goalCode;
	 private int totalpoints;
	 private int reedemedPoints;
	 private String globalBadgeCode;
	 private String priority;
	 
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getGoalCode() {
		return goalCode;
	}
	public void setGoalCode(String goalCode) {
		this.goalCode = goalCode;
	}
	public int getTotalpoints() {
		return totalpoints;
	}
	public void setTotalpoints(int totalpoints) {
		this.totalpoints = totalpoints;
	}
	public int getReedemedPoints() {
		return reedemedPoints;
	}
	public void setReedemedPoints(int reedemedPoints) {
		this.reedemedPoints = reedemedPoints;
	}
	public String getGlobalBadgeCode() {
		return globalBadgeCode;
	}
	public void setGlobalBadgeCode(String globalBadgeCode) {
		this.globalBadgeCode = globalBadgeCode;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	 
	public String toString() {
		return new StringBuilder("UserGoalPoints-->[").append("userCode=").append(userCode).append(",goalCode=").append(goalCode)
				.append(",totalpoints=").append(totalpoints).append(",reedemedPoints=").append(reedemedPoints).append(",globalBadgeCode=")
				.append(globalBadgeCode).append(",priority=").append(priority).append("]").toString();
	}
	
}
