package com.gamification.api.view;

public class UserReward {

	private String rewardCode;
	private String goalCode;
	private String userCode;
	private String status;
	private String redeemStatus;
	private int redeemPoints;
	
	public String getRewardCode() {
		return rewardCode;
	}
	public void setRewardCode(String rewardCode) {
		this.rewardCode = rewardCode;
	}
	public String getGoalCode() {
		return goalCode;
	}
	public void setGoalCode(String goalCode) {
		this.goalCode = goalCode;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getRedeemStatus() {
		return redeemStatus;
	}
	public void setRedeemStatus(String redeemStatus) {
		this.redeemStatus = redeemStatus;
	}
	public int getRedeemPoints() {
		return redeemPoints;
	}
	public void setRedeemPoints(int redeemPoints) {
		this.redeemPoints = redeemPoints;
	}
	public String toString() {
		return new StringBuilder("UserReward--->[").append("rewardCode=").append(rewardCode).append(",goalCode=").append(goalCode)
				.append(",userCode=").append(userCode).append(",status=").append(status).append(",redeemStatus=").append(redeemStatus)
				.append(",redeemPoints=").append(redeemPoints).append("]").toString();
	}
	

}
