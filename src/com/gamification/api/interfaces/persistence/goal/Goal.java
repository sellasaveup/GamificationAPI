package com.gamification.api.interfaces.persistence.goal;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gamification.api.interfaces.persistence.badge.Badge;
import com.gamification.api.interfaces.persistence.challenge.Challenge;
import com.gamification.api.interfaces.persistence.level.Level;
import com.gamification.api.interfaces.persistence.reward.Reward;
import com.gamification.api.interfaces.persistence.user.UserChannel;


@SuppressWarnings("serial")
@Entity
@Table(name="SS_MA_GOAL")
public class Goal implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GOAL_ID")
	private Long goalId;

	@Column(name="GOAL_CODE")
	private String goalCode;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="STORY")
	private String story;
	
	@Column(name="EXPIRY_DATE")
	private Date expiryDate;
	
	@Column(name="IMAGE")
	private String image;
	
//	@ManyToOne
//	@JoinColumn(name="USER_TYPE",referencedColumnName="USER_TYPE_CODE")
//	private UserChannel userChannel;
	
	@Column(name="USER_TYPE")
	private String userType;

	@Column(name="STATUS")
	private String status;

	@Column(name="DATE")
	private Date date;
	
//	@OneToMany(mappedBy="goal", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	private Set<Challenge> challenges;
//	
//	@OneToMany(mappedBy="goal", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	private Set<Level> levels;
//	
//	@OneToMany(mappedBy="goal", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	private Set<Badge> badges;
//	
//	@OneToMany(mappedBy="goal", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	private Set<Reward> rewards;
	
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

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

//	public UserChannel getUserChannel() {
//		return userChannel;
//	}
//
//	public void setUserChannel(UserChannel userChannel) {
//		this.userChannel = userChannel;
//	}

//	public Set<Challenge> getChallenges() {
//		return challenges;
//	}
//
//	public void setChallenges(Set<Challenge> challenges) {
//		this.challenges = challenges;
//	}
//
//	public Set<Level> getLevels() {
//		return levels;
//	}
//
//	public void setLevels(Set<Level> levels) {
//		this.levels = levels;
//	}
//
//	public Set<Badge> getBadges() {
//		return badges;
//	}
//
//	public void setBadges(Set<Badge> badges) {
//		this.badges = badges;
//	}
//
//	public Set<Reward> getRewards() {
//		return rewards;
//	}
//
//	public void setRewards(Set<Reward> rewards) {
//		this.rewards = rewards;
//	}
	
	
}
