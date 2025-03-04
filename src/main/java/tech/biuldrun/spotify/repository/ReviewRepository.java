package tech.biuldrun.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.biuldrun.spotify.entity.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReviewRepository  extends JpaRepository<Reviews, UUID> {
    Optional<Reviews> findByUser(User user); // Método para buscar conta pelo usuário


}