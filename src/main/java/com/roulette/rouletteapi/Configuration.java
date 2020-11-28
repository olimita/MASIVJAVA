package com.roulette.rouletteapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Configuration {
	
	@Value( "${db.url}" )
	private String DBurl;
	
	@Value( "${db.port}" )
	private Integer DBport;
	
	@Value( "${bet.minimumValue}" )
	private Double betMinimum;
	
	@Value( "${bet.maximumValue}" )
	private Double betMaximum;
	
	public String getDBUrl() {
		return DBurl;
	}
	public Integer getDBPort() {
		return DBport;
	}
	public Double getBetMinimum() {
		return betMinimum;
	}
	public Double getBetMaximum() {
		return betMaximum;
	}
	
}
