package tech.biuldrun.spotify.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.biuldrun.spotify.client.Categories;
import tech.biuldrun.spotify.client.AuthSpotifyClient;
import tech.biuldrun.spotify.client.CategoriesSpotifyClient;
import tech.biuldrun.spotify.client.LoginRequest;

import java.util.List;

@RestController
@RequestMapping("/spotify/api")
public class CategoriesController {

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
