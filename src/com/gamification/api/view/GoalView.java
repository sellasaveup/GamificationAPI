package com.gamification.api.view;

import java.io.Serializable;

public class GoalView implements Serializable{
	
	private Long goalId;
	private String goalCode;
	private String goalName;
	private String goalStory;
	private String goalImage;
	
	public Long getGoalId() {
		return goalId;
	}
	public void setGoalId(Long goalId) {
		this.goalId = goalId;
	}
	public String getGoalCode() {
		return goalCode;
	}
	public void setGoalCode(String goalCode) {
		this.goalCode = goalCode;
	}
	public String getGoalName() {
		return goalName;
	}
	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}
	public String getGoalStory() {
		return goalStory;
	}
	public void setGoalStory(String goalStory) {
		this.goalStory = goalStory;
	}
	public String getGoalImage() {
		return goalImage;
	}
	public void setGoalImage(String goalImage) {
		this.goalImage = goalImage;
	}
	

}
