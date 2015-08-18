package com.gamification.api.view;

public class UserProfile {

	
	private String userCode; 
	private String name;
	private String nickName;
	private String image;
	private String userType;
	private String status;
    private String totalPoints;
    private String reedemedPoints;
    private String redeemablePoints;
    private String globalBadgeCode;
    private String isSuccess;
    
    
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
	
	public String getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(String totalPoints) {
		this.totalPoints = totalPoints;
	}
	public String getReedemedPoints() {
		return reedemedPoints;
	}
	public void setReedemedPoints(String reedemedPoints) {
		this.reedemedPoints = reedemedPoints;
	}
	public String getRedeemablePoints() {
		return redeemablePoints;
	}
	public void setRedeemablePoints(String redeemablePoints) {
		this.redeemablePoints = redeemablePoints;
	}
	public String getGlobalBadgeCode() {
		return globalBadgeCode;
	}
	public void setGlobalBadgeCode(String globalBadgeCode) {
		this.globalBadgeCode = globalBadgeCode;
	}
	
	public String getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	
	public String toString() {
		return new StringBuilder("UserProfile-->[").append(",userCode=").append(userCode)
				   .append(",name=").append(name).append(",nickName=").append(nickName).append(",image").append(image)
				   .append(",userType=").append(userType).append(",status=").append(status).append(",totalPoints=").append(totalPoints)
				   .append(",reedemedPoints=").append(reedemedPoints).append(",redeemablePoints=").append(redeemablePoints)
				   .append(",globalBadgeCode=").append(globalBadgeCode).append(",isSuccess=").append(isSuccess).append("]").toString();
	
	}
}
