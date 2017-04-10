package br.com.rogrs.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.rogrs.model.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    
}
