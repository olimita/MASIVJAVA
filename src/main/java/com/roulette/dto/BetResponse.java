package com.roulette.dto;

import org.springframework.stereotype.Component;

@Component
public class BetResponse {
	
	private Boolean success;
	private String errorCode;
	private String errorMessage;
	private Integer betId;
	public BetResponse(Boolean success, String errorCode, String errorMessage, Integer betId) {
		super();
		this.success = success;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.betId = betId;
	}
	public BetResponse() {
		super();
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Integer getBetId() {
		return betId;
	}
	public void setBetId(Integer betId) {
		this.betId = betId;
	}
	
}
