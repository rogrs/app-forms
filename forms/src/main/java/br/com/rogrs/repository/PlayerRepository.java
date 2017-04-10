package br.com.rogrs.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.rogrs.model.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {

    
}
