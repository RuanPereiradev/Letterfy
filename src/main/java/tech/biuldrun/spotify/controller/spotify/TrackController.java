package tech.biuldrun.spotify.controller.spotify;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.biuldrun.spotify.client.*;

import java.util.List;

@RestController
@RequestMapping("/spotify/api")
public class TrackController {
   
    private final AuthSpotifyClient authSpotifyClient;
    
    private final TrackSpotifyClient trackSpotifyClient;

    public TrackController(AuthSpotifyClient authSpotifyClient,
                           TrackSpotifyClient trackSpotifyClient) {
        this.authSpotifyClient = authSpotifyClient;
        this.trackSpotifyClient = trackSpotifyClient;
    }

    @GetMapping("/tracks/{id}")
    public ResponseEntity<TrackResponse> getTrack(@PathVariable String id){

        var request  = new LoginRequest(
                "client_credentials",
                "7ef1cba7337f41ff8c8c5efc69a661af",
                "ef9a6e1617fd4c87b710145a4efd0e54"
        );
        var token = authSpotifyClient.login(request).getAccessToken();

        var response = trackSpotifyClient.getTrack("Bearer " + token, id);

        return ResponseEntity.ok(response);
    }

    @RestController
    @RequestMapping("/spotify/api")
    public static class AlbumNewReleasesController {

        private final AuthSpotifyClient authSpotifyClient;

        private final AlbumNewRealeasesSpotifyClient albumNewRealeasesSpotifyClient;

        public AlbumNewReleasesController(AuthSpotifyClient authSpotifyClient,
                                          AlbumNewRealeasesSpotifyClient albumNewRealeasesSpotifyClient) {
            this.authSpotifyClient = authSpotifyClient;
            this.albumNewRealeasesSpotifyClient = albumNewRealeasesSpotifyClient;
        }

        @GetMapping("/albuns")
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
}


