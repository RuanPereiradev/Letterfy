package tech.biuldrun.spotify.controller.spotify;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.biuldrun.spotify.client.*;

import java.util.List;

@RestController
@RequestMapping("/spotify/api")
@AllArgsConstructor
public class AlbumNewReleasesController {

    private final AuthSpotifyClient authSpotifyClient;
    private final AlbumNewRealeasesSpotifyClient albumNewRealeasesSpotifyClient;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/albumsReleases")
    public ResponseEntity<List<AlbumNewReleases>> helloWorld(){
        var request  = new LoginRequest(
                "client_credentials",
                "7ef1cba7337f41ff8c8c5efc69a661af",
                "ef9a6e1617fd4c87b710145a4efd0e54"
        );
        var token = authSpotifyClient.login(request).getAccessToken();
        var response = albumNewRealeasesSpotifyClient.getReleases("Bearer " + token);
        return ResponseEntity.ok(response.getAlbums().getItems());
    }
}
