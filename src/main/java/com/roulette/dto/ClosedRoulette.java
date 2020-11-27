package com.roulette.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ClosedRoulette {
	
	private Boolean success;
	private String errorCode;
	private Integer chosenNumber;
	private String chosenColor;
	private ArrayList<Bet> bets;
	public ClosedRoulette(Boolean success, String errorCode, Integer chosenNumber, String chosenColor,
			ArrayList<Bet> bets) {
		super();
		this.success = success;
		this.errorCode = errorCode;
		this.chosenNumber = chosenNumber;
		this.chosenColor = chosenColor;
		this.bets = bets;
	}
	public ClosedRoulette() {
		super();
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
	public Integer getChosenNumber() {
		return chosenNumber;
	}
	public void setChosenNumber(Integer chosenNumber) {
		this.chosenNumber = chosenNumber;
	}
	public String getChosenColor() {
		return chosenColor;
	}
	public void setChosenColor(String chosenColor) {
		this.chosenColor = chosenColor;
	}
}
