package com.roulette.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class RouletteToList extends Object implements Cloneable {
	
	private Integer id;
	private String status;
	private ArrayList<Bet> bets;
	private Integer result;
	public RouletteToList(Integer id, String status, ArrayList<Bet> bets, Integer result) {
		super();
		this.id = id;
		this.status = status;
		this.bets = bets;
		this.result = result;
	}
	public RouletteToList() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ArrayList<Bet> getBets() {
		return bets;
	}
	public void setBets(ArrayList<Bet> bets) {
		this.bets = bets;
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
