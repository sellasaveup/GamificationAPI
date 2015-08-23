package com.gamification.api.view;

public class LevelView {
	private String levelCode;
	private String goalCode;
	private String rewardCode;
	private String badgeCode;
	private String name;
	private String image;
	private String story;
	private int startPoint;
	private int endPoint;
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
	
	public int getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(int startPoint) {
		this.startPoint = startPoint;
	}
	public int getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(int endPoint) {
		this.endPoint = endPoint;
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
				.append(",image=").append(image).append(",story=").append(story).append(",startpoint=").append(startPoint).append(",endPoint=").append(endPoint)
				.append(",priority=").append(priority).append(",expiryDate=").append(expiryDate).append("]").toString();
			
	}
	
}
