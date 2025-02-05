package tech.biuldrun.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.biuldrun.spotify.entity.Account;

import java.util.UUID;


import tech.biuldrun.spotify.entity.User;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, UUID> {
    Optional<Account> findByUserUserId(UUID userId);
}
