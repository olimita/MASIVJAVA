package com.roulette.rouletteapi;

import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;

@Component
public class DB {
	
	@Autowired
	private DataBaseConnection DBConn;
	
	@PostConstruct
	public void initializeCounter() throws SQLException {
		Jedis conn = DBConn.getDBConnection();
		if (!conn.exists("counterRoulette"))
			conn.set("counterRoulette","0");
		if (!conn.exists("counterBet"))
			conn.set("counterBet","0");
	}
	
}
