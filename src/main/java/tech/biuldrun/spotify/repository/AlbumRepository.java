    package tech.biuldrun.spotify.repository;

    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import tech.biuldrun.spotify.entity.Albuns;

    import java.util.Optional;
    import java.util.UUID;


    public interface AlbumRepository  extends JpaRepository<Albuns, UUID> {
        Optional<Albuns> findByAlbumId(UUID albumId);

        boolean existsBySpotifyId(String spotifyId);
        boolean existsByName(String name);


    }
