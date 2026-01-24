package com.devs.superior.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devs.superior.dto.GameDTO;
import com.devs.superior.dto.GameMinDTO;
import com.devs.superior.entities.Game;
import com.devs.superior.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	@Autowired
	private GameService gameService;
	
	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id) {
		var result = gameService.findById(id);
		return result;
	}
	
	@GetMapping
	public List<GameMinDTO> findAll() {
		var result = gameService.findAll();
		return result;
	}

}
