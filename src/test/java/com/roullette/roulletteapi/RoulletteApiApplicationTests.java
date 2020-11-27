package com.roullette.roulletteapi;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.roulette.rouletteapi.DB;

@SpringBootTest
class RoulletteApiApplicationTests {
	
	@Autowired
	private DB DB;
	
	@Test
	void contextLoads() throws SQLException {
		DB.initializeCounter();
	}

}
