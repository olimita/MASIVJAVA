package com.roulette.dto;

import org.springframework.stereotype.Component;

@Component
public class Bet {
	
	private Integer id;
	private Integer userId;
	private Double value;
	private Integer number;
	private String color;
	private String result;
	private Double prize;
	public Bet(Integer id, Integer userId, Double value, Integer number, String color, String result, Double prize) {
		super();
		this.id = id;
		this.userId = userId;
		this.value = value;
		this.number = number;
		this.color = color;
		this.result = result;
		this.prize = prize;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Double getPrize() {
		return prize;
	}
	public void setPrize(Double prize) {
		this.prize = prize;
	}
	
	public void closeBet(Integer chosenNumber) {
		if (this.number != null && this.number.equals(chosenNumber)) {
			this.result = "Won!";
			this.prize = this.value * 5;
		} else if (this.color != null) {
			String chosenColor = (chosenNumber % 2 == 0) ? "Red" : "Black";
			if (this.color.equals(chosenColor)) {
				this.result = "Won!";
				this.prize = this.value * 1.8;
			}
		}
		this.result = "Lost!";
		this.prize = 0.0;
	}
}
