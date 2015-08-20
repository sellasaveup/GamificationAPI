package com.gamification.api.interfaces.persistence.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="SS_MA_USER")
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="USER_CODE")	
	private String userCode;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="NICK_NAME")
	private String nickName;
	
	@Column(name="IMAGE")
	private String image;
	
	@ManyToOne
	@JoinColumn(name="USER_TYPE",referencedColumnName="USER_TYPE_CODE")
	private UserChannel userChannel;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="DATE")	
	private Date date;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public UserChannel getUserChannel() {
		return userChannel;
	}

	public void setUserChannel(UserChannel userChannel) {
		this.userChannel = userChannel;
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
}
