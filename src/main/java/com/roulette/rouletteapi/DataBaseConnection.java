package com.roulette.rouletteapi;


import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;

@Component
public class DataBaseConnection {
	
	public DataBaseConnection() {
		super();
	}
	public Jedis getDBConnection() {
		return new Jedis();
	}
	
}
