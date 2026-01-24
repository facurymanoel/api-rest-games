package com.devs.superior.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devs.superior.entities.Game;
import com.devs.superior.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> {
	 /**
	 *Consulta os jogos associados a uma lista específica
	 * 
	 *A query realiza um INNER JOIN entre as tabelas tb_game e tb_belonging 
	 *retornando os dados básicos dos jogos pertecentes à lista informada 
	 *
	 *Os jogos são ordenados de acordo com a posição definida na tabela 
	 *tb_belonging, garantindo a exibição na ordem correta da lista (ORDER BY).
	 *
	 *@param listId identificador da lista de jogos
	 *@return lista de jogos projetados ordenados por posição 
	 */
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	 List<GameMinProjection>searchByList(Long listId);

}
