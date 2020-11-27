package com.roulette.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.roulette.rouletteapi.DB;
import com.roulette.rouletteapi.DataBaseConnection;

import redis.clients.jedis.Jedis;

@Component
public class Roulette {
	
	@Autowired
	private DataBaseConnection DBConn;
	
	@Autowired
	private BetResponse betResponse;
	
	@Autowired
	private ClosedRoulette closedRoullete;
	
	private Integer id;
	private String status;
	private ArrayList<Bet> bets;
	private Integer result;
	public Roulette(Integer id, String status, ArrayList<Bet> bets, Integer result) {
		super();
		this.id = id;
		this.status = status;
		this.bets = bets;
		this.result = result;
	}
	public Roulette() {
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
	public Integer createRoulette() {
		Jedis conn = DBConn.getDBConnection();
		conn.incr("counterRoulette");
		Integer id = Integer.valueOf(conn.get("counterRoulette"));
		this.setId(id);
		this.saveToDB();
		return this.id;
	}
	private void saveToDB() {
		String stringToSave = new Gson().toJson(this);
		Jedis conn = DBConn.getDBConnection();
		conn.set(this.id.toString(), stringToSave);
	}
	private Boolean getFromDB() {
		Jedis conn = DBConn.getDBConnection();
		String rouletteAsJson = conn.get(this.id.toString());
		if (rouletteAsJson == null || rouletteAsJson.isBlank())
			return false;
		Roulette aux = new Gson().fromJson(rouletteAsJson, Roulette.class);
		this.id = aux.id;
		this.status = aux.status;
		this.bets = aux.bets;
		this.result = aux.result;
		return true;
	}
	public Boolean openRoulette() {
		Jedis conn = DBConn.getDBConnection();
		String rouletteAsJson = conn.get(this.id.toString());
		Roulette aux = new Gson().fromJson(rouletteAsJson, Roulette.class);
		if (aux.status == null || !aux.status.equals("open")) {
			this.id = aux.id;
			this.bets = aux.bets;
			this.result = aux.result;
			this.status = "open";
			this.saveToDB();
			return true;
		}
		return false;
	}
	public BetResponse setNewBet(Bet newBet) {
		if (!this.getFromDB())
			return new BetResponse(false, "405",null);
		if(!this.status.equals("open"))
			return new BetResponse(false, "406",null);
		Jedis conn = DBConn.getDBConnection();
		conn.incr("counterBet");
		Integer betId = Integer.valueOf(conn.get("counterBet"));
		newBet.setId(betId);
		this.bets.add(newBet);
		this.saveToDB();
		return new BetResponse(true, "200", betId);
	}
	
	public ClosedRoulette closeRoulette() {
		if (!this.getFromDB())
			return new ClosedRoulette(false, "405",null);
		if(!this.status.equals("open")) {
			Random rand = new Random();
			this.result = rand.nextInt(37);
			this.calculatePrizes();
		}
		return new ClosedRoulette(true, "200", this.bets);
	}
	private void calculatePrizes() {
		for (Iterator<Bet> it = this.bets.iterator(); it.hasNext();) {
			Bet bet = (Bet) it.next();
			bet.closeBet(this.result);
		}
	}
}
