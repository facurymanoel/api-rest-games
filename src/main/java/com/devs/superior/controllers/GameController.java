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

/**
 * Controller responsável por expor os endpoints 
 * relacionados a Games.
 * 
 * Atua como camada de entrada da API REST, 
 * delegando as regras de negócio 
 * para a camada de serviço (GameService).
 */
@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	/**
	 * Serviço responsável pelas operações de negócio 
	 * relacionadas a Game.
	 */
	@Autowired
	private GameService gameService;
	
	/**
	 *Busca um game pelo seu identificador. 
	 * @param id Identificador do game
	 * @return GameDTO contendo os dados completos do game.
	 */
	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id) {
		var result = gameService.findById(id);
		return result;
	}
	
	/**
	 *Retorna a lista de todos os games. 
	 * @return Lista de GameMinDTO contendo informações
	 * resumidas dos games.
	 */
	@GetMapping
	public List<GameMinDTO> findAll() {
		var result = gameService.findAll();
		return result;
	}

}
