package com.roulette.rouletteapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;

@Component
public class DataBaseConnection {
	
	@Autowired
	private Configuration config;
	
	public DataBaseConnection() {
		super();
	}
	public Jedis getDBConnection() {
		return new Jedis(config.getDBUrl(), config.getDBPort());
	}
	
}
