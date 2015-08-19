package com.gamification.api.view;

public class Challenge {
	private String actionCode;
	private String goalCode;
	private String story;
	private String image;
	private int points;
	private int occurrence;
	private String expiryDate;
	private String badgeCode;
	private String rewardCode;
	
	public String getActionCode() {
		return actionCode;
	}
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}
	public String getGoalCode() {
		return goalCode;
	}
	public void setGoalCode(String goalCode) {
		this.goalCode = goalCode;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	public int getOccurrence() {
		return occurrence;
	}
	public void setOccurrence(int occurrence) {
		this.occurrence = occurrence;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getBadgeCode() {
		return badgeCode;
	}
	public void setBadgeCode(String badgeCode) {
		this.badgeCode = badgeCode;
	}
	public String getRewardCode() {
		return rewardCode;
	}
	public void setRewardCode(String rewardCode) {
		this.rewardCode = rewardCode;
	}
	
	
	public String toString() {
		return new StringBuilder("Challenge-->[").append("actionCode=").append(actionCode).append(",goalCode=").append(goalCode)
					.append(",story=").append(story).append(",image=").append(image).append(",points=").append(points)
					.append(",occurrence=").append(occurrence).append(",expiryDate=").append(expiryDate).append(",badgeCode=").append(badgeCode)
					.append(",rewardCode=").append(rewardCode).append("]").toString();
	}
	
}
