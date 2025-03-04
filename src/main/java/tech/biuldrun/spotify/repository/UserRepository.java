package tech.biuldrun.spotify.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import tech.biuldrun.spotify.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    List<User>findAll();

    Optional<User> login(String login);

    UserDetails findByLogin(String login);
    Optional<User> findById(UUID userId);
}
