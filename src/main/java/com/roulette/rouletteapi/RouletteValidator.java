package com.roulette.rouletteapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roulette.dto.BetRequest;
import com.roulette.dto.BetResponse;
import com.roulette.dto.BetValidation;

@Component
public class RouletteValidator {
	
	@Autowired
	private Configuration config;
	
	public BetResponse validateBet(Integer user, BetRequest bet){
		
		if(user == null)
			return new BetResponse(false, "401", "Invalid User", null);
		if(bet.getRouletteId() == null)
			return new BetResponse(false, "402", "Invalid RouletteId", null);
		if(bet.getNumber() != null && (bet.getNumber() > 36 || bet.getNumber() < 0))
			return new BetResponse(false, "403", "Invalid Number", null);
		if(bet.getColor() != null && 
				(!bet.getColor().equals("Black") && !bet.getColor().equals("Red")))
			return new BetResponse(false, "404", "Invalid Color", null);
		if(bet.getColor() != null && bet.getNumber() != null)
			return new BetResponse(false, "405", "You may onlly bet on number or color, no both", null);
		if(bet.getValue() == null 
				|| (bet.getValue().compareTo(config.getBetMinimum()) <= 0) || (bet.getValue().compareTo(config.getBetMaximum()) > 0))
			return new BetResponse(false, "406", "Invalid Bet value", null);	
		return new BetResponse(true, "200", "OK", null);
	}
}
