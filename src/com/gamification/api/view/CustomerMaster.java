package com.gamification.api.view;

public class CustomerMaster {
	int custId;
	String customerName;
	String customerAvatar;
	int points;
	String subjectType;
	int rank;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerAvatar() {
		return customerAvatar;
	}
	public void setCustomerAvatar(String customerAvatar) {
		this.customerAvatar = customerAvatar;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
}
