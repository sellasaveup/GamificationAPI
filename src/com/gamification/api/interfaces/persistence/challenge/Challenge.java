package com.gamification.api.interfaces.persistence.challenge;

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
@Table(name="SS_MA_CHALLENGE")
public class Challenge implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CHALLENGE_ID")
	private Long challengeId;
	
	@Column(name="ACTION_CODE")
	private String actionCode;
	
//	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name="GOAL_CODE", referencedColumnName="GOAL_CODE")
//	private Goal goal;
	
	@Column(name="GOAL_CODE")
	private String goalCode;
	
	
	@Column(name="STORY")
	private String story;
	
	@Column(name="IMAGE")	
	private String image;
	
	@Column(name="POINTS")
	private Long points;
	
	@Column(name="OCCURRENCE")
	private Integer occurrence;
	
	@Column(name="EXPIRY_DATE")
	private Date expiryDate;
	
//	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name="BADGE_CODE", referencedColumnName="BADGE_CODE")
//	private Badge badge;
//	
//	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name="REWARD_CODE", referencedColumnName="REWARD_CODE")
//	private Reward reward;
	
	@Column(name="BADGE_CODE")
	private String badgeCode;
	
	@Column(name="REWARD_CODE")
	private String rewardCode;
	
	@Column(name="DATE")
	private Date date;

	public Long getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(Long challengeId) {
		this.challengeId = challengeId;
	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

//	public Goal getGoal() {
//		return goal;
//	}
//
//	public void setGoal(Goal goal) {
//		this.goal = goal;
//	}

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

	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
	}

	

	public Integer getOccurrence() {
		return occurrence;
	}

	public void setOccurrence(Integer occurrence) {
		this.occurrence = occurrence;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
