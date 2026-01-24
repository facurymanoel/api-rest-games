package com.devs.superior.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devs.superior.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
	/**
	 *Atualiza a posição de um jogo em uma lista na tabela `tb_belonging`.
	 *  
	 *Este método executa uma consulta SQL nativa que altera o valor do campo `position` na tabela `tb_belonging`,
	 *onde o jogo identificado pelo `gameId` pertence à lista identificada pelo `listId`. A nova posição do jogo é
	 *definida pelo parâmetro `newPosition`. A consulta afeta apenas o registro correspondente à combinação
	 *única de `list_id` e `game_id`, garantindo que a posição do jogo seja alterada dentro de uma lista específica.
	 *
	 *A anotação `@Modifying` indica que a operação é uma modificação de dados (neste caso, um `UPDATE`),
	 *e não apenas uma consulta (`SELECT`).
	 *@param listId Identificador da lista de jogos.
	 *@param gameId Identificador do jogo a ser atualizado.
	 *@param newPosition Nova posição a ser atribuída ao jogo na lista.
	 * 
	 *@return Nenhum valor é retornado. A alteração é feita diretamente na tabela.
	 */
	 
	@Modifying
	@Query(nativeQuery = true, 
	value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);

}
