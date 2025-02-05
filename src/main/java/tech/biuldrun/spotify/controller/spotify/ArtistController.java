package tech.biuldrun.spotify.controller.spotify;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.biuldrun.spotify.client.*;
import tech.biuldrun.spotify.client.AuthSpotifyClient;

import java.util.List;

@RestController
@RequestMapping("/spotify/api")
@AllArgsConstructor
public class    ArtistController {

    private final AuthSpotifyClient authSpotifyClient;
    private final ArtistSpotifyClient artistSpotifyClient;


@GetMapping("/artists/{id}")
public ResponseEntity<ArtistResponse> getArtist(@PathVariable String id) {
        var request = new LoginRequest(
                "client_credentials",
                "7ef1cba7337f41ff8c8c5efc69a661af",
                "ef9a6e1617fd4c87b710145a4efd0e54"
        );
        var token = authSpotifyClient.login(request).getAccessToken();
        var response = artistSpotifyClient.getArtist("Bearer " + token, id  );
        return ResponseEntity.ok(response);

    }

    @RestController
    @RequestMapping("/spotify/api")
    public static class CategoriesController {

        private final AuthSpotifyClient authSpotifyClient;
        private final CategoriesSpotifyClient categoriesSpotifyClient;

        public CategoriesController(AuthSpotifyClient authSpotifyClient,
                                    CategoriesSpotifyClient categoriesSpotifyClient) {
            this.authSpotifyClient = authSpotifyClient;
            this.categoriesSpotifyClient = categoriesSpotifyClient;
        }

        @GetMapping("/categories")
        public ResponseEntity<List<Categories>> helloWord(){

            var request = new LoginRequest(
                    "client_credentials",
                    "7ef1cba7337f41ff8c8c5efc69a661af",
                    "ef9a6e1617fd4c87b710145a4efd0e54"
            );
            var token = authSpotifyClient.login(request).getAccessToken();

            var response = categoriesSpotifyClient.getCategories("Bearer " + token);
            return ResponseEntity.ok(response.getCategories().getItems());
        }

    }
}




