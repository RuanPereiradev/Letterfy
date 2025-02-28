    package tech.biuldrun.spotify.repository;

    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import tech.biuldrun.spotify.entity.Albuns;

    import java.util.List;
    import java.util.Optional;
    import java.util.UUID;


    public interface AlbumRepository  extends JpaRepository<Albuns, UUID> {
        Optional<Albuns> findByAlbumId(UUID albumId);

        boolean existsBySpotifyId(String spotifyId);
        boolean existsByName(String name);

        @Query("SELECT a.spotifyId FROM Albuns a WHERE a.spotifyId IN :spotifyIds")
        List<String> findExistingSpotifyIds(@Param("spotifyIds") List<String> spotifyIds);


    }
