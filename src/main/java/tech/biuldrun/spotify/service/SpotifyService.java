package tech.biuldrun.spotify.service;

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

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpotifyService {

    private final AuthSpotifyClient authSpotifyClient;
    private final AlbumNewRealeasesSpotifyClient albumNewRealeasesSpotifyClient;
    private final AlbumRepository albumRepository;

    //fetching new releases from spotify
    @Scheduled(fixedRate = 86400000)
    public void fetchAndSaveNewReleases() {
        var request = new LoginRequest(
                "client_credentials",
                "7ef1cba7337f41ff8c8c5efc69a661af",
                "ef9a6e1617fd4c87b710145a4efd0e54"
        );
        var token = authSpotifyClient.login(request).getAccessToken();

        //getting all new releases
        List<AlbumNewReleases> releases = albumNewRealeasesSpotifyClient
                .getReleases("Bearer " + token)
                .getAlbums()
                .getItems();

        //getting all spotify ids
        List<String> newSpotifyIds = releases.stream()
                .map(AlbumNewReleases::getSpotifyId)
                .collect(Collectors.toList());

        //getting all existing spotify ids
        List<String> existingSpotifyIds = albumRepository.findExistingSpotifyIds(newSpotifyIds);

        //filtering only new releases
        //verification if the album already exists
        List<Albuns> newAlbuns = releases.stream()
                .filter(album -> !existingSpotifyIds.contains(album.getSpotifyId()))
                .map(album -> new Albuns(
                        album.getSpotifyId(),
                        album.getName(),
                        album.getArtists().getFirst().getName()

                ))
                .collect(Collectors.toList());

    //saved only album that does not exist
       if(!newAlbuns.isEmpty()){
           albumRepository.saveAll(newAlbuns);
           
       }
    }
}
