package com.gamification.api.view;

public class RewardView {
	
	private Long rewardId;
	
	private String rewardCode;
	
	private String goalCode;
	
	private String name;
	
	private String image;
	
	private String expiryDate;
	
	private String date;

	private String story;
	
	private int reedemPoints;
	
	public Long getRewardId() {
		return rewardId;
	}

	public void setRewardId(Long rewardId) {
		this.rewardId = rewardId;
	}

	public String getRewardCode() {
		return rewardCode;
	}

	public void setRewardCode(String rewardCode) {
		this.rewardCode = rewardCode;
	}

	public String getGoalCode() {
		return goalCode;
	}

	public void setGoalCode(String goalCode) {
		this.goalCode = goalCode;
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

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public int getReedemPoints() {
		return reedemPoints;
	}

	public void setReedemPoints(int reedemPoints) {
		this.reedemPoints = reedemPoints;
	}
}
