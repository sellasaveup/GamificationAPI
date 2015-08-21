package com.gamification.api.view;

public class Level {
	private String levelCode;
	private String goalCode;
	private String rewardCode;
	private String badgeCode;
	private String name;
	private String image;
	private String story;
	private int points;
	private int priority;
	private String expiryDate;
	
	public String getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	public String getGoalCode() {
		return goalCode;
	}
	public void setGoalCode(String goalCode) {
		this.goalCode = goalCode;
	}
	public String getRewardCode() {
		return rewardCode;
	}
	public void setRewardCode(String rewardCode) {
		this.rewardCode = rewardCode;
	}
	public String getBadgeCode() {
		return badgeCode;
	}
	public void setBadgeCode(String badgeCode) {
		this.badgeCode = badgeCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public String toString() {
		return new StringBuilder("Level-->[").append("levelCode=").append(levelCode).append(",goalCode=").append(goalCode)
				.append(",rewardCode=").append(rewardCode).append(",badgeCode=").append(badgeCode).append(",name").append(name)
				.append(",image=").append(image).append(",story=").append(story).append(",points=").append(points)
				.append(",priority=").append(priority).append(",expiryDate=").append(expiryDate).append("]").toString();
			
	}
	
}
