package com.roulette.dto;

public class BetRequest {
	
	private Integer rouletteId;
	private Integer number;
	private String color;
	private Double value;
	public BetRequest(Integer rouletteId, Integer number, String color, Double value) {
		super();
		this.rouletteId = rouletteId;
		this.number = number;
		this.color = color;
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
	public Integer getRouletteId() {
		return rouletteId;
	}
	public void setRouletteId(Integer rouletteId) {
		this.rouletteId = rouletteId;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
}
