package tech.biuldrun.spotify.controller.spotify;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.biuldrun.spotify.client.Artist;
import tech.biuldrun.spotify.client.ArtistsSpotifyClient;
import tech.biuldrun.spotify.client.AuthSpotifyClient;
import tech.biuldrun.spotify.client.LoginRequest;

import java.util.List;

@RestController
@RequestMapping("/spotify/api")
@AllArgsConstructor
public class ArtistController {
    private  final AuthSpotifyClient authSpotifyClient;
    private  final ArtistsSpotifyClient artistsSpotifyClient;

    @CrossOrigin(origins = "http://localhost:5173")
    @RequestMapping("/v1/artists")
    public ResponseEntity<List<Artist>> helloWord(){
        var request  = new LoginRequest(
                "client_credentials",
                "7ef1cba7337f41ff8c8c5efc69a661af",
                "ef9a6e1617fd4c87b710145a4efd0e54"
        );
        var token = authSpotifyClient.login(request).getAccessToken();
        var response = artistsSpotifyClient.getArtists("Bearer " + token);
        return ResponseEntity.ok(response.getArtists().getItems());
    }
}
