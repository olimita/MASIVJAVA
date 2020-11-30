package com.roulette.rouletteapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
"com.roulette.dto", "com.roulette.rouletteapi"})
public class RouletteApiApplication {
	
	public static void main(String[] args) {
		ApplicationContextProvider contextProvider = new ApplicationContextProvider();
		contextProvider.setApplicationContext(SpringApplication.run(RouletteApiApplication.class, args));
	}

}
