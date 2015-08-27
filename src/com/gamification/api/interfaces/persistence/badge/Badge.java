package com.gamification.api.interfaces.persistence.badge;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SS_MA_BADGE")
@SuppressWarnings("serial")
public class Badge implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BADGE_ID")
	private Long badgeId;
	
	@Column(name="BADGE_CODE")
	private String badgeCode;
	
//	@ManyToOne
//	@JoinColumn(name="GOAL_CODE", referencedColumnName="GOAL_CODE")
//	private Goal goal;
	
	@Column(name="GOAL_CODE")
	private String goalCode;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="IMAGE")
	private String image;
	
	@Column(name="STORY")
	private String story;
	
	@Column(name="EXPIRY_DATE")
	private Date expiryDate;
	
	@Column(name="DATE")
	private Date date;
	
	public Long getBadgeId() {
		return badgeId;
	}
	public void setBadgeId(Long badgeId) {
		this.badgeId = badgeId;
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
