package com.roulette.dto;

public class BetValidation {
	
	private Boolean valid;
	private String errorCode;
	public BetValidation(Boolean valid, String errorCode) {
		super();
		this.valid = valid;
		this.errorCode = errorCode;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
