package br.com.rogrs.omega.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rogrs.omega.entity.Stormtrooper;

public interface StormtrooperRepository extends JpaRepository<Stormtrooper, Long> {

}
