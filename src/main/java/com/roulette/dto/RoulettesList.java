package com.roulette.dto;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roulette.rouletteapi.DataBaseConnection;

@Component
public class RoulettesList {
	
	@Autowired
	private DataBaseConnection DBConn;
	
	private ArrayList<Roulette> roulettes;

	public RoulettesList(ArrayList<Roulette> roulettes) {
		super();
		this.roulettes = roulettes;
	}
	public ArrayList<Roulette> getRoulettes() {
		return roulettes;
	}
	public void setRoulettes(ArrayList<Roulette> roulettes) {
		this.roulettes = roulettes;
	}
	
}
