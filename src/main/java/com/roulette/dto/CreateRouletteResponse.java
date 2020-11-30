package com.roulette.dto;

public class CreateRouletteResponse {
	
	private String errorCode;
	private String errorMesagge;
	private Integer rouletteId;
	public CreateRouletteResponse(String errorCode, String errorMesagge, Integer rouletteId) {
		super();
		this.errorCode = errorCode;
		this.errorMesagge = errorMesagge;
		this.rouletteId = rouletteId;
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
	public Integer getRouletteId() {
		return rouletteId;
	}
	public void setRouletteId(Integer rouletteId) {
		this.rouletteId = rouletteId;
	}
	
}
