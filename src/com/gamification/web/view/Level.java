package com.gamification.web.view;

public class Level {
	
	private Long levelId;
	private String levelDesc;
	private String imageUrl;
	private Long badgeId;
	private Long rewardId;
	
	public Long getLevelId() {
		return levelId;
	}
	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}
	public String getLevelDesc() {
		return levelDesc;
	}
	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Long getBadgeId() {
		return badgeId;
	}
	public void setBadgeId(Long badgeId) {
		this.badgeId = badgeId;
	}
	public Long getRewardId() {
		return rewardId;
	}
	public void setRewardId(Long rewardId) {
		this.rewardId = rewardId;
	}
}
