package com.roulette.dto;

public class OpenRouletteResponse {
	
	private String errorCode;
	private String errorMesagge;
	private Boolean succesful;
	public OpenRouletteResponse(String errorCode, String errorMesagge, Boolean succesful) {
		super();
		this.errorCode = errorCode;
		this.errorMesagge = errorMesagge;
		this.succesful = succesful;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMesagge() {
		return errorMesagge;
	}
	public void setErrorMesagge(String errorMesagge) {
		this.errorMesagge = errorMesagge;
	}
	public Boolean getSuccesful() {
		return succesful;
	}
	public void setSuccesful(Boolean succesful) {
		this.succesful = succesful;
	}

}
