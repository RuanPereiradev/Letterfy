package tech.biuldrun.spotify.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(
        name = "ArtistsSpotifyClient",
        url = "https://api.spotify.com"
)

public interface ArtistsSpotifyClient {
    @GetMapping(value = "/v1/artists")
    ArtistsResponse getArtists(@RequestHeader("Authorization") String authorization);
}
