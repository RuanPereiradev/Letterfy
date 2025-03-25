package tech.biuldrun.spotify.service;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import tech.biuldrun.spotify.client.AlbumNewRealeasesSpotifyClient;
import tech.biuldrun.spotify.client.AlbumNewReleases;
import tech.biuldrun.spotify.client.AuthSpotifyClient;
import tech.biuldrun.spotify.client.LoginRequest;
import tech.biuldrun.spotify.entity.Albuns;
import tech.biuldrun.spotify.repository.AlbumRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class SpotifyService {

    private final AuthSpotifyClient authSpotifyClient;
    private final AlbumNewRealeasesSpotifyClient albumNewRealeasesSpotifyClient;
    private final AlbumRepository albumRepository;

    // Fetching new releases from Spotify
    @Scheduled(fixedRate = 86400000)
    public void fetchAndSaveNewReleases() {
        var request = new LoginRequest(
                "client_credentials",
                "7ef1cba7337f41ff8c8c5efc69a661af",
                "ef9a6e1617fd4c87b710145a4efd0e54"
        );
        var token = authSpotifyClient.login(request).getAccessToken();

        // Getting all new releases
        List<AlbumNewReleases> releases = albumNewRealeasesSpotifyClient
                .getReleases("Bearer " + token)
                .getAlbums()
                .getItems();

        // Getting all spotify ids
        List<String> newSpotifyIds = releases.stream()
                .map(AlbumNewReleases::getSpotifyId)
                .collect(Collectors.toList());

        // Getting all existing spotify ids
        List<String> existingSpotifyIds = albumRepository.findExistingSpotifyIds(newSpotifyIds);

        // Filtering only new releases
        List<Albuns> newAlbuns = releases.stream()
                .filter(album -> !existingSpotifyIds.contains(album.getSpotifyId()))
                .map(album -> {
                    // Extraindo os links das imagens
                    List<String> imageUrls = album.getImages().stream()
                            .map(image -> image.getUrl())  // Pegando o link de cada imagem
                            .collect(Collectors.toList());

                    List<String> artists = album.getArtists().stream()
                            .map(artist -> artist.getName())
                            .collect(Collectors.toList());
                    // Criando a entidade Albuns com os links das imagens
                    return new Albuns(
                            album.getSpotifyId(),
                            album.getName(),
                            imageUrls,
                            artists
                    );
                })
                .collect(Collectors.toList());

        // Save only albums that do not exist
        if (!newAlbuns.isEmpty()) {
            albumRepository.saveAll(newAlbuns);
            System.out.println(newAlbuns.size() + " novos álbuns salvos.");
        } else {
            System.out.println("Nenhum novo álbum encontrado.");
        }
    }
}
