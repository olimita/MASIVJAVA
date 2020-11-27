package com.roulette.dto;

import java.util.ArrayList;

public class ClosedRoulette {
	
	private Boolean success;
	private String errorCode;
	private ArrayList<Bet> bets;
	public ClosedRoulette(Boolean success, String errorCode, ArrayList<Bet> bets) {
		super();
		this.success = success;
		this.errorCode = errorCode;
		this.bets = bets;
	}
	public ArrayList<Bet> getBets() {
		return bets;
	}
	public void setBets(ArrayList<Bet> bets) {
		this.bets = bets;
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
}
