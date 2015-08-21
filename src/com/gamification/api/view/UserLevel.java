package com.gamification.api.view;

public class UserLevel {
	private String levelCode;
	private String userCode;
	private String goalCode;
	private String badgeCode;
	private int priority;
	
	public String getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
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
	public String getBadgeCode() {
		return badgeCode;
	}
	public void setBadgeCode(String badgeCode) {
		this.badgeCode = badgeCode;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public String toString() {
		return new StringBuilder("UserLevel-->[").append("levelCode=").append(levelCode).append(",userCode=").append(userCode)
				.append(",goalCode=").append(goalCode).append(",badgeCode=").append(badgeCode).append(",priority=").append(priority).append("]").toString();
	}
	
}
