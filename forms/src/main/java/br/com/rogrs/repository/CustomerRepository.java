package br.com.rogrs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.rogrs.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
