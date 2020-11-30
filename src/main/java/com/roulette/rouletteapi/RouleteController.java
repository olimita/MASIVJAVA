package com.roulette.rouletteapi;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roulette.dto.Bet;
import com.roulette.dto.BetRequest;
import com.roulette.dto.BetResponse;
import com.roulette.dto.BetValidation;
import com.roulette.dto.ClosedRoulette;
import com.roulette.dto.CreateRouletteResponse;
import com.roulette.dto.ListRoulettesResponse;
import com.roulette.dto.OpenRouletteResponse;
import com.roulette.dto.Roulette;
import com.roulette.dto.RouletteToList;

@RestController
@RequestMapping("/api/*")
public class RouleteController {
	
	@Autowired
	private RouletteValidator rouletteValidator;
	
	@Autowired
	private Roulette roulette;
	
	@Autowired
	private Bet bet;
	
	@GetMapping("/createRoulette")
	public CreateRouletteResponse createRoulete() throws SQLException {		
		return roulette.createRoulette();
	}
	
	@PostMapping("/openRoulette")
	public OpenRouletteResponse openRoulette(@RequestBody Integer roulletteId) {
		roulette.setId(roulletteId);
		return roulette.openRoulette();
	}
	
	@PostMapping("/setBet")
	public BetResponse setBetOnRoullette(@RequestHeader("user") Integer user, @RequestBody BetRequest roulletteBet) {
		
		BetResponse validatedBet = rouletteValidator.validateBet(user, roulletteBet);
		if(validatedBet.getSuccess()) {
			roulette.setId(roulletteBet.getRouletteId());
			bet.setUserId(user);
			bet.setNumber(roulletteBet.getNumber());
			bet.setColor(roulletteBet.getColor());
			bet.setValue(roulletteBet.getValue());
			return roulette.setNewBet(bet);
		}
		else
			return validatedBet;
	}
	
	@PostMapping("/closeRoulette")
	public ClosedRoulette closeRoulette(@RequestBody Integer roulletteId) {
		roulette.setId(roulletteId);
		return roulette.closeRoulette();
	}
	
	@GetMapping("/listRoulettes")
	public ListRoulettesResponse listRoulettes() throws CloneNotSupportedException {
		return roulette.listRoulettes();
	}
	
}
