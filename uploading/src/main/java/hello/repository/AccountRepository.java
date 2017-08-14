package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.model.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}