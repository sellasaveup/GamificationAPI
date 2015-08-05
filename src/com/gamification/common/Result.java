package com.gamification.common;

public class Result {
	int status;
	int customerId;
	String statusReport;
	
	public Result() {
		
	}
	public Result(int status, int customerId, String statusReport) {
		this.status = status;
		this.customerId = customerId;
		this.statusReport = statusReport;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getStatusReport() {
		return statusReport;
	}
	public void setStatusReport(String statusReport) {
		this.statusReport = statusReport;
	}
	
	
}
