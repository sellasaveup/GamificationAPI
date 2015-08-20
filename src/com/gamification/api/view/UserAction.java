package com.gamification.api.view;

public class UserAction {
	private String goalCode;
	private String userCode;
	private String actionCode;
	private int points;
	private String status;
	private String date;
	
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
	public String getActionCode() {
		return actionCode;
	}
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String toString() {
		return new StringBuilder("UserAction-->[").append("goalCode=").append(goalCode).append(",userCode=").append(userCode)
				.append(",actionCode=").append(actionCode).append(",points=").append(points).append(",status=").append(status)
				.append(",date=").append(date).append("]").toString();
	}
}
