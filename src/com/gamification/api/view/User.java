package com.gamification.api.view;


public class User {
	
	private Long userId;
	private String userCode; 
	private String name;
	private String nickName;
	private String image;
	private String userType;
	private String status;
	private String date;
	
	
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String toString() {
		return new StringBuilder("User-->[").append("userId=").append(userId).append(",userCode=").append(userCode)
				   .append(",name=").append(name).append(",nickName=").append(nickName).append(",image").append(image)
				   .append(",userType=").append(userType).append(",status=").append(status).append("date=").append(date).append("]").toString();
	
	}
}
