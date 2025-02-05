package tech.biuldrun.spotify.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "spotifyClient",
        url = "https://api.spotify.com"
)
public interface CategoriesSpotifyClient {
    @GetMapping(value = "/v1/browse/categories")
    CategoriesResponse getCategories(@RequestHeader("Authorization") String autorization);
}
