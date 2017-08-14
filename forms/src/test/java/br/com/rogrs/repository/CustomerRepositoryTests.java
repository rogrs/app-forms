package br.com.rogrs.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.rogrs.model.Customer;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CustomerRepository customers;

	@Test
	public void testFindByLastName() {
		Customer customer = new Customer("first", "last");
		entityManager.persist(customer);

		List<Customer> findByLastName = customers.findByLastName(customer.getLastName());

		assertThat(findByLastName).extracting(Customer::getLastName).containsOnly(customer.getLastName());
	}
}
