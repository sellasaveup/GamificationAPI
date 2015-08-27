package com.gamification.api.interfaces.persistence.reward;

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
@Table(name="SS_MA_REWARD")
public class Reward implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REWARD_ID")
	private Long rewardId;
	
	@Column(name="REWARD_CODE")
	private String rewardCode;
	
//	@ManyToOne
//	@JoinColumn(name="GOAL_CODE", referencedColumnName="GOAL_CODE")
//	private Goal goal;
	
	
	@Column(name="GOAL_CODE")
	private String goalCode;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="image")
	private String image;
	
	@Column(name = "EXPIRY_DATE")
	private Date expiryDate;
	
	@Column(name="DATE")
	private Date date;

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

//	public Goal getGoal() {
//		return goal;
//	}
//
//	public void setGoal(Goal goal) {
//		this.goal = goal;
//	}

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

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

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
	
	
}
