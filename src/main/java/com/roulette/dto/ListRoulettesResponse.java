package com.roulette.dto;

import java.util.ArrayList;

public class ListRoulettesResponse {
	
	private String errorCode;
	private String errorMessage;
	private ArrayList<RouletteToList> roulettes;
	public ListRoulettesResponse(String errorCode, String errorMessage, ArrayList<RouletteToList> roulettes) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.roulettes = roulettes;
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
	public ArrayList<RouletteToList> getRoulettes() {
		return roulettes;
	}
	public void setRoulettes(ArrayList<RouletteToList> roulettes) {
		this.roulettes = roulettes;
	}
	
}
