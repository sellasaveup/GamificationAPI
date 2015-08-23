package com.gamification.api.interfaces.persistence.level;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.gamification.api.interfaces.persistence.badge.Badge;
import com.gamification.api.interfaces.persistence.goal.Goal;
import com.gamification.api.interfaces.persistence.reward.Reward;

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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="GOAL_CODE", referencedColumnName="GOAL_CODE")
	private Goal goal;
	
	@OneToOne
	@JoinColumn(name="BADGE_CODE", referencedColumnName="BADGE_CODE")
	private Badge badge;
	
	@OneToOne
	@JoinColumn(name="REWARD_CODE", referencedColumnName="REWARD_CODE")
	private Reward reward;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="STORY")
	private String story;
	
	@Column(name="POINTS")
	private Long points;

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

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}

	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
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

	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
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
	

}
