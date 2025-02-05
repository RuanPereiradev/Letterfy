package tech.biuldrun.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.biuldrun.spotify.controller.dto.ReviewResponseDto;
import tech.biuldrun.spotify.entity.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReviewRepository  extends JpaRepository<Reviews, UUID> {
    Optional<Reviews> findByAccount(Account account); // Método para buscar conta pelo usuário

//    List<ReviewResponseDto> findByAlbumId(String albumId);

}