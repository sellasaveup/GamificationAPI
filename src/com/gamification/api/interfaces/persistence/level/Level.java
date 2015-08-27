package com.gamification.api.interfaces.persistence.level;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="SS_MA_LEVEL")
public class Level implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LEVEL_ID")
	private Long levelId;
	
	@Column(name="LEVEL_CODE")
	private String levelCode;
	
	@Column(name="GOAL_CODE")
	private String goalCode;
	
	
	@Column(name="BADGE_CODE")
	private String badgeCode;
	
	@Column(name="REWARD_CODE")
	private String rewardCode;
	
//	@ManyToOne
//	@JoinColumn(name="GOAL_CODE", referencedColumnName="GOAL_CODE")
//	private Goal goal;
//	
//	@OneToOne
//	@JoinColumn(name="BADGE_CODE", referencedColumnName="BADGE_CODE")
//	private Badge badge;
//	
//	@OneToOne
//	@JoinColumn(name="REWARD_CODE", referencedColumnName="REWARD_CODE")
//	private Reward reward;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="STORY")
	private String story;
	
	@Column(name="START_POINT")
	private Long startPoint;
	
	@Column(name="END_POINT")
	private Long endPoint;

	@Column(name="PRIORITY")
	private Integer priority;
	
	@Column(name="DATE")
	private Date date;

	@Column(name="IMAGE")
	private String image;
	
	public Long getLevelId() {
		return levelId;
	}

	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

//	public Goal getGoal() {
//		return goal;
//	}
//
//	public void setGoal(Goal goal) {
//		this.goal = goal;
//	}
//
//	public Badge getBadge() {
//		return badge;
//	}
//
//	public void setBadge(Badge badge) {
//		this.badge = badge;
//	}
//
//	public Reward getReward() {
//		return reward;
//	}
//
//	public void setReward(Reward reward) {
//		this.reward = reward;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public Long getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Long startPoint) {
		this.startPoint = startPoint;
	}

	public Long getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Long endPoint) {
		this.endPoint = endPoint;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getRewardCode() {
		return rewardCode;
	}

	public void setRewardCode(String rewardCode) {
		this.rewardCode = rewardCode;
	}
	
	
}
