package com.roulette.rouletteapi;

import org.springframework.stereotype.Component;

import com.roulette.dto.BetRequest;
import com.roulette.dto.BetValidation;

@Component
public class RouletteValidator {
	
	public BetValidation validateBet(Integer user, BetRequest bet){
		
		if(user == null)
			return new BetValidation(false, "401");
		if(bet.getRouletteId() == null)
			return new BetValidation(false, "402");
		if(bet.getNumber() > 36 || bet.getNumber() < 0)
			return new BetValidation(false, "403");
		if(!bet.getColor().equals("Black") && !bet.getColor().equals("Red"))
			return new BetValidation(false, "404");
		if(!(bet.getValue().compareTo(0.0) <= 0) 
				|| !(bet.getValue().compareTo(10000.0) > 0))
			return new BetValidation(false, "404");	
		/*if(!(bet.getValue().compareTo(Double.valueOf("0")) <= 0) 
				|| !(bet.getValue().compareTo(Double.valueOf("10000")) > 0))
			return new BetValidation(false, "404");	*/
		return new BetValidation(true, "200");
	}
}
