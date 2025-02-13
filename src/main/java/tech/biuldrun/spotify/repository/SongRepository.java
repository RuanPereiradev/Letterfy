package tech.biuldrun.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.biuldrun.spotify.entity.Song;

import java.util.Optional;
import java.util.UUID;

public interface SongRepository  extends JpaRepository<Song, UUID> {
    Optional<Song> findBySongId(UUID songId);

    boolean existsBySpotifyId(String spotifyId);
    boolean existsByName(String name);

}
