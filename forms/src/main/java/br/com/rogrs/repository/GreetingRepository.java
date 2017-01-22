package br.com.rogrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rogrs.model.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}
