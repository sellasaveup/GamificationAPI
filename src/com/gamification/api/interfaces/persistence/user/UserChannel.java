package com.gamification.api.interfaces.persistence.user;

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
@Table(name="SS_MA_USER_TYPE")
public class UserChannel implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_TYPE_ID")
	private Long userTypeId;
	
	@Column(name="USER_TYPE_CODE")
	private String userTypeCode;
	
	@Column(name="STORY")
	private String story;
	
	@Column(name="IMAGE")
	private String image;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="DATE")
	private Date date;
	
//	@OneToMany(mappedBy="userChannel", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	private Set<User> users;

	public Long getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Long userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserTypeCode() {
		return userTypeCode;
	}

	public void setUserTypeCode(String userTypeCode) {
		this.userTypeCode = userTypeCode;
	}

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

//	public Set<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}
}
