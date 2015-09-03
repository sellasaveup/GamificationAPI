package com.gamification.api.view;

public class UserBadge {
	private String badgeCode;
	private String goalCode;
	private String userCode;
	private String status;
	private String story;
	private String date;
	private String image;
	
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
	
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "UserBadge [badgeCode=" + badgeCode + ", goalCode=" + goalCode + ", userCode=" + userCode + ", status="
				+ status + ", story=" + story + ", date=" + date + ", image=" + image + "]";
	}
}
