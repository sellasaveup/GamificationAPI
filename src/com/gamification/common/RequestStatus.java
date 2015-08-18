package com.gamification.common;

public class RequestStatus {
   private String isSuccess;
   private String code;
   private String message;
   
   
	public String getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
   
	public String toString() {
		return new StringBuilder("RequestStatus-->[").append("isSuccess=").append(isSuccess)
				.append(",code=").append(code).append(",message=").append(message).append("]").toString();
	}
   
}
