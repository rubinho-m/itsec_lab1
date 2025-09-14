package com.rubinho.itsec_lab1.repository;

import com.rubinho.itsec_lab1.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByLogin(String login);

    boolean existsByLogin(String login);
}
